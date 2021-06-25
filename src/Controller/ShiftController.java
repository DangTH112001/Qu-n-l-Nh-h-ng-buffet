/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.Discount;
import DBObject.SQLTable;
import DBObject.Shift;
import MainView.Home;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Phan Hau
 */
public class ShiftController extends javax.swing.JFrame {
    private Date date;
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form DiscountController
     */
    public ShiftController() {
        date = new Date();
        TAG = 1;
        initComponents();
    }
    
    public ShiftController(Object[] data, int RowID) {     
        date = new Date();
        TAG = 2;
        this.RowID = RowID;
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        initComponents();
        
        ID = (String) data[0];
        try {
            Spin_BEGIN.setValue(format.parse((String) data[1]));
            Spin_END.setValue(format.parse((String) data[2]));
        } catch (ParseException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbType.setSelectedItem((String) data[3]);
    }                                     
    
    private void update(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        
        String Begin = format.format((Date) Spin_BEGIN.getValue());
        String End = format.format((Date) Spin_END.getValue());
        String Type = (String) cbType.getSelectedItem();
        String query = "update CA "
                        + "set TGBD = ?, TGKT = ?, LOAICA = ?"
                        + "where MACA = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setDate(1, new java.sql.Date(((Date) Spin_BEGIN.getValue()).getTime()));
            p_statement.setDate(2, new java.sql.Date(((Date) Spin_END.getValue()).getTime()));
            p_statement.setString(3, Type);
            p_statement.setString(4, ID);
            
            p_statement.executeUpdate();
            Object[] data = (new Shift(ID, Begin, End, Type)).get_Properties();
            Home.update(data, RowID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {      
            dispose();
        }          
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        
        String Begin = format.format((Date) Spin_BEGIN.getValue());
        String End = format.format((Date) Spin_END.getValue());
        String Type = (String) cbType.getSelectedItem();
        String ID = Home.getTableID();
 

        String query = "insert into GIAMGIA values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setDate(2, new java.sql.Date(((Date) Spin_BEGIN.getValue()).getTime()));
            p_statement.setDate(3, new java.sql.Date(((Date) Spin_END.getValue()).getTime()));
            p_statement.setString(4, Type);
            
            
                
            p_statement.executeUpdate();
            Object[] data = (new Shift(ID, Begin, End, Type)).get_Properties();
            Home.update(data);      
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            dispose();
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCreateCustomerAccount1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbName1 = new javax.swing.JLabel();
        lbName3 = new javax.swing.JLabel();
        btnConfirm1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_BEGIN = new javax.swing.JSpinner(sm1);
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_END = new javax.swing.JSpinner(sm2);
        cbType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbCreateCustomerAccount1.setBackground(new java.awt.Color(255, 255, 255));
        lbCreateCustomerAccount1.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lbCreateCustomerAccount1.setForeground(new java.awt.Color(120, 168, 252));
        lbCreateCustomerAccount1.setText("ADD SHIFT");

        lbName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(120, 168, 252));
        lbName.setText("START TIME:");

        lbName1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName1.setForeground(new java.awt.Color(120, 168, 252));
        lbName1.setText("END TIME:");

        lbName3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName3.setForeground(new java.awt.Color(120, 168, 252));
        lbName3.setText("SHIFT TYPE:");

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
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(Spin_BEGIN, "HH:mm:ss");
        Spin_BEGIN.setEditor(de1);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(Spin_END, "HH:mm:ss");
        Spin_END.setEditor(de2);

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca thường", "Tăng ca" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbName1)
                    .addComponent(lbName)
                    .addComponent(lbName3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Spin_BEGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Spin_END, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbCreateCustomerAccount1)
                                        .addGap(12, 12, 12)))
                                .addGap(0, 110, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirm1)))
                        .addGap(18, 18, 18)
                        .addComponent(btnExit)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCreateCustomerAccount1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_BEGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_END, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName3)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnConfirm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirm1MouseClicked
        if (TAG == 1) {
            add(evt);
        } 
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirm1MouseClicked

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
            java.util.logging.Logger.getLogger(ShiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShiftController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShiftController().setVisible(true);
                new ShiftController().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Spin_BEGIN;
    private javax.swing.JSpinner Spin_END;
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCreateCustomerAccount1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName3;
    // End of variables declaration//GEN-END:variables
}
