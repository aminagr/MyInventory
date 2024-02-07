/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class UserDAO 
{
        
        
        
   private DatabaseHandler databaseHandler;
   private Session currentSession;

    public UserDAO() {
        
        this.databaseHandler = new DatabaseHandler();
        
    }

    

    public List<User> listAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
             Connection connection = databaseHandler.getConnection();
            String query = "SELECT * FROM user";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("mdp"),
                            resultSet.getString("role"),
                            resultSet.getString("email")
                    );
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void createUser(User user) {
        try {
             Connection connection = databaseHandler.getConnection();
            String query = "INSERT INTO user (username, mdp, role, email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
             Connection connection = databaseHandler.getConnection();
            String query = "UPDATE user SET username = ?, mdp = ?, role = ?, email = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setInt(5, user.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
             Connection connection = databaseHandler.getConnection();
            String query = "DELETE FROM user WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User searchUser(int userId) {
        try {
             Connection connection = databaseHandler.getConnection();
            String query = "SELECT * FROM user WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("mdp"),
                            resultSet.getString("role"),
                            resultSet.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    
    
    public boolean login(String username, String password) {
        try {
            Connection connection = databaseHandler.getConnection();
            String query = "SELECT * FROM user WHERE username = ? AND mdp = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    User currentUser = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("mdp"),
                            resultSet.getString("role"),
                            resultSet.getString("email")
                    );
                    currentSession = new Session(currentUser);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void logout() {
        // Clear the current session (logout)
        currentSession = null;
    }

    public boolean isLoggedIn() {
        return currentSession != null;
    }

    public User getCurrentUser() {
        return currentSession != null ? currentSession.getUser() : null;
    }

    

    
    
    
    
   
        
        
    
}
