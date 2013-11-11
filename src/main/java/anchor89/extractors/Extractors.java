package anchor89.extractors;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Extractors {
  final private static Logger logger = LogManager.getLogger(Extractors.class);

  private static Map<String, Extractor> store = new HashMap<String, Extractor>();
  static {
    store.put("html", new HtmlExtractor());
    store.put("text", new TextExtractor());
  }
  
  public static Extractor getExtractor(String name) {
    return store.get(name);
  }
}
