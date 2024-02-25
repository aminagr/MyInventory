
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
public class Main {
    
    

public static void main(String[] args) {
    
       UserDAO userDAO = new UserDAO();

        
        User rememberedUser = userDAO.getRememberedUser();

      
        if (userDAO.isUserLoggedIn() || rememberedUser != null) {
            // If the user is logged in or remembered, open the Home frame
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Home(rememberedUser).setVisible(true);
                }
            });
        } else {
           
            User user = new User();
user.setId(2);
user.setUsername("Mina");
user.setPassword("Mina");
        user.setNom("Mina");
        user.setPrenom("G");
        user.setEmail("mina@gmail.com");
        
            
            
            
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                  //  new login().setVisible(true);
                   new Home(user).setVisible(true);
                }
            });
        }

}
}