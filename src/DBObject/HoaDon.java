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
public class HoaDon {
    public static String ColumnName[] = {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã vé", "Mã giảm giá", "Tổng tiền", "Ngày hóa đơn"};
    String MaHD;
    String MaNV;
    String MaKH;
    String MaVe;
    String MaGG;
    int TongTien;
    String NgHD;

    public HoaDon(String MaHD, String MaNV, String MaKH, String MaVe, String MaGG, int TongTien, String NgHD) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaVe = MaVe;
        this.MaGG = MaGG;
        this.TongTien = TongTien;
        this.NgHD = NgHD;
    }

    
    
    public HoaDon(ResultSet rs) {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.MaHD = rs.getString("MAHD");
            this.MaNV = rs.getString("MANV");
            this.MaKH = rs.getString("MAKH");
            this.MaVe = rs.getString("MAVE");
            this.MaGG = rs.getString("MAGG");
            if (rs.getDate("NGHD") != null)
                this.NgHD = format.format(rs.getDate("NGHD"));
            else
                this.NgHD = "";
            this.TongTien = rs.getInt("TONGTIEN");
        } catch (SQLException ex) {
            Logger.getLogger(GiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public HoaDon() {
    }

    
    
    public Object[] get_Properties() {
        return new Object[] {MaHD, MaNV, MaKH, MaVe, MaGG, TongTien, NgHD};
    }
}
