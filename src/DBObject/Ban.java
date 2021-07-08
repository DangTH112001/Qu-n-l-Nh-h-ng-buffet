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
public class Ban {
    public static String ColumnName[] = {"Mã bàn", "Loại bàn", "Số người"};
    private String MaBan;
    private String LoaiBan;
    private int SoNguoi;

    public Ban(String MaBan, String LoaiBan, int SoNguoi) {
        this.MaBan = MaBan;
        this.LoaiBan = LoaiBan;
        this.SoNguoi = SoNguoi;
    }
    
    public Ban(ResultSet rs) {
        try {
            this.MaBan = rs.getString("MABAN");
            this.LoaiBan = rs.getString("LOAIBAN");
            this.SoNguoi = Integer.parseInt(rs.getString("SONGUOI"));
        }
        catch (SQLException ex) {
            Logger.getLogger(Combo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public Ban() {
    }
    
    public Object[] get_Properties() {
        return new Object[] {MaBan, LoaiBan, SoNguoi};
    }
}
