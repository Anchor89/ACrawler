package anchor89.crawl;

import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import anchor89.extractors.Extractors;

public class HtmlGetterTest {
  final private static Logger logger = LogManager.getLogger(HtmlGetter.class);
  
  @Test
  public void test() {
    Document doc = Jsoup.parse("<html>"
        + "<head></head>"
        + "<body>"
        + "<div id=\"main\">"
        + "<ul>"
        + "<li>1. test1</li>"
        + "<li>2. test2</li>"
        + "</ul>"
        + "</div>"
        + "<div class=\"footer\">"
        + "test used by ACrawler"
        + "</div>"
        + "</body>"
        + "</html>");
    HtmlGetter hg = new HtmlGetter(doc);
    String result = hg.get("div#main li", Extractors.getExtractor("text"));
    assertEquals("1. test1,2. test2", result);
    logger.info(result);
  }
}
