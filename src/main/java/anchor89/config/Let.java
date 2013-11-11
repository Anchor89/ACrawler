package anchor89.config;

import java.util.ArrayList;
import java.util.List;

public class Let extends KeyValue {

	public Let(String key) {
		super(key);
	}

	public Let(String key, String value) {
		super(key, value);
	}

	public static List<String> parseXpath(String path) {
	  return parseXpath(path, ">");
	}
	
	public static List<String> parseXpath(String path, String deli) {
	  List<String> result = new ArrayList<String>();
	  if (path != null) {
	    String[] nodes = path.split(deli);
	    for (String node : nodes){
	      result.add(node.trim());
	    }	    
	  }
	  return result;
	}
}
