/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.NhaCungCap;
import pojo.NhanVien;
import pojo.PhieuNhap;
import swing.chart.ModelPieChart;
import swing.chart.PieChart;

/**
 *
 * @author LinhPTA-PC
 */
public class PhieuNhapDAO {
    public static ArrayList<PhieuNhap> layDSPN()
    {
        ArrayList<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
        try {
            String sql = "select * from PhieuNhap pn, NhaCungCap ncc where pn.MANCC = ncc.MANCC";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(resultSet.getInt("MAPN"));
                pn.setMaNCC(resultSet.getInt("MANCC"));
                pn.setTenNCC(resultSet.getString("TENNCC"));
                pn.setNgayNhap(resultSet.getString("NGAYNHAP"));
                pn.setTongNhap(resultSet.getInt("TONGNHAP"));
                
                dsPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPN;
    }
    
     public static boolean themPN(PhieuNhap nv)
    {
        boolean kq = false;
        String sql = String.format("Set dateformat DMY insert into PHIEUNHAP(MANCC, NGAYNHAP)values (%d,'%s')",nv.getMaNCC(), nv.getNgayNhap());  
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
    public static int layMAPN_moiThem() {
        int n = 0;
        try {
            
            boolean kq = false;
            String sql = String.format("SELECT TOP 1 MAPN FROM PHIEUNHAP ORDER BY MAPN DESC");
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(resultSet.getInt("MAPN"));
                
                
                n = resultSet.getInt("MAPN");
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static ArrayList<PhieuNhap> lay_CBo_thang()
    {
        ArrayList<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
        try {
            String sql = "select MONTH(NGAYNHAP) as NgayNHAP from PHIEUNHAP GROUP BY MONTH(NGAYNHAP)";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setNgayNhap(resultSet.getString("NGAYNHAP"));
                
                
                dsPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPN;
    }
    
     public static ArrayList<PhieuNhap> lay_CBo_nam()
    {
        ArrayList<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
        try {
            String sql = "select YEAR(NGAYNHAP) as NgayNHAP from PHIEUNHAP GROUP BY YEAR(NGAYNHAP)";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setNgayNhap(resultSet.getString("NGAYNHAP"));
                
                
                dsPN.add(pn);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPN;
    }
     
    
    
}
