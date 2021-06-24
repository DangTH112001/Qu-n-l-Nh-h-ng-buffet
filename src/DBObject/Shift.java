/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class Shift {
    public static String ColumnName[] = {"Mã ca", "Thời gian bắt đầu", "Thời gian kết thúc", "Loại ca"};

    String MACA;
    String TGBD;
    String TGKT;
    String LOAICA;

    public Shift() {
    }

    public Shift(String MACA, String TGBD, String TGKT, String LOAICA) {
        this.MACA = MACA;
        this.TGBD = TGBD;
        this.TGKT = TGKT;
        this.LOAICA = LOAICA;
    }
    
    public Shift(ResultSet rs) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            this.MACA = rs.getString("MACA");
            this.TGBD = format.format(rs.getTime("TGBD"));
            this.TGKT = format.format(rs.getTime("TGKT"));
            this.LOAICA = rs.getString("LOAICA");
        } catch (SQLException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public Object[] get_Properties() {
        return new Object[] {MACA, TGBD, TGKT, LOAICA};
    }
    
}
