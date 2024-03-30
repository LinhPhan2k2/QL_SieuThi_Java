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
import pojo.NhaCungCap;

/**
 *
 * @author LinhPTA-PC
 */
public class HangHoaDAO {
    public static ArrayList<HangHoa> layDSHangHoa()
    {
        ArrayList<HangHoa> dsHH = new ArrayList<HangHoa>();
        try {
            String sql = "select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH from HANGHOA, NHOMHANG where HANGHOA.MANH=NHOMHANG.MANH";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HangHoa hh = new HangHoa();
                hh.setMaHH(resultSet.getInt("MAHH"));               
                hh.setTenHH(resultSet.getString("TENHH"));
                hh.setDVT(resultSet.getString("DVT"));
                hh.setGiaban(resultSet.getInt("GIABAN"));
                hh.setSlton(resultSet.getInt("SLTON"));
                hh.setTENNH(resultSet.getString("TENNH"));
                
                dsHH.add(hh);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHH;
    }
           public static ArrayList<HangHoa> timKiemTheoTenHang(String tenHH)
    {
        ArrayList<HangHoa> dsHH = new ArrayList<HangHoa>();
        try {
            String sql = "select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH \n" +
            "from HANGHOA, NHOMHANG \n" +
            "where HANGHOA.MANH=NHOMHANG.MANH\n" +
            "and TENHH like N'"+tenHH+ "%' ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HangHoa hh = new HangHoa();
                hh.setMaHH(resultSet.getInt("MAHH"));               
                hh.setTenHH(resultSet.getString("TENHH"));
                hh.setDVT(resultSet.getString("DVT"));
                hh.setGiaban(resultSet.getInt("GIABAN"));
                hh.setSlton(resultSet.getInt("SLTON"));
                hh.setTENNH(resultSet.getString("TENNH"));                
                dsHH.add(hh);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHH;
    } 
       
    public static ArrayList<HangHoa> timKiemTheoMaHang(int maHH)
    {
        ArrayList<HangHoa> dsHH = new ArrayList<HangHoa>();
        try {
            String sql = "select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH \n" +
                    "from HANGHOA, NHOMHANG \n" +
                    "where HANGHOA.MANH=NHOMHANG.MANH\n" +
                    "and MAHH="+maHH+"";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HangHoa hh = new HangHoa();
                hh.setMaHH(resultSet.getInt("MAHH"));               
                hh.setTenHH(resultSet.getString("TENHH"));
                hh.setDVT(resultSet.getString("DVT"));
                hh.setGiaban(resultSet.getInt("GIABAN"));
                hh.setSlton(resultSet.getInt("SLTON"));
                hh.setTENNH(resultSet.getString("TENNH"));                
                dsHH.add(hh);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHH;
    } 
      
      public static ArrayList<HangHoa> timKiemTheoMaNH(int maNH)
    {
        ArrayList<HangHoa> dsHH = new ArrayList<HangHoa>();
        try {
            String sql = "select DISTINCT  MAHH , TENHH, DVT, GIABAN, SLTON, TENNH \n" +
                    "from HANGHOA, NHOMHANG \n" +
                    "where HANGHOA.MANH=NHOMHANG.MANH\n" +
                    "and NHOMHANG.MANH="+maNH+"";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HangHoa hh = new HangHoa();
                hh.setMaHH(resultSet.getInt("MAHH"));               
                hh.setTenHH(resultSet.getString("TENHH"));
                hh.setDVT(resultSet.getString("DVT"));
                hh.setGiaban(resultSet.getInt("GIABAN"));
                hh.setSlton(resultSet.getInt("SLTON"));
                hh.setTENNH(resultSet.getString("TENNH"));                
                dsHH.add(hh);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHH;
    } 
    
    
    public static ArrayList<String> layDSTenHH()
    {
        ArrayList<String> dsTenHH = new ArrayList<String>();
        try {
            String sql = "select TENHH from HANGHOA";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {       
                String a= resultSet.getString("TENHH");
                dsTenHH.add(a);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTenHH;
    }
    
    public static String layDSTenHH(int ma)
    {
        String a = null;
        //ArrayList<String> dsTenHH = new ArrayList<String>();
        try {
            String sql = "select TENHH from HANGHOA where mahh = "+ma+"";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {       
               a = resultSet.getString("TENHH");
                //dsTenHH.add(a);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    
    public static  ArrayList<String> layDSTenNH()
    {
        ArrayList<String> dsTenNH = new ArrayList<String>();
        try {
            String sql = "select TENNH from HANGHOA, NHOMHANG where HANGHOA.MAHH= NHOMHANG.MANH";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {       
                String a= resultSet.getString("TENNH");
                dsTenNH.add(a);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTenNH;
    }
 
     public static  ArrayList<String> layDSDVT()
    {
        ArrayList<String> dsdvt = new ArrayList<String>();
        try {
            String sql = "select DISTINCT  DVT from HANGHOA ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {       
                String a= resultSet.getString("DVT");
                dsdvt.add(a);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsdvt;
    }
    
    public static  boolean themHH(HangHoa hh)
    {
        boolean kq = false;
        String sql = String.format("insert into HANGHOA values (%d,N'%s', N'%s',%f,%d)",hh.getMaNH(),hh.getTenHH(),hh.getDVT(),hh.getGiaban(),hh.getSlton());
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
      public static  boolean suaHH(HangHoa hh)
    {
        boolean kq = false;
        String sql = String.format("update HANGHOA set TENHH=N'"+hh.getTenHH()+"' ,DVT=N'"+hh.getDVT()+"' ,MANH="+ hh.getMaNH()+", SLTON='"+hh.getSlton()+"', GIABAN="+hh.getGiaban()+" where MAHH= "+hh.getMaHH()+"");
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
    public static boolean xoaHH(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete hanghoa where MAHH="+ma+"");        
        KetNoi ketnoi = new KetNoi();
        ketnoi.open();
        try {
            
        } catch (Exception e) {
        }
        int n = ketnoi.excuteUpdate(sql);
        if (n == 1)
        {
            kq = true;
        }
        ketnoi.close();
        return kq;
    }   
    public static int chuyenDoiGia(int index)
    {
        
        String sql = String.format("select GIABAN from HANGHOA where MAHH= "+index+" ");  
        int giaban=0;
        KetNoi ketnoi = new KetNoi();
         ketnoi.open();
        ResultSet resultSet = ketnoi.excuteQuery(sql);
        try {
            while(resultSet.next())       
            {
                 giaban = resultSet.getInt("GIABAN");               
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ketnoi.close();
        return giaban;
    }
    
     
}
