package model.data;

import java.io.Serializable;

public class Search implements Serializable {
	final private int EXAM = 0;
	final private int USER = 1;
	
	final private int type;
	final private String icon;
	final private String URL;
	final private String name;
	
	public Search(int type, String icon, String URL, String name) {
		this.type = type;
		this.icon = icon;
		this.URL = URL;
		this.name = name;
	}

	
	public int getEXAM() {
		return EXAM;
	}


	public int getUSER() {
		return USER;
	}

	public int getType() {
		return type;
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
