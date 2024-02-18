/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import dao.User;
import dao.UserDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author amina
 */
public class Warehouse {

    public static void main(String[] args) {
       /* UserDAO userDAO = new UserDAO();

        
        User rememberedUser = userDAO.getRememberedUser();

        // Check if the user is logged in or has checked "Remember Me"
        if (userDAO.isUserLoggedIn() || rememberedUser != null) {
            // If the user is logged in or remembered, open the Home frame
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Home(rememberedUser).setVisible(true);
                }
            });
        } else {
            // If neither logged in nor remembered, open the Login frame
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new login().setVisible(true);
                }
            });
        }
    */


        
        new login().setVisible(true);

       
    }


              
           
        

