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
import pojo.HangHoa;
import pojo.KhachHang;

/**
 *
 * @author admin
 */
public class KhachHangDAO {
     public static ArrayList<KhachHang> layDSKH()
    {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "select * from khachhang";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                KhachHang kh = new KhachHang();
                kh.setMaKh(resultSet.getInt("makh"));               
                kh.setTenKh(resultSet.getString("tenkh"));  
                kh.setDiaChi(resultSet.getString("diachi"));  
                kh.setSoDT(resultSet.getString("sodt"));                     
                kh.setDiem(resultSet.getInt("DIEM"));                                  
                dskh.add(kh);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dskh;
    }
        public static  boolean themKH(KhachHang kh)
    {
        boolean kq = false;
        String sql = String.format("insert into khachhang values (N'%s', N'%s',N'%s',%d)",kh.getTenKh(),kh.getDiaChi(),kh.getSoDT(),kh.getDiem());
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
    public static  boolean suaKH(KhachHang kh)
    {
        boolean kq = false;
        String sql = String.format("update KhachHang set tenKH=N'"+kh.getTenKh()+"' ,diachi=N'"+kh.getDiaChi()+"',SODT=N'"+ kh.getSoDT()+"' where makh= "+kh.getMaKh()+"");
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
     public static  ArrayList<KhachHang> layKHCoThe(String sdt)
    {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        String sql="select * from KHACHHANG where sodt='"+sdt+"'";
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        ResultSet resultSet= ketnoi.excuteQuery(sql);
         try {
             while(resultSet.next())
             {
                 KhachHang kh = new KhachHang();
                 kh.setMaKh(resultSet.getInt("makh"));
                 kh.setTenKh(resultSet.getString("tenkh"));
                 kh.setDiaChi(resultSet.getString("diachi"));
                 kh.setSoDT(resultSet.getString("sodt"));
                 kh.setDiem(resultSet.getInt("DIEM"));
                 dskh.add(kh);
             }
         } catch (SQLException ex) {
             Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        ketnoi.close();  
        return dskh;
    }
    
       public static boolean kiemtraSDT(String sdt)
    {
        boolean kt=true;      
        String sql="select * from KHACHHANG where sodt='"+sdt+"'";
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        String  soDT="";
        ResultSet resultSet= ketnoi.excuteQuery(sql);
         try {
             while(resultSet.next())
             {                 
                 soDT=resultSet.getString("soDT");  
                 System.out.println(soDT);
             }
         } catch (SQLException ex) {
             Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        if(soDT.isEmpty())
        {
            kt=false;
            System.out.println("ko có");
        }         
        ketnoi.close();  
        return kt;
    }             
}
