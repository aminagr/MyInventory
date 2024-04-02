
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
   private SessionManager currentSession;

    public UserDAO() {
        
        this.databaseHandler = new DatabaseHandler();
        
    }
public List<User> listAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("mdp"),
                        resultSet.getString("role"),
                        resultSet.getString("email"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse"),
                        resultSet.getString("numero")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


     public void createUser(User user) {
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username, mdp, role, email, nom, prenom, adresse, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getNom());
            preparedStatement.setString(6, user.getPrenom());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET username = ?, mdp = ?, role = ?, email = ?, nom = ?, prenom = ?, adresse = ?, numero = ? WHERE id = ?")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getNom());
            preparedStatement.setString(6, user.getPrenom());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.setInt(9, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<User> searchUser(String searchQuery) {
    List<User> userList = new ArrayList<>();
    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username LIKE ? OR email LIKE ? OR nom LIKE ? OR prenom LIKE ? OR adresse LIKE ? OR numero LIKE ?")) {
        String queryParam = "%" + searchQuery + "%";
        preparedStatement.setString(1, queryParam);
        preparedStatement.setString(2, queryParam);
        preparedStatement.setString(3, queryParam);
        preparedStatement.setString(4, queryParam);
        preparedStatement.setString(5, queryParam);
        preparedStatement.setString(6, queryParam);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("mdp"),
                        resultSet.getString("role"),
                        resultSet.getString("email"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse"),
                        resultSet.getString("numero")
                );
                userList.add(user);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return userList;
}

    
   
    public void logout() {
           try {
            // Get the currently logged-in user
            User currentUser = SessionManager.getInstance().getUser();

            // If a user is logged in
            if (currentUser != null) {
                // Update the "remember_me" value to false in the database
                updateRememberMeValue(currentUser.getUsername(), false);
            }

            // Clear the session (logout)
            SessionManager.getInstance().setUser(null);

        } catch (Exception e) {
            e.printStackTrace();
        
    } 
    }
    
    
    
    
    
    
   
public boolean login(String username, String password, boolean rememberMe) {
    try {
        Connection connection = databaseHandler.getConnection();
        //String query = "SELECT * FROM user WHERE username = ? AND mdp = ?";
        
        
        String query = "SELECT id, username, mdp, role, email, nom, prenom, adresse, numero FROM user WHERE username = ? AND mdp = ?";

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
                        resultSet.getString("email"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                         resultSet.getString("adresse"),
                            resultSet.getString("numero")
                );

                if (rememberMe) {
                    updateRememberMeValue(username, true);
                }

                SessionManager.getInstance().setUser(currentUser); // Set the user in the SessionManager
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

 

    public void updateRememberMeValue(String username, boolean rememberMe) {
    try {
        Connection connection = databaseHandler.getConnection();
        String query = "UPDATE user SET remember_me = ? WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, rememberMe);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    }
    
    
    
    
    
    
    

    public boolean isLoggedIn() {
        return currentSession != null;
    }

    public User getCurrentUser() {
        return currentSession != null ? currentSession.getUser() : null;
    }

    public User getRememberedUser() {
        try {
            Connection connection = databaseHandler.getConnection();
            String query = "SELECT * FROM user WHERE remember_me = true";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("mdp"),
                            resultSet.getString("role"),
                            resultSet.getString("email"),
                              resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                             resultSet.getString("adresse"),
                            resultSet.getString("numero")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
  public boolean isUserLoggedIn() {
        // Check if the SessionManager has a user
        return SessionManager.getInstance().getUser() != null;
    }
}

    
    
    
    
   
        
        
    

