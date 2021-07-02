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
public class Doi {
    public static String[] ColumnName = {"Mã khách hàng", "Mã quà", "Ngày đổi quà", "Số lượng"};
    private String MaKH;
    private String MaQua;
    private String NgDoi;
    private int SoLuong;

    public Doi() {}
    
    public Doi(String MaKH, String MaQua, String NgDoi, int SoLuong) {
        this.MaKH = MaKH;
        this.MaQua = MaQua;
        this.NgDoi = NgDoi;
        this.SoLuong = SoLuong;
    }
    
    public Doi(ResultSet rs) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.MaKH = rs.getString("MAKH");
            this.MaQua = rs.getString("MAQUA");
            this.NgDoi = format.format(rs.getDate("NGDOIQUA"));
            this.SoLuong = rs.getInt("SOLUONG");
        } catch (SQLException ex) {
            Logger.getLogger(Combo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Object[] get_Properties() {
        return new Object[] {MaKH, MaQua, NgDoi, SoLuong};
    }
}
