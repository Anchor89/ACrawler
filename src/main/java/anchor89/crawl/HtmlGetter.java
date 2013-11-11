package anchor89.crawl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import anchor89.extractors.Extractor;
import anchor89.util.StringUtil;

public class HtmlGetter {
  final private static Logger logger = LogManager.getLogger(HtmlGetterTest.class);
  
  private Document root = null;
  public HtmlGetter(Document root) {
    this.root = root;
  }
  
  public String get(String selector, Extractor ext) {
    return get(selector, ext, ",");
  }
  
  public String get(String selector, Extractor ext, String joinDeli) {
    List<String> results = new ArrayList<String>();
    for (Element element : root.select(selector)) {
      results.add(ext.extract(element));
    }
    return StringUtil.join(results, joinDeli);
  }
}
