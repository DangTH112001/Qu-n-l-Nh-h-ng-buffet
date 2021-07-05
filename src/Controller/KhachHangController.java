/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import MainView.ManagerHome;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class KhachHangController {
    public static void update(Object[] data, int RowID) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "update KHACHHANG "
                        + "set HOTEN = ?, GIOITINH = ?, NGSINH = ?, LOAIKH = ?, SDT = ?, DIACHI = ?, TAIKHOAN = ?, MATKHAU = ?, MAGIOITHIEU = ?, DIEMTL = ?"
                        + "where MAKH = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1,(String) data[1]);
            p_statement.setString(2, (String) data[2]);
            p_statement.setDate(3, new java.sql.Date((format.parse((String) data[3])).getTime()));
            p_statement.setInt(4, Integer.parseInt((String) data[4]));
            p_statement.setString(5, (String) data[5]);
            p_statement.setString(6, (String) data[6]);
            p_statement.setString(7, (String) data[8]);
            p_statement.setString(8, (String) data[9]);
            p_statement.setString(9, (String) data[10]);
            p_statement.setInt(10, Integer.parseInt((String) data[11]));
            p_statement.setString(11, (String) data[0]);

            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update complete");
            ManagerHome.set_Table("KHACHHANG");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {   
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "insert into KHACHHANG values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2,(String) data[1]);
            p_statement.setString(3, (String) data[2]);
            p_statement.setDate(4, new java.sql.Date((format.parse((String) data[3])).getTime()));
            p_statement.setInt(5, Integer.parseInt((String) data[4]));
            p_statement.setString(6, (String) data[5]);
            p_statement.setString(7, (String) data[6]);
            p_statement.setDate(8, new java.sql.Date((format.parse((String) data[7])).getTime()));
            p_statement.setString(9, (String) data[8]);
            p_statement.setString(10, (String) data[9]);
            p_statement.setString(11, (String) data[10]);
            p_statement.setInt(12, Integer.parseInt((String) data[11]));
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.set_Table("KHACHHANG");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from KHACHHANG where MAKH = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
