
package dao;

import java.util.List;

/**
 *
 * @author amina
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private double pricev;
    private int categoryId;
    private int providerId;
    private String images;
    private List<String> imagess; 

    private String codeBar;
    private String categoryName;
    private String providerName;

    public Product(){
    
    }
    
    
    public Product(int id, String name, int quantity, double price,
                String images, String codeBar, String categoryName, String providerName) {
     
        
         this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.providerId = providerId;
        this.images = images;
        this.codeBar = codeBar;
       this.categoryName = categoryName;
       this.providerName = providerName;
        
    } 
       
        public Product(int id, String name, int quantity, double price, double pricev,
                String codeBar, String categoryName, String providerName, List<String> imagess) {
     
        
         this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.providerId = providerId;
       
        this.codeBar = codeBar;
       this.categoryName = categoryName;
       this.providerName = providerName;
        this.imagess = imagess;
        this.pricev=pricev;
    } 
       
        
        
        
         public Product(int id, String name, int quantity, double price,
                String codeBar, String categoryName, String providerName, List<String> imagess) {
     
        
         this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.providerId = providerId;
       
        this.codeBar = codeBar;
       this.categoryName = categoryName;
       this.providerName = providerName;
        this.imagess = imagess;
      
    } 
       
     
       
       
       public List<String> getImagess() {
        return imagess;
    }

    public void setImagess(List<String> imagess) {
        this.imagess = imagess;
    }
       
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }
   public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

     public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;}
    



 public double getPricev() {
        return pricev;
    }

    // Setter method for pricev
    public void setPricev(double pricev) {
        this.pricev = pricev;
    }

}