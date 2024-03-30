/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.CT_HoaDon;
import pojo.PhieuNhap;
import pojo.HoaDon;

/**
 *
 * @author admin
 */
public class dsHDDAO {

   public static ArrayList<HoaDon> layDSHD()
    {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        try {
            String sql = "select distinct MAHD, TENNV,NGAYBAN,TONGTIEN,HOADON.MAKH\n" +
"from HOADON, NHANVIEN, KHACHHANG\n" +
" WHERE NHANVIEN.MANV=HOADON.MANV ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHD(resultSet.getInt("MAHD"));
                hd.setTenNV(resultSet.getString("TENNV"));                    
                hd.setNgayBan(resultSet.getString("NGAYBAN"));
                hd.setTongTien(resultSet.getDouble("TONGTIEN"));
                hd.setTenKH(resultSet.getString("MAKH"));                                        
                dsHD.add(hd);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHD;
    }
   
    public static ArrayList<HoaDon> timHD(int maHD)
    {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        try {
            String sql = "select distinct MAHD, TENNV,NGAYBAN,TONGTIEN,HOADON.MAKH\n" +
"from HOADON, NHANVIEN, KHACHHANG\n" +
"WHERE NHANVIEN.MANV=HOADON.MANV and maHD="+maHD+" ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                HoaDon hd = new HoaDon();
                hd.setMaHD(resultSet.getInt("MAHD"));
                hd.setTenNV(resultSet.getString("TENNV"));                    
                hd.setNgayBan(resultSet.getString("NGAYBAN"));
                hd.setTongTien(resultSet.getDouble("TONGTIEN"));
                hd.setTenKH(resultSet.getString("MAKH"));                                        
                dsHD.add(hd);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHD;
    }
//    public static ArrayList<CTHD> layDsCTHD()
//    { 
//        ArrayList<CTHD> ds_cthd= new ArrayList<CTHD>();
//              try {
//            String sql = "";
//            KetNoi ketnoi = new KetNoi();
//            ketnoi.open();
//            ResultSet resultSet = ketnoi.excuteQuery(sql);
//            while(resultSet.next())
//            {
//                CTHD cthd = new CTHD();
//                cthd.setMaHD(resultSet.getInt("MAHD"));
//                cthd.setTenNV(resultSet.getString("MAHH"));                    
//                cthd.setNgayBan(resultSet.getString("SOLUONG"));
//                cthd.setTongTien(resultSet.getDouble("GIABAN"));
//                cthd.setTenKH(resultSet.getString("THANHTIEN"));                                        
//                ds_cthd.add(cthd);
//            }
//            ketnoi.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     
//        return ds_cthd;
//    }
   public static boolean themHD_CoKH(HoaDon hd)
   {
         boolean kq=false;         
        String sql = "Set dateformat DMY insert into HOADON(MANV,MAKH,NGAYBAN) values ("+hd.getMaNV()+","+hd.getMaKH()+",'"+hd.getNgayBan()+"')";
          //String sql = "insert into HOADON(MANV,MAKH,NGAYBAN) values (3,4,'28-2-1999')";
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
       public static boolean themHD_khongKh(HoaDon hd)
   {
         boolean kq=false;
         
       String sql = "Set dateformat DMY insert into HOADON(MANV,NGAYBAN) values ("+hd.getMaNV()+",'"+hd.getNgayBan()+"')";
          //String sql = "insert into HOADON(MANV,MAKH,NGAYBAN) values (3,4,'28-2-1999')";
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
   public static int layMaHDMoiTao(){
         String sql= "select MAX(MAHD) as MA from HOADON";
         KetNoi ketnoi = new KetNoi();
         ketnoi.open();      
      
       int maHD=0;
       ResultSet resultSet = ketnoi.excuteQuery(sql);
       try {
           while(resultSet.next())
           {
               maHD=resultSet.getInt("MA");
           }
       } catch (SQLException ex) {
           Logger.getLogger(dsHDDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
            ketnoi.close();
            return maHD;
   }
   
   
   public static boolean updateTongTienChuaGG(int maHD)
   {
       boolean kq=false;
       String sql = "update HOADON set TONGTIEN = (select sum(thanhtien) from HOADON_HANGHOA where MAHD="+maHD+") where MAHD="+maHD+"";         
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
   public static boolean updateTongTienCoGG(int maHD, double phanTramGG)
   {
       boolean kq=false;
       String sql = "update HOADON set TONGTIEN = (select sum(thanhtien) from HOADON_HANGHOA where MAHD="+maHD+")*"+phanTramGG+" where MAHD="+maHD+"";         
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
   public static int layDiem(String sdt)
   {
       String sql= "select DIEM from KHACHHANG where  sodt='"+sdt+"'";
       KetNoi ketnoi = new KetNoi();
       ketnoi.open();             
       int diem=0;
       ResultSet resultSet = ketnoi.excuteQuery(sql);
       try {
           while(resultSet.next())
           {
               diem=resultSet.getInt("DIEM");
           }
       } catch (SQLException ex) {
           Logger.getLogger(dsHDDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
        ketnoi.close();
        return diem;
   }  
   
    public static int laySLTon(int maHD)
   {
       String sql= "select slton from HANGHOA where MAHH="+maHD+"";
       KetNoi ketnoi = new KetNoi();
       ketnoi.open();             
       int sl=0;
       ResultSet resultSet = ketnoi.excuteQuery(sql);
       try {
           while(resultSet.next()){
               sl=resultSet.getInt("SLTON");
           }
       } catch (SQLException ex) {
           Logger.getLogger(dsHDDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
        ketnoi.close();
        return sl;
   }  
    
   public static double layTongTien(int maHD)
   {
          
       String sql = "select TONGTIEN from HOADON where MAHD="+maHD+"";
       KetNoi ketnoi = new KetNoi();
       ketnoi.open(); 
       Double tongTien=0.0;
       ResultSet resultSet = ketnoi.excuteQuery(sql);
       try {
           while(resultSet.next())
           {
               tongTien=resultSet.getDouble("Tongtien");
           }
       } catch (SQLException ex) {
           Logger.getLogger(dsHDDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
            ketnoi.close();
            return tongTien;
   }
   public static boolean capNhatDiemve0(int maKH)
   {     
       boolean kq= false;
       String sql = "update KHACHHANG set diem = 0 where MAKH="+maKH+"";
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
   
     public static boolean capNhatCongDiem(int maKH, int diem)
   {     
       boolean kq= false;
       String sql = "update KHACHHANG set diem=diem+"+diem+" where MAKH="+maKH+"";
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
      
}
