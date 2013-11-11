package anchor89.extractors;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.nodes.Element;

public class HtmlExtractor implements Extractor {
  final private static Logger logger = LogManager
      .getLogger(HtmlExtractor.class);
  
  public HtmlExtractor() {

  }
  
  public String extract(Element element) {
    return element.html();
  }
}
