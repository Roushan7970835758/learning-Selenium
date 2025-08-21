package selenium.SQLDBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase {
	public static void main(String[] args) throws SQLException {
		
		String hostName = "localhost";
		String port = "3306";
		
		Connection conn = DriverManager.getConnection(
                "jdbc:mysql://" + hostName + ":" + port + "/QASelenium",
                "root",
                "Roushan@123"
            );
		
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT username, password FROM credentials\r\n"
				+ "WHERE scenario = 'zerobalancecard';");
		
		while(rs.next()) {
			System.out.println("User Name: "+rs.getString("username"));
			System.out.println("Password: "+rs.getString("password"));
		}
		
		conn.close();
		
	}

}
