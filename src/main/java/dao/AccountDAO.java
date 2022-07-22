package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountDAO extends Database {
	
	final private String table = "UserTBL";
	final private String UserID = "User_ID";
	final private String PASS = "PASS";
	
	public User findByLogin(Account account) {
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + UserID + " FROM " + table + " WHERE " + UserID + " = ? AND " + PASS + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUSER_ID());
			pStmt.setString(2, account.getPASS());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("UserID");
				user = new User(id,true);
			}else {
				user = new User(account.getUSER_ID(),false);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	public boolean findByID(String id){
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + UserID + " FROM " + table + " WHERE " + UserID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
	
	public boolean setAccount(Account account) {
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + table + "";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUSER_ID());
			pStmt.setString(2, account.getPASS());
			
			int result = pStmt.executeUpdate();
			if(result>0) {
				resultSts=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return resultSts;
	}
}
