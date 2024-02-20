
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
                            resultSet.getString("email"),
                              resultSet.getString("nom"),
                        resultSet.getString("prenom")
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
                            resultSet.getString("email"),
                              resultSet.getString("nom"),
                        resultSet.getString("prenom")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
        
        
        String query = "SELECT id, username, mdp, role, email, nom, prenom FROM user WHERE username = ? AND mdp = ?";

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
                        resultSet.getString("prenom")
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
                        resultSet.getString("prenom")
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

    
    
    
    
   
        
        
    

