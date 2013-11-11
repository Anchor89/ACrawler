package anchor89.util;

import java.util.Collection;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class StringUtil {
  final private static Logger logger = LogManager.getLogger(StringUtil.class);
  
  public static String join(Collection<?> c, String deli) {
    StringBuilder sb = new StringBuilder();
    if (c.size() > 0) {
      boolean first = true;
      for (Object o : c) {
        if (!first) {
          sb.append(deli);
        } else {
          first = false;
        }
        sb.append(o.toString());          
      }
    }
    return sb.toString(); 
  }
}
