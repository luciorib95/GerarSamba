package br.com.logusinfo.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil {
    static String jdbcURL = "jdbc:oracle:thin:@//10.10.50.38:1521/orclpdbdsv";
    static String username = "teste";
    static String password = "teste";
	
	private static InheritableThreadLocal<Connection> connection;
	
	static {
		connection = new InheritableThreadLocal<Connection>();
	}
	
	public static Connection init() throws ConnectionException{
		try {
			if (connection.get() == null) {
				Connection c = DriverManager.getConnection(jdbcURL, username, password);
				c.setAutoCommit(false);		
				connection.set(c);				
			}
		} catch (SQLException e) {
			throw new ConnectionException("Erro ao abrir uma conexão");
		}
		return connection.get();	
	}

}
