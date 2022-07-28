package model;

public class Genre {
	final private int genreID;
	final private String genreName;
	public Genre(int genreID, String genreName) {
		this.genreID = genreID;
		this.genreName = genreName;
	}
	public int getGenreID() {
		return genreID;
	}
	public String getGenreName() {
		return genreName;
	}
	
}
