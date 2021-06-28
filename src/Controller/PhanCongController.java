/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBObject.SQLTable;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author DangT
 */
public class PhanCongController {
    public static boolean check(String MaNV) {
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        String query = "SELECT * FROM PHANCONG WHERE MANV = ? AND NGLAM = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
            
        }
        catch (Exception ex) {
            
        }
        return false;
    }
}
