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
public class NhanVienController {
    public static void update(Object[] data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "update NHANVIEN "
                        + "set MAQUANLY = ?, HOTEN = ?, GIOITINH = ?, DIACHI = ?, CHUCVU = ?, SDT = ?, LUONG = ?, NGSINH = ?, TAIKHOAN = ?, MATKHAU = ?"
                        + "where MANV = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[1]);
            p_statement.setString(2, (String) data[2]);
            p_statement.setString(3, (String) data[3]);
            p_statement.setString(4, (String) data[5]);
            p_statement.setString(5, (String) data[6]);
            p_statement.setString(6, (String) data[7]);
            p_statement.setInt(7, Integer.parseInt((String) data[8]));
            p_statement.setDate(8, new java.sql.Date((format.parse((String) data[9])).getTime()));
            p_statement.setString(9, (String) data[10]);
            p_statement.setString(10, (String) data[11]);
            p_statement.setString(11, (String) data[0]);

            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update complete");
            ManagerHome.set_Table("NHANVIEN");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {   
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "insert into NHANVIEN values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setString(3, (String) data[2]);
            p_statement.setString(4, (String) data[3]);
            p_statement.setDate(5, new java.sql.Date((format.parse((String) data[4])).getTime()));
            p_statement.setString(6, (String) data[5]);
            p_statement.setString(7, (String) data[6]);
            p_statement.setString(8, (String) data[7]);
            p_statement.setInt(9, Integer.parseInt((String) data[8]));
            p_statement.setDate(10, new java.sql.Date((format.parse((String) data[9])).getTime()));
            p_statement.setString(11, (String) data[10]);
            p_statement.setString(12, (String) data[11]);
           
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.set_Table("NHANVIEN");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from NHANVIEN where MANV = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
