import Parser.SourceParser;
import Scraper.SourceFromUrlScraper;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chris on 20/08/2017.
 */
public class ParserTest {




//    String elementaryHtml = "<!DOCTYPE html>" +
//            "<html>" +
//            "<body>" +
//            "<h1>My First Heading</h1>" +
//            "<p>My first paragraph.</p>" +
//            "</body>" +
//            "</html>";
//
//
//
//    String squirrelMailSource = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><html><head><meta name=\"robots\" content=\"noindex,nofollow\"><meta http-equiv=\"x-dns-prefetch-control\" content=\"off\"><link rel=\"stylesheet\" type=\"text/css\" href=\"../themes/css/tahoma-10.css\"><title>WestNet - Login</title><script language=\"JavaScript\" type=\"text/javascript\"><!--  var alreadyFocused = false;  function squirrelmail_loginpage_onload() {    document.login_form.js_autodetect_results.value = '1';    if (alreadyFocused) return;    var textElements = 0;    for (i = 0; i < document.login_form.elements.length; i++) {      if (document.login_form.elements[i].type == \"text\" || document.login_form.elements[i].type == \"password\") {        textElements++;        if (textElements == 1) {          document.login_form.elements[i].focus();          break;        }      }    }  }// --></script><!--[if IE 6]><style type=\"text/css\">/* avoid stupid IE6 bug with frames and scrollbars */body {    width: expression(document.documentElement.clientWidth - 30);}</style><![endif]--></head><body text=\"#000000\" bgcolor=\"#ffffff\" link=\"#8888ff\" vlink=\"#8888ff\" alink=\"#8888ff\" onLoad=\"squirrelmail_loginpage_onload();\"><form action=\"redirect.php\" method=\"post\" name=\"login_form\"  ><table bgcolor=\"#ffffff\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr><td align=\"center\"><center><img src=\"/westnet.gif\" alt=\"WestNet Logo\" width=\"320\" height=\"75\" /><br /><small>SquirrelMail version 1.4.21<br />  By the SquirrelMail Project Team<br /></small><table bgcolor=\"#ffffff\" border=\"0\" width=\"350\"><tr><td bgcolor=\"#c0daff\" align=\"center\"><b>WestNet Login</b></td></tr><tr><td bgcolor=\"#ffffff\" align=\"left\"><table bgcolor=\"#ffffff\" align=\"center\" border=\"0\" width=\"100%\"><tr><td align=\"right\" width=\"30%\">Name:</td><td align=\"left\" width=\"70%\"><input type=\"text\" name=\"login_username\" value=\"\" onfocus=\"alreadyFocused=true;\" /></td></tr><tr><td align=\"right\" width=\"30%\">Password:</td><td align=\"left\" width=\"70%\"><input type=\"password\" name=\"secretkey\" onfocus=\"alreadyFocused=true;\" /><input type=\"hidden\" name=\"js_autodetect_results\" value=\"0\" /><input type=\"hidden\" name=\"just_logged_in\" value=\"1\" /></td></tr></table></td></tr><tr><td align=\"left\"><center><input type=\"submit\" value=\"Login\" /></center></td></tr></table></center></td></tr></table></form><br><br><center><table width=\"75%\"><tr><td>To Setup a Vacation Message please click <A HREF=\"http://westnet.com/cgi-bin/userinfo/login.cgi\">here</A><P>Welcome to SquirrelMail. WestNet users who are traveling, at work, or forwhatever reason are not at their regular computer can check their e-mail viaany web browser. While not a replacement for a regular desktop e-mailprogram, SquirrelMail will help you keep in touch, no matter where you are.<P>For everyday use, WestNet recomends the <AHREF=\"http://www.mozilla.org/\">Mozilla Thunderbird</A> mail client orEudora.If you do not have a desktop mail program configured, we have <AHREF=\"http://www.westnet.com/Help/mail.html\">help available for configuring various packages</A>.</td></tr></table></center></body></html>";
   // String squirrelMailUrl = "http://mail.westnet.com/squirrelmail/src/login.php";


//    @Test
//    public void ElementaryDocInstantiatesCorrectly() throws IOException {
//        SourceParser elementaryDoc = new SourceParser(elementaryHtml);
//    }
//
//    @Test
//    public void RealisticDocInstantiatesCorrectly() throws IOException {
//        SourceParser RealisticDoc = new SourceParser(squirrelMailSource);
//    }
//
//    @Test
//    public void ElementaryDocReturnsBody() throws IOException {
//        SourceParser elementaryDoc = new SourceParser(elementaryHtml);
//        String body = elementaryDoc.getDoc().body().toString();
//        Assert.assertEquals("<body>\n" +
//                " <h1>My First Heading</h1>\n" +
//                " <p>My first paragraph.</p>\n" +
//                "</body>", body);
//
//    }
//
//    @Test
//    public void ElementaryDocParsedCorrectly() throws IOException {
//        String expectedResult = "2.1 My First Heading\n"+
//                                "2.2 My first paragraph.\n"+
//                                "\n"+
//                                "Images:\n";
//
//        SourceParser elementaryDoc = new SourceParser(elementaryHtml);
//        Assert.assertEquals(expectedResult, elementaryDoc.parseDoc(""));
//
//    }

    @Test
    public void RealisticDocParsedCorrectly() throws IOException, InterruptedException {
        String expectedResult = "";

        SourceFromUrlScraper scraper = new SourceFromUrlScraper();
        SourceParser realisticDoc = new SourceParser(scraper.getUrlSource("https://ms.taleo.net/careersection/2/jobsearch.ftl?lang=en"));

        BufferedWriter writer = null;

        System.out.println("Writing to output.txt");
        try
        {


            String path = System.getProperty("user.dir")+ "/ms.taleo.net"+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            new File(path).mkdir();
            writer = new BufferedWriter( new FileWriter( path+"/output.txt"));
            writer.write( realisticDoc.parseDocs("https://ms.taleo.net"));

        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }

    }




}
