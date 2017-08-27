package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chris on 20/08/2017.
 */
public class SourceParser {

    Document doc;
    Elements links;
    Elements images, body;
    Set<String> imageSet, linkSet;
    String[] bodyTags;

    public SourceParser(String source) throws IOException {
        doc = Jsoup.parse(source);

        body = doc.body().select("*");
        bodyTags = new String[body.size()];

        for (int i = 0; i < body.size(); i++) {
            bodyTags[i] =  getIndexOfelement(body.get(i));
        }
    }

    public String parseDoc(String url){
        String parsedString = tagsToString(this.doc.body().select("*"));
        parsedString += imagesToString(url);
        parsedString += urlsToString();
        return parsedString.replace("\n", System.getProperty("line.separator"));
    }

    public Document getDoc(){
        return this.doc;
    }


    public String urlsToString(){
        String urls = "\nURLS:\n";
        links = doc.select("a");
        linkSet = new HashSet<String>();

        for (Element src : links) {
            linkSet.add(src.attr("href"));
        }

        for(String url: linkSet){
            urls += url +"\n";
        }

        return urls;
    }

    public String imagesToString(String url){
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
