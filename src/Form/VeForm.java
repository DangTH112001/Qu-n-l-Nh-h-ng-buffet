/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.VeController;
import DBObject.Employee;
import DBObject.SQLTable;
import DBObject.Ticket;
import MainView.ManagerHome;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author DangT
 */
public class VeForm extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;
    private Date date;

    public VeForm() {
        this.TAG = 1;
        this.date = new Date();
        
        initComponents();
    }  
    public VeForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        this.date = new Date();
        
        initComponents();
        initInfo(data);
    }
    
    private void add() {
        if (check()) {
            VeController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            VeController.update(getInfo(), RowID);
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private boolean check() {
        Object[] data = getInfo();
        
        for (Object obj : data)
            if (obj.equals("")) 
                return false;
        return true;
    }
    
    private void ErrorMessage() {
        JOptionPane.showMessageDialog(null, "Invalid Input");
    }
    
    public Object[] getInfo() {
        DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat tformat = new SimpleDateFormat("HH:mm:ss");
        
        String tableID = tf_MaBan.getText();
        String cusID = tf_MaKH.getText();
        String BookDate = dformat.format(dc_NGAN.getDate());
        String CreateDate = dformat.format(dc_NGDV.getDate());
        String TongCB = tf_TongCB.getText();
        String TongMK = tf_TongMK.getText();
        String Begin = tformat.format((Date) Spin_TGBD.getValue());
        String End = tformat.format((Date) Spin_TGKT.getValue());
        if (ID == null)
            ID = ManagerHome.getTableID();
        
        Object[] data = {ID, tableID, cusID, BookDate, CreateDate, TongCB, TongMK, Begin, End};
        return data;
    }
    
    public void initInfo(Object[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ID = (String) data[0];
        tf_MaBan.setText((String) data[1]);
        tf_MaKH.setText((String) data[2]);
        try {         
            dc_NGAN.setDate(format.parse((String) data[3]));
            dc_NGDV.setDate(format.parse((String) data[4]));
        } catch (ParseException ex) {
            Logger.getLogger(VeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        format = new SimpleDateFormat("HH:mm:ss");
        tf_TongCB.setText((String) data[5]);
        tf_TongMK.setText((String) data[6]);
        try {
            Spin_TGBD.setValue(format.parse((String) data[7]));
            Spin_TGKT.setValue(format.parse((String) data[8]));
        } catch (ParseException ex) {
            Logger.getLogger(VeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VePanel = new javax.swing.JPanel();
        lb_VeTitle = new javax.swing.JLabel();
        lb_MaKH = new javax.swing.JLabel();
        tf_MaKH = new javax.swing.JTextField();
        lb_MaBan = new javax.swing.JLabel();
        tf_MaBan = new javax.swing.JTextField();
        lb_NGAN = new javax.swing.JLabel();
        lb_NGDV = new javax.swing.JLabel();
        lb_TGBD = new javax.swing.JLabel();
        lb_TongCB = new javax.swing.JLabel();
        lb_TongMK = new javax.swing.JLabel();
        tf_TongCB = new javax.swing.JTextField();
        lb_TGKT = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        dc_NGAN = new com.toedter.calendar.JDateChooser();
        dc_NGDV = new com.toedter.calendar.JDateChooser();
        tf_TongMK = new javax.swing.JTextField();
        SpinnerDateModel sm2 =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGKT = new javax.swing.JSpinner(sm2);
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGBD = new javax.swing.JSpinner(sm1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        VePanel.setBackground(new java.awt.Color(255, 255, 255));
        VePanel.setPreferredSize(new java.awt.Dimension(1040, 500));

        lb_VeTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_VeTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_VeTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_VeTitle.setText("TICKET INFO");

        lb_MaKH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaKH.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaKH.setText("CUSTOMER ID:");

        tf_MaKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_MaBan.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaBan.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaBan.setText("TABLE ID:");

        tf_MaBan.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaBan.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaBan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_NGAN.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGAN.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGAN.setText("BOOK DATE:");

        lb_NGDV.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGDV.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGDV.setText("CREATE DATE:");

        lb_TGBD.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGBD.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGBD.setText("BEGIN AT:");

        lb_TongCB.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TongCB.setForeground(new java.awt.Color(120, 168, 252));
        lb_TongCB.setText("COMBO MONEY:");

        lb_TongMK.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TongMK.setForeground(new java.awt.Color(120, 168, 252));
        lb_TongMK.setText("FOOD MONEY:");

        tf_TongCB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TongCB.setForeground(new java.awt.Color(120, 168, 252));
        tf_TongCB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TongCB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));
        tf_TongCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TongCBActionPerformed(evt);
            }
        });

        lb_TGKT.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGKT.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGKT.setText("END AT:");

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

        dc_NGAN.setDateFormatString("dd/MM/yyyy");

        dc_NGDV.setDateFormatString("dd/MM/yyyy");

        tf_TongMK.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TongMK.setForeground(new java.awt.Color(120, 168, 252));
        tf_TongMK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TongMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(Spin_TGKT, "HH:mm:ss");
        Spin_TGKT.setEditor(de2);

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(Spin_TGBD, "HH:mm:ss");
        Spin_TGBD.setEditor(de1);

        javax.swing.GroupLayout VePanelLayout = new javax.swing.GroupLayout(VePanel);
        VePanel.setLayout(VePanelLayout);
        VePanelLayout.setHorizontalGroup(
            VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VePanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TongCB)
                    .addComponent(lb_MaKH)
                    .addComponent(lb_MaBan)
                    .addComponent(lb_TGBD))
                .addGap(18, 18, 18)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VePanelLayout.createSequentialGroup()
                        .addComponent(tf_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_NGAN))
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addComponent(tf_MaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(lb_NGDV))
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_TongCB, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(Spin_TGBD))
                        .addGap(106, 106, 106)
                        .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TongMK, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_TGKT, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addGap(46, 46, 46)
                        .addComponent(btnExit)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_NGDV, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(dc_NGAN, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(tf_TongMK)
                            .addComponent(Spin_TGKT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(VePanelLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(lb_VeTitle)
                .addGap(33, 33, 33))
        );
        VePanelLayout.setVerticalGroup(
            VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_VeTitle)
                .addGap(18, 18, 18)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NGAN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NGDV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(VePanelLayout.createSequentialGroup()
                        .addComponent(dc_NGAN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dc_NGDV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TongCB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TongCB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TongMK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TongMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(VePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMouseClicked
        switch (TAG) {
            case 1: add(); break;
            case 2: update(); break;
            default: break;
        }
    }//GEN-LAST:event_btnConfirmMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void tf_TongCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TongCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TongCBActionPerformed

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
            java.util.logging.Logger.getLogger(VeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Spin_TGBD;
    private javax.swing.JSpinner Spin_TGKT;
    private javax.swing.JPanel VePanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private com.toedter.calendar.JDateChooser dc_NGAN;
    private com.toedter.calendar.JDateChooser dc_NGDV;
    private javax.swing.JLabel lb_MaBan;
    private javax.swing.JLabel lb_MaKH;
    private javax.swing.JLabel lb_NGAN;
    private javax.swing.JLabel lb_NGDV;
    private javax.swing.JLabel lb_TGBD;
    private javax.swing.JLabel lb_TGKT;
    private javax.swing.JLabel lb_TongCB;
    private javax.swing.JLabel lb_TongMK;
    private javax.swing.JLabel lb_VeTitle;
    private javax.swing.JTextField tf_MaBan;
    private javax.swing.JTextField tf_MaKH;
    private javax.swing.JTextField tf_TongCB;
    private javax.swing.JTextField tf_TongMK;
    // End of variables declaration//GEN-END:variables
}
