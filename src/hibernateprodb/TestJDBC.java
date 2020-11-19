package hibernateprodb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/hibernaterbt?useSSL=false";
		
		String user = "root";
		
		String password = "";
				
			try {
				
				System.out.println("Trying to connect to DB");
				
				Connection myConnection = DriverManager.getConnection(jdbcurl, user, password);
				
				System.out.println("Succesfully connection!!");
					
			}catch(Exception e) {
					e.printStackTrace();
			}

	
	}
}
