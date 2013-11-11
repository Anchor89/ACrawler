package anchor89;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Try {
  final private static Logger logger = LogManager.getLogger(Try.class);
  
  public Try() {
    // TODO Auto-generated constructor stub
  }
  
  @Test
  public void smoke() {
    assertTrue(true);
    Document doc;
    doc = DocumentHelper.createDocument();
    logger.info("parsed");
    Element cur = doc.getRootElement();
    logger.info(cur);
  }
}
