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
public class Session {
    
    private User user;
    private static Session instance;
    private String userId;
    
    private Session(){
    }
    
    public Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
    
    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}


