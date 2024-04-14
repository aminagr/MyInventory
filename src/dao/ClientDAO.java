package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private DatabaseHandler databaseHandler;

    public ClientDAO() {
        databaseHandler = new DatabaseHandler();
    }

    public void addClient(Client client) {
        String query = "INSERT INTO client (nom, adresse, phone, mail) VALUES (?, ?, ?, ?)";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getAddress());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getMail());

            preparedStatement.executeUpdate();

            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        String query = "UPDATE client SET nom=?, adresse=?, phone=?, mail=? WHERE id=?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getAddress());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getMail());
            preparedStatement.setInt(5, client.getId());

            preparedStatement.executeUpdate();
            System.out.println("Client updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        String query = "DELETE FROM client WHERE id=?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, clientId);

            preparedStatement.executeUpdate();
            System.out.println("Client deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public List<Client> searchClient(String searchKeyword) {
    String query = "SELECT * FROM client WHERE id=? OR nom LIKE ? OR adresse LIKE ? OR phone LIKE ? OR mail LIKE ?";
    List<Client> searchResults = new ArrayList<>();

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        // Set searchKeyword to all parameters
        preparedStatement.setString(1, searchKeyword);
        preparedStatement.setString(2, "%" + searchKeyword + "%");
        preparedStatement.setString(3, "%" + searchKeyword + "%");
        preparedStatement.setString(4, "%" + searchKeyword + "%");
        preparedStatement.setString(5, "%" + searchKeyword + "%");

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("nom"));
                client.setAddress(resultSet.getString("adresse"));
                client.setPhone(resultSet.getString("phone"));
                client.setMail(resultSet.getString("mail"));
                searchResults.add(client);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return searchResults;
}



    public String[] getClientNames() {
        List<String> clientNames = new ArrayList<>();

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT nom FROM client");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String clientName = resultSet.getString("nom");
                clientNames.add(clientName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientNames.toArray(new String[0]);
    }

    public List<Client> getAllClients() {
        List<Client> resultList = new ArrayList<>();
        String query = "SELECT * FROM client";

        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("nom"));
                client.setAddress(resultSet.getString("adresse"));
                client.setPhone(resultSet.getString("phone"));
                client.setMail(resultSet.getString("mail"));

                resultList.add(client);
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
