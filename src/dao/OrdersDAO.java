
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amina
 */
public class OrdersDAO {



    private DatabaseHandler databaseHandler;


    public OrdersDAO() {
    
        databaseHandler = new DatabaseHandler();
    }

    
    public List<Orders> getAllOrders() {
        List<Orders> ordersList = new ArrayList<>();

        try (Statement statement = databaseHandler.getConnection().createStatement()) {
     String query = "SELECT o.id, o.product_id, p.nom AS product_name, " +
               "c.nom AS client_name, o.order_date, o.quantity, " +
               "o.total_amount " +
               "FROM orders o " +
               "JOIN produits p ON o.product_id = p.id " +
               "JOIN client c ON o.client_id = c.id " +
               "WHERE o.statut = 'pending'";


            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Orders order = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("client_name"),
                        resultSet.getTimestamp("order_date"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("total_amount")
                      
                );

                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return ordersList;
    }
    
    
    
    
     public List<Orders> getAcceptedOrders() {
        List<Orders> ordersList = new ArrayList<>();

        try (Statement statement = databaseHandler.getConnection().createStatement()) {
     String query = "SELECT o.id, o.product_id, p.nom AS product_name, " +
               "c.nom AS client_name, o.order_date, o.quantity, " +
               "o.total_amount " +
               "FROM orders o " +
               "JOIN produits p ON o.product_id = p.id " +
               "JOIN client c ON o.client_id = c.id " +
               "WHERE o.statut = 'accepted'";


            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Orders order = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("client_name"),
                        resultSet.getTimestamp("order_date"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("total_amount")
                      
                );

                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return ordersList;
    }
     
     
     public List<Orders> getRejectedOrders() {
        List<Orders> ordersList = new ArrayList<>();

        try (Statement statement = databaseHandler.getConnection().createStatement()) {
     String query = "SELECT o.id, o.product_id, p.nom AS product_name, " +
               "c.nom AS client_name, o.order_date, o.quantity, " +
               "o.total_amount " +
               "FROM orders o " +
               "JOIN produits p ON o.product_id = p.id " +
               "JOIN client c ON o.client_id = c.id " +
               "WHERE o.statut = 'rejected'";


            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Orders order = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("client_name"),
                        resultSet.getTimestamp("order_date"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("total_amount")
                      
                );

                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return ordersList;
    }
    
    
    
    
    
    public void updateStatusToAccepted(int id) {
        String query = "UPDATE orders SET statut = ? WHERE id = ?";

        try (PreparedStatement pstmt = databaseHandler.getConnection().prepareStatement(query)) {
            // Set the new status and ID in the prepared statement
            pstmt.setString(1, "accepted");
            pstmt.setInt(2, id);

            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStatusToRejected(int id) {
        String query = "UPDATE orders SET statut = ? WHERE id = ?";

        try (PreparedStatement pstmt = databaseHandler.getConnection().prepareStatement(query))
        {
            // Set the new status and ID in the prepared statement
            pstmt.setString(1, "rejected");
            pstmt.setInt(2, id);

            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating status to rejected: " + e.getMessage());
        }
    }
    
     public void updateStatusToPending(int id) {
        String query = "UPDATE orders SET statut = ? WHERE id = ?";

        try (PreparedStatement pstmt = databaseHandler.getConnection().prepareStatement(query)) {
            // Set the new status and ID in the prepared statement
            pstmt.setString(1, "pending");
            pstmt.setInt(2, id);

            // Execute the update statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

   
}


