/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.Customer;
import DBObject.SQLTable;
import MainView.Home;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class CustomerController extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form addEmployee
     */
    public CustomerController() {
        TAG = 1;
        initComponents();
    }
    
    public CustomerController(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        initComponents();
        
        ID = (String) data[0];
        tf_HOTEN.setText((String) data[1]);
        cbGender.setSelectedItem((String) data[2]);
        tf_LOAIKH.setText((String) data[3]);
        tf_SDT.setText((String) data[4]);
        tf_DIACHI.setText((String) data[5]);
        try {
            DC_Birth.setDate(format.parse((String) data[6]));
            DC_Reg.setDate(format.parse((String) data[7]));
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        tf_TAIKHOAN.setText((String) data[8]);
        tf_MATKHAU.setText((String) data[9]);       
        tf_MAGT.setText((String) data[10]);
        tf_DIEMTL.setText((String) data[11]);     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCreateCustomerAccount1 = new javax.swing.JLabel();
        lbName1 = new javax.swing.JLabel();
        tf_HOTEN = new javax.swing.JTextField();
        lbName2 = new javax.swing.JLabel();
        tf_LOAIKH = new javax.swing.JTextField();
        lbName3 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        lbName4 = new javax.swing.JLabel();
        lbName5 = new javax.swing.JLabel();
        lbName6 = new javax.swing.JLabel();
        lbName7 = new javax.swing.JLabel();
        tf_DIACHI = new javax.swing.JTextField();
        lbName8 = new javax.swing.JLabel();
        lbAccount = new javax.swing.JLabel();
        lbAccount1 = new javax.swing.JLabel();
        tf_TAIKHOAN = new javax.swing.JTextField();
        tf_SDT = new javax.swing.JTextField();
        tf_DIEMTL = new javax.swing.JTextField();
        tf_MAGT = new javax.swing.JTextField();
        lbAccount2 = new javax.swing.JLabel();
        btnConfirm1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        DC_Reg = new com.toedter.calendar.JDateChooser();
        DC_Birth = new com.toedter.calendar.JDateChooser();
        tf_MATKHAU = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbCreateCustomerAccount1.setBackground(new java.awt.Color(255, 255, 255));
        lbCreateCustomerAccount1.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lbCreateCustomerAccount1.setForeground(new java.awt.Color(120, 168, 252));
        lbCreateCustomerAccount1.setText("CUSTOMER INFO");

        lbName1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName1.setForeground(new java.awt.Color(120, 168, 252));
        lbName1.setText("FULL NAME:");

        tf_HOTEN.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_HOTEN.setForeground(new java.awt.Color(120, 168, 252));
        tf_HOTEN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_HOTEN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName2.setForeground(new java.awt.Color(120, 168, 252));
        lbName2.setText("TYPE:");

        tf_LOAIKH.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_LOAIKH.setForeground(new java.awt.Color(120, 168, 252));
        tf_LOAIKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_LOAIKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName3.setForeground(new java.awt.Color(120, 168, 252));
        lbName3.setText("GENDER:");

        cbGender.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cbGender.setForeground(new java.awt.Color(120, 168, 252));
        cbGender.setMaximumRowCount(2);
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbGender.setBorder(null);

        lbName4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName4.setForeground(new java.awt.Color(120, 168, 252));
        lbName4.setText("ADDRESS:");

        lbName5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName5.setForeground(new java.awt.Color(120, 168, 252));
        lbName5.setText("INVITE CODE:");

        lbName6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName6.setForeground(new java.awt.Color(120, 168, 252));
        lbName6.setText("PHONE:");

        lbName7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName7.setForeground(new java.awt.Color(120, 168, 252));
        lbName7.setText("BIRTHDAY:");

        tf_DIACHI.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DIACHI.setForeground(new java.awt.Color(120, 168, 252));
        tf_DIACHI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_DIACHI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbName8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName8.setForeground(new java.awt.Color(120, 168, 252));
        lbName8.setText("POINT:");

        lbAccount.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbAccount.setForeground(new java.awt.Color(120, 168, 252));
        lbAccount.setText("ACCOUNT:");

        lbAccount1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbAccount1.setForeground(new java.awt.Color(120, 168, 252));
        lbAccount1.setText("PASSWORD:");

        tf_TAIKHOAN.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TAIKHOAN.setForeground(new java.awt.Color(120, 168, 252));
        tf_TAIKHOAN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TAIKHOAN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_SDT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_SDT.setForeground(new java.awt.Color(120, 168, 252));
        tf_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_SDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_DIEMTL.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DIEMTL.setForeground(new java.awt.Color(120, 168, 252));
        tf_DIEMTL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_DIEMTL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MAGT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MAGT.setForeground(new java.awt.Color(120, 168, 252));
        tf_MAGT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MAGT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lbAccount2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbAccount2.setForeground(new java.awt.Color(120, 168, 252));
        lbAccount2.setText("REGISTER DATE:");

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

        DC_Reg.setDateFormatString("dd/MM/yyyy");

        DC_Birth.setDateFormatString("dd/MM/yyyy");

        tf_MATKHAU.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MATKHAU.setForeground(new java.awt.Color(120, 168, 252));
        tf_MATKHAU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MATKHAU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbName1)
                            .addComponent(lbName2)
                            .addComponent(lbName8)
                            .addComponent(lbAccount)
                            .addComponent(lbName4)
                            .addComponent(lbName5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_HOTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbName3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_DIEMTL, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAccount2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_TAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAccount1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_DIACHI, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbName6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_LOAIKH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(lbName7))
                            .addComponent(tf_MAGT, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnConfirm1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DC_Birth, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_MATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DC_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(lbCreateCustomerAccount1)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCreateCustomerAccount1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_HOTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbName3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_LOAIKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbName7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DC_Birth, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_DIACHI, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_DIEMTL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbName8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAccount2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DC_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_MAGT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void btnConfirm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirm1MouseClicked
        if (TAG == 1) {
            add(evt);
        }
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirm1MouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void update(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String FullName = tf_HOTEN.getText();
        String Gender = (String) cbGender.getSelectedItem();
        String Type = tf_LOAIKH.getText();
        String Phone = tf_SDT.getText();
        String Address = tf_DIACHI.getText();
        String Birth = format.format(DC_Birth.getDate());
        String Reg = format.format(DC_Reg.getDate());
        String Account  = tf_TAIKHOAN.getText();
        String Password = tf_MATKHAU.getText();
        String InviteCode = tf_MAGT.getText();
        int Point = Integer.parseInt(tf_DIEMTL.getText());
        
        String query = "update KHACHHANG "
                        + "set HOTEN = ?, GIOITINH = ?, LOAIKH = ?, DIACHI = ?, SDT = ?, NGSINH = ?, TAIKHOAN = ?, MATKHAU = ?, MAGIOITHIEU = ?, DIEMTL = ?"
                        + "where MAKH = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, FullName);
            p_statement.setString(2, Gender);
            p_statement.setString(3, Type);
            p_statement.setString(4, Address);
            p_statement.setString(5, Phone);
            p_statement.setDate(6, new java.sql.Date(DC_Birth.getDate().getTime()));
            p_statement.setString(7, Account);
            p_statement.setString(8, Password);
            p_statement.setString(9, InviteCode);
            p_statement.setInt(10, Point);
            p_statement.setString(11, ID);

            p_statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = (new Customer(ID, FullName, Gender, Type, Phone, Address, Birth, Reg, Account, Password, InviteCode, Point)).get_Properties();
            Home.update(data, RowID);
            dispose();
        } 
        
                
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String FullName = tf_HOTEN.getText();
        String Gender = (String) cbGender.getSelectedItem();
        String Type = tf_LOAIKH.getText();
        String Phone = tf_SDT.getText();
        String Address = tf_DIACHI.getText();
        String Birth = format.format(DC_Birth.getDate());
        String Reg = format.format(DC_Reg.getDate());
        String Account  = tf_TAIKHOAN.getText();
        String Password = tf_MATKHAU.getText();
        String InviteCode = tf_MAGT.getText();
        int Point = Integer.parseInt(tf_DIEMTL.getText());

        String query = "insert into KHACHHANG values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, FullName);
            p_statement.setString(3, Gender);
            p_statement.setString(4, Type);
            p_statement.setString(5, Phone);
            p_statement.setString(6, Address);
            p_statement.setDate(7, new java.sql.Date(DC_Birth.getDate().getTime()));
            p_statement.setDate(8, new java.sql.Date(DC_Reg.getDate().getTime()));
            p_statement.setString(9, Account);
            p_statement.setString(10, Password);
            p_statement.setString(11, InviteCode);
            p_statement.setInt(12, Point);

            p_statement.executeUpdate();
            Object[] data = (new Customer(ID, FullName, Gender, Type, Phone, Address, Birth, Reg, Account, Password, InviteCode, Point)).get_Properties();
            Home.update(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            
            dispose();
        } 
    }
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
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DC_Birth;
    private com.toedter.calendar.JDateChooser DC_Reg;
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbAccount1;
    private javax.swing.JLabel lbAccount2;
    private javax.swing.JLabel lbCreateCustomerAccount1;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName2;
    private javax.swing.JLabel lbName3;
    private javax.swing.JLabel lbName4;
    private javax.swing.JLabel lbName5;
    private javax.swing.JLabel lbName6;
    private javax.swing.JLabel lbName7;
    private javax.swing.JLabel lbName8;
    private javax.swing.JTextField tf_DIACHI;
    private javax.swing.JTextField tf_DIEMTL;
    private javax.swing.JTextField tf_HOTEN;
    private javax.swing.JTextField tf_LOAIKH;
    private javax.swing.JTextField tf_MAGT;
    private javax.swing.JTextField tf_MATKHAU;
    private javax.swing.JTextField tf_SDT;
    private javax.swing.JTextField tf_TAIKHOAN;
    // End of variables declaration//GEN-END:variables
}
