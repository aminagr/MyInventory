
package dao;

import java.sql.Connection;
import java.sql.Date;
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
public class InventoryDAO {
    private DatabaseHandler databaseHandler;

    public InventoryDAO(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }
public void addInventoryRecord(Inventory inventory) throws SQLException {
        String query = "INSERT INTO inventory (product_id, quantity, transaction_type, transaction_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, inventory.getProductId());
            preparedStatement.setInt(2, inventory.getQuantity());
            preparedStatement.setString(3, inventory.getTransactionType());
            preparedStatement.setDate(4, new java.sql.Date(inventory.getTransactionDate().getTime()));
            preparedStatement.executeUpdate();

           
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                inventory.setId(generatedKeys.getInt(1));
            }
        }
    }



public List<Inventory> getAllInventoryRecords() throws SQLException {
        List<Inventory> inventoryList = new ArrayList<>();
        String query = "SELECT * FROM inventory";
        try (Connection connection = databaseHandler.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Inventory inventory = mapResultSetToInventory(resultSet);
                    inventoryList.add(inventory);
                }
            }
        }
        return inventoryList;
    }


private Inventory mapResultSetToInventory(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int productId = resultSet.getInt("product_id");
        int quantity = resultSet.getInt("quantity");
        String transactionType = resultSet.getString("transaction_type");
        java.sql.Date transactionDate = resultSet.getDate("transaction_date");

        return new Inventory(id, productId, quantity, transactionType, new Date(transactionDate.getTime()));
    }

}
