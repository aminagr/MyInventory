
package dao;

import java.sql.Date;

/**
 *
 * @author amina
 */


public class Inventory {
    private int id;
    private int productId;
    private int quantity;
    private String transactionType;
    private Date transactionDate;

    public Inventory(int id, int productId, int quantity, String transactionType, Date transactionDate) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    // Add getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}

    
    
    

