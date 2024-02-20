
package warehouse;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author amina
 */
public class ImageRenderer extends DefaultTableCellRenderer {
    
    
   
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value != null) {
            ImageIcon imageIcon = new ImageIcon((String) value);
            label.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        } else {
            label.setIcon(null);
        }
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
    
    
    
    
      /*
   private static final int ICON_SIZE = 100; // Adjust the size as needed


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value != null) {
            ImageIcon imageIcon = new ImageIcon((String) value);
            label.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
        } else {
            label.setIcon(null);
        }
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
*/
    
    
    
}


