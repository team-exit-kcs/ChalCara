package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.Account;
import model.data.Login;

public class AccountDAO extends Database {
	
	final private String TABLE = "Account";
	final private String USER_ID = "UserID";
	final private String PASS = "Password";
	final private String PROFILE = "Profile";
	final private String ICON = "Icon";
	
	public Account findByAccount(Login login) {
		Account account = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + USER_ID + "," + PROFILE + "," + ICON + " FROM " + TABLE + " WHERE " + USER_ID + " = ? AND " + PASS + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserID());
			pStmt.setString(2, login.getPASS());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userID = rs.getString(USER_ID);
				String profile = rs.getString(PROFILE);
				String icon = rs.getString(ICON);
				account = new Account(userID,profile,icon);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return account;
	}
	
	public Account findByAccount(String ID) {
		Account account = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + USER_ID + "," + PROFILE + "," + ICON + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ID);

			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userID = rs.getString(USER_ID);
				String profile = rs.getString(PROFILE);
				String icon = rs.getString(ICON);
				account = new Account(userID,profile,icon);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return account;
	}
	
	public boolean isID(String id){
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT " + USER_ID + " FROM " + TABLE + " WHERE " + USER_ID + " = ?";
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
	
	public boolean setAccount(Login login) {
		boolean resultSts=false;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "INSERT INTO " + TABLE + " VALUES(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserID());
			pStmt.setString(2, login.getPASS());
			pStmt.setString(3, "/ExamPlatform/img/kari.png");
			pStmt.setString(4, "");
			
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
