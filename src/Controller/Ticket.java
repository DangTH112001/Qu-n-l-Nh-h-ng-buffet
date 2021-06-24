/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class Ticket {
    public static String ColumnName[] = {"Mã vé", "Mã bàn","Mã khách hàng", "Ngày ăn","Ngày đặt vé","Tổng tiền combo","Tổng tiền món khác","Thời gian bắt đầu","Thời gian kết thúc"};

    
    String MAVE;
    String MABAN;
    String MAKH; 
    String NGAN;
    String NGDV;
    int TTCB;
    int TTMK;
    String TGBD; 
    String TGKT;
    
    public Ticket(String MAVE, String MABAN, String MAKH, String NGAN, String NGDV, int TTCB, int TTMK, String TGBD, String TGKT) {
        this.MAVE = MAVE;
        this.MABAN = MABAN;
        this.MAKH = MAKH;
        this.NGAN = NGAN;
        this.NGDV = NGDV;
        this.TTCB = TTCB;
        this.TTMK = TTMK;
        this.TGBD = TGBD;
        this.TGKT = TGKT;
    }
    
    public Ticket(ResultSet rs) {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
            this.MAVE = rs.getString("MAVE");
            this.MABAN = rs.getString("MABAN");
            this.MAKH = rs.getString("MAKH");
            this.NGAN = format.format(rs.getDate("NGAN"));
            this.NGDV = format.format(rs.getDate("NGDV"));
            this.TTCB = rs.getInt("TONGCB");
            this.TTMK = rs.getInt("TONGMK");
            format = new SimpleDateFormat("HH:mm:ss");  
            this.TGBD = format.format(rs.getDate("TGBD"));;
            this.TGKT = format.format(rs.getDate("TGKT"));;
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    public Ticket() {
    
    }
    
    
    public Object[] get_Properties() {
        return new Object[] {MAVE, MABAN, MAKH, NGAN, NGDV, TTCB, TTMK, TGBD, TGKT};
    }
}
