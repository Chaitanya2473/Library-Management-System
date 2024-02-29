package com.connection;

import java.sql.DriverManager;

import com.commonUtils.Constants;
import com.mysql.jdbc.Connection;

public  class ConnectionProvider {
public static Connection getConnection() {
	
	Connection connection = null;
	
	try {
		Class.forName(Constants.SQLDRIVER);
		 connection =  (Connection) DriverManager.getConnection(Constants.SQLURL, Constants.SQLUSERID, Constants.SQLPWD);
		 System.out.println(connection.getCatalog());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return connection;
}

}


