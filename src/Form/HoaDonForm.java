/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.HoaDonController;
import DBObject.SQLTable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class HoaDonForm extends javax.swing.JFrame {
   private int TAG;
    private String ID;
    private int RowID;

    public HoaDonForm() {
        this.TAG = 1;
        initComponents();
    }  
    public HoaDonForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }
    
    private void add() {
        if (check()) {
            HoaDonController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            HoaDonController.update(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private boolean check() {
        Object[] data = getInfo();
        int[] idx = {2, 3, 5, 6};
        
        for (int i = 0; i < idx.length; i++)
            if (data[idx[i]].equals(""))
                return false;
        return true;
    }
    
    private void ErrorMessage() {
        JOptionPane.showMessageDialog(null, "Invalid Input");
    }
    
    public Object[] getInfo() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String MaNV = tf_MaNV.getText();
        String MaKH = tf_MaKH.getText();
        String MaVe = tf_MaVe.getText();
        String MaGG = tf_MaGG.getText();
        String TongTien = tf_TongTien.getText();
        String NgHD = format.format(dc_NGHD.getDate());
        if (ID == null)
            ID = SQLTable.getTableID("HOADON", "HD");
        
        Object[] data = {ID, MaNV, MaKH, MaVe, MaGG, TongTien, NgHD};
        return data;
    }
    
    public void initInfo(Object[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ID = (String) data[0];
        tf_MaNV.setText((String) data[1]);
        tf_MaKH.setText((String) data[2]);
        tf_MaVe.setText((String) data[3]);
        tf_MaGG.setText((String) data[4]);
        tf_TongTien.setText((String) data[5]);
       try {
           dc_NGHD.setDate(format.parse((String) data[6]));
       } catch (ParseException ex) {
           Logger.getLogger(HoaDonForm.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KhachHangPanel2 = new javax.swing.JPanel();
        tf_MaNV = new javax.swing.JTextField();
        tf_MaKH = new javax.swing.JTextField();
        tf_MaVe = new javax.swing.JTextField();
        tf_TongTien = new javax.swing.JTextField();
        tf_MaGG = new javax.swing.JTextField();
        lb_KhachHangTitle2 = new javax.swing.JLabel();
        lb_MaNV = new javax.swing.JLabel();
        lb_MaKH = new javax.swing.JLabel();
        lb_NGHD = new javax.swing.JLabel();
        lb_MaVe = new javax.swing.JLabel();
        lb_MaGG = new javax.swing.JLabel();
        lb_TongTIen = new javax.swing.JLabel();
        btnConfirm2 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        dc_NGHD = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECEIPT FORM");
        setResizable(false);

        KhachHangPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tf_MaNV.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaNV.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MaKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MaVe.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaVe.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaVe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaVe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_TongTien.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TongTien.setForeground(new java.awt.Color(120, 168, 252));
        tf_TongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MaGG.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaGG.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaGG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaGG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_KhachHangTitle2.setBackground(new java.awt.Color(255, 255, 255));
        lb_KhachHangTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_KhachHangTitle2.setForeground(new java.awt.Color(120, 168, 252));
        lb_KhachHangTitle2.setText("RECEIPT INFO");

        lb_MaNV.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaNV.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaNV.setText("EMPLOYEE ID:");

        lb_MaKH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaKH.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaKH.setText("CUSTOMER ID:");

        lb_NGHD.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGHD.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGHD.setText("DATE:");

        lb_MaVe.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaVe.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaVe.setText("TICKET ID:");

        lb_MaGG.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaGG.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaGG.setText("DISCOUNT ID:");

        lb_TongTIen.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TongTIen.setForeground(new java.awt.Color(120, 168, 252));
        lb_TongTIen.setText("TOTAL COST:");

        btnConfirm2.setBackground(new java.awt.Color(120, 168, 252));
        btnConfirm2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnConfirm2.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm2.setText("CONFIRM");
        btnConfirm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirm2MouseClicked(evt);
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

        dc_NGHD.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout KhachHangPanel2Layout = new javax.swing.GroupLayout(KhachHangPanel2);
        KhachHangPanel2.setLayout(KhachHangPanel2Layout);
        KhachHangPanel2Layout.setHorizontalGroup(
            KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_MaNV)
                    .addComponent(lb_MaKH)
                    .addComponent(lb_MaVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(KhachHangPanel2Layout.createSequentialGroup()
                        .addComponent(tf_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_NGHD))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanel2Layout.createSequentialGroup()
                        .addComponent(tf_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_MaGG))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanel2Layout.createSequentialGroup()
                        .addComponent(tf_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(lb_TongTIen)))
                .addGap(18, 18, 18)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(KhachHangPanel2Layout.createSequentialGroup()
                            .addComponent(btnConfirm2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit))
                        .addComponent(dc_NGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_KhachHangTitle2)
                .addGap(432, 432, 432))
        );
        KhachHangPanel2Layout.setVerticalGroup(
            KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_KhachHangTitle2)
                .addGap(18, 18, 18)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachHangPanel2Layout.createSequentialGroup()
                        .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_TongTIen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dc_NGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(KhachHangPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KhachHangPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KhachHangPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirm2MouseClicked
        switch (TAG) {
            case 1: add(); break;
            case 2: update(); break;
            default: break;
        }
    }//GEN-LAST:event_btnConfirm2MouseClicked

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
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KhachHangPanel2;
    private javax.swing.JButton btnConfirm2;
    private javax.swing.JButton btnExit;
    private com.toedter.calendar.JDateChooser dc_NGHD;
    private javax.swing.JLabel lb_KhachHangTitle2;
    private javax.swing.JLabel lb_MaGG;
    private javax.swing.JLabel lb_MaKH;
    private javax.swing.JLabel lb_MaNV;
    private javax.swing.JLabel lb_MaVe;
    private javax.swing.JLabel lb_NGHD;
    private javax.swing.JLabel lb_TongTIen;
    private javax.swing.JTextField tf_MaGG;
    private javax.swing.JTextField tf_MaKH;
    private javax.swing.JTextField tf_MaNV;
    private javax.swing.JTextField tf_MaVe;
    private javax.swing.JTextField tf_TongTien;
    // End of variables declaration//GEN-END:variables
}
