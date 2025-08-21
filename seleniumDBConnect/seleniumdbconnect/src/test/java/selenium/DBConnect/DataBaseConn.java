package selenium.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConn {
public static void main(String[] args) {
        // This is a placeholder for database connection logic
        System.out.println("Database connection logic goes here.");

        String hostName = "Roushan";
        String port = "3306";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://" + hostName + ":" + port + "/QASelenium",
                "host",
                "Roushan@123"
            );
            System.out.println("Connected to database successfully.");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
