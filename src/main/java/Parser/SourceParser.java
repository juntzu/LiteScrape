package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Chris on 20/08/2017.
 */
public class SourceParser {

    Document[] docs;
    Elements links;
    Elements images, body, jsButtons;
    Set<String> imageSet, linkSet;
    String[] bodyTags;



    public SourceParser(List<String> sources) throws IOException {
        System.out.println("Processing...");
        docs = new Document[sources.size()];

        for(int i = 0; i< docs.length ; i++){
            docs[i] = Jsoup.parse(sources.get(i));
        }






    }

    public String parseDocs(String url) throws IOException {

        Set<String> set = new TreeSet<>();

        String[] strings = new String[docs.length];
        for(int i = 0; i< docs.length; i ++){
            strings[i] = parseDoc(url, docs[i]);
        }

        System.out.println("Concatenating results...");
        for(String s:strings){
            BufferedReader bufReader = new BufferedReader(new StringReader(s));
            String line=null;
            while( (line=bufReader.readLine()) != null )
            {
                set.add(line);

            }
        }

        String returnString = "";

        for(String s: set){
            returnString += s +"\n";
        }

        return returnString;

    }

    public String parseDoc(String url, Document doc){
        String parsedString = tagsToString(doc.body().select("*"));
        parsedString += imagesToString(url, doc);
        parsedString += urlsToString(doc);

        for(Element ele: jsButtons){

        }
        return parsedString.replace("\n", System.getProperty("line.separator"));
    }

//    public Document getDoc(){
//        return this.doc;
//    }


    public String urlsToString(Document doc){
        String urls = "\nURLS:\n";
        links = doc.select("a");
        jsButtons = new Elements();
        linkSet = new HashSet<String>();

        for (Element src : links) {
            String href = src.attr("href");

                linkSet.add(href);


        }

        for(String url: linkSet){
            urls += url +"\n";
        }

        return urls;
    }

    public String imagesToString(String url, Document doc){
        images = doc.select("img");
        imageSet = new HashSet<String>();
        String images = "\nImages:\n";

        for (Element src : this.images) {
            imageSet.add( url + src.attr("abs:href") + src.attr("src"));
        }

        for(String imageName: imageSet){
            images += imageName +"\n";
        }

        return images;
    }

    public String tagsToString(List<Element> nodeList){



        String parsedString = "";

        for(int i = 0; i < nodeList.size(); i++){

            parsedString+=(getIndexOfelement(nodeList.get(i)))+ " " + nodeList.get(i).ownText()  + "\n";
        }
        return parsedString;
    }


    public String getIndexOfelement(Element element){

        if(element.parent().parent()!=null){

            return (getIndexOfelement(element.parent())+(element.elementSiblingIndex()+1)+".");
        }
        return "";
    }


    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
