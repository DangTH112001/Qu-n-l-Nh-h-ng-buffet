/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DBObject.Employee;
import DBObject.SQLTable;
import MainView.ManagerHome;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phan Hau
 */
public class NhanVienForm extends javax.swing.JFrame {
    private int TAG;
    private String ID;
    private int RowID;
    /**
     * Creates new form addEmployee
     */
    public NhanVienForm() {
        TAG = 1;
        initComponents();
    }
    
    public NhanVienForm(Object[] data, int RowID) {     
        TAG = 2;
        this.RowID = RowID;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        initComponents();
        
        ID = (String) data[0];
        tf_MaQuanLy.setText((String) data[1]);
        tf_HoTen.setText((String) data[2]);
        tf_DiaChi.setText((String) data[5]);
        tf_TaiKhoan.setText((String) data[10]);
        tf_ChucVu.setText((String) data[6]);
        tf_Luong.setText((String) data[8]);
        cb_GioiTinh.setSelectedItem((String) data[3]);
        try {
            dc_NGSINH.setDate(format.parse((String) data[9]));
            dc_NGBD.setDate(format.parse((String) data[4]));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_SDT.setText((String) data[7]);
        tf_MatKhau.setText((String) data[11]);
        dc_NGBD.enable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        NhanVienPanel = new javax.swing.JPanel();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        tf_DiaChi = new javax.swing.JTextField();
        tf_MaQuanLy = new javax.swing.JTextField();
        tf_HoTen = new javax.swing.JTextField();
        tf_TaiKhoan = new javax.swing.JTextField();
        tf_SDT = new javax.swing.JTextField();
        tf_ChucVu = new javax.swing.JTextField();
        tf_Luong = new javax.swing.JTextField();
        tf_MatKhau = new javax.swing.JTextField();
        lb_NhanVienTitle = new javax.swing.JLabel();
        lb_MaQuanLy = new javax.swing.JLabel();
        lb_HoTen = new javax.swing.JLabel();
        lb_GioiTinh = new javax.swing.JLabel();
        lb_DiaChi = new javax.swing.JLabel();
        lb_Luong = new javax.swing.JLabel();
        lb_SDT = new javax.swing.JLabel();
        lb_NGSINH = new javax.swing.JLabel();
        lb_ChucVu = new javax.swing.JLabel();
        lb_TaiKhoan = new javax.swing.JLabel();
        lb_MatKhau = new javax.swing.JLabel();
        lb_NGVL = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        dc_NGBD = new com.toedter.calendar.JDateChooser();
        dc_NGSINH = new com.toedter.calendar.JDateChooser();

        lbName.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(120, 168, 252));
        lbName.setText("FOOD NAME:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        NhanVienPanel.setBackground(new java.awt.Color(255, 255, 255));

        cb_GioiTinh.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cb_GioiTinh.setForeground(new java.awt.Color(120, 168, 252));
        cb_GioiTinh.setMaximumRowCount(2);
        cb_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cb_GioiTinh.setBorder(null);

        tf_DiaChi.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_DiaChi.setForeground(new java.awt.Color(120, 168, 252));
        tf_DiaChi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_DiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MaQuanLy.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MaQuanLy.setForeground(new java.awt.Color(120, 168, 252));
        tf_MaQuanLy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MaQuanLy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_HoTen.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_HoTen.setForeground(new java.awt.Color(120, 168, 252));
        tf_HoTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_HoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_TaiKhoan.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_TaiKhoan.setForeground(new java.awt.Color(120, 168, 252));
        tf_TaiKhoan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TaiKhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_SDT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_SDT.setForeground(new java.awt.Color(120, 168, 252));
        tf_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_SDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_ChucVu.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_ChucVu.setForeground(new java.awt.Color(120, 168, 252));
        tf_ChucVu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_ChucVu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_Luong.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_Luong.setForeground(new java.awt.Color(120, 168, 252));
        tf_Luong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Luong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        tf_MatKhau.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tf_MatKhau.setForeground(new java.awt.Color(120, 168, 252));
        tf_MatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_MatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(120, 168, 252)));

        lb_NhanVienTitle.setBackground(new java.awt.Color(255, 255, 255));
        lb_NhanVienTitle.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        lb_NhanVienTitle.setForeground(new java.awt.Color(120, 168, 252));
        lb_NhanVienTitle.setText("EMPLOYEE INFO");

        lb_MaQuanLy.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MaQuanLy.setForeground(new java.awt.Color(120, 168, 252));
        lb_MaQuanLy.setText("MANAGER ID:");

        lb_HoTen.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_HoTen.setForeground(new java.awt.Color(120, 168, 252));
        lb_HoTen.setText("FULL NAME:");

        lb_GioiTinh.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_GioiTinh.setForeground(new java.awt.Color(120, 168, 252));
        lb_GioiTinh.setText("GENDER:");

        lb_DiaChi.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_DiaChi.setForeground(new java.awt.Color(120, 168, 252));
        lb_DiaChi.setText("ADDRESS:");

        lb_Luong.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_Luong.setForeground(new java.awt.Color(120, 168, 252));
        lb_Luong.setText("SALARY: ");

        lb_SDT.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_SDT.setForeground(new java.awt.Color(120, 168, 252));
        lb_SDT.setText("PHONE:");

        lb_NGSINH.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGSINH.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGSINH.setText("BIRTHDAY:");

        lb_ChucVu.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_ChucVu.setForeground(new java.awt.Color(120, 168, 252));
        lb_ChucVu.setText("POSITION: ");

        lb_TaiKhoan.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_TaiKhoan.setForeground(new java.awt.Color(120, 168, 252));
        lb_TaiKhoan.setText("ACCOUNT:");

        lb_MatKhau.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_MatKhau.setForeground(new java.awt.Color(120, 168, 252));
        lb_MatKhau.setText("PASSWORD:");

        lb_NGVL.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lb_NGVL.setForeground(new java.awt.Color(120, 168, 252));
        lb_NGVL.setText("STARTING DATE:");

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

        javax.swing.GroupLayout NhanVienPanelLayout = new javax.swing.GroupLayout(NhanVienPanel);
        NhanVienPanel.setLayout(NhanVienPanelLayout);
        NhanVienPanelLayout.setHorizontalGroup(
            NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_MaQuanLy)
                            .addComponent(lb_HoTen)
                            .addComponent(lb_ChucVu)
                            .addComponent(lb_TaiKhoan)
                            .addComponent(lb_DiaChi)
                            .addComponent(lb_Luong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                .addComponent(tf_MaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_GioiTinh))
                            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                .addComponent(tf_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_NGVL))
                            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                .addComponent(tf_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_MatKhau))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhanVienPanelLayout.createSequentialGroup()
                                .addComponent(tf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_SDT))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhanVienPanelLayout.createSequentialGroup()
                                .addComponent(tf_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(lb_NGSINH))
                            .addComponent(tf_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dc_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dc_NGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(lb_NhanVienTitle)))
                .addGap(33, 33, 33))
        );
        NhanVienPanelLayout.setVerticalGroup(
            NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_NhanVienTitle)
                .addGap(18, 18, 18)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NhanVienPanelLayout.createSequentialGroup()
                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MaQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dc_NGSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_NGVL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dc_NGBD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(NhanVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NhanVienPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NhanVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMouseClicked
        if (TAG == 1) {
            add(evt);
        } 
        else if (TAG == 2) {
            update(evt);
        }
    }//GEN-LAST:event_btnConfirmMouseClicked
    
    private void update(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String ManagerID = tf_MaQuanLy.getText();
        String FullName = tf_HoTen.getText();
        String Address = tf_DiaChi.getText();
        String Account = tf_TaiKhoan.getText();
        String Position = tf_ChucVu.getText();
        int Salary = Integer.parseInt(tf_Luong.getText());
        String Gender = (String) cb_GioiTinh.getSelectedItem();
        String Birth = format.format(dc_NGSINH.getDate());
        String Phone = tf_SDT.getText();
        String Password = tf_MatKhau.getText();
        String query = "update NHANVIEN "
                        + "set MAQUANLY = ?, HOTEN = ?, GIOITINH = ?, DIACHI = ?, CHUCVU = ?, SDT = ?, LUONG = ?, NGSINH = ?, TAIKHOAN = ?, MATKHAU = ?"
                        + "where MANV = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ManagerID);
            p_statement.setString(2, FullName);
            p_statement.setString(3, Gender);
            p_statement.setString(4, Address);
            p_statement.setString(5, Position);
            p_statement.setString(6, Phone);
            p_statement.setInt(7, Salary);
            p_statement.setDate(8, new java.sql.Date(dc_NGSINH.getDate().getTime()));
            p_statement.setString(9, Account);
            p_statement.setString(10, Password);
            p_statement.setString(11, ID);

            p_statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            Object[] data = (new Employee(ID, ManagerID, FullName, Gender, format.format(dc_NGBD.getDate()), Address, Position, Phone, Salary, Birth, Account, Password)).get_Properties();
            ManagerHome.update(data, RowID);
            dispose();
        } 
        
                
    }
    
    private void add(java.awt.event.MouseEvent evt) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String ManagerID = tf_MaQuanLy.getText();
        String FullName = tf_HoTen.getText();
        String Address = tf_DiaChi.getText();
        String Account = tf_TaiKhoan.getText();
        String Position = tf_ChucVu.getText();
        int Salary = Integer.parseInt(tf_Luong.getText());
        String Gender = (String) cb_GioiTinh.getSelectedItem();
        String Birth = format.format(dc_NGSINH.getDate());
        String Start = format.format(dc_NGBD.getDate());
        String Phone = tf_SDT.getText();
        String Password = tf_MatKhau.getText();
        String ID = ManagerHome.getTableID();

        String query = "insert into NHANVIEN values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.setString(2, ManagerID);
            p_statement.setString(3, FullName);
            p_statement.setString(4, Gender);
            p_statement.setDate(5, new java.sql.Date(dc_NGBD.getDate().getTime()));
            p_statement.setString(6, Address);
            p_statement.setString(7, Position);
            p_statement.setString(8, Phone);
            p_statement.setInt(9, Salary);
            p_statement.setDate(10, new java.sql.Date(dc_NGSINH.getDate().getTime()));
            p_statement.setString(11, Account);
            p_statement.setString(12, Password);

            p_statement.executeUpdate();
            Object[] data = (new Employee(ID, ManagerID, FullName, Gender, format.format(dc_NGBD.getDate()), Address, Position, Phone, Salary, Birth, Account, Password)).get_Properties();
            ManagerHome.update(data);
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
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienForm().setVisible(true);
                new NhanVienForm().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NhanVienPanel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private com.toedter.calendar.JDateChooser dc_NGBD;
    private com.toedter.calendar.JDateChooser dc_NGSINH;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lb_ChucVu;
    private javax.swing.JLabel lb_DiaChi;
    private javax.swing.JLabel lb_GioiTinh;
    private javax.swing.JLabel lb_HoTen;
    private javax.swing.JLabel lb_Luong;
    private javax.swing.JLabel lb_MaQuanLy;
    private javax.swing.JLabel lb_MatKhau;
    private javax.swing.JLabel lb_NGSINH;
    private javax.swing.JLabel lb_NGVL;
    private javax.swing.JLabel lb_NhanVienTitle;
    private javax.swing.JLabel lb_SDT;
    private javax.swing.JLabel lb_TaiKhoan;
    private javax.swing.JTextField tf_ChucVu;
    private javax.swing.JTextField tf_DiaChi;
    private javax.swing.JTextField tf_HoTen;
    private javax.swing.JTextField tf_Luong;
    private javax.swing.JTextField tf_MaQuanLy;
    private javax.swing.JTextField tf_MatKhau;
    private javax.swing.JTextField tf_SDT;
    private javax.swing.JTextField tf_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
