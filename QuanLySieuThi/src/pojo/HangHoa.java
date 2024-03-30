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
public class HangHoa {

    public HangHoa(int maHH, int maNH, String tenHH, String DVT, String TENNH, double giaban, int slton) {
        this.maHH = maHH;
        this.maNH = maNH;
        this.tenHH = tenHH;
        this.DVT = DVT;
        this.TENNH = TENNH;
        this.giaban = giaban;
        this.slton = slton;
    }
    int maHH, maNH;
    String tenHH, DVT,TENNH;

    public String getTENNH() {
        return TENNH;
    }

    public void setTENNH(String TENNH) {
        this.TENNH = TENNH;
    }
    int  slton;
    double giaban;

    public HangHoa() {
    }



    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public int getMaNH() {
        return maNH;
    }

    public void setMaNH(int maNH) {
        this.maNH = maNH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getSlton() {
        return slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }
    
    
}
