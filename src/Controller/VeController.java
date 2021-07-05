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
public class VeController {
    public static void update(Object[] data, int RowID) {
        DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat tformat = new SimpleDateFormat("HH:mm:ss");
        String query = "update VE "
                        + "set MABAN = ?, MAKH = ?, NGAN = ?, NGDV = ?, TONGCB = ?, TONGMK = ?, TGBD = ?, TGKT = ?"
                        + "where MAVE = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[1]);
            p_statement.setString(2, (String) data[2]);
            p_statement.setDate(3, new java.sql.Date((dformat.parse((String) data[3])).getTime()));
            p_statement.setDate(4, new java.sql.Date((dformat.parse((String) data[4])).getTime()));
            p_statement.setInt(5, Integer.parseInt((String) data[5]));
            p_statement.setInt(6, Integer.parseInt((String) data[6]));
            p_statement.setDate(7, new java.sql.Date((tformat.parse((String) data[7])).getTime()));
            p_statement.setDate(8, new java.sql.Date((tformat.parse((String) data[8])).getTime()));
            p_statement.setString(9, (String) data[0]);
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update complete");
            ManagerHome.set_Table("VE");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {   
        DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat tformat = new SimpleDateFormat("HH:mm:ss");
        String query = "insert into VE values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setString(3, (String) data[2]);
            p_statement.setDate(4, new java.sql.Date((dformat.parse((String) data[3])).getTime()));
            p_statement.setDate(5, new java.sql.Date((dformat.parse((String) data[4])).getTime()));
            p_statement.setInt(6, Integer.parseInt((String) data[5]));
            p_statement.setInt(7, Integer.parseInt((String) data[6]));
            p_statement.setDate(8, new java.sql.Date((tformat.parse((String) data[7])).getTime()));
            p_statement.setDate(9, new java.sql.Date((tformat.parse((String) data[8])).getTime()));
           
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.set_Table("VE");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from VE where MAVE = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
