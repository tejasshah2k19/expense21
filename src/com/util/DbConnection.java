package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
//	public static void main(String[] args) {
//		getConnection();
//	}
	private static String url = "jdbc:postgresql://localhost:5434/expense21";
	private static String userName = "postgres";
	private static String password = "root";
	private static String driverClass = "org.postgresql.Driver";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("something went wrong in DbConnection....");
			e.printStackTrace();
		}
		return con;
	}
}
