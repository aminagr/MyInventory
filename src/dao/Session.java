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

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}


