/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JDB_KetNoi {
    
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
//    String strServer = "A210PC26";
//    String strDatabase = "dbKhachHang";
//    String strUser = "sa";
//    String strPass = "123";
    
    String strServer = "MSI\\SQLEXPRESS";
    String strDatabase = "QL_SIEUTHI";
    String strUser = "sa";
    String strPass = "123";
    
    public JDB_KetNoi(){
        KetNoi();
    }
    
    public void KetNoi()
    {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDB_KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectURL = "jdbc:sqlserver://" + strServer
                               + ":1433;databaseName=" + strDatabase
                               + ";user =" + strUser + "; password= " + strPass;
        //jdbc:sqlserver://LAPTOP-DAC11E8M\SQLEXPRESS:1433;databaseName=dbKhachHang
        //String connectURL = "jdbc:sqlserver://LAPTOP-DAC11E8M\\SQLEXPRESS:1433;databaseName=dbKhachHang";
        
        try {
            connection = DriverManager.getConnection(connectURL);
            if (connection != null)
            {
                System.out.println("Ket noi thanh cong");
            }
            else
            {
                System.out.println("Khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDB_KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new JDB_KetNoi();
    }
        
    
}
