/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import MainView.CustomerHome;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class DoiController {
    public static void add(Object[] data) {    
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String query = "insert into DOI values (?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setDate(3, new java.sql.Date((format.parse((String) data[2])).getTime()));
            p_statement.setInt(4, Integer.parseInt((String) data[3]));
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            CustomerHome.isOK = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            CustomerHome.isOK = false;
        }
    }
}
