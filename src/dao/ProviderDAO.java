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

public class ProviderDAO {
    private DatabaseHandler databaseHandler;

    public ProviderDAO() {
        databaseHandler = new DatabaseHandler();
    }

    public void addProvider(Provider provider) {
        String query = "INSERT INTO fournisseur (nom, adresse, mail, numero) VALUES (?, ?, ?, ?)";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, provider.getName());
            preparedStatement.setString(2, provider.getAddress());
            preparedStatement.setString(3, provider.getMail());
            preparedStatement.setString(4, provider.getPhone());

            preparedStatement.executeUpdate();

            // Retrieve the generated key (provider ID)
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                provider.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
     public String[] getProviderNames() {
        List<String> ProviderNames = new ArrayList<>();

        try (Connection connection =  databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT nom FROM fournisseur");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String categoryName = resultSet.getString("nom");
                ProviderNames.add(categoryName);
            }

        } catch (Exception e) {
            e.printStackTrace();
                        e.printStackTrace();

        }
        return ProviderNames.toArray(new String[0]);
    }
    
    
     public int getProviderIdByName(String providerName) {
        int providerid = 0;

       
        try (Connection connection =  databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM fournisseur WHERE nom = ?");
        ) {
            preparedStatement.setString(1, providerName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    providerid = resultSet.getInt("id");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
         

        }

        return providerid;
    }
    
    
    
    
    
    public ArrayList<Provider> getAllProviders() {
        ArrayList<Provider> providerList = new ArrayList<>();
        String query = "SELECT * FROM fournisseur";

        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                String address = resultSet.getString("adresse");
                String mail = resultSet.getString("mail");
                String phone = resultSet.getString("numero");

                Provider provider = new Provider(id, name, address, mail, phone);
                providerList.add(provider);
            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return providerList;
    }
     

    public void updateProvider(Provider provider) {
        String query = "UPDATE fournisseur SET nom = ?, adresse = ?, mail = ?, numero = ? WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, provider.getName());
            preparedStatement.setString(2, provider.getAddress());
            preparedStatement.setString(3, provider.getMail());
            preparedStatement.setString(4, provider.getPhone());
            preparedStatement.setInt(5, provider.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProvider(int providerId) {
        String query = "DELETE FROM fournisseur WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, providerId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
        public List<Provider> searchProvider(String keyword) {
        List<Provider> list = new ArrayList<>();
        String query = "SELECT fournisseur.*  from fournisseur WHERE fournisseur.nom LIKE ?";
             

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String likeKeyword = "%" + keyword + "%";
            preparedStatement.setString(1, likeKeyword);
           
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    
                    Provider p = new Provider(resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("adresse"),
                            resultSet.getString("numero"),
                            resultSet.getString("mail"));
      
                    list.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return list;
    }

    
    
    
    
}

      
