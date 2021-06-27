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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class ComboController {
    public static void update(Object[] data, int RowID) {
        String query = "update COMBO "
                        + "set TENCB = ?, GIA = ?, SONGUOI = ?"
                        + "where MACB = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[1]);
            p_statement.setInt(2, Integer.parseInt((String) data[2]));
            p_statement.setInt(3, Integer.parseInt((String) data[3]));
            p_statement.setString(4, (String) data[0]);

            p_statement.executeUpdate();
            
            ManagerHome.update(data, RowID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void add(Object[] data) {    
        String query = "insert into COMBO values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setInt(3, Integer.parseInt((String) data[2]));
            p_statement.setInt(4, Integer.parseInt((String) data[3]));

            p_statement.executeUpdate();
            ManagerHome.update(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from COMBO where MACB = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComboController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
