package co.edu.ufps.SegundoPrevio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGeneric {
	
	private static final long serialVersionUID = 1L;

	private static Connection c;

	public ConnectionGeneric() {

	}

	public static Connection getConnection() {
		try {
			Class.forName(Server.DRIVER_BD);
			c = (Connection) DriverManager.getConnection(Server.URL, Server.USER_BD, Server.PASSWORD_BD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		ConnectionGeneric.c = c;
	}
	
}
