/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class Gift {
    public static String ColumnName[] = {"Mã quà", "Tên quà", "Điểm đổi thưởng"};
    String ID;
    String Name;
    int Point;

    public Gift() {
    }

    public Gift(String ID, String Name, int Point) {
        this.ID = ID;
        this.Name = Name;
        this.Point = Point;
    }

    public Gift(ResultSet rs) {
        try {
            this.ID = rs.getString("MAQUA");
            this.Name = rs.getString("TENQUA");
            this.Point = rs.getInt("DIEMDOI");
        } catch (SQLException ex) {
            Logger.getLogger(Gift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] get_Properties() {
        return new Object[] {ID, Name, Point};
    }
}
