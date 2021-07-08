/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DBObject.SQLTable;
import MainView.CustomerHome;
import MainView.EmployeeHome;
import MainView.ManagerHome;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


/**
 *
 * @author Phan Hau
 */
public class DangNhapForm extends javax.swing.JFrame {
    ManagerHome mh;
    EmployeeHome eh;
    CustomerHome ch;
    TaiKhoan ai;
    SQLTable table = new SQLTable();
    
    public DangNhapForm() {
        initComponents();
        Error.setVisible(false);
        mh = new ManagerHome();
        eh = new EmployeeHome();
        ch = new CustomerHome();
        ai = new TaiKhoan();
        table = new SQLTable();
    }
    
    private void setBorder() {
        Border errorBorder = BorderFactory.createLineBorder(Color.RED, 1);
        TextField_UserName.setBorder(errorBorder);
        TextField_Password.setBorder(errorBorder);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_LoginForm = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Label_Login = new javax.swing.JLabel();
        TextField_UserName = new javax.swing.JTextField();
        Label_UserName = new javax.swing.JLabel();
        Label_Password = new javax.swing.JLabel();
        TextField_Password = new javax.swing.JPasswordField();
        Button_Login = new javax.swing.JButton();
        Label_Register = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN FORM");
        setResizable(false);

        Panel_LoginForm.setBackground(new java.awt.Color(255, 255, 255));
        Panel_LoginForm.setMinimumSize(new java.awt.Dimension(785, 578));
        Panel_LoginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        Logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 168, 252));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BuffetGO");
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        Panel_LoginForm.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 578));

        Label_Login.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        Label_Login.setForeground(new java.awt.Color(102, 102, 102));
        Label_Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Login.setText("Login");
        Panel_LoginForm.add(Label_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 115, 68));

        TextField_UserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Panel_LoginForm.add(TextField_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 205, 309, 42));

        Label_UserName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_UserName.setForeground(new java.awt.Color(102, 102, 102));
        Label_UserName.setText("User name");
        Panel_LoginForm.add(Label_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 176, 99, -1));

        Label_Password.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Password.setForeground(new java.awt.Color(102, 102, 102));
        Label_Password.setText("Password");
        Panel_LoginForm.add(Label_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 296, 99, -1));

        TextField_Password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_LoginForm.add(TextField_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 325, 309, 42));

        Button_Login.setBackground(new java.awt.Color(120, 168, 252));
        Button_Login.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Button_Login.setForeground(new java.awt.Color(240, 240, 240));
        Button_Login.setText("Sign In");
        Button_Login.setBorder(null);
        Button_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_LoginMouseClicked(evt);
            }
        });
        Panel_LoginForm.add(Button_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 86, 40));

        Label_Register.setForeground(new java.awt.Color(120, 168, 252));
        Label_Register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Register.setText("Don't have an account?");
        Label_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_RegisterMouseClicked(evt);
            }
        });
        Panel_LoginForm.add(Label_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 242, 31));

        Error.setForeground(new java.awt.Color(255, 0, 51));
        Error.setText("The username or password is incorrect.");
        Panel_LoginForm.add(Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_LoginMouseClicked
        String queryNV = "SELECT * FROM NHANVIEN "
                    + "WHERE TAIKHOAN = ? AND MATKHAU = ?";
        String queryKH = "SELECT * FROM KHACHHANG "
                    + "WHERE TAIKHOAN = ? AND MATKHAU = ?";
        String ChucVu = null;
              
        String TK = TextField_UserName.getText();
        String MK = TextField_Password.getText();
        boolean isLogin = false;
        
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(queryNV);
            p_statement.setString(1, TK);
            p_statement.setString(2, MK);
            
            ResultSet rs = p_statement.executeQuery();
            isLogin = rs.next();
            if (isLogin) {
                ManagerHome.MaNV = rs.getString("MANV");
                EmployeeHome.MaNV = rs.getString("MANV");
                ChucVu = rs.getString("CHUCVU");
                System.out.println(rs.getString("NGVL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (isLogin) {
                if (ChucVu.equals("Quản lý"))
                    mh.setVisible(true);
                if (ChucVu.equals("Nhân viên"))
                    eh.setVisible(true);
                dispose();
            }
        }
        
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(queryKH);
            p_statement.setString(1, TK);
            p_statement.setString(2, MK);
            
            ResultSet rs = p_statement.executeQuery();
            isLogin = rs.next();
            if (isLogin) {
                ch = new CustomerHome(rs.getString("MAKH"));
                CustomerHome.Point = rs.getInt("DIEMTL");
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                TaiKhoan.data = new Object[] {rs.getString("HOTEN"), rs.getString("GIOITINH"), format.format(rs.getDate("NGSINH")), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("MAGIOITHIEU")};
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {    
            if (isLogin) {
                ch.setVisible(true);
                dispose();
            }
        }
        
        setBorder();
        Error.setVisible(true);
    }//GEN-LAST:event_Button_LoginMouseClicked

    private void Label_RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_RegisterMouseClicked
        DangKyForm form = new DangKyForm();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_Label_RegisterMouseClicked

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
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapForm().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Login;
    private javax.swing.JLabel Error;
    private javax.swing.JLabel Label_Login;
    private javax.swing.JLabel Label_Password;
    private javax.swing.JLabel Label_Register;
    private javax.swing.JLabel Label_UserName;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Panel_LoginForm;
    private javax.swing.JPasswordField TextField_Password;
    private javax.swing.JTextField TextField_UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
