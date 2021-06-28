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
public class GiamGia {
    public static String ColumnName[] = {"Mã giảm giá", "Tên giảm giá", "Phần trăm", "Loại khách hàng", "Ngày bắt đầu", "Ngày kết thúc", "Tình trạng"};
    String MAGG;
    String TENGG;
    int PHANTRAM;
    int LOAIKH;
    String NGBD;
    String NGKT;
    int TINHTRANG;

    public GiamGia(String MAGG, String TENGG, int PHANTRAM, int LOAIKH, String NGBD, String NGKT, int TINHTRANG) {
        this.MAGG = MAGG;
        this.TENGG = TENGG;
        this.PHANTRAM = PHANTRAM;
        this.LOAIKH = LOAIKH;
        this.NGBD = NGBD;
        this.NGKT = NGKT;
        this.TINHTRANG = TINHTRANG;
    }
    
    public GiamGia(ResultSet rs) {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.MAGG = rs.getString("MAGG");
            this.TENGG = rs.getString("TENGG");
            this.PHANTRAM = rs.getInt("PHANTRAM");
            this.LOAIKH = rs.getInt("LOAIKH");
            if (rs.getDate("NGBD") != null)
                this.NGBD = format.format(rs.getDate("NGBD"));
            else 
                this.NGBD = "";
            if (rs.getDate("NGKT") != null)
                this.NGKT = format.format(rs.getDate("NGKT"));
            else
                this.NGKT = "";
            this.TINHTRANG = rs.getInt("TINHTRANG");
        } catch (SQLException ex) {
            Logger.getLogger(GiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public GiamGia() {
    }

    
    
    public Object[] get_Properties() {
        return new Object[] {MAGG, TENGG, PHANTRAM, LOAIKH, NGBD, NGKT, TINHTRANG};
    }
}
