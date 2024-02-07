
package dao;

/**
 *
 * @author amina
 */

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
   // private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    //private static final String USER = "your_username";
    //private static final String PASSWORD = "your_password";
 
    private Connection connection;

    public DatabaseHandler() {
        try {
           // connection = DriverManager.getConnection(URL, USER, PASSWORD);
       connection = DriverManager.getConnection("jdbc:mysql://localhost/warehouse?autoReconnect=true&useSSL=false","root","");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

   
