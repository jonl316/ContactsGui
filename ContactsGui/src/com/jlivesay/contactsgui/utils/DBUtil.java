package com.jlivesay.contactsgui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{

	public static final String DB_USERNAME = "dbuser";
	public static final String DB_PASSWORD = "12345";
	public static final String M_CONN_STRING = 
			"jdbc:mysql://10.0.100.225/contacts";
	
	
	public static Connection getConnection(DBType dbType) throws SQLException
	{
		switch (dbType)
		{
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, DB_USERNAME, DB_PASSWORD);
		case HSQLDB:
			return null;
		case SQLLITE:
			return null;
		default:
			return null;		
		}// end switch 
	}// end getConnection Method
	
	
	public static void processException(SQLException e)
	{
		System.err.println("Error Message: " + e.getMessage());
		System.err.println("Error Code: " + e.getErrorCode());
		System.err.println("SQL State: " + e.getSQLState());
	}
	
	public static String processExceptionString(SQLException e)
	{
		StringBuilder buf = new StringBuilder();
		buf.append("Error Message: " + e.getMessage() + "\n");
		buf.append("Error Code: " + e.getErrorCode() + "\n");
		buf.append("SQL State: " + e.getSQLState());
		return buf.toString();
	}
	
}
