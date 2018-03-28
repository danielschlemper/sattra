package br.com.sattra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {
	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://localhost/sattra";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection getConection() {
		Connection conn = null;		
		try {

			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/sattra", "root", "root");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} // end main
		return conn;
	}
	
}
