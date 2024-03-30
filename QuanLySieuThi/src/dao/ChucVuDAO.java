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
import pojo.ChucVu;
import pojo.TaiKhoan;

/**
 *
 * @author LinhPTA-PC
 */
public class ChucVuDAO {
     public static ArrayList<ChucVu> layDSChucVu()
    {
        ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
        try {
            String sql = "select * from ChucVu";
            KetNoi ketnoi = new KetNoi();
            ketnoi.open();
            ResultSet resultSet = ketnoi.excuteQuery(sql);
            while(resultSet.next())
            {
                ChucVu cv = new ChucVu();
                cv.setMaCV(resultSet.getInt("MACV"));
                cv.setTenCV(resultSet.getString("TENCV"));
                
                dsCV.add(cv);
            }
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCV;
    }
    
}
