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
public class NhaCungCap {
    
    int MANCC;
    String tenNCC, DChi, SDT;

    public NhaCungCap() {
    }

    public NhaCungCap(int MANCC, String tenNCC, String DChi, String SDT) {
        this.MANCC = MANCC;
        this.tenNCC = tenNCC;
        this.DChi = DChi;
        this.SDT = SDT;
    }

    public int getMANCC() {
        return MANCC;
    }

    public void setMANCC(int MANCC) {
        this.MANCC = MANCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDChi() {
        return DChi;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
    
}
