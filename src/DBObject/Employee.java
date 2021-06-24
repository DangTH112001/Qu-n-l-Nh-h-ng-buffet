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
public class Employee {
    public static String ColumnName[] = {"Mã NV", "Mã QL", "Họ tên","Giới tính", "Ngày vào làm","Địa chỉ","Chức vụ","SĐT","Lương","Ngày sinh","Tài khoản","Mật khẩu"};
    String Emp_ID;
    String Boss_ID;
    String Emp_Name;
    String Emp_Sex; 
    String Start;
    String Emp_Address;
    String Emp_Position;
    String Emp_PhoneNumber;
    int Emp_Salary; 
    String Emp_Birth;
    String Emp_UserName;
    String Emp_Password;

    public Employee(String Emp_ID, String Boss_ID, String Emp_Name, String Emp_Sex, String Start, String Emp_Address, String Emp_Position, String Emp_PhoneNumber, int Emp_Salary, String Emp_Birth, String Emp_UserName, String Emp_Password) {
        this.Emp_ID = Emp_ID;
        this.Boss_ID = Boss_ID;
        this.Emp_Name = Emp_Name;
        this.Emp_Sex = Emp_Sex;
        this.Start = Start;
        this.Emp_Address = Emp_Address;
        this.Emp_Position = Emp_Position;
        this.Emp_PhoneNumber = Emp_PhoneNumber;
        this.Emp_Salary = Emp_Salary;
        this.Emp_Birth = Emp_Birth;
        this.Emp_UserName = Emp_UserName;
        this.Emp_Password = Emp_Password;
    }

    public Employee() {
    }
    
    
    public Employee(ResultSet rs) {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.Emp_ID = rs.getString("MANV");
            this.Boss_ID = rs.getString("MaQuanLy");
            this.Emp_Name = rs.getString("HOTEN");
            this.Emp_Sex = rs.getString("GIOITINH");
            this.Start = format.format(rs.getDate("NGVL"));
            this.Emp_Address = rs.getString("DIACHI");
            this.Emp_Position = rs.getString("CHUCVU");
            this.Emp_PhoneNumber = rs.getString("SDT");
            this.Emp_Salary = rs.getInt("LUONG");
            this.Emp_Birth = format.format(rs.getDate("NGSINH"));
            this.Emp_UserName = rs.getString("TAIKHOAN");
            this.Emp_Password = rs.getString("MATKHAU");
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] get_Properties() {
        return new Object[] {Emp_ID, Boss_ID, Emp_Name, Emp_Sex, Start, Emp_Address, Emp_Position, Emp_PhoneNumber, Emp_Salary, Emp_Birth, Emp_UserName, Emp_Password};
    }
}
