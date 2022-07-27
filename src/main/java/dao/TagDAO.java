package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDAO extends Database {
	final private String TABLE = "Tag";
	final private String EXAM_ID = "ExamID";
	final private String TAG = "Tag";
	
	public List<String> findTag(String examID){
		List<String> tagList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT "+ TAG + " FROM " + TABLE + " WHERE " + EXAM_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, examID);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String tag = rs.getString(TAG);
				tagList.add(tag);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tagList;
	}
}
