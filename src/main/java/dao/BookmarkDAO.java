package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bookmark;

public class BookmarkDAO extends Database{
	
	final private String TABLE = "Bookmark";
	final private String EXAM_ID = "ExamID";
	final private String USER_ID = "UserID";
	
	public Bookmark findByBookmark(String userID) {
		Bookmark bookmark = null;
		List<String> examIDList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ EXAM_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userID);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String examID = rs.getString(EXAM_ID);
				examIDList.add(examID);
			}
			bookmark = new Bookmark(userID,examIDList);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return bookmark;
	}
}
