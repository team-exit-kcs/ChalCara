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
	
	public List<String> findAll(){
		List<String> tagList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT DISTINCT "+ TAG + " FROM " + TABLE + " ORDER BY " + TAG;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
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
	
	public boolean setTag(String examID,List<String> tagList) {
		if(tagList == null || tagList.isEmpty()) {
			return true;
		}else {
			boolean resultSts=false;
		
			try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
				int result=0;
			
				String sql = "INSERT INTO " + TABLE + "VALUES(?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				pStmt.setString(1, examID);
				
				for(String tag: tagList) {
					pStmt.setString(2, tag);
					result += pStmt.executeUpdate();
				}
			
				if(result>=tagList.size()) {
					resultSts=true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		
			return resultSts;
		}
	}
}
