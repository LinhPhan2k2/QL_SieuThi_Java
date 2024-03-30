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
import pojo.CT_PhieuNhap;
import pojo.PhieuNhap;

/**
 *
 * @author LinhPTA-PC
 */
public class CT_PhieuNhapDAO {
    
    public static ArrayList<CT_PhieuNhap> layDS_CTPN()
    {
        ArrayList<CT_PhieuNhap> ds_CTPN = new ArrayList<CT_PhieuNhap>();
        try {
            String sql = "select *  from PHIEUNHAP_HH pn, HANGHOA hh where MAPN = (SELECT TOP 1 MAPN FROM PHIEUNHAP ORDER BY MAPN DESC) AND hh.MAHH = PN.MAHH";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                CT_PhieuNhap pn = new CT_PhieuNhap();
                pn.setMaPN(resultSet.getInt("MAPN"));
                pn.setMaHH(resultSet.getInt("MAHH"));
                pn.setTenHH(resultSet.getString("TENHH"));
                pn.setSL(resultSet.getInt("SOLUONG"));
                pn.setGianhap(resultSet.getInt("GIANHAP"));
                pn.setThanhTien(resultSet.getInt("THANHTIEN"));
                
                ds_CTPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds_CTPN;
    }
    
    public static int diemSoHD()
    {
            String sql = "select count(*) as sl from HOADON";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql); 
            int count=0;
            try {
                while(resultSet.next())
                {
                     count=resultSet.getInt("sl");
                }                                         
            } catch (SQLException ex) {
                Logger.getLogger(CT_PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ketnoi.close();
            return count;
    }

     public static ArrayList<ArrayList<String>> layDSMaHH(){
         ArrayList<ArrayList<String>> transactions= new ArrayList<ArrayList<String>>();
         int slHD=diemSoHD();
         int maHD=0;
         //String[]dsItemset= new String[slHD];       
         KetNoi ketnoi = new KetNoi();
         ketnoi.open();         
         for(int i=0;i<slHD;i++){ 
            int t=i+1;
            String sql = "select mahh from HOADON_HANGHOA where MAHD="+t+"";            
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            ArrayList<String> Itemset= new ArrayList<String>();
                try {
                    while(resultSet.next())
                    {                               
                         Itemset.add(resultSet.getString("mahh"));                         
                         transactions.add(Itemset);                           
                    }                      
                } 
                catch (SQLException ex) {
                    Logger.getLogger(CT_PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                }                              
         }
         ketnoi.close();              
         return transactions;
     }
     
     
    public static boolean them_CTPN(CT_PhieuNhap pn)
    {
        boolean kq = false;
        String sql = String.format("insert into PHIEUNHAP_HH(MAHH, MAPN, SOLUONG, GIANHAP) values (%d, %d, %d, %d)",pn.getMaHH(), pn.getMaPN(), pn.getSL(), pn.getGianhap());  
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
    
    public static boolean capnhat_TongTien(int mapn)
    {
        boolean kq = false;
        String sql = String.format("update PHIEUNHAP set TONGNHAP = (select sum(pnhh.THANHTIEN) from PHIEUNHAP_HH pnhh, PHIEUNHAP pn where pnhh.MAPN = pn.MAPN and pn.MAPN = %d group by pn.MAPN) where MAPN = %d", mapn, mapn);  
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
