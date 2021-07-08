/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.BanController;
import DBObject.SQLTable;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class BanForm extends javax.swing.JFrame {

    private int TAG;
    private String ID;
    private int RowID;

    public BanForm() {
        this.TAG = 1;
        initComponents();
    }  
    public BanForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }
    
    private void add() {
        if (check()) {
            BanController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            BanController.update(getInfo());
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
        String Type = tf_LoaiBan.getText();
        String NoP = tf_SoNguoi.getText();
        if (ID == null)
            ID = SQLTable.getTableID("BAN", "B");
        
        Object[] data = {ID, Type, NoP};
        return data;
    }
    
    public void initInfo(Object[] data) {
        ID = (String) data[0];
        tf_LoaiBan.setText((String) data[1]);
        tf_SoNguoi.setText((String) data[2]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BanPanel = new javax.swing.JPanel();
        lb_BanTitle = new javax.swing.JLabel();
        lb_LoaiBan = new javax.swing.JLabel();
        tf_LoaiBan = new javax.swing.JTextField();
        lb_SoNguoi = new javax.swing.JLabel();
        tf_SoNguoi = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BanPanel.setBackground(new java.awt.Color(255, 255, 255));

        lb_BanTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_BanTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_BanTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_BanTitle.setText("TABLE INFO");

        lb_LoaiBan.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_LoaiBan.setForeground(new java.awt.Color(120, 168, 252));
        lb_LoaiBan.setText("TABLE TYPE:");

        tf_LoaiBan.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_LoaiBan.setForeground(new java.awt.Color(120, 168, 252));
        tf_LoaiBan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_LoaiBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_SoNguoi.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_SoNguoi.setForeground(new java.awt.Color(120, 168, 252));
        lb_SoNguoi.setText("NUMBER OF PEOPLE:");

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

        javax.swing.GroupLayout BanPanelLayout = new javax.swing.GroupLayout(BanPanel);
        BanPanel.setLayout(BanPanelLayout);
        BanPanelLayout.setHorizontalGroup(
            BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanPanelLayout.createSequentialGroup()
                .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanPanelLayout.createSequentialGroup()
                        .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_BanTitle)
                            .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(BanPanelLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(lb_LoaiBan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_LoaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(BanPanelLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(lb_SoNguoi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BanPanelLayout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addGap(18, 18, 18)))
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BanPanelLayout.setVerticalGroup(
            BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_BanTitle)
                .addGap(40, 40, 40)
                .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_LoaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_LoaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(BanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(BanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BanPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lb_BanTitle;
    private javax.swing.JLabel lb_LoaiBan;
    private javax.swing.JLabel lb_SoNguoi;
    private javax.swing.JTextField tf_LoaiBan;
    private javax.swing.JTextField tf_SoNguoi;
    // End of variables declaration//GEN-END:variables
}
