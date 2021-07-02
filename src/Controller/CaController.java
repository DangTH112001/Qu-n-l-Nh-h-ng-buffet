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
public class CaController {  
    public static void update(Object[] data, int RowID) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String query = "update CA "
                        + "set TGBD = ?, TGKT = ?, LOAICA = ?"
                        + "where MACA = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            
            p_statement.setDate(1, new java.sql.Date((format.parse((String) data[1])).getTime()));
            p_statement.setDate(2, new java.sql.Date((format.parse((String) data[2])).getTime()));
            p_statement.setString(3, (String) data[3]);
            p_statement.setString(4, (String) data[0]);

            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update complete");
            ManagerHome.update(data, RowID);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    public static void add(Object[] data) {    
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String query = "insert into CA values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setDate(2, new java.sql.Date((format.parse((String) data[1])).getTime()));
            p_statement.setDate(3, new java.sql.Date((format.parse((String) data[2])).getTime()));
            p_statement.setString(4, (String) data[3]);
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.update(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from CA where MACA = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
