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
public class Customer {
    public static String ColumnName[] = {"Mã KH", "Họ và tên", "Giới tính", "Ngày sinh", "Loại khách hàng", "SĐT", "Địa chỉ", "Ngày đăng ký", "Tài khoản", "Mật khẩu", "Mã giới thiệu", "Điểm tích lũy"};
    String Cus_ID;
    String Cus_Name;
    String Cus_Gender; 
    String Cus_Type;
    String Cus_Phone;
    String Cus_Address;
    String Cus_Ngsinh;
    String Cus_NgDK;
    String Cus_TK;
    String Cus_MK;
    String MAGT;
    int Point;

    public Customer(String Cus_ID, String Cus_Name, String Cus_Gender, String Cus_Type, String Cus_Phone, String Cus_Address, String Cus_Ngsinh, String Cus_NgDK, String Cus_TK, String Cus_MK, String MAGT, int Point) {
        this.Cus_ID = Cus_ID;
        this.Cus_Name = Cus_Name;
        this.Cus_Gender = Cus_Gender;
        this.Cus_Type = Cus_Type;
        this.Cus_Phone = Cus_Phone;
        this.Cus_Address = Cus_Address;
        this.Cus_Ngsinh = Cus_Ngsinh;
        this.Cus_NgDK = Cus_NgDK;
        this.Cus_TK = Cus_TK;
        this.Cus_MK = Cus_MK;
        this.MAGT = MAGT;
        this.Point = Point;
    }

    

    public Customer() {
    }
    
    
    public Customer(ResultSet rs) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.Cus_ID = rs.getString("MAKH");
            this.Cus_Name = rs.getString("HOTEN");
            this.Cus_Gender = rs.getString("GIOITINH");
            this.Cus_Type = rs.getString("LOAIKH");
            this.Cus_Phone = rs.getString("SDT");
            this.Cus_Address = rs.getString("DIACHI");
            this.Cus_Ngsinh = format.format(rs.getDate("NGSINH"));
            this.Cus_NgDK = format.format(rs.getDate("NGDK"));
            this.Cus_TK = rs.getString("TAIKHOAN");
            this.Cus_MK = rs.getString("MATKHAU");
            this.MAGT = rs.getString("MAGIOITHIEU");
            this.Point = rs.getInt("DIEMTL");
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Object[] get_Properties() {
        return new Object[] {Cus_ID, Cus_Name, Cus_Gender, Cus_Ngsinh, Cus_Type, Cus_Phone, Cus_Address , Cus_NgDK, Cus_TK, Cus_MK, MAGT, Point};
    }
}
