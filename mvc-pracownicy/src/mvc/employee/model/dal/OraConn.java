package mvc.employee.model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraConn {

	static Connection connection = null;
	static boolean registered=false;
	static SQLException exception=null;

	private static void registerDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Sterownik Oracle JDBC zostal zarejestrowany.");
			registered=true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Brak sterownika JDBC.");
		}
	}

	public static int open(String host, String user, String password) {
		if(!registered)
		{
			registerDriver();
		}
		try {
			connection = DriverManager.getConnection(host, user, password);
		} catch (SQLException ex) {
			exception=ex;
			return 1;
		}
		return 0;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static String getErr() {
		if(exception!=null)
			return Integer.toString(exception.getErrorCode());
		return "";
	}

	public static String getErrMsg() {
		if(exception!=null)
			return exception.getMessage();
		return "";
	}

	public static void close() {
		try {
			if(connection!=null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
