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

public class CategoryDAO {
    private DatabaseHandler databaseHandler;

    public CategoryDAO() {
        databaseHandler = new DatabaseHandler();
    }

    public void addCategory(Category category) {
        String query = "INSERT INTO categorie (nom) VALUES (?)";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();

            // Retrieve the generated key (category ID)
           /* ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                category.setId(generatedKeys.getInt(1));
            } */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM categorie";

        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");

                Category category = new Category(id, name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
    
    
    public String[] getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();

        try (Connection connection =  databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT nom FROM categorie");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String categoryName = resultSet.getString("nom");
                categoryNames.add(categoryName);
            }

        } catch (Exception e) {
            e.printStackTrace();
                        e.printStackTrace();

        }
        return categoryNames.toArray(new String[0]);
    }

    
    public int getCategoryIdByName(String categoryName) {
        int categoryId = 0;

       
        try (Connection connection =  databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM categorie WHERE nom = ?");
        ) {
            preparedStatement.setString(1, categoryName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    categoryId = resultSet.getInt("id");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
         

        }

        return categoryId;
    }
    
    
    
    
    
 
    
    

    public void updateCategory(Category category) {
        String query = "UPDATE categorie SET nom = ? WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int categoryId) {
        String query = "DELETE FROM categorie WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, categoryId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Category> searchCategory(String keyword) {
        List<Category> catlist = new ArrayList<>();
        String query = "SELECT categorie.*  from categorie WHERE categorie.nom LIKE ?";
             

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String likeKeyword = "%" + keyword + "%";
            preparedStatement.setString(1, likeKeyword);
           
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    
                    Category c = new Category(resultSet.getInt("id"),
                            resultSet.getString("nom"));
                        
                            
                    catlist.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return catlist;
    }

    
     public int getTotalCount() {
    String query = "SELECT COUNT(*) AS total2 FROM categorie";

    try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        if (resultSet.next()) {
            return resultSet.getInt("total2");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return 0;
}
    
    
    
}

