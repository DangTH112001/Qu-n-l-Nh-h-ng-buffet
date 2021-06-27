/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class Combo {
    public static String ColumnName[] = {"Mã combo", "Tên combo", "Giá", "Số lượng"};
    private String MaCB;
    private String TenCB;
    private int Gia;
    private int SoNguoi;
    
    public Combo(String MaCB, String TenCB, int Gia, int SoNguoi) {
        this.MaCB = MaCB;
        this.TenCB = TenCB;
        this.Gia = Gia;
        this.SoNguoi = SoNguoi;
    }
    
    public Combo(ResultSet rs) {
        try {
            this.MaCB = rs.getString("MACB");
            this.TenCB = rs.getString("TENCB");
            this.Gia = Integer.parseInt(rs.getString("GIA"));
            this.SoNguoi = Integer.parseInt(rs.getString("SONGUOI"));
        } catch (SQLException ex) {
            Logger.getLogger(Combo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Combo() {
    }
    
    public Object[] get_Properties() {
        return new Object[] {MaCB, TenCB, Gia, SoNguoi};
    }
}
