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
public class NhanVien {
    int maNV, maCV;
    String tenDN, tenNV, gTinh, Sdt, tenCV;

    public NhanVien() {
    }

    public NhanVien(int maNV, int maCV, String tenDN, String tenNV, String gTinh, String Sdt, String tenCV) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.tenDN = tenDN;
        this.tenNV = tenNV;
        this.gTinh = gTinh;
        this.Sdt = Sdt;
        this.tenCV = tenCV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaCV() {
        return maCV;
    }

    public void setMaCV(int maCV) {
        this.maCV = maCV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getgTinh() {
        return gTinh;
    }

    public void setgTinh(String gTinh) {
        this.gTinh = gTinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

   
    
    
}
