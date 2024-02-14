/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author amina
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private DatabaseHandler databaseHandler;

    public CustomerDAO() {
        databaseHandler = new DatabaseHandler();
    }

    public void addCustomer(Customer customer) {
        String query = "INSERT INTO client (nom, adresse, phone, mail) VALUES (?, ?, ?, ?)";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getMail());

            preparedStatement.executeUpdate();

            // Retrieve the generated key (customer ID)
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        String query = "UPDATE client SET nom=?, adresse=?, phone=?, mail=? WHERE id=?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getMail());
            preparedStatement.setInt(5, customer.getId());

            preparedStatement.executeUpdate();
            System.out.println("Customer updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        String query = "DELETE FROM client WHERE id=?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, customerId);

            preparedStatement.executeUpdate();
            System.out.println("Customer deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer searchCustomer(int customerId) {
        String query = "SELECT * FROM client WHERE id=?";
        Customer customer = null;

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, customerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("nom"));
                    customer.setAddress(resultSet.getString("adresse"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setMail(resultSet.getString("mail"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public String[] getCustomerNames() {
        List<String> customerNames = new ArrayList<>();

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT nom FROM client");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String customerName = resultSet.getString("nom");
                customerNames.add(customerName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerNames.toArray(new String[0]);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> resultList = new ArrayList<>();
        String query = "SELECT * FROM client";

        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("nom"));
                customer.setAddress(resultSet.getString("adresse"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setMail(resultSet.getString("mail"));

                resultList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    
    }
     
    
      public int getTotalCount() {
    String query = "SELECT COUNT(*) AS total7 FROM client";

    try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        if (resultSet.next()) {
            return resultSet.getInt("total7");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return 0;
}
    
        
        
}


