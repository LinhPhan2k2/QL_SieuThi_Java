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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JDB_HienThi {
    Scanner sc = new Scanner(System.in);
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
//    String strServer = "A210PC26";
//    String strDatabase = "dbKhachHang";
//    String strUser = "sa";
//    String strPass = "123";
    String strServer = "LAPTOP-DAC11E8M\\SQLEXPRESS";
    String strDatabase = "QL_SIEUTHI_2";
    String strUser = "sa";
    String strPass = "123QWEasd";
    public JDB_HienThi(){
        KetNoi();
        HienThi();
        ThemDuLieu();
        SuaDuLieu();
        XoaDuLieu();
    }
    
    public void KetNoi()
    {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectURL = "jdbc:sqlserver://" + strServer
                               + ":1433;databaseName=" + strDatabase
                               + ";user =" + strUser + "; password= " + strPass;
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
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new JDB_HienThi();
    }

    private void HienThi() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "Select * from KhachHang";
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                String ma = resultSet.getString("Makh");
                String ten = resultSet.getString("Tenkh");
                int nam = resultSet.getInt("namsinh");
                System.out.println("Ma khach hang: "+ma);
                System.out.println("Ten khach hang: "+ten);
                System.out.println("Nam sinh: "+nam);
                System.out.println("---------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ThemDuLieu() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String makh;
        System.out.println("Nhap ma kh can them: ");
        makh = sc.nextLine();
        String sql = "insert into KhachHang values ('"+ makh +"', 'Phan Thi Anh Linh', '2002', 'n2')";
        int x = 0;
        try {
            x = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (x >= 1)
        {
            System.out.println("Them khach hang thanh cong!!!");
        }
        else
        {
            System.out.println("That bai!!!");
        }
        
    }

    private void SuaDuLieu() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String makh;
        System.out.println("Nhap ma kh can cap nhat: ");
        makh = sc.nextLine();
        String sql = "update KhachHang set TenKH = 'Phan Thi Anh Linh' where MaKH = '"+ makh +"'";
        int x;
        try {
            x = statement.executeUpdate(sql);
            if (x >= 1)
            {
                System.out.println("Cap nhat thanh cong!!!");
            }
            else
            {
                System.out.println("Cap nhat that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void XoaDuLieu() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        String makh;
        System.out.println("Nhap ma kh can xoa: ");
        makh = sc.nextLine();
        String sql = "delete from KhachHang where MaKH='"+makh+"'";
        int x;
        try {
            x = statement.executeUpdate(sql);
            if (x >= 1)
            {
                System.out.println("Xoa thanh cong dong");
            }
            else
            {
                System.out.println("Xoa that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDB_HienThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        
    
}
