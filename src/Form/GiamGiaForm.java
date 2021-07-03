/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.GiamGiaController;
import DBObject.SQLTable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class GiamGiaForm extends javax.swing.JFrame {
    private Date date;
    private int TAG;
    private String ID;
    private int RowID;                                
    
    public GiamGiaForm() {
        this.date = new Date();
        this.TAG = 1;
        initComponents();
    }
    
    public GiamGiaForm(Object[] data, int RowID) {    
        this.date = new Date();  
        this.TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }    
    
    private void add() {
        if (check()) {
            GiamGiaController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            GiamGiaController.update(getInfo(), RowID);
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private boolean check() {
        Object[] data = getInfo();
        int[] idx = {1, 2, 3, 6};
        
        for (int i = 0; i < idx.length; i++)
            if (data[idx[i]].equals(""))
                return false;
        return true;
    }
    
    private void ErrorMessage() {
        JOptionPane.showMessageDialog(null, "Invalid Input");
    }
    
    private Object[] getInfo() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String Name = tf_TenGG.getText();
        String Percent = tf_PhanTram.getText();
        String Type = tf_LoaiKH.getText();
        String Start= "01/01/0000";
        String End= "31/12/9999";
        if (dc_NGBD.getDate() != null)
             Start = format.format(dc_NGBD.getDate());
        if (dc_NGKT.getDate() != null)
             End = format.format(dc_NGKT.getDate());
        String Status = tf_TinhTrang.getText();
        if (ID == null)
            ID = SQLTable.getTableID("GIAMGIA", "GG");
        
        Object[] data = {ID, Name, Percent, Type, Start, End, Status};
        return data;
    }
    
    private void initInfo(Object[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        ID = (String) data[0];
        tf_TenGG.setText((String) data[1]);
        tf_PhanTram.setText((String) data[2]);
        tf_LoaiKH.setText((String) data[3]);
        try {
            dc_NGBD.setDate(format.parse((String) data[4]));
            dc_NGKT.setDate(format.parse((String) data[5]));
        } catch (ParseException ex) {
            Logger.getLogger(GiamGiaForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        tf_TinhTrang.setText((String) data[6]); 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GiamGiaPanel = new javax.swing.JPanel();
        lb_GiamGiaTitle = new javax.swing.JLabel();
        lb_TenGG = new javax.swing.JLabel();
        lb_NGAN = new javax.swing.JLabel();
        lb_NGDV = new javax.swing.JLabel();
        lb_TGBD = new javax.swing.JLabel();
        lb_PhanTram = new javax.swing.JLabel();
        lb_TGKT = new javax.swing.JLabel();
        tf_TenGG = new javax.swing.JTextField();
        tf_PhanTram = new javax.swing.JTextField();
        tf_TinhTrang = new javax.swing.JTextField();
        tf_LoaiKH = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        dc_NGBD = new com.toedter.calendar.JDateChooser();
        dc_NGKT = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        GiamGiaPanel.setBackground(new java.awt.Color(255, 255, 255));
        GiamGiaPanel.setPreferredSize(new java.awt.Dimension(950, 380));

        lb_GiamGiaTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_GiamGiaTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_GiamGiaTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_GiamGiaTitle.setText("DISCOUNT INFO");

        lb_TenGG.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TenGG.setForeground(new java.awt.Color(120, 168, 252));
        lb_TenGG.setText("NAME:");

        lb_NGAN.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGAN.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGAN.setText("TYPE:");

        lb_NGDV.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGDV.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGDV.setText("STATUS:");

        lb_TGBD.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGBD.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGBD.setText("BEGIN AT:");

        lb_PhanTram.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_PhanTram.setForeground(new java.awt.Color(120, 168, 252));
        lb_PhanTram.setText("DISCOUNT:");

        lb_TGKT.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGKT.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGKT.setText("END AT:");

        tf_TenGG.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TenGG.setForeground(new java.awt.Color(120, 168, 252));
        tf_TenGG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TenGG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_PhanTram.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_PhanTram.setForeground(new java.awt.Color(120, 168, 252));
        tf_PhanTram.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_PhanTram.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_TinhTrang.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TinhTrang.setForeground(new java.awt.Color(120, 168, 252));
        tf_TinhTrang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TinhTrang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_LoaiKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_LoaiKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_LoaiKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_LoaiKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

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

        dc_NGBD.setDateFormatString("dd/MM/yyyy");

        dc_NGKT.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout GiamGiaPanelLayout = new javax.swing.GroupLayout(GiamGiaPanel);
        GiamGiaPanel.setLayout(GiamGiaPanelLayout);
        GiamGiaPanelLayout.setHorizontalGroup(
            GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(lb_GiamGiaTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TenGG)
                    .addComponent(lb_TGBD)
                    .addComponent(lb_TGKT))
                .addGap(18, 18, 18)
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                        .addComponent(tf_TenGG, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_NGAN))
                    .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                        .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dc_NGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dc_NGKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_NGDV, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_PhanTram, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tf_LoaiKH, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_TinhTrang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addComponent(tf_PhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GiamGiaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addGap(37, 37, 37))
        );
        GiamGiaPanelLayout.setVerticalGroup(
            GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GiamGiaPanelLayout.createSequentialGroup()
                        .addComponent(lb_GiamGiaTitle)
                        .addGap(18, 18, 18)
                        .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NGAN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_LoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_TenGG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TenGG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NGDV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dc_NGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_PhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_PhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dc_NGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(GiamGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GiamGiaPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GiamGiaPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMouseClicked
        switch (TAG) {
            case 1: add(); break;
            case 2: update(); break;
            default: break;
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
            java.util.logging.Logger.getLogger(GiamGiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiamGiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiamGiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiamGiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiamGiaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GiamGiaPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private com.toedter.calendar.JDateChooser dc_NGBD;
    private com.toedter.calendar.JDateChooser dc_NGKT;
    private javax.swing.JLabel lb_GiamGiaTitle;
    private javax.swing.JLabel lb_NGAN;
    private javax.swing.JLabel lb_NGDV;
    private javax.swing.JLabel lb_PhanTram;
    private javax.swing.JLabel lb_TGBD;
    private javax.swing.JLabel lb_TGKT;
    private javax.swing.JLabel lb_TenGG;
    private javax.swing.JTextField tf_LoaiKH;
    private javax.swing.JTextField tf_PhanTram;
    private javax.swing.JTextField tf_TenGG;
    private javax.swing.JTextField tf_TinhTrang;
    // End of variables declaration//GEN-END:variables
}
