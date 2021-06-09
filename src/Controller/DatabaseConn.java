/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DangT
 */
public class DatabaseConn {
    public static Connection connection;
    public final String URL = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
    public final String UserName = "BuffetGO";
    public final String Password = "123";
    
    public DatabaseConn() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, UserName, Password);  
    }
}
