package Scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Chris on 20/08/2017.
 */
public class SourceFromUrlScraper {


    //    Document doc = Jsoup.connect("http://example.com")
//            .data("query", "Java")
//            .userAgent("Mozilla")
//            .cookie("auth", "token")
//            .timeout(3000)
//            .post();
//
    WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();
    List<WebElement> nextButtons = new ArrayList<WebElement>();
    WebDriverWait wait;
    ArrayList<String> sources = new ArrayList<String>();




    public SourceFromUrlScraper(){

    }

    public List<String> getUrlSource(String url) throws IOException, InterruptedException {
        driver = driverFactory.getDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(url);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for(WebElement ele: elements){
            if(ele.getText().toLowerCase().contains("next")){
                System.out.println("adding");
                nextButtons.add(ele);
            }
        }
        //Thread.sleep(5000);
        String source = driver.getPageSource();
//
//        nextButtons.get(0).click();
//        Thread.sleep(5000);
//
//        source += driver.getPageSource();
//
//        System.out.println(source);

        for(WebElement ele:nextButtons){

            System.out.println("Finding paginations for "+ele.getText());

            for(int i = 1;;i++) {
                System.out.println("Pagination #  "+i);


                wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
                sources.add(driver.getPageSource());

                if(ele.isEnabled()==false || ele.isDisplayed()==false || ele.getAttribute("aria-disabled").equals("true")){
                    System.out.println("Found "+i +" paginations.");
                    break;
                }
            }}



        driver.quit();
        return sources;
    }
}
