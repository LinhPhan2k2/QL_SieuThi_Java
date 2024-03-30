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
import pojo.NhaCungCap;
import pojo.NhanVien;

/**
 *
 * @author LinhPTA-PC
 */
public class NhaCCDAO {
     public static ArrayList<NhaCungCap> layDSNhaCC()
    {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        try {
            String sql = "select * from NhaCungCap";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMANCC(resultSet.getInt("MANCC"));
                ncc.setTenNCC(resultSet.getString("TENNCC"));
                ncc.setDChi(resultSet.getString("DIACHI"));
                ncc.setSDT(resultSet.getString("SODT"));
                
                dsNCC.add(ncc);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
    }
     
      public static ArrayList<NhaCungCap> layDSNhaCC_theoTen(String s)
    {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        try {
            String sql = "select * from NHACUNGCAP where tenncc LIKE   N'%"+s+"%'  ";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMANCC(resultSet.getInt("MANCC"));
                ncc.setTenNCC(resultSet.getString("TENNCC"));
                ncc.setDChi(resultSet.getString("DIACHI"));
                ncc.setSDT(resultSet.getString("SODT"));
                
                dsNCC.add(ncc);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
    }
     
    
}
