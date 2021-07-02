/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.MonKhacController;
import Controller.QuaController;
import DBObject.SQLTable;
import MainView.ManagerHome;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class QuaForm extends javax.swing.JFrame {
private int TAG;
    private String ID;
    private int RowID;

    public QuaForm() {
        this.TAG = 1;
        initComponents();
    }  
    public QuaForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }
    
    private void add() {
        if (check()) {
            QuaController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            QuaController.update(getInfo(), RowID);
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
        String Name = tf_TenQua.getText();
        String Point = tf_DiemDoi.getText();
        if (ID == null)
            ID = SQLTable.getTableID("QUA", "Q");
        
        Object[] data = {ID, Name, Point};
        return data;
    }
    
    public void initInfo(Object[] data) {
        ID = (String) data[0];
        tf_TenQua.setText((String) data[1]);
        tf_DiemDoi.setText((String) data[2]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuaPanel = new javax.swing.JPanel();
        lb_QuaTItle = new javax.swing.JLabel();
        lb_TenQua = new javax.swing.JLabel();
        lb_DiemDoi = new javax.swing.JLabel();
        tf_TenQua = new javax.swing.JTextField();
        tf_DiemDoi = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        QuaPanel.setBackground(new java.awt.Color(255, 255, 255));

        lb_QuaTItle.setBackground(new java.awt.Color(255, 255, 255));
        lb_QuaTItle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_QuaTItle.setForeground(new java.awt.Color(120, 168, 252));
        lb_QuaTItle.setText("GIFT INFO");

        lb_TenQua.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TenQua.setForeground(new java.awt.Color(120, 168, 252));
        lb_TenQua.setText("GIFT NAME:");

        lb_DiemDoi.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_DiemDoi.setForeground(new java.awt.Color(120, 168, 252));
        lb_DiemDoi.setText("POINT:");

        tf_TenQua.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TenQua.setForeground(new java.awt.Color(120, 168, 252));
        tf_TenQua.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_TenQua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_DiemDoi.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DiemDoi.setForeground(new java.awt.Color(120, 168, 252));
        tf_DiemDoi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_DiemDoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

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

        javax.swing.GroupLayout QuaPanelLayout = new javax.swing.GroupLayout(QuaPanel);
        QuaPanel.setLayout(QuaPanelLayout);
        QuaPanelLayout.setHorizontalGroup(
            QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuaPanelLayout.createSequentialGroup()
                .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuaPanelLayout.createSequentialGroup()
                        .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_QuaTItle)
                            .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(QuaPanelLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(lb_TenQua)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_TenQua, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuaPanelLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(lb_DiemDoi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_DiemDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuaPanelLayout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addGap(18, 18, 18)))
                .addComponent(btnExit)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        QuaPanelLayout.setVerticalGroup(
            QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_QuaTItle)
                .addGap(40, 40, 40)
                .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TenQua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TenQua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_DiemDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_DiemDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(QuaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(QuaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuaPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lb_DiemDoi;
    private javax.swing.JLabel lb_QuaTItle;
    private javax.swing.JLabel lb_TenQua;
    private javax.swing.JTextField tf_DiemDoi;
    private javax.swing.JTextField tf_TenQua;
    // End of variables declaration//GEN-END:variables
}
