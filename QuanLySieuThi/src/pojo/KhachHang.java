/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author admin
 */
public class KhachHang {

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public KhachHang() {
    }

    public KhachHang(int maKh, int diem, String tenKh, String diaChi, String soDT) {
        this.maKh = maKh;
        this.diem = diem;
        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    int maKh, diem;
    String tenKh, diaChi, soDT;
    
}
