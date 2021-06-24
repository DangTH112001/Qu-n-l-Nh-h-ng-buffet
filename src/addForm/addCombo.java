/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addForm;

import Controller.SQLTable;
import MainView.Home;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Phan Hau
 */
public class addCombo extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form addCombo
     */
    public addCombo() {
        TAG = 1;
        initComponents();
    }
    
    public addCombo(Object[] data, int TAG, int RowID) {     
        this.TAG = TAG;
        this.RowID = RowID;
        initComponents();
        
        ID = (String) data[0];
        tf_Combo.setText((String) data[1]);
        tf_Price.setText((String) data[2]);
        tf_No_People.setText((String) data[3]);
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
        lbCreateCustomerAccount1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        tf_Combo = new javax.swing.JTextField();
        lbName1 = new javax.swing.JLabel();
        tf_Price = new javax.swing.JTextField();
        lbName2 = new javax.swing.JLabel();
        tf_No_People = new javax.swing.JTextField();
        btnConfirm1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 276));

        lbCreateCustomerAccount1.setBackground(new java.awt.Color(255, 255, 255));
        lbCreateCustomerAccount1.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lbCreateCustomerAccount1.setForeground(new java.awt.Color(120, 168, 252));
        lbCreateCustomerAccount1.setText("COMBO INFO");

        lbName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(120, 168, 252));
        lbName.setText("COMBO NAME:");

        tf_Combo.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Combo.setForeground(new java.awt.Color(120, 168, 252));
        tf_Combo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Combo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName1.setForeground(new java.awt.Color(120, 168, 252));
        lbName1.setText("PRICE:");

        tf_Price.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Price.setForeground(new java.awt.Color(120, 168, 252));
        tf_Price.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName2.setForeground(new java.awt.Color(120, 168, 252));
        lbName2.setText("PEOPLE:");

        tf_No_People.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_No_People.setForeground(new java.awt.Color(120, 168, 252));
        tf_No_People.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_No_People.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        btnConfirm1.setBackground(new java.awt.Color(120, 168, 252));
        btnConfirm1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnConfirm1.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm1.setText("CONFIRM");
        btnConfirm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirm1MouseClicked(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(129, 0, 0));
        btnExit.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("CANCEL");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbName)
                    .addComponent(lbName1)
                    .addComponent(lbName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_Combo, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(tf_Price)
                    .addComponent(tf_No_People))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 376, Short.MAX_VALUE)
                .addComponent(btnConfirm1)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCreateCustomerAccount1)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCreateCustomerAccount1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_No_People, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    
    private void btnConfirm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirm1MouseClicked
        if (TAG == 1) {
            add(evt);
        } 
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirm1MouseClicked
    private void update(java.awt.event.MouseEvent evt) {
        String Combo = tf_Combo.getText();
        String Price = tf_Price.getText();
        String NoP = tf_No_People.getText();
        String query = "update COMBO "
                        + "set TENCB = ?, GIA = ?, SONGUOI = ?"
                        + "where MACB = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, Combo);
            p_statement.setString(2, Price);
            p_statement.setString(3, NoP);
            p_statement.setString(4, ID);

            p_statement.executeUpdate();
            System.out.println("SUCCESS");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = {ID, Combo, Price, NoP};
            Home.update(data, RowID);
            dispose();
        } 
        
                
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        String Combo = tf_Combo.getText();
        String Price = tf_Price.getText();
        String NoP = tf_No_People.getText();
        String ID = Home.getTableID();

        String query = "insert into COMBO values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, Combo);
            p_statement.setString(3, Price);
            p_statement.setString(4, NoP);

            p_statement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = {ID, Combo, Price, NoP};
            Home.update(data);
            dispose();
        } 
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCombo().setVisible(true);
                new addCombo().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCreateCustomerAccount1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName2;
    private javax.swing.JTextField tf_Combo;
    private javax.swing.JTextField tf_No_People;
    private javax.swing.JTextField tf_Price;
    // End of variables declaration//GEN-END:variables
}
