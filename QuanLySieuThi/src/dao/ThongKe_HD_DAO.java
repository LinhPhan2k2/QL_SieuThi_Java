/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.CT_PhieuNhapDAO.diemSoHD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.PhieuNhap;
import pojo.ThongKe_HD;

/**
 *
 * @author LinhPTA-PC
 */
public class ThongKe_HD_DAO {
public static ArrayList<ThongKe_HD> lay_DS_SP_BanChay_TrongThang(int nam, int thang)
    {
        ArrayList<ThongKe_HD> dsPN = new ArrayList<ThongKe_HD>();
        try {
//            String sql = "select MAHH, TENHH, sum(SL) as tongSL from (select sum(SOLUONG) as SL, Detail.MAHD, Detail.MAHH, HH.TENHH from HOADON_HANGHOA Detail INNER JOIN HOADON HD on Detail.MAHD = HD.MAHD INNER JOIN HANGHOA HH on Detail.MAHH = HH.MAHH WHERE MONTH(HD.NGAYBAN) = 3 and YEAR(HD.NGAYBAN) = 2023 group by Detail.MAHD, Detail.MAHH, HH.TENHH) AS TBL group by TBL.MAHH, TBL.TENHH order by tongSL desc";   
            String sql = "select MAHH, TENHH,sum(SL) as tongSL from (select sum(SOLUONG) as SL, Detail.MAHD, Detail.MAHH, HH.TENHH from HOADON_HANGHOA Detail INNER JOIN HOADON HD on Detail.MAHD = HD.MAHD INNER JOIN HANGHOA HH on Detail.MAHH = HH.MAHH WHERE MONTH(HD.NGAYBAN) = "+thang+" and YEAR(HD.NGAYBAN) = "+nam+" group by Detail.MAHD, Detail.MAHH, HH.TENHH) AS TBL group by TBL.MAHH, TBL.TENHH order by tongSL desc";   

            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            int index= 0;
            while(resultSet.next())
            {
                
                ThongKe_HD pn = new ThongKe_HD();
                pn.setMaHH(resultSet.getInt("MAHH"));
                pn.setTenHH(resultSet.getString("TENHH"));
                pn.setTongSL(resultSet.getInt("tongSL"));
                
               
                dsPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPN;
    }
    



public static ArrayList<ThongKe_HD> lay_DS_SP_BanChay()
    {
        ArrayList<ThongKe_HD> dsPN = new ArrayList<ThongKe_HD>();
        try {
            String sql = "select MAHH, TENHH,sum(SL) as tongSL from (select sum(SOLUONG) as SL, Detail.MAHD, Detail.MAHH, HH.TENHH from HOADON_HANGHOA Detail INNER JOIN HOADON HD on Detail.MAHD = HD.MAHD INNER JOIN HANGHOA HH on Detail.MAHH = HH.MAHH group by Detail.MAHD, Detail.MAHH, HH.TENHH) AS TBL group by TBL.MAHH, TBL.TENHH order by tongSL desc";   

            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            int index= 0;
            while(resultSet.next())
            {
                
                ThongKe_HD pn = new ThongKe_HD();
                pn.setMaHH(resultSet.getInt("MAHH"));
                pn.setTenHH(resultSet.getString("TENHH"));
                pn.setTongSL(resultSet.getInt("tongSL"));
                
               
                dsPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPN;
    }

    

    public static ArrayList<ThongKe_HD> layThang()
    {
        ArrayList<ThongKe_HD> dsNCC = new ArrayList<ThongKe_HD>();
        try {
            String sql = "select DISTINCT MONTH(NGAYBAN) as Thang, YEAR(NGAYBAN) as Nam  from HOADON";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                ThongKe_HD ncc = new ThongKe_HD();
                ncc.setThang(resultSet.getInt("Thang"));
                ncc.setNam(resultSet.getInt("Nam"));
                
                dsNCC.add(ncc);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
    }
    
    public static ArrayList<ArrayList<String>> layDSMaHH(){
         ArrayList<ArrayList<String>> transactions= new ArrayList<ArrayList<String>>();
         //int slHD=diemSoHD();
         int slHD = 10;
         int maHD=0;
         //String[]dsItemset= new String[slHD];       
         KetNoi ketnoi = new KetNoi();
         ketnoi.open();         
         for(int i=0;i<slHD;i++){ 
            int t=i+1;
            String sql = "select mahh from HOADON_HANGHOA where MAHD="+t+"";  
            //String sql = "select MAHH, TENHH,sum(SL) as tongSL from (select sum(SOLUONG) as SL, Detail.MAHD, Detail.MAHH, HH.TENHH from HOADON_HANGHOA Detail INNER JOIN HOADON HD on Detail.MAHD = HD.MAHD INNER JOIN HANGHOA HH on Detail.MAHH = HH.MAHH group by Detail.MAHD, Detail.MAHH, HH.TENHH) AS TBL group by TBL.MAHH, TBL.TENHH order by tongSL desc";  
            //String sql = "select mahh from DEXUAT where MAHD="+t+"";
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
                    Logger.getLogger(ThongKe_HD_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }                              
         }
         ketnoi.close();              
         return transactions;
     }

    
}
