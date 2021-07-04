/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.MonKhacController;
import DBObject.SQLTable;
import javax.swing.JOptionPane;

/**
 *
 * @author Phan Hau
 */
public class MonKhacForm extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;

    public MonKhacForm() {
        this.TAG = 1;
        initComponents();
    }  
    public MonKhacForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }
    
    private void add() {
        if (check()) {
            MonKhacController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            MonKhacController.update(getInfo(), RowID);
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
        String Name = tf_TenMK.getText();
        String Price = tf_Gia.getText();
        if (ID == null)
            ID = SQLTable.getTableID("MONKHAC", "MK");
        
        Object[] data = {ID, Name, Price};
        return data;
    }
    
    public void initInfo(Object[] data) {
        ID = (String) data[0];
        tf_TenMK.setText((String) data[1]);
        tf_Gia.setText((String) data[2]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        MonKhacPanel = new javax.swing.JPanel();
        lb_MonKhacTitle = new javax.swing.JLabel();
        lb_TenMK = new javax.swing.JLabel();
        tf_TenMK = new javax.swing.JTextField();
        Gia = new javax.swing.JLabel();
        tf_Gia = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FOOD FORM");
        setResizable(false);

        MonKhacPanel.setBackground(new java.awt.Color(255, 255, 255));

        lb_MonKhacTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_MonKhacTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_MonKhacTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_MonKhacTitle.setText("FOOD INFO");

        lb_TenMK.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TenMK.setForeground(new java.awt.Color(120, 168, 252));
        lb_TenMK.setText("FOOD NAME:");

        tf_TenMK.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TenMK.setForeground(new java.awt.Color(120, 168, 252));
        tf_TenMK.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_TenMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        Gia.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        Gia.setForeground(new java.awt.Color(120, 168, 252));
        Gia.setText("PRICE:");

        tf_Gia.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Gia.setForeground(new java.awt.Color(120, 168, 252));
        tf_Gia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Gia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

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

        javax.swing.GroupLayout MonKhacPanelLayout = new javax.swing.GroupLayout(MonKhacPanel);
        MonKhacPanel.setLayout(MonKhacPanelLayout);
        MonKhacPanelLayout.setHorizontalGroup(
            MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonKhacPanelLayout.createSequentialGroup()
                .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MonKhacPanelLayout.createSequentialGroup()
                        .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_MonKhacTitle)
                            .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MonKhacPanelLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(lb_TenMK)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_TenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonKhacPanelLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(Gia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonKhacPanelLayout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addGap(18, 18, 18)))
                .addComponent(btnExit)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        MonKhacPanelLayout.setVerticalGroup(
            MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonKhacPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_MonKhacTitle)
                .addGap(40, 40, 40)
                .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(MonKhacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MonKhacPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MonKhacPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(MonKhacForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonKhacForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonKhacForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonKhacForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonKhacForm().setVisible(true);
                new MonKhacForm().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gia;
    private javax.swing.JPanel MonKhacPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lb_MonKhacTitle;
    private javax.swing.JLabel lb_TenMK;
    private javax.swing.JTextField tf_Gia;
    private javax.swing.JTextField tf_TenMK;
    // End of variables declaration//GEN-END:variables
}
