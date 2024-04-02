
package dao;

/**
 *
 * @author amina
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String nom;
   private String prenom;
    private String address;
    private String phoneNumber;

    
    public User()
    {
    
    }
    
   
    public User(int id, String username, String password, String role, String email, String nom, String prenom) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
    public User(int id, String username, String password, String role, String email, String nom, String prenom, String address, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    
    }
     public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
