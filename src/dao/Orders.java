
package dao;

/**
 *
 * @author amina
 */
import java.sql.Timestamp;

public class Orders {
    private int id;
    private int productId;
    private String productName;
    private String clientName;
    private Timestamp orderDate;
    private int quantity;
    private double amount;
    private String status;

   
    public Orders() {
    }

   
    public Orders(int id, int productId, String productName, String clientName,
                  Timestamp orderDate, int quantity, double amount) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.clientName = clientName;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.amount = amount;
        
    }

    

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
