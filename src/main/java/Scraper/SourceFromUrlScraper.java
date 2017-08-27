package Scraper;

import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
    public SourceFromUrlScraper(){

    }

    public String getUrlSource(String url) throws IOException, InterruptedException {
        driver = driverFactory.getDriver();
        driver.get(url);
       //Thread.sleep(5000);
        String source = driver.getPageSource();
        driver.quit();
        return source;
    }
}
