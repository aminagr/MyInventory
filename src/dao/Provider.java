
package dao;

/**
 *
 * @author amina
 */

public class Provider {
    private int id;
    private String name;
    private String address;
    private String mail;
    private String phone;

    public Provider(){
    }
    public Provider(int id, String name, String address, String mail, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

