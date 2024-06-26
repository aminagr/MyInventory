
package warehouse;

import dao.Category;
import dao.CategoryDAO;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author amina
 */
public class categorie extends javax.swing.JPanel {

    
     CategoryDAO cd = new CategoryDAO();
    
    /**
     * Creates new form clients
     */
    public categorie() {
        initComponents();
        updatebt.setVisible(false);
        idfield.setVisible(false);
        idlabel.setVisible(false);
        tb_load();
           
   
    }

    
     public void tb_load(){
  
  
     
          
          DefaultTableModel dt = (DefaultTableModel) TableCat.getModel();
          dt.setRowCount(0);
                  ArrayList<Category> list = cd.getAllCategories();
                  Iterator<Category> itr = list.iterator();
                  while(itr.hasNext()){
                      
                      Category categorie = itr.next();
                      dt.addRow(new Object[]{categorie.getId(),categorie.getName()});
                      
                  }
                         
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        catnom = new javax.swing.JTextField();
        addcat = new javax.swing.JButton();
        idlabel = new java.awt.Label();
        idfield = new java.awt.Label();
        jSeparator2 = new javax.swing.JSeparator();
        ajt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCat = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bt_r = new javax.swing.JButton();
        r_c = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        deletecat = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        updatebt = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nom");

        catnom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        catnom.setBorder(null);
        catnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catnomActionPerformed(evt);
            }
        });

        addcat.setBackground(new java.awt.Color(255, 255, 255));
        addcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/save-32.png"))); // NOI18N
        addcat.setBorder(null);
        addcat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcatActionPerformed(evt);
            }
        });

        idlabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idlabel.setText("ID");

        idfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        ajt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ajt.setText("AJOUTER UNE CATEGORIE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(catnom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ajt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(addcat)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ajt)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(catnom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(addcat))
        );

        TableCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TableCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nom"
            }
        ));
        jScrollPane1.setViewportView(TableCat);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("GERER LES CATEGORIES");

        bt_r.setBackground(new java.awt.Color(255, 255, 255));
        bt_r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/search (1).png"))); // NOI18N
        bt_r.setBorder(null);
        bt_r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rActionPerformed(evt);
            }
        });

        r_c.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        r_c.setBorder(null);
        r_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_cActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        deletecat.setBackground(new java.awt.Color(255, 255, 255));
        deletecat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/delete-32.png"))); // NOI18N
        deletecat.setBorder(null);
        deletecat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletecat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecatActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/edit-3-32.png"))); // NOI18N
        edit.setBorder(null);
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        updatebt.setBackground(new java.awt.Color(255, 255, 255));
        updatebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/save-as-32.png"))); // NOI18N
        updatebt.setBorder(null);
        updatebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(updatebt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(r_c, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_r, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deletecat)
                .addGap(281, 281, 281)
                .addComponent(edit)
                .addGap(191, 191, 191))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(72, 72, 72)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatebt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(bt_r, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(r_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(deletecat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletecatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecatActionPerformed

        int index = TableCat.getSelectedRow();
        if (index != -1) {
            
             int response = JOptionPane.showConfirmDialog(categorie.this,
                "Voulez vous vraiment supprimer cete catégorie?", " Confirmation de suppression", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            
            
            
            
            TableModel model = TableCat.getModel();
            int id = (int) model.getValueAt(index,0);

            CategoryDAO caa = new CategoryDAO();
            caa.deleteCategory(id);
            refreshTable();
            JOptionPane.showMessageDialog(this, "categorie supprimée avec succès");

        }}
        else {
            JOptionPane.showMessageDialog(this, "veuillez selectionner une catégorie à supprimer.");
        }

 
    }//GEN-LAST:event_deletecatActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        int index = TableCat.getSelectedRow();
        if (index != -1) {
            TableModel model = TableCat.getModel();

            int id = (int) model.getValueAt(index,0);
            String nom = (String) model.getValueAt(index,1);
            String idd = Integer.toString(id);
            catnom.setText(nom);

            idfield.setVisible(true);
            idlabel.setVisible(true);

            idfield.setText(idd);
            addcat.setVisible(false);
            updatebt.setVisible(true);
            
            ajt.setText("MODIFIER LA CATEGORIE");
            
            // RefreshTable2();
        }
        else {
            JOptionPane.showMessageDialog(this, "veuillez selectionner une catégorie à éditer.");
        }
    }//GEN-LAST:event_editActionPerformed

    private void bt_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rActionPerformed

        String searchKeyword = r_c.getText();

        CategoryDAO dao = new CategoryDAO();
        List<Category> searchResults = dao.searchCategory(searchKeyword);
        updateTable(searchResults);
        }

        private void updateTable(List<Category> productList) {
            DefaultTableModel model = (DefaultTableModel) TableCat.getModel();
            model.setRowCount(0); //

            for (Category product : productList) {
                model.addRow(new Object[]{product.getId(), product.getName()});

            }
    }//GEN-LAST:event_bt_rActionPerformed

    private void r_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_cActionPerformed

    private void updatebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtActionPerformed

      String nom = catnom.getText();
    String idd = idfield.getText();
    int id;

    try {
        id = Integer.parseInt(idd);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (nom.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir le nom de la catégorie", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {


        CategoryDAO dao = new CategoryDAO();
        Category c = new Category();
        c.setId(id);
        c.setName(nom);

        dao.updateCategory(c);
        refreshTable();
        JOptionPane.showMessageDialog(this, "Catégorie modifiée avec succès");
        addcat.setVisible(true);
        updatebt.setVisible(false);

        idfield.setVisible(false);
        idlabel.setVisible(false);
          ajt.setText("AJOUTER UNE CATEGORIE");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred while updating the category.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_updatebtActionPerformed

    private void addcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcatActionPerformed

        String cat_nom = catnom.getText();

    if (cat_nom.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez entrer le nom de la catégorie ", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
    

        Category c = new Category();
        c.setName(cat_nom);

        CategoryDAO caa = new CategoryDAO();
        caa.addCategory(c);
        refreshTable();
        JOptionPane.showMessageDialog(null, "Catégorie ajoutée");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur pendant l'insertion.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addcatActionPerformed

    private void catnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catnomActionPerformed
        
    }//GEN-LAST:event_catnomActionPerformed

    
  
     


private void refreshTable() {
    CategoryDAO dao = new CategoryDAO();
    List<Category> list = dao.getAllCategories(); 

    
    DefaultTableModel newTableModel = new DefaultTableModel(new Object[]{"ID", "Nom"}, 0);

   
    for (Category objet : list) {
        Object[] rowData = {objet.getId(), objet.getName()};
        newTableModel.addRow(rowData);
    }

    
    TableCat.setModel(newTableModel);
}

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCat;
    private javax.swing.JButton addcat;
    private javax.swing.JLabel ajt;
    private javax.swing.JButton bt_r;
    private javax.swing.JTextField catnom;
    private javax.swing.JButton deletecat;
    private javax.swing.JButton edit;
    private java.awt.Label idfield;
    private java.awt.Label idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField r_c;
    private javax.swing.JButton updatebt;
    // End of variables declaration//GEN-END:variables
}
