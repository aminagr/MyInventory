/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import dao.Provider;
import dao.ProviderDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DELL-10
 */
public class fournisseurs extends javax.swing.JPanel {

    /**
     * Creates new form clients
     */
    public fournisseurs() {
        initComponents();
        tb_load();
        updatebtn.setVisible(false);
        idlabel.setVisible(false);
        idfield.setVisible(false);
    }

    
    
    
    public void tb_load(){
  
  
     ProviderDAO cd = new ProviderDAO();
          
          DefaultTableModel dt = (DefaultTableModel) TabF.getModel();
          dt.setRowCount(0);
                  ArrayList<Provider> list = cd.getAllProviders();
                  Iterator<Provider> itr = list.iterator();
                  while(itr.hasNext()){
                      
                      Provider pr = itr.next();
                      dt.addRow(new Object[]{pr.getId(),pr.getName(),pr.getMail(),pr.getPhone(),pr.getAddress()});
                      
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fnom = new javax.swing.JTextField();
        fmail = new javax.swing.JTextField();
        fnum = new javax.swing.JTextField();
        fadd = new javax.swing.JTextField();
        savef = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabF = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        f_r = new javax.swing.JTextField();
        bt_r = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        idlabel = new java.awt.Label();
        idfield = new java.awt.Label();

        jLabel1.setText("Nom");

        jLabel2.setText("Mail");

        jLabel3.setText("Numéro");

        jLabel4.setText("Adresse");

        fmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmailActionPerformed(evt);
            }
        });

        fnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnumActionPerformed(evt);
            }
        });

        savef.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/save-16.png"))); // NOI18N
        savef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savefActionPerformed(evt);
            }
        });

        updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/save-16.png"))); // NOI18N
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(fnum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(fmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(fnom, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(fadd))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updatebtn)
                            .addComponent(savef))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(savef)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatebtn)
                .addContainerGap())
        );

        TabF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Mail", "Numéro", "Adresse"
            }
        ));
        jScrollPane1.setViewportView(TabF);

        jLabel5.setText("Rechercher  ");

        bt_r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/search-3-16.png"))); // NOI18N
        bt_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(f_r, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_r)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_r)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(f_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/delete-16.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        editbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/images/edit-16.png"))); // NOI18N
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        idlabel.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editbtn)
                .addGap(36, 36, 36)
                .addComponent(delete)
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delete)
                    .addComponent(editbtn))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void savefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savefActionPerformed

String nom = fnom.getText();
String mail = fmail.getText();
String ad = fadd.getText();
String num = fnum.getText();

Provider p = new Provider();
p.setName(nom);
p.setPhone(num);
p.setMail(mail);
p.setAddress(ad);
ProviderDAO d = new ProviderDAO();
d.addProvider(p);
 refreshTable();
JOptionPane.showMessageDialog(null, "fournisseur ajouté");
        // TODO add your handling code here:
    }//GEN-LAST:event_savefActionPerformed

    private void fnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnumActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

 int index = TabF.getSelectedRow();
        if (index != -1) {
        TableModel model = TabF.getModel();
        int id = (int) model.getValueAt(index,0);
       
        ProviderDAO dao = new ProviderDAO();
        dao.deleteProvider(id);
         refreshTable();
        JOptionPane.showMessageDialog(this, "Fournisseur supprimé avec succès");
        
        }
        else {
            JOptionPane.showMessageDialog(this, "veuillez selectionner un fournisseur à supprimer.");
        }
        
              



    }//GEN-LAST:event_deleteActionPerformed

    private void fmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmailActionPerformed

    private void bt_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rActionPerformed
     
        String searchKeyword = f_r.getText();

ProviderDAO dao = new ProviderDAO();
                List<Provider> searchResults = dao.searchProvider(searchKeyword);
                updateTable(searchResults);
    }

    
    private void updateTable(List<Provider> productList) {
        DefaultTableModel model = (DefaultTableModel) TabF.getModel();
        model.setRowCount(0); //

        for (Provider pv : productList) {
            model.addRow(new Object[]{pv.getId(), pv.getName(),pv.getMail(), pv.getPhone(), pv.getMail() });

              
        }
        
        
        
        
        
        
    }//GEN-LAST:event_bt_rActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed



String idd = idfield.getText();
        int id = Integer.parseInt(idd);
String nom = fnom.getText();
String mail = fmail.getText();
String ad = fadd.getText();
String num = fnum.getText();


ProviderDAO dao = new ProviderDAO();

Provider p = new Provider();
p.setId(id);
p.setName(nom);
p.setPhone(num);
p.setMail(mail);
p.setAddress(ad);

dao.updateProvider(p);
 refreshTable();
 JOptionPane.showMessageDialog(this, "Fournisseur modifié avec succès"); 
 savef.setVisible(true);                                         
updatebtn.setVisible(false);
        
       idfield.setVisible(false);
        idlabel.setVisible(false);
    }//GEN-LAST:event_updatebtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed

        
 int index = TabF.getSelectedRow();
        if (index != -1) {
        TableModel model = TabF.getModel();
    
        
        idlabel.setVisible(true);
        idfield.setVisible(true);
        savef.setVisible(false);
        updatebtn.setVisible(true);

        
        
         int id = (int) model.getValueAt(index,0);   
        String nom = (String) model.getValueAt(index,1);
        String mail = (String) model.getValueAt(index,2);
           String tel = (String) model.getValueAt(index,3);
        String adr = (String) model.getValueAt(index,4);
                 String idd = Integer.toString(id);
    
        
     
                fnom.setText(nom);
 fmail.setText(mail);
fadd.setText(adr);
 fnum.setText(tel);
idfield.setText(idd);
                 
        
       
       
        }
        else {
            JOptionPane.showMessageDialog(this, "veuillez selectionner une catégorie à éditer.");
        }


    }//GEN-LAST:event_editbtnActionPerformed


    
    private void refreshTable() {
    ProviderDAO dao = new ProviderDAO();
    List<Provider> providerList = dao.getAllProviders();

    DefaultTableModel newTableModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Mail", "Numéro", "Adresse"}, 0);

    for (Provider provider : providerList) {
        Object[] rowData = {provider.getId(), provider.getName(), provider.getMail(), provider.getPhone(), provider.getAddress()};
        newTableModel.addRow(rowData);
    }

    TabF.setModel(newTableModel); 
}

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabF;
    private javax.swing.JButton bt_r;
    private javax.swing.JButton delete;
    private javax.swing.JButton editbtn;
    private javax.swing.JTextField f_r;
    private javax.swing.JTextField fadd;
    private javax.swing.JTextField fmail;
    private javax.swing.JTextField fnom;
    private javax.swing.JTextField fnum;
    private java.awt.Label idfield;
    private java.awt.Label idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savef;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
