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
public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int categoryId;
    private int providerId;
    private String images;
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
       public Product(int id, String name, int quantity, double price, int categoryId, int providerId,
                   String images, String codeBar){
    this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.providerId = providerId;
        this.images = images;
        this.codeBar = codeBar;
      
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
    
}
