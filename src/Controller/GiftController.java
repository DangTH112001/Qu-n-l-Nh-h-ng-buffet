/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import MainView.Home;
import java.sql.PreparedStatement;

/**
 *
 * @author DangT
 */
public class GiftController extends javax.swing.JFrame {

    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form addFood
     */
    public GiftController() {
        TAG = 1;
        initComponents();
    }
    
    public GiftController(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        initComponents();
        
        ID = (String) data[0];
        tf_GiftName.setText((String) data[1]);
        tf_Point.setText((String) data[2]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCreateCustomerAccount1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        tf_GiftName = new javax.swing.JTextField();
        lbName1 = new javax.swing.JLabel();
        tf_Point = new javax.swing.JTextField();
        btnConfirm1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbCreateCustomerAccount1.setBackground(new java.awt.Color(255, 255, 255));
        lbCreateCustomerAccount1.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lbCreateCustomerAccount1.setForeground(new java.awt.Color(120, 168, 252));
        lbCreateCustomerAccount1.setText("GIFT INFO");

        lbName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(120, 168, 252));
        lbName.setText("GIFT NAME:");

        tf_GiftName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_GiftName.setForeground(new java.awt.Color(120, 168, 252));
        tf_GiftName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_GiftName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName1.setForeground(new java.awt.Color(120, 168, 252));
        lbName1.setText("POINT:");

        tf_Point.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Point.setForeground(new java.awt.Color(120, 168, 252));
        tf_Point.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Point.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirm1)
                    .addComponent(lbCreateCustomerAccount1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(lbName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_GiftName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(lbName1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_Point, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(btnExit)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCreateCustomerAccount1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_GiftName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Point, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirm1MouseClicked
        if (TAG == 1) {
            add(evt);
        }
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirm1MouseClicked
    private void update(java.awt.event.MouseEvent evt) {
        String Name = tf_GiftName.getText();
        String Price = tf_Point.getText();
        String query = "update QUA "
                        + "set TENQUA = ?, DIEMDOI = ?"
                        + "where MAQUA = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, Name);
            p_statement.setString(2, Price);
            p_statement.setString(3, ID);

            p_statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = {ID, Name, Price};
            Home.update(data, RowID);
            dispose();
        } 
        
                
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        String Name = tf_GiftName.getText();
        String Price = tf_Point.getText();
        String ID = Home.getTableID();

        String query = "insert into QUA values (?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, Name);
            p_statement.setString(3, Price);

            p_statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = {ID, Name, Price};
            Home.update(data);
            dispose();
        } 
    }
    
    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

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
            java.util.logging.Logger.getLogger(GiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiftController().setVisible(true);
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
    private javax.swing.JTextField tf_GiftName;
    private javax.swing.JTextField tf_Point;
    // End of variables declaration//GEN-END:variables
}
