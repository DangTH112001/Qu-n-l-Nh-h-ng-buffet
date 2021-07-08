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
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class BanController {
    public static void update(Object[] data) {
        String query = "update BAN "
                        + "set LOAIBAN = ?, SONGUOI = ?"
                        + "where MABAN = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[1]);
            p_statement.setInt(2, Integer.parseInt((String) data[2]));
            p_statement.setString(3, (String) data[0]);

            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update complete");
            ManagerHome.set_Table("BAN");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {    
        String query = "insert into BAN values (?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setInt(3, Integer.parseInt((String) data[2]));
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.set_Table("BAN");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from BAN where MABAN = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
