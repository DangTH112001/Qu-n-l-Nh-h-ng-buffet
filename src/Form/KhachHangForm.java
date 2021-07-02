/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.KhachHangController;
import DBObject.SQLTable;
import MainView.ManagerHome;
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
public class KhachHangForm extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;

    public KhachHangForm() {
        this.TAG = 1;
        initComponents();
    }
    
    public KhachHangForm(Object[] data, int RowID) {    
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        this.TAG = 2;
        this.RowID = RowID;
        
        initComponents();
        initInfo(data);
    }    
    
    private void add() {
        if (check()) {
            KhachHangController.add(getInfo());
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private void update() {
        if (check()) {
            KhachHangController.update(getInfo(), RowID);
            dispose();
        }
        else 
            ErrorMessage();
    }
    
    private boolean check() {
        Object[] data = getInfo();
        int[] idx = {1, 2, 8, 9};
        
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
        
        String FullName = tf_HoTen.getText();
        String Gender = (String) cb_GioiTinh.getSelectedItem();
        String Type = tf_LoaiKH.getText();
        String Phone = tf_SDT.getText();
        String Address = tf_DiaChi.getText();
        String Birth = format.format(dc_NGSINH.getDate());
        String Reg = format.format(dc_NGDK.getDate());
        String Account  = tf_TaiKhoan.getText();
        String Password = tf_MatKhau.getText();
        String InviteCode = tf_MAGT.getText();
        String Point = tf_DiemTL.getText();
        if (ID == null)
            ID = SQLTable.getTableID("KHACHHANG", "KH");
        
        Object[] data = {ID, FullName, Gender, Birth, Type, Phone, Address, Reg, Account, Password, InviteCode, Point};
        return data;
    }
    
    private void initInfo(Object[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        ID = (String) data[0];
        tf_HoTen.setText((String) data[1]);
        cb_GioiTinh.setSelectedItem((String) data[2]);
        tf_LoaiKH.setText((String) data[4]);
        tf_SDT.setText((String) data[5]);
        tf_DiaChi.setText((String) data[6]);
        try {
            dc_NGSINH.setDate(format.parse((String) data[3]));
            dc_NGDK.setDate(format.parse((String) data[7]));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        tf_TaiKhoan.setText((String) data[8]);
        tf_MatKhau.setText((String) data[9]);       
        tf_MAGT.setText((String) data[10]);
        tf_DiemTL.setText((String) data[11]);     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KhachHangPanel = new javax.swing.JPanel();
        tf_HoTen = new javax.swing.JTextField();
        tf_LoaiKH = new javax.swing.JTextField();
        tf_DiaChi = new javax.swing.JTextField();
        tf_TaiKhoan = new javax.swing.JTextField();
        tf_SDT = new javax.swing.JTextField();
        tf_DiemTL = new javax.swing.JTextField();
        tf_MAGT = new javax.swing.JTextField();
        tf_MatKhau = new javax.swing.JTextField();
        lb_KhachHangTitle = new javax.swing.JLabel();
        lb_TenKH = new javax.swing.JLabel();
        lb_LoaiKH = new javax.swing.JLabel();
        lb_GioiTInh = new javax.swing.JLabel();
        lb_DiaChi = new javax.swing.JLabel();
        lb_MaGioiThieu = new javax.swing.JLabel();
        lb_SDT = new javax.swing.JLabel();
        lb_NGSINH = new javax.swing.JLabel();
        lb_DiemTL = new javax.swing.JLabel();
        lb_TaiKhoan = new javax.swing.JLabel();
        lb_MatKhau = new javax.swing.JLabel();
        lb_NGDK = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        dc_NGDK = new com.toedter.calendar.JDateChooser();
        dc_NGSINH = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        KhachHangPanel.setBackground(new java.awt.Color(255, 255, 255));

        tf_HoTen.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_HoTen.setForeground(new java.awt.Color(120, 168, 252));
        tf_HoTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_HoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_LoaiKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_LoaiKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_LoaiKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_LoaiKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_DiaChi.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DiaChi.setForeground(new java.awt.Color(120, 168, 252));
        tf_DiaChi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_DiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_TaiKhoan.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TaiKhoan.setForeground(new java.awt.Color(120, 168, 252));
        tf_TaiKhoan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TaiKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_SDT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_SDT.setForeground(new java.awt.Color(120, 168, 252));
        tf_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_SDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_DiemTL.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DiemTL.setForeground(new java.awt.Color(120, 168, 252));
        tf_DiemTL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_DiemTL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MAGT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MAGT.setForeground(new java.awt.Color(120, 168, 252));
        tf_MAGT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MAGT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MatKhau.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MatKhau.setForeground(new java.awt.Color(120, 168, 252));
        tf_MatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_KhachHangTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_KhachHangTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_KhachHangTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_KhachHangTitle.setText("CUSTOMER INFO");

        lb_TenKH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TenKH.setForeground(new java.awt.Color(120, 168, 252));
        lb_TenKH.setText("FULL NAME:");

        lb_LoaiKH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_LoaiKH.setForeground(new java.awt.Color(120, 168, 252));
        lb_LoaiKH.setText("TYPE:");

        lb_GioiTInh.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_GioiTInh.setForeground(new java.awt.Color(120, 168, 252));
        lb_GioiTInh.setText("GENDER:");

        lb_DiaChi.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_DiaChi.setForeground(new java.awt.Color(120, 168, 252));
        lb_DiaChi.setText("ADDRESS:");

        lb_MaGioiThieu.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaGioiThieu.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaGioiThieu.setText("INVITE CODE:");

        lb_SDT.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_SDT.setForeground(new java.awt.Color(120, 168, 252));
        lb_SDT.setText("PHONE:");

        lb_NGSINH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGSINH.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGSINH.setText("BIRTHDAY:");

        lb_DiemTL.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_DiemTL.setForeground(new java.awt.Color(120, 168, 252));
        lb_DiemTL.setText("POINT:");

        lb_TaiKhoan.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TaiKhoan.setForeground(new java.awt.Color(120, 168, 252));
        lb_TaiKhoan.setText("ACCOUNT:");

        lb_MatKhau.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MatKhau.setForeground(new java.awt.Color(120, 168, 252));
        lb_MatKhau.setText("PASSWORD:");

        lb_NGDK.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGDK.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGDK.setText("REGISTER DATE:");

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

        cb_GioiTinh.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cb_GioiTinh.setForeground(new java.awt.Color(120, 168, 252));
        cb_GioiTinh.setMaximumRowCount(2);
        cb_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cb_GioiTinh.setBorder(null);

        dc_NGDK.setDateFormatString("dd/MM/yyyy");

        dc_NGSINH.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout KhachHangPanelLayout = new javax.swing.GroupLayout(KhachHangPanel);
        KhachHangPanel.setLayout(KhachHangPanelLayout);
        KhachHangPanelLayout.setHorizontalGroup(
            KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_TenKH)
                            .addComponent(lb_LoaiKH)
                            .addComponent(lb_DiemTL)
                            .addComponent(lb_TaiKhoan)
                            .addComponent(lb_DiaChi)
                            .addComponent(lb_MaGioiThieu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                .addComponent(tf_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_GioiTInh))
                            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                .addComponent(tf_DiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_NGDK))
                            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                .addComponent(tf_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_MatKhau))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanelLayout.createSequentialGroup()
                                .addComponent(tf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_SDT))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangPanelLayout.createSequentialGroup()
                                .addComponent(tf_LoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(lb_NGSINH))
                            .addComponent(tf_MAGT, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dc_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dc_NGDK, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(lb_KhachHangTitle)))
                .addGap(33, 33, 33))
        );
        KhachHangPanelLayout.setVerticalGroup(
            KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_KhachHangTitle)
                .addGap(18, 18, 18)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(KhachHangPanelLayout.createSequentialGroup()
                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_GioiTInh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_LoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_LoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dc_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_DiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_DiemTL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_NGDK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dc_NGDK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_MAGT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MaGioiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(KhachHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KhachHangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KhachHangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KhachHangPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private com.toedter.calendar.JDateChooser dc_NGDK;
    private com.toedter.calendar.JDateChooser dc_NGSINH;
    private javax.swing.JLabel lb_DiaChi;
    private javax.swing.JLabel lb_DiemTL;
    private javax.swing.JLabel lb_GioiTInh;
    private javax.swing.JLabel lb_KhachHangTitle;
    private javax.swing.JLabel lb_LoaiKH;
    private javax.swing.JLabel lb_MaGioiThieu;
    private javax.swing.JLabel lb_MatKhau;
    private javax.swing.JLabel lb_NGDK;
    private javax.swing.JLabel lb_NGSINH;
    private javax.swing.JLabel lb_SDT;
    private javax.swing.JLabel lb_TaiKhoan;
    private javax.swing.JLabel lb_TenKH;
    private javax.swing.JTextField tf_DiaChi;
    private javax.swing.JTextField tf_DiemTL;
    private javax.swing.JTextField tf_HoTen;
    private javax.swing.JTextField tf_LoaiKH;
    private javax.swing.JTextField tf_MAGT;
    private javax.swing.JTextField tf_MatKhau;
    private javax.swing.JTextField tf_SDT;
    private javax.swing.JTextField tf_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
