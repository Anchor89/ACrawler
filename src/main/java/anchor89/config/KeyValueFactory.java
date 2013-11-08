package anchor89.config;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class KeyValueFactory {
  final private static Logger logger = LogManager
      .getLogger(KeyValueFactory.class);
  
  /**
   * Parse one line to KeyValue instance.
   * @param line
   * @return
   */
  public static KeyValue fromString(String line) {
    if (line == null || line.isEmpty() || line.startsWith("#")) {
      return null;
    }
    
    String key = null;
    String value = null;
    String[] items = line.split("=", 2);
    key = items.length > 0? items[0]:null;
    value = items.length > 1? items[1]:null;
    if (key == null) {
      return null;
    } else if ((key.equalsIgnoreCase("xml") || key.equalsIgnoreCase("html"))
        && (value == null || value.equalsIgnoreCase("xml") ||  
            value.equalsIgnoreCase("html"))){
      // TODO: change hard code supported type.
      return new ConversionType(key, value);
    } else if (key.startsWith("@@")){
      return new Macro(key, value);
    } else if (key.equalsIgnoreCase("URL")) {
      return new UrlList(key, value);
    } else {
      return new Let(key, value);
    }
  }
}
