package com.revature.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    /**The connetion field is static as well as its getter method.
     * This is because the connection field belongs to the class, and not an instance of connection.
     * Moreover, the connection util constructor is private, meaning that the only way to create a connection is by 
     * using the only instance of the connection that is created -- this is becuase the constructor can only be accessed by ConnectionUtil
     * class itself. No outside class can instantiate a Connection Util object.
     * 
     * The get connection method is static, and it is used to be able to access the static Connection field.
     * By being the only public method, the getConnection() method is the only means by which one can create a connection.
     * 
     */
    private static Connection connection = null;
    
    private ConnectionUtil() {
        super();
    }
    public static Connection getConnection() {
        try {
            if(connection != null && !connection.isClosed()) {
                //if there is no connection or the connection is closed then 
                //return a new connection. 
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
