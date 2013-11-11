package anchor89.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import anchor89.util.StringUtil;

public class StringUtilTest {
  final private static Logger logger = LogManager
      .getLogger(StringUtilTest.class);
  
  @Test
  public void test() {
    List<String> list = Arrays.asList("abc", "123", "(&(*(");
    assertEquals("abc,123,(&(*(", StringUtil.join(list, ","));
    assertEquals("abc:123:(&(*(", StringUtil.join(list, ":"));
    assertEquals("abc", StringUtil.join(Arrays.asList("abc"), ":"));
  }
}
