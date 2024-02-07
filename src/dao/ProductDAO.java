
package dao;

/**
 *
 * @author amina
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DatabaseHandler databaseHandler;

    public ProductDAO() {
        databaseHandler = new DatabaseHandler();
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO produits (nom, qt, prix, categorie, fournisseur, image, code) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getProviderId());
            preparedStatement.setString(6, product.getImages());
            preparedStatement.setString(7, product.getCodeBar());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


            
            
            
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
      //  String query = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.image, produits.code, categorie.nom AS category_name FROM produits INNER JOIN categorie ON produits.categorie = categorie.id, fournisseur.nom as fournisseur_name FROM produits INNER JOIN fournisseur on produits.fournisseur = fournisseur.id";
String query = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.image, produits.code, categorie.nom AS category_name, fournisseur.nom AS fournisseur_name FROM produits INNER JOIN categorie ON produits.categorie = categorie.id INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id";

        try (Connection connection = databaseHandler.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                int quantity = resultSet.getInt("qt");
                double price = resultSet.getDouble("prix");
                //int categoryId = resultSet.getInt("categorie");
               // int providerId = resultSet.getInt("fournisseur");
              String fournisseurName= resultSet.getString("fournisseur_name");
               String categoryName = resultSet.getString("category_name");
                String images = resultSet.getString("image");
                String codeBar = resultSet.getString("code");

                Product product = new Product(id, name, quantity, price, images, codeBar,categoryName,fournisseurName);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public void updateProduct(Product product) {
        String query = "UPDATE produits SET nom = ?, qt = ?, prix = ?, categorie = ?, " +
                       "fournisseur = ?, image = ?, code = ? WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getProviderId());
            preparedStatement.setString(6, product.getImages());
            preparedStatement.setString(7, product.getCodeBar());
            preparedStatement.setInt(8, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        String query = "DELETE FROM produits WHERE id = ?";

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, productId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


 public List<Product> searchProducts(String keyword) {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT produits.*, categorie.nom AS catn, fournisseur.nom AS forn FROM produits INNER JOIN categorie ON produits.categorie = categorie.id INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id WHERE produits.nom LIKE ? OR produits.id LIKE ? OR produits.qt LIKE ? OR produits.prix LIKE ? OR produits.image LIKE ? OR produits.code LIKE ? OR categorie.nom LIKE ? OR fournisseur.nom LIKE ?";
             

        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String likeKeyword = "%" + keyword + "%";
            preparedStatement.setString(1, likeKeyword);
            preparedStatement.setString(2, likeKeyword);
            preparedStatement.setString(3, likeKeyword);
            preparedStatement.setString(4, likeKeyword);
            preparedStatement.setString(5, likeKeyword);
            preparedStatement.setString(6, likeKeyword);
preparedStatement.setString(7, likeKeyword);
            preparedStatement.setString(8, likeKeyword);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    
                    Product product = new Product(resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getInt("qt"),
                            resultSet.getDouble("prix"),
                            resultSet.getString("image"),
                            resultSet.getString("code"),
                            resultSet.getString("catn"),
                            resultSet.getString("forn"));
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return productList;
    }



}
