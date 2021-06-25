/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.Discount;
import DBObject.SQLTable;
import MainView.Home;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author DangT
 */
public class DiscountController extends javax.swing.JFrame {
    private Date date;
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form DiscountController
     */
    public DiscountController() {
        date = new Date();
        TAG = 1;
        initComponents();
    }
    
    public DiscountController(Object[] data, int RowID) {     
        date = new Date();
        TAG = 2;
        this.RowID = RowID;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        initComponents();
        
        ID = (String) data[0];
        tf_TEN.setText((String) data[1]);
        tf_PHANTRAM.setText((String) data[2]);
        tf_LOAIKH.setText((String) data[3]);
        try {
            DC_BEGIN.setDate(format.parse((String) data[4]));
            DC_END.setDate(format.parse((String) data[5]));
        } catch (ParseException ex) {
            Logger.getLogger(DiscountController.class.getName()).log(Level.SEVERE, null, ex);
        }    
        tf_TINHTRANG.setText((String) data[6]);
    }                                     
    
    private void update(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String Name = tf_TEN.getText();
        int Percent = Integer.parseInt(tf_PHANTRAM.getText());
        int Type = Integer.parseInt(tf_LOAIKH.getText());
        Date Start = DC_BEGIN.getDate();
        Date End = DC_END.getDate();
        
        
            try {
                if (Start == null)
                    Start = format.parse("01/01/0000");
                if (End == null)
                    End = format.parse("31/12/9999");
        } catch (ParseException ex) {
            Logger.getLogger(DiscountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int Status = Integer.parseInt(tf_TINHTRANG.getText());
        String query = "update GIAMGIA "
                        + "set TENGG = ?, PHANTRAM = ?, LOAIKH = ?, NGBD = ?, NGKT = ?, TINHTRANG = ?"
                        + "where MAGG = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, Name);
            p_statement.setInt(2, Percent);
            p_statement.setInt(3, Type);
            p_statement.setDate(4, new java.sql.Date(Start.getTime()));
            p_statement.setDate(5, new java.sql.Date(End.getTime()));
            p_statement.setInt(6, Status);
            p_statement.setString(7, ID);
            
            p_statement.executeUpdate();
            Object[] data = (new Discount(ID, Name, Percent, Type, format.format(Start), format.format(End), Status)).get_Properties();
            Home.update(data, RowID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {      
            dispose();
        }          
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String Name = tf_TEN.getText();
        int Percent = Integer.parseInt(tf_PHANTRAM.getText());
        int Type = Integer.parseInt(tf_LOAIKH.getText());
        Date Start = DC_BEGIN.getDate();
        Date End = DC_END.getDate();
        int Status = Integer.parseInt(tf_TINHTRANG.getText());
        String ID = Home.getTableID();
 

        String query = "insert into GIAMGIA values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, Name);
            p_statement.setInt(3, Percent);
            p_statement.setInt(4, Type);
            p_statement.setDate(5, new java.sql.Date(Start.getTime()));
            p_statement.setDate(6, new java.sql.Date(End.getTime()));
            p_statement.setInt(7, Status);
            
                
            p_statement.executeUpdate();
            Object[] data = (new Discount(ID, Name, Percent, Type, format.format(Start), format.format(End), Status)).get_Properties();
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

        jPanel4 = new javax.swing.JPanel();
        lb_Title = new javax.swing.JLabel();
        lb_MABAN = new javax.swing.JLabel();
        tf_TEN = new javax.swing.JTextField();
        lb_BOOK = new javax.swing.JLabel();
        lb_CREATE = new javax.swing.JLabel();
        lb_BEGIN = new javax.swing.JLabel();
        lb_TONGCB = new javax.swing.JLabel();
        tf_PHANTRAM = new javax.swing.JTextField();
        lb_END = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        tf_TINHTRANG = new javax.swing.JTextField();
        tf_LOAIKH = new javax.swing.JTextField();
        DC_BEGIN = new com.toedter.calendar.JDateChooser();
        DC_END = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(950, 380));

        lb_Title.setBackground(new java.awt.Color(255, 255, 255));
        lb_Title.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(120, 168, 252));
        lb_Title.setText("DISCOUNT INFO");

        lb_MABAN.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MABAN.setForeground(new java.awt.Color(120, 168, 252));
        lb_MABAN.setText("NAME:");

        tf_TEN.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TEN.setForeground(new java.awt.Color(120, 168, 252));
        tf_TEN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TEN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_BOOK.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_BOOK.setForeground(new java.awt.Color(120, 168, 252));
        lb_BOOK.setText("TYPE:");

        lb_CREATE.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_CREATE.setForeground(new java.awt.Color(120, 168, 252));
        lb_CREATE.setText("STATUS:");

        lb_BEGIN.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_BEGIN.setForeground(new java.awt.Color(120, 168, 252));
        lb_BEGIN.setText("BEGIN AT:");

        lb_TONGCB.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TONGCB.setForeground(new java.awt.Color(120, 168, 252));
        lb_TONGCB.setText("DISCOUNT:");

        tf_PHANTRAM.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_PHANTRAM.setForeground(new java.awt.Color(120, 168, 252));
        tf_PHANTRAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_PHANTRAM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_END.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_END.setForeground(new java.awt.Color(120, 168, 252));
        lb_END.setText("END AT:");

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

        tf_TINHTRANG.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TINHTRANG.setForeground(new java.awt.Color(120, 168, 252));
        tf_TINHTRANG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TINHTRANG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_LOAIKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_LOAIKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_LOAIKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_LOAIKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        DC_BEGIN.setDateFormatString("dd/MM/yyyy");

        DC_END.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(lb_Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_MABAN)
                    .addComponent(lb_BEGIN)
                    .addComponent(lb_END))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tf_TEN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_BOOK))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DC_BEGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DC_END, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_CREATE, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_TONGCB, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tf_LOAIKH, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_TINHTRANG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addComponent(tf_PHANTRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lb_Title)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_BOOK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_LOAIKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_MABAN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TEN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TINHTRANG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_BEGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DC_BEGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_TONGCB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_PHANTRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_END, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DC_END, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(DiscountController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiscountController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiscountController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiscountController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiscountController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DC_BEGIN;
    private com.toedter.calendar.JDateChooser DC_END;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb_BEGIN;
    private javax.swing.JLabel lb_BOOK;
    private javax.swing.JLabel lb_CREATE;
    private javax.swing.JLabel lb_END;
    private javax.swing.JLabel lb_MABAN;
    private javax.swing.JLabel lb_TONGCB;
    private javax.swing.JLabel lb_Title;
    private javax.swing.JTextField tf_LOAIKH;
    private javax.swing.JTextField tf_PHANTRAM;
    private javax.swing.JTextField tf_TEN;
    private javax.swing.JTextField tf_TINHTRANG;
    // End of variables declaration//GEN-END:variables
}
