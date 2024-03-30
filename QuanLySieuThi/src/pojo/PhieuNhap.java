/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

/**
 *
 * @author LinhPTA-PC
 */
public class PhieuNhap {
    int maPN, maNCC;
    String tenNCC;
    String ngayNhap;
    int tongNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPN, int maNCC, String tenNCC, String ngayNhap, int tongNhap) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.ngayNhap = ngayNhap;
        this.tongNhap = tongNhap;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongNhap() {
        return tongNhap;
    }

    public void setTongNhap(int tongNhap) {
        this.tongNhap = tongNhap;
    }
    
    
    
    
            
    
}
