package anchor89.crawl;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.Element;

import anchor89.config.Let;

public class XmlSetter {
  final private static Logger logger = LogManager.getLogger(XmlSetter.class);
  
  private Document root = null;
  
  /**
   * 
   * @param root Can be empty document.
   */
  public XmlSetter(Document root) {
    this.root = root;
  }
  
  public void setText(String path, String value) {
    List<String> nodes = Let.parseXpath(path);
    Element cur = createFollowPath(nodes);
    cur.setText(value);
  }
  
  public void setAttr(String path, String key, String value) {
    List<String> nodes = Let.parseXpath(path);
    Element cur = createFollowPath(nodes);
    cur.addAttribute(key, value);
  }
  
  protected Element createFollowPath(List<String> path) {
    if (path != null && path.size() > 0) {
      Element cur = root.getRootElement();
      Element next = null;
      if (cur == null) {
        cur = root.addElement(path.get(0));
      }      
      for (int i=1; i<path.size(); i++) {
        next = cur.element(path.get(i));
        cur = next == null? cur.addElement(path.get(i)):next;
      }
      return cur;
    } else {
      return null;
    }
    
  }
}
