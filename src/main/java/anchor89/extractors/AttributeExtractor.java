package anchor89.extractors;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.nodes.Element;

/**
 * Return the attribute with key=@key in given element.
 * If that element has no such attribute, return empty string.
 * 
 * @author Anchor
 * 
 */
public class AttributeExtractor implements Extractor {
  final private static Logger logger = LogManager
      .getLogger(AttributeExtractor.class);
  
  private String key = null;
  
  public AttributeExtractor(String key) {
    this.key = key;
  }
  
  public String extract(Element element) {
    return key != null && element.hasAttr(key) ? 
        element.attr(key) : "";
  }
}
