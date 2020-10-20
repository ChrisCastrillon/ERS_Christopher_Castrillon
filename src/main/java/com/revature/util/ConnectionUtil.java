package com.revature.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
    private static Connection connection = null;
    
    private ConnectionUtil() {
        super();
    }
    public static Connection getConnection() {
        try {
            if(connection != null && !connection.isClosed()) {
                return connection;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO REUSE A CONNECTION");
            return null;
        }
    
    
//        String url = "jdbc:postgresql://training.cio3nwbbkrum.us-east-1.rds.amazonaws.com";
//        
//        String username = "root";
//        String password = "password";
        String url = System.getenv("db_url");
        String username = System.getenv("db_username");
        String password = System.getenv("db_password");
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO GET A CONNECTION!");
            return null;
        }
        return connection;
    }
    

}
