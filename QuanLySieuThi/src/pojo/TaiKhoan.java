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
public class TaiKhoan {
    int maNV;
    String tenDN, matKhau, Quyen, tenNV;

    public TaiKhoan() {
    }

    public TaiKhoan(int maNV, String tenDN, String matKhau, String Quyen, String tenNV) {
        this.maNV = maNV;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.Quyen = Quyen;
        this.tenNV = tenNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    
            
    
}
