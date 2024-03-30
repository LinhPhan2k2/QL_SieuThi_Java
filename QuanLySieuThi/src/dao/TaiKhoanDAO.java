/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.NhanVien;
import pojo.TaiKhoan;

/**
 *
 * @author LinhPTA-PC
 */
public class TaiKhoanDAO {
    
    public static ArrayList<TaiKhoan> layDSTaiKhoan()
    {
        ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan tk, NhanVien nv where tk.manv = nv.manv";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaNV(resultSet.getInt("MANV"));
                tk.setTenDN(resultSet.getString("TENDN"));
                tk.setMatKhau(resultSet.getString("MATKHAU"));
                tk.setQuyen(resultSet.getString("QUYEN"));
                tk.setTenNV(resultSet.getString("TENNV"));
                dsTK.add(tk);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTK;
    }
     
    public static boolean themTK(TaiKhoan tk)
    {

        boolean kq = false;
        String sql = String.format("insert into TAIKHOAN(TENDN, MATKHAU) values ('%s','%s')",tk.getTenDN(),tk.getMatKhau());
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        int n = ketnoi.excuteUpdate(sql);
        if (n == 1)
        {
            kq = true;
        }
        ketnoi.close();
        return kq;
                
    }
    
    public static boolean xoaTK(String tendn)
    {
        boolean kq = false;
        String sql = String.format("delete from TaiKhoan where TENDN='%s'", tendn);
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        int n = ketnoi.excuteUpdate(sql);
        if (n == 1)
        {
            kq = true;
        }
        ketnoi.close();
        return kq; 
    }
    
    public static boolean KT_TaiKhoan_tenDN(String tendn)
    {   
         try {
             boolean kq = false;
             String sql = String.format("select * from TAIKHOAN where TENDN = '%s'", tendn.trim());
             KetNoi ketnoi = new KetNoi();
             ketnoi.open();
             ResultSet resultSet = ketnoi.excuteQuery(sql);
             if (resultSet.next())
             {
                 return true;
             }
             else
             {
                 return false;
             }
            } catch (SQLException ex) {
             Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
     public static boolean KT_TaiKhoan_MK(String mk)
    {   
         try {
             boolean kq = false;
             String sql = String.format("select * from TAIKHOAN where MATKHAU = '%s'", mk.trim());
             KetNoi ketnoi = new KetNoi();
             ketnoi.open();
             ResultSet resultSet = ketnoi.excuteQuery(sql);
             if (resultSet.next())
             {
                 return true;
             }
             else
             {
                 return false;
             }
            } catch (SQLException ex) {
             Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
    
    
}
