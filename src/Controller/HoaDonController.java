/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import MainView.EmployeeHome;
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
public class HoaDonController {
     public static void update(Object[] data, int RowID) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "update HOADON "
                        + "set MANV = ?, MAKH = ?, MAVE = ?, MAGG = ?, TONGTIEN = ?, NGHD = ?"
                        + "where MAHD = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[1]);
            p_statement.setString(2, (String) data[2]);
            p_statement.setString(3, (String) data[3]);
            p_statement.setString(4, (String) data[4]);
            p_statement.setInt(5, Integer.parseInt((String) data[5]));          
            p_statement.setDate(6, new java.sql.Date((format.parse((String) data[6])).getTime()));
            p_statement.setString(7, (String) data[0]);
            
            p_statement.executeUpdate();  
            JOptionPane.showMessageDialog(null, "Update complete");
            EmployeeHome.initTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {    
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "insert into HOADON values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setString(3, (String) data[2]);
            p_statement.setString(4, (String) data[3]);
            p_statement.setString(5, (String) data[4]);
            p_statement.setInt(6, Integer.parseInt((String) data[5]));          
            p_statement.setDate(7, new java.sql.Date((format.parse((String) data[6])).getTime()));
            

            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            EmployeeHome.initTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from HOADON where MAHD = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
