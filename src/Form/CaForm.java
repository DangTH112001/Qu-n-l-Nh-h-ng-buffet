/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.CaController;
import DBObject.SQLTable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Phan Hau
 */
public class CaForm extends javax.swing.JFrame {
    private Date date;
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form DiscountController
     */
    public CaForm() {
        this.date = new Date();
        this.TAG = 1;
        initComponents();
    }
    
    public CaForm(Object[] data, int RowID) {    
        this.date = new Date();
        this.TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }    
    
    private void add() {
        if (check()) {
            CaController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            CaController.update(getInfo());
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
    
    private Object[] getInfo() {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");   
        
        String Begin = format.format((Date) Spin_TGBD.getValue());
        String End = format.format((Date) Spin_TGKT.getValue());
        String Type = (String) cb_LoaiCa.getSelectedItem();
        if (ID == null)
            ID = SQLTable.getTableID("CA", "C");
        
        Object[] data = {ID, Begin, End, Type};
        return data;
    }
    
    private void initInfo(Object[] data) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");   
        
        ID = (String) data[0];
        try {
            Spin_TGBD.setValue(format.parse((String) data[1]));
            Spin_TGKT.setValue(format.parse((String) data[2]));
        } catch (ParseException ex) {
            Logger.getLogger(VeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb_LoaiCa.setSelectedItem((String) data[3]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CaPanel = new javax.swing.JPanel();
        lb_CaTitle = new javax.swing.JLabel();
        lb_TGBD = new javax.swing.JLabel();
        lb_TGKT = new javax.swing.JLabel();
        lb_LoaiCa = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGBD = new javax.swing.JSpinner(sm1);
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGKT = new javax.swing.JSpinner(sm2);
        cb_LoaiCa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SHIFT FORM");
        setResizable(false);

        CaPanel.setBackground(new java.awt.Color(255, 255, 255));

        lb_CaTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_CaTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_CaTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_CaTitle.setText("ADD SHIFT");

        lb_TGBD.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGBD.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGBD.setText("START TIME:");

        lb_TGKT.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TGKT.setForeground(new java.awt.Color(120, 168, 252));
        lb_TGKT.setText("END TIME:");

        lb_LoaiCa.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_LoaiCa.setForeground(new java.awt.Color(120, 168, 252));
        lb_LoaiCa.setText("SHIFT TYPE:");

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
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(Spin_TGBD, "HH:mm:ss");
        Spin_TGBD.setEditor(de1);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(Spin_TGKT, "HH:mm:ss");
        Spin_TGKT.setEditor(de2);

        cb_LoaiCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca thường", "Tăng ca" }));

        javax.swing.GroupLayout CaPanelLayout = new javax.swing.GroupLayout(CaPanel);
        CaPanel.setLayout(CaPanelLayout);
        CaPanelLayout.setHorizontalGroup(
            CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TGKT)
                    .addComponent(lb_TGBD)
                    .addComponent(lb_LoaiCa))
                .addGap(18, 18, 18)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CaPanelLayout.createSequentialGroup()
                        .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Spin_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Spin_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CaPanelLayout.createSequentialGroup()
                        .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CaPanelLayout.createSequentialGroup()
                                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_LoaiCa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(CaPanelLayout.createSequentialGroup()
                                        .addComponent(lb_CaTitle)
                                        .addGap(12, 12, 12)))
                                .addGap(0, 110, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CaPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirm)))
                        .addGap(18, 18, 18)
                        .addComponent(btnExit)
                        .addGap(24, 24, 24))))
        );
        CaPanelLayout.setVerticalGroup(
            CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_CaTitle)
                .addGap(34, 34, 34)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spin_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_LoaiCa)
                    .addComponent(cb_LoaiCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(CaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(CaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaForm().setVisible(true);
                new CaForm().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CaPanel;
    private javax.swing.JSpinner Spin_TGBD;
    private javax.swing.JSpinner Spin_TGKT;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cb_LoaiCa;
    private javax.swing.JLabel lb_CaTitle;
    private javax.swing.JLabel lb_LoaiCa;
    private javax.swing.JLabel lb_TGBD;
    private javax.swing.JLabel lb_TGKT;
    // End of variables declaration//GEN-END:variables
}
