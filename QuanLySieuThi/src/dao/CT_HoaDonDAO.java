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
import pojo.CT_HoaDon;
import pojo.CT_PhieuNhap;
import pojo.HangHoa;

/**
 *
 * @author admin
 */
public class CT_HoaDonDAO {    
       public static ArrayList<CT_HoaDon> layDS_CTHD(int maHD)
    {     
        ArrayList<CT_HoaDon> ds_CTHD = new ArrayList<CT_HoaDon>();
        try {
            String sql = "select HOADON_HANGHOA.MAHH,HANGHOA.TENHH,HANGHOA.GIABAN,SOLUONG,THANHTIEN \n" +
"from HOADON_HANGHOA, HANGHOA \n" +
"WHERE HANGHOA.MAHH=HOADON_HANGHOA.MAHH AND HOADON_HANGHOA.MAHD="+maHD+"";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                CT_HoaDon cthd = new CT_HoaDon();
                cthd.setMaHH(resultSet.getInt("mahh"));               
                cthd.setTenHH(resultSet.getString("TENHH"));
                cthd.setSoLuong(resultSet.getInt("SOLUONG"));
                cthd.setGiaBan(resultSet.getInt("giaban"));
                cthd.setThanhTien(resultSet.getInt("THANHTIEN"));                
                ds_CTHD.add(cthd);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds_CTHD;
    }
       
     public static boolean them_CTHD(CT_HoaDon cthd)
    {
        boolean kq = false;
        String sql = "insert into HOADON_HANGHOA(MAHD,MAHH,SOLUONG) values("+cthd.getMaHD()+","+cthd.getMaHH()+","+cthd.getSoLuong()+")";
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
     public static boolean xoa_CTHD(int maHH)
     {
        boolean kq = false;
        String sql = "delete HOADON_HANGHOA where MAHH="+maHH+"";
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
     public static  boolean sua_CTHD(CT_HoaDon cthd)
    {
        boolean kq = false;
        String sql = "update HOADON_HANGHOA set SOLUONG="+cthd.getSoLuong()+" where MAHH="+cthd.getMaHH()+" and MAHD="+cthd.getMaHD()+"";
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
