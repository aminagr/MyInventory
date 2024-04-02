
package dao;

/**
 *
 * @author amina
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDAO {
    private DatabaseHandler databaseHandler;

    public ProductDAO() {
        databaseHandler = new DatabaseHandler();
    }

    
    
  
    
    public void addProduct(Product product) {
    String insertProductQuery = "INSERT INTO produits (nom, qt, prix, categorie, fournisseur, code) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

    String insertImageQuery = "INSERT INTO images (product_id, image_path) VALUES (?, ?)";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement insertProductStatement = connection.prepareStatement(insertProductQuery, Statement.RETURN_GENERATED_KEYS);
         PreparedStatement insertImageStatement = connection.prepareStatement(insertImageQuery)) {

        connection.setAutoCommit(false);

        insertProductStatement.setString(1, product.getName());
        insertProductStatement.setInt(2, product.getQuantity());
        insertProductStatement.setDouble(3, product.getPrice());
        insertProductStatement.setInt(4, product.getCategoryId());
        insertProductStatement.setInt(5, product.getProviderId());
        insertProductStatement.setString(6, product.getCodeBar());

        insertProductStatement.executeUpdate();

        // Get the auto-generated product_id
        ResultSet generatedKeys = insertProductStatement.getGeneratedKeys();
        int productId = -1;
        if (generatedKeys.next()) {
            productId = generatedKeys.getInt(1);
        }

        // Insert each image path into the images table
        for (String imagePath : product.getImagess()) {
            insertImageStatement.setInt(1, productId);
            insertImageStatement.setString(2, imagePath);
            insertImageStatement.executeUpdate();
        }

        connection.commit();

    } catch (SQLException e) {
        e.printStackTrace();
        try(Connection connection = databaseHandler.getConnection();) { 
            connection.rollback();
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }
    }
}



            
           

    
    public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();

    String selectQuery = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.code, " +
                         "categorie.nom AS category_name, fournisseur.nom AS fournisseur_name " +
                         "FROM produits " +
                         "INNER JOIN categorie ON produits.categorie = categorie.id " +
                         "INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id";

    try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(selectQuery)) {

        while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("nom");
            int quantity = resultSet.getInt("qt");
            double price = resultSet.getDouble("prix");
            String fournisseurName = resultSet.getString("fournisseur_name");
            String categoryName = resultSet.getString("category_name");
            String codeBar = resultSet.getString("code");

            List<String> imagePaths = getImagePathsForProduct(connection, productId);

            Product product = new Product(productId, productName, quantity, price, codeBar, categoryName, fournisseurName, imagePaths);
            products.add(product);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return products;
}

// Helper method to retrieve image paths for a product
private List<String> getImagePathsForProduct(Connection connection, int productId) throws SQLException {
    List<String> imagePaths = new ArrayList<>();

    String selectImageQuery = "SELECT image_path FROM images WHERE product_id = ?";
    try (PreparedStatement imageStatement = connection.prepareStatement(selectImageQuery)) {
        imageStatement.setInt(1, productId);
        try (ResultSet imageResultSet = imageStatement.executeQuery()) {
            while (imageResultSet.next()) {
                String imagePath = imageResultSet.getString("image_path");
                imagePaths.add(imagePath);
            }
        }
    }

    return imagePaths;
}

    






public void updateProduct(Product product, boolean deleteOldImages) {
    String updateProductQuery = "UPDATE produits SET nom = ?, qt = ?, prix = ?, categorie = ?, " +
                                "fournisseur = ?, code = ? WHERE id = ?";

    String insertImageQuery = "INSERT INTO images (product_id, image_path) VALUES (?, ?)";
    
    String deleteImageQuery = "DELETE FROM images WHERE product_id = ?";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement updateProductStatement = connection.prepareStatement(updateProductQuery);
         PreparedStatement insertImageStatement = connection.prepareStatement(insertImageQuery);
         PreparedStatement deleteImageStatement = connection.prepareStatement(deleteImageQuery)) {

        connection.setAutoCommit(false);

        updateProductStatement.setString(1, product.getName());
        updateProductStatement.setInt(2, product.getQuantity());
        updateProductStatement.setDouble(3, product.getPrice());
        updateProductStatement.setInt(4, product.getCategoryId());
        updateProductStatement.setInt(5, product.getProviderId());
        updateProductStatement.setString(6, product.getCodeBar());
        updateProductStatement.setInt(7, product.getId());

        updateProductStatement.executeUpdate();

        // Delete old images if specified
        if (deleteOldImages) {
            deleteImageStatement.setInt(1, product.getId());
            deleteImageStatement.executeUpdate();
        }

        // Insert new images for the product
        for (String imagePath : product.getImagess()) {
            insertImageStatement.setInt(1, product.getId());
            insertImageStatement.setString(2, imagePath);
            insertImageStatement.executeUpdate();
        }

        connection.commit();
    } catch (SQLException e) {
        e.printStackTrace();
        try(Connection connection = databaseHandler.getConnection();) { 
            connection.rollback();
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }
    }
}







// Helper method to get the current quantity of a product
private int getProductQuantity(int productId) throws SQLException {
    String query = "SELECT qt FROM produits WHERE id = ?";
    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, productId);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("qt");
            }
        }
    }
    return 0; // Default value if the product is not found
}




public void update2(Product product) {
    String updateProductQuery = "UPDATE produits SET nom = ?, qt = ?, prix = ?, categorie = ?, " +
                                "fournisseur = ?, code = ? WHERE id = ?";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement updateProductStatement = connection.prepareStatement(updateProductQuery)) {

        updateProductStatement.setString(1, product.getName());
        updateProductStatement.setInt(2, product.getQuantity());
        updateProductStatement.setDouble(3, product.getPrice());
        updateProductStatement.setInt(4, product.getCategoryId());
        updateProductStatement.setInt(5, product.getProviderId());
        updateProductStatement.setString(6, product.getCodeBar());
        updateProductStatement.setInt(7, product.getId());

        updateProductStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



public Product getProductById(int productId) {
    Product product = null;
    String selectQuery = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.code, " +
                        "categorie.nom AS category_name, fournisseur.nom AS fournisseur_name " +
                        "FROM produits " +
                        "INNER JOIN categorie ON produits.categorie = categorie.id " +
                        "INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id " +
                        "WHERE produits.id = ?";

    try (Connection connection = databaseHandler.getConnection();
         PreparedStatement statement = connection.prepareStatement(selectQuery)) {

        statement.setInt(1, productId);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                int quantity = resultSet.getInt("qt");
                double price = resultSet.getDouble("prix");
                String codeBar = resultSet.getString("code");
                String categoryName = resultSet.getString("category_name");
                String providerName = resultSet.getString("fournisseur_name");

                // Retrieve images for the product
                List<String> images = getImagesByProductId(connection, productId);

                // Create the Product object using the constructor
                product = new Product(id, name, quantity, price, codeBar, categoryName, providerName, images);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return product;
}

private List<String> getImagesByProductId(Connection connection, int productId) {
    List<String> images = new ArrayList<>();
    String selectImageQuery = "SELECT image_path FROM images WHERE product_id = ?";

    try (PreparedStatement imageStatement = connection.prepareStatement(selectImageQuery)) {

        imageStatement.setInt(1, productId);

        try (ResultSet imageResultSet = imageStatement.executeQuery()) {
            while (imageResultSet.next()) {
                String imagePath = imageResultSet.getString("image_path");
                images.add(imagePath);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return images;
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
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("nom");
                int quantity = resultSet.getInt("qt");
                double price = resultSet.getDouble("prix");
                String fournisseurName = resultSet.getString("forn");
                String categoryName = resultSet.getString("catn");
                String codeBar = resultSet.getString("code");

                List<String> imagePaths = getImagePathsForProduct(connection, productId);

                Product product = new Product(productId, productName, quantity, price, codeBar, categoryName, fournisseurName, imagePaths);
                productList.add(product);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productList;
}









 public int getTotalProductCount() {
    String query = "SELECT COUNT(*) AS total FROM produits";

    try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        if (resultSet.next()) {
            return resultSet.getInt("total");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return 0;
}

public int getProductCountWithZeroQuantity() {
    String query = "SELECT COUNT(*) AS total4 FROM produits WHERE qt = 0";

    try (DatabaseHandler databaseHandler = new DatabaseHandler();
         Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

       
        if (resultSet.next()) {
            return resultSet.getInt("total4");
        } else {
            
            System.err.println("No results found for the query.");
            
            return 0;
        }

    } catch (SQLException e) {
       
        System.err.println("Error executing SQL query: " + e.getMessage());
        e.printStackTrace();
        
        return 0;
    }
}


public int getProductCountWithQuantityLessThanFive() {
    String query = "SELECT COUNT(*) AS total FROM produits WHERE qt < 5 && qt >0";

    try (DatabaseHandler databaseHandler = new DatabaseHandler();
         Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

       
        if (resultSet.next()) {
            return resultSet.getInt("total");
        } else {
           
            System.err.println("No results found for the query.");
                      return 0;
        }

    } catch (SQLException e) {
       
        System.err.println("Error executing SQL query: " + e.getMessage());
        e.printStackTrace();
      
        return 0;
    }
}





    
    
     public List<Product> getLowProducts() {
    List<Product> products = new ArrayList<>();

      String query = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.image, produits.code, categorie.nom AS category_name, fournisseur.nom AS fournisseur_name FROM produits INNER JOIN categorie ON produits.categorie = categorie.id INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id WHERE produits.qt < 5 AND produits.qt > 0";


    try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("nom");
            int quantity = resultSet.getInt("qt");
            double price = resultSet.getDouble("prix");
            String fournisseurName = resultSet.getString("fournisseur_name");
            String categoryName = resultSet.getString("category_name");
            String codeBar = resultSet.getString("code");

            List<String> imagePaths = getImagePathsForProduct(connection, productId);

            Product product = new Product(productId, productName, quantity, price, codeBar, categoryName, fournisseurName, imagePaths);
            products.add(product);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return products;
}
    
    
    
    public List<Product> getOutProducts() {
    List<Product> productList = new ArrayList<>();
String query = "SELECT produits.id, produits.nom, produits.qt, produits.prix, produits.image, produits.code, categorie.nom AS category_name, fournisseur.nom AS fournisseur_name FROM produits INNER JOIN categorie ON produits.categorie = categorie.id INNER JOIN fournisseur ON produits.fournisseur = fournisseur.id WHERE produits.qt = 0";

   try (Connection connection = databaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        while (resultSet.next()) {
            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("nom");
            int quantity = resultSet.getInt("qt");
            double price = resultSet.getDouble("prix");
            String fournisseurName = resultSet.getString("fournisseur_name");
            String categoryName = resultSet.getString("category_name");
            String codeBar = resultSet.getString("code");

            List<String> imagePaths = getImagePathsForProduct(connection, productId);

            Product product = new Product(productId, productName, quantity, price, codeBar, categoryName, fournisseurName, imagePaths);
            productList.add(product);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productList;


    }
}





