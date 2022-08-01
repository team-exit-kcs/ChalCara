package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.Genre;

public class GenreDAO extends Database {
	final private String TABLE = "Genre";
	final private String GENRE_ID = "GenreID";
	final private String GENRE_NAME = "GenreName";
	
	public String findGenreName(int genreID) {
		String genreName = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ GENRE_NAME + " FROM " + TABLE + " WHERE " + GENRE_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, genreID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				genreName = rs.getString(GENRE_NAME);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return genreName;
	}
	
	public List<Genre> findAll(){
		List<Genre> genreList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int genreID = rs.getInt(GENRE_ID);
				String genreName = rs.getString(GENRE_NAME);
				genreList.add(new Genre(genreID, genreName));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return genreList;
	}
}
