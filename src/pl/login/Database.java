package pl.login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Database extends SQLException {
	private static final long serialVersionUID = 1L;
	
	private String DRIVER = "driver";
	private String URL = "url";
	private String USER = "user";
	private String PASSWORD = "password";

	private int checkIfUserExist(String user) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		String QUERY = "{call p_signin.checkIfUserExist(?,?)}";
		int result = 0;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			cstmt = connection.prepareCall(QUERY);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.setString(1, user);
			cstmt.execute();
			result = cstmt.getInt(2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cstmt != null)
				cstmt.close();
			if (connection != null)
				connection.close();
		}
		return result;
	}
	
	private int checkIfUserPasswordExist(String user, String password) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		String QUERY = "{call p_signin.checkIfUserPasswordExist(?,?,?)}";
		int result = 0;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			cstmt = connection.prepareCall(QUERY);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.setString(1, user);
			cstmt.setString(2, password);
			cstmt.execute();
			result = cstmt.getInt(3);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cstmt != null)
				cstmt.close();
			if (connection != null)
				connection.close();
		}
		return result;
	}
	
	public boolean signup(String user, String password) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		String QUERY = "{call p_signin.signup(?,?)}";
		if(checkIfUserExist(user) == 0) {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				cstmt = connection.prepareCall(QUERY);
				cstmt.setString(1, user);
				cstmt.setString(2, password);
				cstmt.execute();
				passwordHistory(user, password);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (cstmt != null)
					cstmt.close();
				if (connection != null)
					connection.close();
			}
		}		
		return false;
	}
	
	public boolean changePassword(String user, String password) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		String QUERY = "{call p_signin.changePassword(?,?)}";
		if(checkIfUserExist(user) > 0 && checkIfUserPasswordExist(user, password) == 0) {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				cstmt = connection.prepareCall(QUERY);
				cstmt.setString(1, user);
				cstmt.setString(2, password);
				cstmt.execute();
				passwordHistory(user, password);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (cstmt != null)
					cstmt.close();
				if (connection != null)
					connection.close();
			}
		}		
		return false;
	}
	
	private void passwordHistory(String user, String password) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		String QUERY = "{call p_signin.savePassswordHistory(?,?)}";
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			cstmt = connection.prepareCall(QUERY);
			cstmt.setString(1, user);
			cstmt.setString(2, password);
			cstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cstmt != null)
				cstmt.close();
			if (connection != null)
				connection.close();
		}		
	}
}
