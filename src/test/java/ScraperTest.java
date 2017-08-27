import Scraper.SourceFromUrlScraper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Chris on 20/08/2017.
 */
public class ScraperTest {

//
//    SourceFromUrlScraper scraper = new SourceFromUrlScraper();
//
//    String squirrelMailUrl = "http://mail.westnet.com/squirrelmail/src/login.php";
//    String squirrelMailSource = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><html><head><meta name=\"robots\" content=\"noindex,nofollow\"><meta http-equiv=\"x-dns-prefetch-control\" content=\"off\"><link rel=\"stylesheet\" type=\"text/css\" href=\"../themes/css/tahoma-10.css\"><title>WestNet - Login</title><script language=\"JavaScript\" type=\"text/javascript\"><!--  var alreadyFocused = false;  function squirrelmail_loginpage_onload() {    document.login_form.js_autodetect_results.value = '1';    if (alreadyFocused) return;    var textElements = 0;    for (i = 0; i < document.login_form.elements.length; i++) {      if (document.login_form.elements[i].type == \"text\" || document.login_form.elements[i].type == \"password\") {        textElements++;        if (textElements == 1) {          document.login_form.elements[i].focus();          break;        }      }    }  }// --></script><!--[if IE 6]><style type=\"text/css\">/* avoid stupid IE6 bug with frames and scrollbars */body {    width: expression(document.documentElement.clientWidth - 30);}</style><![endif]--></head><body text=\"#000000\" bgcolor=\"#ffffff\" link=\"#8888ff\" vlink=\"#8888ff\" alink=\"#8888ff\" onLoad=\"squirrelmail_loginpage_onload();\"><form action=\"redirect.php\" method=\"post\" name=\"login_form\"  ><table bgcolor=\"#ffffff\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tr><td align=\"center\"><center><img src=\"/westnet.gif\" alt=\"WestNet Logo\" width=\"320\" height=\"75\" /><br /><small>SquirrelMail version 1.4.21<br />  By the SquirrelMail Project Team<br /></small><table bgcolor=\"#ffffff\" border=\"0\" width=\"350\"><tr><td bgcolor=\"#c0daff\" align=\"center\"><b>WestNet Login</b></td></tr><tr><td bgcolor=\"#ffffff\" align=\"left\"><table bgcolor=\"#ffffff\" align=\"center\" border=\"0\" width=\"100%\"><tr><td align=\"right\" width=\"30%\">Name:</td><td align=\"left\" width=\"70%\"><input type=\"text\" name=\"login_username\" value=\"\" onfocus=\"alreadyFocused=true;\" /></td></tr><tr><td align=\"right\" width=\"30%\">Password:</td><td align=\"left\" width=\"70%\"><input type=\"password\" name=\"secretkey\" onfocus=\"alreadyFocused=true;\" /><input type=\"hidden\" name=\"js_autodetect_results\" value=\"0\" /><input type=\"hidden\" name=\"just_logged_in\" value=\"1\" /></td></tr></table></td></tr><tr><td align=\"left\"><center><input type=\"submit\" value=\"Login\" /></center></td></tr></table></center></td></tr></table></form><br><br><center><table width=\"75%\"><tr><td>To Setup a Vacation Message please click <A HREF=\"http://westnet.com/cgi-bin/userinfo/login.cgi\">here</A><P>Welcome to SquirrelMail. WestNet users who are traveling, at work, or forwhatever reason are not at their regular computer can check their e-mail viaany web browser. While not a replacement for a regular desktop e-mailprogram, SquirrelMail will help you keep in touch, no matter where you are.<P>For everyday use, WestNet recomends the <AHREF=\"http://www.mozilla.org/\">Mozilla Thunderbird</A> mail client orEudora.If you do not have a desktop mail program configured, we have <AHREF=\"http://www.westnet.com/Help/mail.html\">help available for configuring various packages</A>.</td></tr></table></center></body></html>";

//    @Test
//    public void ScraperReturnsStringFromGoogle() throws IOException {
//        scraper.getUrlSource("https://www.google.com");
//    }
//
//    @Test
//    public void ScraperReturnsSourceCodeFromSquirrelMail() throws IOException {
//        Assert.assertEquals(squirrelMailSource, scraper.getUrlSource(squirrelMailUrl));
//    }

    
}
