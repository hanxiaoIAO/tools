package tools.iniTool;

public class Property {
	public Property(String key, String value) {
		this.key = key;
		this.value = value;
	}

	String key;
	String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

}
