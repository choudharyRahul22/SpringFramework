package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/world?useSSL=false";
		String USERNAME = "root";
		String PASSWORD = "$Dec2017";
		
		try {
			System.out.println("Connecting to database " + URL);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connection successful " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
