
package dao;

/**
 *
 * @author amina
 */

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHandler implements AutoCloseable {

    private Connection connection;

    public DatabaseHandler() {
        try {
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost/warehouse?autoReconnect=true&useSSL=false&", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


   
