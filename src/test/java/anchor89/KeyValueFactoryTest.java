package anchor89;

import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import anchor89.config.ConversionType;
import anchor89.config.KeyValue;
import anchor89.config.KeyValueFactory;
import anchor89.config.Let;
import anchor89.config.Macro;
import anchor89.config.UrlList;

public class KeyValueFactoryTest {
  final private static Logger logger = LogManager
      .getLogger(KeyValueFactoryTest.class);
  
  @Test
  public void test() {
    match("xml=html", ConversionType.class);
//    match("@@url=somth", Macro.class);
//    nomatch("@asdo=asdfa", Macro.class);
    match("url=http://aaaaa", UrlList.class);
    match("url=file://bbbb", UrlList.class);
    nomatch("@url=htpp:/cccc", UrlList.class);
    match("a=b", Let.class);
    match("@a=bb@c", Let.class);
    match("aa@aa=bb@bb", Let.class);    
  }
  
  protected void match(String line, Class c) {
    KeyValue kv = KeyValueFactory.fromString(line);
    assertTrue(c.isInstance(kv));
  }
  
  protected void nomatch(String line, Class c) {
    KeyValue kv = KeyValueFactory.fromString(line);
    assertFalse(c.isInstance(kv));
  }
}
