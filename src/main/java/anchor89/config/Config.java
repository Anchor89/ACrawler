package anchor89.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The content of config file will be parsed and store here.
 * Config file is in following grammar:
 * ConversionType:: xml=html
 * Macro:: @name=Content
 * UrlList:: URL=(http://.*)|(file://.*)|Content
 * Let:: xmlPath=Content
 * Content:: CssSelector [|] Extractor
 * CssSelector:: a subset of CSS selector.
 * Extractor:: Name of a class.
 * Comment start with a "#" and must be line comment.
 * 
 * Description:
 *  ConversionType: Convert one type of pages to another type of pages.
 *  	E.g: "xml=html" convert HTML file to XML file. Case-insensitive.
 *  
 *  Macro: Store a string and be used in later context. This is just an 
 *   	easy replace instruction. The macro start with "@@" as prefix
 *    and start with "@" when using.
 *   	E.g: "@@article=book>chapter>asia" then a line "@article>china=something" 
 *   	will be replaced to "book>chapter>asia>china=something".
 *   
 *  UrlList: URL is a reserved variable to tell which URL to crawl. It can
 *  	be set using literal string or content crawled from previous pages.
 *  
 *  Content: First using CSS selector to select some tags and then pipe
 *  	these tags(string in HTML) to an extractor which is a kind of class
 *  	that take a string as parameter and return another string.
 *  	If the CSS selector select more than one tags, then returned string
 *  	will also be put into a list. 
 *  
 *  @author Anchor
 *
 */
public class Config {
  final private static Logger logger = LogManager.getLogger(Config.class);
	private List<KeyValue> lines = new ArrayList<KeyValue>();
	private Map<String, String> macros = new HashMap<String, String>();
	
	public static Config readFile(String path) {
	  Config result = new Config();
	  try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(null);
      String line = br.readLine();
      KeyValue kv = null;
      while(line != null) {
        kv = KeyValueFactory.fromString(line);
        result.lines.add(kv);
      }
    } catch (FileNotFoundException e) {
      logger.error(e);
    } catch (IOException e) {
      logger.error(e);
    }
	  
	  return result;
	}
}
