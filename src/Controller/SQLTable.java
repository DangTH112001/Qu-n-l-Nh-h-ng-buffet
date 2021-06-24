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
package Controller;

import MainView.Home;
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
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getLength(String TableName) {
        int res = 0;
        
        switch (TableName) {
            case "NHANVIEN" : res = Employee.ColumnName.length; break;
            case "COMBO" : res = Combo.ColumnName.length; break;
            case "MONKHAC" : res = Food.ColumnName.length; break;
            case "QUA" : res = Gift.ColumnName.length; break;
            case "VE" : res = Ticket.ColumnName.length; break;
            case "GIAMGIA" : res = Discount.ColumnName.length; break;
            case "KHACHHANG" : res = Customer.ColumnName.length; break;
            case "CA" : res = Shift.ColumnName.length; break;
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
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        return size;
    }
    
    public static Object[] getProperties(String TableName, ResultSet rs) {
        Object[] res = null;
        
        switch (TableName) {
            case "NHANVIEN" : {
                Employee emp = new Employee(rs);
                res = emp.get_Properties();
                break;
            }
            case "COMBO" : {
                Combo cb = new Combo(rs);
                res = cb.get_Properties();
                break;
            }
            case "MONKHAC" : {
                Food f = new Food(rs);
                res = f.get_Properties();
                break;
            } 
            case "QUA" : {
                Gift g = new Gift(rs);
                res = g.get_Properties();
                break;
            }
            case "VE" : {
                Ticket t = new Ticket(rs);
                res = t.get_Properties();
                break;
            }
            case "GIAMGIA" : {
                Discount d = new Discount(rs);
                res = d.get_Properties();
                break;
            }
            case "KHACHHANG" : {
                Customer c = new Customer(rs);
                res = c.get_Properties();
                break;
            }
            case "CA" : {
                Shift s = new Shift(rs);
                res = s.get_Properties();
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
                res = Employee.ColumnName;
                break;
            }
            case "COMBO" : {
                res = Combo.ColumnName;
                break;
            }
            case "MONKHAC" : {
                res = Food.ColumnName;
                break;
            }
            case "QUA" : {
                res = Gift.ColumnName;
                break;
            }
            case "VE" :{
                res = Ticket.ColumnName;
                break;
            }
            case "GIAMGIA" : {
                res = Discount.ColumnName;
                break;
            }
            case "KHACHHANG" : {
                res = Customer.ColumnName;
                break;
            }
            case "CA" : {
                res = Shift.ColumnName;
                break;
            }
            default: break;
        }
        
        return res;
    }
}

