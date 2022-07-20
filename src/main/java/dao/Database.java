package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private final String JDBC_URL="";
	private final String DB_USER="";
	private final String DB_PASS="";
	
	protected boolean ConnectDatabase() {
		//databaseにアクセスし、成功ならtrue　失敗ならfalseを返す
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
		}catch(SQLException e) {
			return false;
		}
		return true;
	}
}
