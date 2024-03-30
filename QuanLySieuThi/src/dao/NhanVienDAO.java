
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

/**
 *
 * @author LinhPTA-PC
 */
public class NhanVienDAO {
    
     public static ArrayList<NhanVien> layDSNhanVien()
    {
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        try {
            String sql = "select * from NhanVien nv, CHUCVU cv where nv.MACV = cv.MACV ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getInt("MANV"));
                nv.setMaCV(resultSet.getInt("MACV"));
                nv.setTenCV(resultSet.getString("TENCV"));
                nv.setTenDN(resultSet.getString("TENDN"));
                nv.setTenNV(resultSet.getString("TENNV"));
                nv.setgTinh(resultSet.getString("GTINH"));
                nv.setSdt(resultSet.getString("SODT"));
                
                dsNV.add(nv);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNV;
    }
     
    public static boolean themNV(NhanVien nv)
    {
        boolean kq = false;
        String sql = String.format("insert into NHANVIEN values (%d,'%s', N'%s', N'%s', '%s')",nv.getMaCV(), nv.getTenDN(), nv.getTenNV(), nv.getgTinh(), nv.getSdt());
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
    
    public static boolean suaNV(NhanVien nv)
    {
        boolean kq = false;
        String sql = String.format("update NhanVien set MACV="+nv.getMaCV()+", TENNV=N'"+nv.getTenNV()+"', GTINH=N'"+nv.getgTinh()+"', SODT='"+nv.getSdt()+"'  where MANV="+nv.getMaNV()+" ");
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
    public static String chuyenDoiTenDNThanhTenNV(String tendn)
    {
        String sql = String.format("select TENNV from NHANVIEN where TENDN=N'"+tendn+"'");
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        ResultSet resultSet =  ketnoi.excuteQuery(sql);
        String tenNV="";
         try {
             while(resultSet.next())
             {
                 tenNV=resultSet.getString("TENNV");
             }} catch (SQLException ex) {
             Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return tenNV;
    }
    public static int layMaNvTuTendn(String tendn) // lấy mã nhân viên
    {
        String sql = String.format("select MANV from NHANVIEN where TENDN='"+tendn+"'");
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        ResultSet resultSet =  ketnoi.excuteQuery(sql);
        int maNV=0;        
         try {
             while(resultSet.next())
             {
                 maNV=resultSet.getInt("MANV");
             }} catch (SQLException ex) {
             Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return maNV;
    }
    
    public static int KT_MaChucVu_TK(String tendn) {
        int cv = 0;
         try {
                boolean kq = false;
                String sql = String.format("select MACV from NhanVien where TENDN='%s'", tendn.trim());
                KetNoi ketnoi = new KetNoi();
                ketnoi.open();
                ResultSet resultSet = ketnoi.excuteQuery(sql);
                if (resultSet.next())
                {
                    //NhanVien nv = new NhanVien();
                    //nv.setMaCV(resultSet.getInt("MACV"));
                    cv = resultSet.getInt("MACV");
                    
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
         return cv;
    }
    
     public static boolean xoaNV(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from NhanVien where MANV=%d", ma);
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
     
    public static boolean KT_tenDN(String tendn) {
         try {
             boolean kq = false;
             String sql = String.format("select * from NhanVien where TENDN='%s'", tendn.trim());
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
             Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
         return false;         
    }
    
    
    
}
