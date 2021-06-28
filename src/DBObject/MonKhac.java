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
public class MonKhac {
    public static String ColumnName[] = {"Mã món khác", "Tên món khác", "Giá"};
    String MaMK;
    String TenMK;
    int Gia;

    public MonKhac() {
    }

    public MonKhac(String MaMK, String TenMK, int Gia) {
        this.MaMK = MaMK;
        this.TenMK = TenMK;
        this.Gia = Gia;
    }
    
    public MonKhac(ResultSet rs) {
        try {
            this.MaMK = rs.getString("MAMK");
            this.TenMK = rs.getString("TENMK");
            this.Gia = rs.getInt("GIA");
        } catch (SQLException ex) {
            Logger.getLogger(MonKhac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] get_Properties() {
        return new Object[] {MaMK, TenMK, Gia};
    }
}
