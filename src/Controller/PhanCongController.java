/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DangT
 */
public class PhanCongController {
    public static boolean check(String MaNV) {
        String query = "SELECT * FROM PHANCONG WHERE MANV = ? AND TO_CHAR(NGLAM, 'dd/mm/yyyy') = TO_CHAR(SYSDATE, 'dd/mm/yyyy')";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(1, MaNV);
            
            ResultSet rs = p_statement.executeQuery();
            if (rs.next()) 
                return false;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return true;
    }
    
    public static void add(String MaNV) {
        // Lấy ca
        String MaCa = null;
        Date date = new Date();
        String query = "SELECT MACA FROM CA WHERE TO_NUM(TGBD) > TO_NUM(SYSDATE) AND TO_NUM(SYSDATE) < TO_NUM(TGKT)";
        
        try {
            Statement statement = SQLTable.connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) 
                MaCa = rs.getString("MACA");
                   
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        // Thêm
        query = "insert into PHANCONG values (?, ?, ?)";
        
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            p_statement.setString(2, MaNV);
            p_statement.setString(1, MaCa);
            p_statement.setDate(3, new java.sql.Date(date.getTime()));
            
            p_statement.executeUpdate();
            
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
