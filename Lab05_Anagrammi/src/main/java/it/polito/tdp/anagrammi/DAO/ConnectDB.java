package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	// check user e password
	public  static  Connection  getConnection () throws SQLException {
	String jdbcURL =  "jdbc:mysql://localhost/dizionario?user=root&password=root"  ;
	return DriverManager . getConnection (jdbcURL);
}

}
