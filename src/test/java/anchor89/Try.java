package anchor89;

import static org.junit.Assert.*;
import org.junit.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Try {
  final private static Logger logger = LogManager.getLogger(Try.class);
  
  public Try() {
    // TODO Auto-generated constructor stub
  }
  
  @Test
  public void smoke() {
    String line = "    afdasdfads    ";
    String[] items = line.split("=", 2);
    for (String item:items) {
      logger.info(item);
    }
  }
}
