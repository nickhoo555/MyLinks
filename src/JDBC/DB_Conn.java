package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Conn {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USERNAME = "scott";
	public static final String PASS = "tiger";
	
	public Connection getConn() throws ClassNotFoundException, SQLException 
	{
		Class.forName(DRIVER);
		Connection conn = null;
		conn = DriverManager.getConnection(URL,USERNAME,PASS);
		return conn;
	}
}
