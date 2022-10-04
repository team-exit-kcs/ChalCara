package model.data;

import java.io.Serializable;

public class Search implements Serializable {
	final private String icon;
	final private String URL;
	final private String name;
	
	public Search(String icon, String URL, String name) {
		this.icon = icon;
		this.URL = URL;
		this.name = name;
	}
	
	public String getIcon() {
		return icon;
	}

	public String getURL() {
		return URL;
	}

	public String getName() {
		return name;
	}
}
