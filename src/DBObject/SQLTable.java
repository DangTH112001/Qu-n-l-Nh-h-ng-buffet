/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBObject;

import Form.ComboForm;
import MainView.ManagerHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangT
 */
public class SQLTable {
    public static Connection connection;
    private static String URL = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
    private static String UserName = "BuffetGO";
    private static String Password = "123";

    public SQLTable() {
        getConn();
    }
    private static void getConn() {
        try {
            connection = DriverManager.getConnection(URL, UserName, Password);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int getLength(String TableName) {
        int res = 0;
        
        switch (TableName) {
            case "NHANVIEN" : res = NhanVien.ColumnName.length; break;
            case "COMBO" : res = Combo.ColumnName.length; break;
            case "MONKHAC" : res = MonKhac.ColumnName.length; break;
            case "QUA" : res = Qua.ColumnName.length; break;
            case "VE" : res = Ve.ColumnName.length; break;
            case "GIAMGIA" : res = GiamGia.ColumnName.length; break;
            case "KHACHHANG" : res = KhachHang.ColumnName.length; break;
            case "CA" : res = Ca.ColumnName.length; break;
            case "HOADON": res = HoaDon.ColumnName.length; break;
            case "DOI" : res = Doi.ColumnName.length; break;
            default: break;
        }
        
        return res;
    }  
    public static int getSize(String TableName) {
        int size = 0;
        String query = "select count(*) from " + TableName;
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                size = rs.getInt(1);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        return size;
    }  
    public static Object[] getProperties(String TableName, ResultSet rs) {
        Object[] res = null;
        
        switch (TableName) {
            case "NHANVIEN" : {
                NhanVien emp = new NhanVien(rs);
                res = emp.get_Properties();
                break;
            }
            case "COMBO" : {
                Combo cb = new Combo(rs);
                res = cb.get_Properties();
                break;
            }
            case "MONKHAC" : {
                MonKhac f = new MonKhac(rs);
                res = f.get_Properties();
                break;
            } 
            case "QUA" : {
                Qua g = new Qua(rs);
                res = g.get_Properties();
                break;
            }
            case "VE" : {
                Ve t = new Ve(rs);
                res = t.get_Properties();
                break;
            }
            case "GIAMGIA" : {
                GiamGia d = new GiamGia(rs);
                res = d.get_Properties();
                break;
            }
            case "KHACHHANG" : {
                KhachHang c = new KhachHang(rs);
                res = c.get_Properties();
                break;
            }
            case "CA" : {
                Ca s = new Ca(rs);
                res = s.get_Properties();
                break;
            }
            case "HOADON" : {
                HoaDon hd = new HoaDon(rs);
                res = hd.get_Properties();
                break;
            }
            case "DOI" : {
                Doi d = new Doi(rs);
                res = d.get_Properties();
                break;
            }
            default: break;
        }
        
        return res;
    }
    public static String[] ColumnName(String TableName) {
        String[] res = null;
        
        switch (TableName) {
            case "NHANVIEN" : {
                res = NhanVien.ColumnName;
                break;
            }
            case "COMBO" : {
                res = Combo.ColumnName;
                break;
            }
            case "MONKHAC" : {
                res = MonKhac.ColumnName;
                break;
            }
            case "QUA" : {
                res = Qua.ColumnName;
                break;
            }
            case "VE" :{
                res = Ve.ColumnName;
                break;
            }
            case "GIAMGIA" : {
                res = GiamGia.ColumnName;
                break;
            }
            case "KHACHHANG" : {
                res = KhachHang.ColumnName;
                break;
            }
            case "CA" : {
                res = Ca.ColumnName;
                break;
            }
            case "HOADON" : {
                res = HoaDon.ColumnName;
                break;
            }
            case "DOI" : {
                res = Doi.ColumnName;
                break;
            }
            default: break;
        }
        
        return res;
    }
    
    public static String getTableID(String TableName, String Prefix) {
        String res = Prefix;
        try {
            Statement statement = SQLTable.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SEQ_"+TableName+".NEXTVAL FROM dual");  
            while (rs.next()) {
                res += rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return res;
        }  
     }
}

