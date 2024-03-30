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
public class ThongKe_HD {
int tongSL, maHH, thang, nam;
    String tenHH;
    

    public ThongKe_HD() {
    }

    public ThongKe_HD(int tongSL, int maHH, String tenHH, int thang, int nam) {
        this.tongSL = tongSL;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.thang = thang;
        this.nam = nam;
    }

    public int getTongSL() {
        return tongSL;
    }

    public void setTongSL(int tongSL) {
        this.tongSL = tongSL;
    }

    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }


    
    
    
    
}
