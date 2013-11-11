package anchor89.crawl;

import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import anchor89.crawl.XmlSetter;

public class XmlSetterTest {
  final private static Logger logger = LogManager
      .getLogger(XmlSetterTest.class);
  
  @Test
  public void test() {
    Document doc = DocumentHelper.createDocument();
    XmlSetter xs = new XmlSetter(doc);
    xs.setText("bookstore>book>title", "java");
    xs.setText("bookstore>book>author", "someone");
    xs.setText("bookstore>book>date", "someday");
    xs.setAttr("bookstore>book", "id", "1111");
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bookstore><book id=\"1111\"><title>java</title><author>someone</author><date>someday</date></book></bookstore>", doc.asXML());
  }
}
