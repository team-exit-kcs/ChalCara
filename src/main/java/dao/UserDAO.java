package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class UserDAO extends Database {
	public User findByLogin(Account account) {
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(super.JDBC_URL, super.DB_USER, super.DB_PASS)){
			String sql = "SELECT ID FROM UserID WHERE USER_ID = ? AND PASS = ?";
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
}
