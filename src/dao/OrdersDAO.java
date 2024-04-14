
package dao;

import java.sql.Connection;
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
    
    public void updateStatusToRejected(int orderId) {
    String selectQuery = "SELECT product_id, quantity FROM orders WHERE id = ?";
    String updateStatusQuery = "UPDATE orders SET statut = ? WHERE id = ?";
    String updateProductQtyQuery = "UPDATE produits SET qt = qt + ? WHERE id = ?";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
         PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery);
         PreparedStatement updateProductQtyStmt = connection.prepareStatement(updateProductQtyQuery)) {

        // Set orderId to the PreparedStatement
        selectStmt.setInt(1, orderId);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            int quantityRejected = resultSet.getInt("quantity");

            // Update the status of the order
            updateStatusStmt.setString(1, "rejected");
            updateStatusStmt.setInt(2, orderId);
            updateStatusStmt.executeUpdate();

            // Update the quantity in produits table by adding back the rejected quantity
            updateProductQtyStmt.setInt(1, quantityRejected);
            updateProductQtyStmt.setInt(2, productId);
            updateProductQtyStmt.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
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
    
  public void updateStatusToSold(int orderId) {
    String selectQuery = "SELECT o.product_id, o.quantity " +
                         "FROM orders o " +
                         "WHERE o.id = ?";
    String updateStatusQuery = "UPDATE orders SET statut = ? WHERE id = ?";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
         PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery)) {

        // Set orderId to the PreparedStatement
        selectStmt.setInt(1, orderId);
        ResultSet resultSet = selectStmt.executeQuery();
        if (resultSet.next()) {
            int productId = resultSet.getInt("product_id");

            // Update the status of the order
            updateStatusStmt.setString(1, "sold");
            updateStatusStmt.setInt(2, orderId);
            updateStatusStmt.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



   


 public List<Orders> getSoldOrders() {
        List<Orders> ordersList = new ArrayList<>();

        try (Statement statement = databaseHandler.getConnection().createStatement()) {
     String query = "SELECT o.id, o.product_id, p.nom AS product_name, " +
               "c.nom AS client_name, o.order_date, o.quantity, " +
               "o.total_amount " +
               "FROM orders o " +
               "JOIN produits p ON o.product_id = p.id " +
               "JOIN client c ON o.client_id = c.id " +
               "WHERE o.statut = 'sold'";


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
 
 
 
 public double calculateNetGain() {
        double netGain = 0;

        try (Statement statement = databaseHandler.getConnection().createStatement())  {

            String query = "SELECT SUM(o.total_amount) - SUM(p.prix * o.quantity) AS gain_net " +
                           "FROM orders o " +
                           "JOIN produits p ON o.product_id = p.id " +
                           "WHERE o.statut = 'sold'";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                netGain = resultSet.getDouble("gain_net");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return netGain;
    }
 
 public double calculateTotalRevenue() {
        double totalRevenue = 0;

        try (Statement statement = databaseHandler.getConnection().createStatement()) {

            String query = "SELECT SUM(o.total_amount) AS total_revenue " +
                           "FROM orders o " +
                           "WHERE o.statut = 'sold'";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalRevenue = resultSet.getDouble("total_revenue");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRevenue;
    }
 
 
 
 
 public int getTotalPendingOrders() {
        int totalPendingOrders = 0;

        try (Statement statement = databaseHandler.getConnection().createStatement())  {

            String query = "SELECT COUNT(*) AS total_pending_orders " +
                           "FROM orders " +
                           "WHERE statut = 'pending'";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalPendingOrders = resultSet.getInt("total_pending_orders");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPendingOrders;
    }

  public int getTotalSoldOrders() {
        int totalPendingOrders = 0;

        try (Statement statement = databaseHandler.getConnection().createStatement())  {

            String query = "SELECT COUNT(*) AS total_sold_orders " +
                           "FROM orders " +
                           "WHERE statut = 'sold'";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalPendingOrders = resultSet.getInt("total_sold_orders");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPendingOrders;
    }
  
  

 
    public void addOrder(int productId, int clientId, int userId, int quantity) {
        String insertOrderQuery = "INSERT INTO orders (product_id, client_id, user_id, quantity, total_amount, statut) VALUES (?, ?, ?, ?, ?, ?)";

        try (
             PreparedStatement insertStatement = databaseHandler.getConnection().prepareStatement(insertOrderQuery)) {

            // Validate product existence
            if (!isProductExists(productId)) {
                throw new IllegalArgumentException("Product ID does not exist");
            }

            // Validate client existence
            if (!isClientExists(clientId)) {
                throw new IllegalArgumentException("Client ID does not exist");
            }

            // Check if the quantity of the order is less than or equal to the existing quantity of the product
            if (!isSufficientQuantity(productId, quantity)) {
                throw new IllegalArgumentException("Insufficient quantity of the product");
            }

            // Get product price from database
            double productPrice = getProductPrice(productId);

            // Calculate total amount
            double totalAmount = productPrice * quantity;

            // Insert new order
            insertStatement.setInt(1, productId);
            insertStatement.setInt(2, clientId);
            insertStatement.setInt(3, userId);
            insertStatement.setInt(4, quantity);
            insertStatement.setDouble(5, totalAmount);
            insertStatement.setString(6, "pending");

            insertStatement.executeUpdate();

            // Update the quantity of the product
          updateProductQuantity(productId, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public boolean isProductExists(int productId) throws SQLException {
        String productQuery = "SELECT id FROM produits WHERE id = ?";
        try (
             PreparedStatement productStatement = databaseHandler.getConnection().prepareStatement(productQuery)) {
            productStatement.setInt(1, productId);
            try (ResultSet productResult = productStatement.executeQuery()) {
                return productResult.next();
            }
        }
    }

    public boolean isClientExists(int clientId) throws SQLException {
        String clientQuery = "SELECT id FROM client WHERE id = ?";
        try (
             PreparedStatement clientStatement = databaseHandler.getConnection().prepareStatement(clientQuery)) {
            clientStatement.setInt(1, clientId);
            try (ResultSet clientResult = clientStatement.executeQuery()) {
                return clientResult.next();
            }
        }
    }

    public boolean isSufficientQuantity(int productId, int orderQuantity) throws SQLException {
        String productQuantityQuery = "SELECT qt FROM produits WHERE id = ?";
        try (
             PreparedStatement productQuantityStatement = databaseHandler.getConnection().prepareStatement(productQuantityQuery)) {
            productQuantityStatement.setInt(1, productId);
            try (ResultSet resultSet = productQuantityStatement.executeQuery()) {
                if (resultSet.next()) {
                    int existingQuantity = resultSet.getInt("qt");
                    return existingQuantity >= orderQuantity;
                } else {
                    throw new IllegalArgumentException("Product ID does not exist");
                }
            }
        }
    }

    public double getProductPrice(int productId) throws SQLException {
        String productPriceQuery = "SELECT prixv FROM produits WHERE id = ?";
        try (
             PreparedStatement productPriceStatement = databaseHandler.getConnection().prepareStatement(productPriceQuery)) {
            productPriceStatement.setInt(1, productId);
            try (ResultSet resultSet = productPriceStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("prixv");
                } else {
                    throw new IllegalArgumentException("Product ID does not exist");
                }
            }
        }
    }

public void updateProductQuantity(int productId, int orderQuantity) throws SQLException {
    String productQuantityQuery = "SELECT qt FROM produits WHERE id = ?";
    String updateQuantityQuery = "UPDATE produits SET qt = ? WHERE id = ?";
    
    try (PreparedStatement productQuantityStatement = databaseHandler.getConnection().prepareStatement(productQuantityQuery);
         PreparedStatement updateStatement = databaseHandler.getConnection().prepareStatement(updateQuantityQuery)) {
        
        // Get existing quantity
        productQuantityStatement.setInt(1, productId);
        try (ResultSet resultSet = productQuantityStatement.executeQuery()) {
            if (resultSet.next()) {
                int existingQuantity = resultSet.getInt("qt");
                
                // Calculate updated quantity
                int updatedQuantity = existingQuantity - orderQuantity;
                updatedQuantity = Math.max(updatedQuantity, 0); // Ensure quantity doesn't go below 0
                
                // Update quantity
                updateStatement.setInt(1, updatedQuantity);
                updateStatement.setInt(2, productId);
                updateStatement.executeUpdate();
            } else {
                throw new IllegalArgumentException("Product ID does not exist");
            }
        }
    }
}
}







   
  
  

  
  
