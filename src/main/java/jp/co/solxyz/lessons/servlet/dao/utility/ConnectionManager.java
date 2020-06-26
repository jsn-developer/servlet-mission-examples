package jp.co.solxyz.lessons.servlet.dao.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	final static String URL = "jdbc:mySQL://localhost:3306/customerdb?useSSL=false";
	final static String USER = "root";
	final static String PASS = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			//MySQL に接続する
			Class.forName("com.mysql.jdbc.Driver");
			//データベースに接続
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			// データベースに対する処理
			System.out.println(conn);

			return conn;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
