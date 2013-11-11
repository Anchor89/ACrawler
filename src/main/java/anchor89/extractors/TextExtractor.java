package anchor89.extractors;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.nodes.Element;

public class TextExtractor implements Extractor {
  final private static Logger logger = LogManager
      .getLogger(TextExtractor.class);
  
  public TextExtractor() {

  }
  
  public String extract(Element element) {
    return element.text();
  }
}
