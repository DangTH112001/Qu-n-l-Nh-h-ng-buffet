/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
//import static DBObject.SQLTable.connection;
import MainView.ManagerHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class GiamGiaController {
    public static Connection connection;
    
    public static void update(Object[] data, int RowID) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "update GIAMGIA "
                        + "set TENGG = ?, PHANTRAM = ?, LOAIKH = ?, NGBD = ?, NGKT = ?, TINHTRANG = ?"
                        + "where MAGG = ?";
        try {
            connection = DriverManager.getConnection(SQLTable.URL, SQLTable.UserName, SQLTable.Password);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            
            p_statement.setString(1, (String) data[1]);
            p_statement.setInt(2, Integer.parseInt((String) data[2]));
            p_statement.setInt(3, Integer.parseInt((String) data[3]));
            p_statement.setDate(4, new java.sql.Date((format.parse((String) data[4])).getTime()));
            p_statement.setDate(5, new java.sql.Date((format.parse((String) data[5])).getTime()));
            p_statement.setInt(6, Integer.parseInt((String) data[6]));
            p_statement.setString(7, (String) data[0]);
            
            p_statement.executeUpdate();
            
            /*if (ManagerHome.MaNV.equals("NV03")) {
                TimeUnit.SECONDS.sleep(10);
            }
            else {
                connection.commit();
            }*/
            connection.commit();
            ManagerHome.set_Table("GIAMGIA");
    }
    catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
}
    public static void add(Object[] data) {   
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String query = "insert into GIAMGIA values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, (String) data[0]);
            p_statement.setString(2, (String) data[1]);
            p_statement.setInt(3, Integer.parseInt((String) data[2]));
            p_statement.setInt(4, Integer.parseInt((String) data[3]));
            p_statement.setDate(5, new java.sql.Date((format.parse((String) data[4])).getTime()));
            p_statement.setDate(6, new java.sql.Date((format.parse((String) data[5])).getTime()));
            p_statement.setInt(7, Integer.parseInt((String) data[6]));
            
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add complete");
            ManagerHome.set_Table("GIAMGIA");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void delete(String ID) {
        try {
            String query = "delete from GIAMGIA where MAGG = ?";
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, ID);
            p_statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete complete");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
