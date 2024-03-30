/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LinhPTA-PC
 */
public class KetNoi {
    private Connection connection = null;
    public void open()
    {
//        String strServer = "MSI\\SQLEXPRESS";
//        String strDatabase = "QL_SIEUTHI_GG";
//        String strUser = "sa";
//        String strPass = "123";
 
        String strServer = "LAPTOP-DAC11E8M\\SQLEXPRESS";
        String strDatabase = "QL_SIEUTHI_GG";
        String strUser = "sa";
        String strPass = "123QWEasd";
        
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String connectURL = "jdbc:sqlserver://" + strServer
                               + ":1433;databaseName=" + strDatabase
                               + ";user =" + strUser + "; password= " + strPass;
        try {
            
            connection = DriverManager.getConnection(connectURL);
            //preparedStatement = connection.prepareStatement(strUser)
            if (connection != null)
            {
                System.out.println("Ket noi thanh cong");
            }
            else
            {
                System.out.println("Khong thanh cong");
            }
        } catch (SQLException ex) {
                ex.printStackTrace();  
        }
    }
    
    public void close()
    {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet excuteQuery(String sql)
    {
        ResultSet resultSet = null;
        try {
            
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    
    public int excuteUpdate(String sql)
    {
        int n = -1;
        try {
           
            Statement statement = connection.createStatement();
            n=statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
