/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author LinhPTA-PC
 */
public class CT_PhieuNhap {
    int maHH, maPN, SL, gianhap, thanhTien;
    String tenHH;

    public CT_PhieuNhap() {
    }

    public CT_PhieuNhap(int maHH, int maPN, int SL, int gianhap, int thanhTien, String tenhang) {
        this.maHH = maHH;
        this.maPN = maPN;
        this.SL = SL;
        this.gianhap = gianhap;
        this.thanhTien = thanhTien;
        this.tenHH = tenhang;
    }

    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }
    
   
    
    
}
