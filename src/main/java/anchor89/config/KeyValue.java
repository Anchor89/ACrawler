package anchor89.config;

/**
 * Store a pair of key and value read from config file.
 * @author Anchor
 *
 */
public class KeyValue {
	private String key = null;
	private String value = null;
	
	public KeyValue(String key) {
		this.key = key;
	}
	
	public KeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
