/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DBObject.SQLTable;
import MainView.ManagerHome;
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
public class ComboForm extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;

    public ComboForm() {
        TAG = 1;
        initComponents();
    }  
    public ComboForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        initComponents();
        
        ID = (String) data[0];
        tf_TenCB.setText((String) data[1]);
        tf_Gia.setText((String) data[2]);
        tf_SoNguoi.setText((String) data[3]);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboPanel = new javax.swing.JPanel();
        lb_ComboTitle = new javax.swing.JLabel();
        lb_TenCB = new javax.swing.JLabel();
        lb_Gia = new javax.swing.JLabel();
        lb_SoNguoi = new javax.swing.JLabel();
        tf_TenCB = new javax.swing.JTextField();
        tf_Gia = new javax.swing.JTextField();
        tf_SoNguoi = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);

        ComboPanel.setBackground(new java.awt.Color(255, 255, 255));
        ComboPanel.setPreferredSize(new java.awt.Dimension(650, 276));

        lb_ComboTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_ComboTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_ComboTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_ComboTitle.setText("COMBO INFO");

        lb_TenCB.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TenCB.setForeground(new java.awt.Color(120, 168, 252));
        lb_TenCB.setText("COMBO NAME:");

        lb_Gia.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_Gia.setForeground(new java.awt.Color(120, 168, 252));
        lb_Gia.setText("PRICE:");

        lb_SoNguoi.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_SoNguoi.setForeground(new java.awt.Color(120, 168, 252));
        lb_SoNguoi.setText("PEOPLE:");

        tf_TenCB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TenCB.setForeground(new java.awt.Color(120, 168, 252));
        tf_TenCB.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_TenCB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_Gia.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Gia.setForeground(new java.awt.Color(120, 168, 252));
        tf_Gia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Gia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_SoNguoi.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_SoNguoi.setForeground(new java.awt.Color(120, 168, 252));
        tf_SoNguoi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_SoNguoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        btnConfirm.setBackground(new java.awt.Color(120, 168, 252));
        btnConfirm.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("CONFIRM");
        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmMouseClicked(evt);
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

        javax.swing.GroupLayout ComboPanelLayout = new javax.swing.GroupLayout(ComboPanel);
        ComboPanel.setLayout(ComboPanelLayout);
        ComboPanelLayout.setHorizontalGroup(
            ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComboPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TenCB)
                    .addComponent(lb_Gia)
                    .addComponent(lb_SoNguoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_TenCB, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(tf_Gia)
                    .addComponent(tf_SoNguoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComboPanelLayout.createSequentialGroup()
                .addGap(0, 376, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComboPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_ComboTitle)
                .addGap(223, 223, 223))
        );
        ComboPanelLayout.setVerticalGroup(
            ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComboPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ComboTitle)
                .addGap(25, 25, 25)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TenCB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TenCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(ComboPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ComboPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ComboPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked
    private void btnConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMouseClicked
        if (TAG == 1) {
            add(evt);
        } 
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirmMouseClicked
    private void update(java.awt.event.MouseEvent evt) {
        String Combo = tf_TenCB.getText();
        String Price = tf_Gia.getText();
        String NoP = tf_SoNguoi.getText();
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
            Object[] data = {ID, Combo, Price, NoP};
            ManagerHome.update(data, RowID);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            dispose();
        } 
        
                
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        String Combo = tf_TenCB.getText();
        String Price = tf_Gia.getText();
        String NoP = tf_SoNguoi.getText();
        String ID = ManagerHome.getTableID();

        String query = "insert into COMBO values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, Combo);
            p_statement.setString(3, Price);
            p_statement.setString(4, NoP);

            p_statement.executeUpdate();
            Object[] data = {ID, Combo, Price, NoP};
            ManagerHome.update(data);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {            
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
            java.util.logging.Logger.getLogger(ComboForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComboForm().setVisible(true);
                new ComboForm().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComboPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lb_ComboTitle;
    private javax.swing.JLabel lb_Gia;
    private javax.swing.JLabel lb_SoNguoi;
    private javax.swing.JLabel lb_TenCB;
    private javax.swing.JTextField tf_Gia;
    private javax.swing.JTextField tf_SoNguoi;
    private javax.swing.JTextField tf_TenCB;
    // End of variables declaration//GEN-END:variables
}
