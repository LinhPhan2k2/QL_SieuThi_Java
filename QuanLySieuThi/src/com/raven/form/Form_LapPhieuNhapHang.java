 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import dao.ChucVuDAO;
import dao.NhaCCDAO;
import dao.NhanVienDAO;
import dao.PhieuNhapDAO;
import dao.TaiKhoanDAO;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.JDB_HienThi;
import pojo.ChucVu;
import pojo.NhaCungCap;
import pojo.NhanVien;
import pojo.PhieuNhap;
import pojo.TaiKhoan;

/**
 *
 * @author RAVEN
 */
public class Form_LapPhieuNhapHang extends javax.swing.JPanel {
    String tieude[]={"Mã phiếu nhập", "Tên nhà cung cấp", "Ngày Nhập", "Tổng nhập"};
    DefaultTableModel tbl_mode = new DefaultTableModel();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date;
    /**
     * Creates new form Form_1
     */
    public Form_LapPhieuNhapHang() {
        
        initComponents();
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) this.tbl_danhsach.getModel();
        tbl_mode.setColumnIdentifiers(tieude);
        tbl_danhsach.setModel(tbl_mode);
        HienThi_PN();
        HienThi_CBo_NhaCC();
        updateRowHeights();
        chinhFont();
        txt_ngaynhap.setEnabled(false);
        txt_mapn.setEnabled(false);
        txt_tongnhap.setEnabled(false);
        //String ngay_hientai = dateFormat.format();
        
        txt_ngaynhap.setText(now());
        
    }
    
    public static final String DateFormat = "dd/MM/yyyy";
 
    public static String now(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DateFormat);
        return format.format(cal.getTime());
    }
     public void chinhFont()
    {
        tbl_danhsach.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 23)); // chỉnh font chữ lại cho title
        tbl_danhsach.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 23));
    }
    private void updateRowHeights()
    {
        for (int row = 0; row < tbl_danhsach.getRowCount(); row++)
        {
            int rowHeight = tbl_danhsach.getRowHeight();

            for (int column = 0; column < tbl_danhsach.getColumnCount(); column++)
            {
                Component comp = tbl_danhsach.prepareRenderer(tbl_danhsach.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            tbl_danhsach.setRowHeight(row, rowHeight);
        }
              
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tongnhap = new CustomTextField.TextField();
        button3 = new CustomButton.Button();
        button1 = new CustomButton.Button();
        button2 = new CustomButton.Button();
        txt_mapn = new CustomTextField.TextField();
        jLabel12 = new javax.swing.JLabel();
        cbo_ncc = new combobox.Combobox();
        txt_ngaynhap = new CustomTextField.TextField();
        btn_luu_pn = new CustomButton.Button();
        jTextField1 = new javax.swing.JTextField();
        btn_reload = new CustomButton.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhsach = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("Lập phiếu nhập hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 176, 227));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mã phiếu nhập");
        jLabel5.setAutoscrolls(true);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tổng nhập");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhà cung cấp");

        txt_tongnhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_tongnhap.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_tongnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongnhapActionPerformed(evt);
            }
        });

        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-plus.gif"))); // NOI18N
        button3.setText("Thêm");
        button3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button3.setShadowColor(new java.awt.Color(51, 0, 204));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-trash.gif"))); // NOI18N
        button1.setText("Xóa");
        button1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button1.setShadowColor(new java.awt.Color(51, 0, 204));

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-edit2.gif"))); // NOI18N
        button2.setText("Sửa");
        button2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button2.setShadowColor(new java.awt.Color(0, 0, 204));

        txt_mapn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_mapn.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_mapn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mapnActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ngày lập");
        jLabel12.setToolTipText("");

        cbo_ncc.setEditable(true);
        cbo_ncc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nhà cung cấp 1", "Nhà cung cấp 2", "Nhà cung cấp 3", "" }));
        cbo_ncc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_ncc.setLabeText("");
        cbo_ncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_nccActionPerformed(evt);
            }
        });

        txt_ngaynhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_ngaynhap.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_ngaynhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaynhapActionPerformed(evt);
            }
        });

        btn_luu_pn.setForeground(new java.awt.Color(255, 0, 0));
        btn_luu_pn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-save.gif"))); // NOI18N
        btn_luu_pn.setText("Lưu");
        btn_luu_pn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_luu_pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_pnActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btn_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-synchronize.gif"))); // NOI18N
        btn_reload.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_reload.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_mapn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(62, 62, 62)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tongnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_ngaynhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_luu_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mapn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luu_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        tbl_danhsach.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tbl_danhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_danhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhsachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_danhsach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tongnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongnhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongnhapActionPerformed

    private void txt_mapnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mapnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mapnActionPerformed

    private void cbo_nccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_nccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_nccActionPerformed

    private void txt_ngaynhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaynhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaynhapActionPerformed

    private void tbl_danhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhsachMouseClicked
        // TODO add your handling code here:
        int n = this.tbl_danhsach.getSelectedRow();
        this.txt_mapn.setText(String.valueOf(tbl_danhsach.getValueAt(n, 0)));
        this.txt_tongnhap.setText(String.valueOf(tbl_danhsach.getValueAt(n, 3)));
        this.cbo_ncc.setSelectedItem((String) tbl_danhsach.getValueAt(n, 1));
        this.txt_ngaynhap.setText(String.valueOf(tbl_danhsach.getValueAt(n, 2)));
    }//GEN-LAST:event_tbl_danhsachMouseClicked

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        this.txt_mapn.setText("");
        this.txt_tongnhap.setText("");
        this.cbo_ncc.setSelectedIndex(0);
        this.txt_ngaynhap.setText(now());
        HienThi_PN();
        updateRowHeights();
    }//GEN-LAST:event_button3ActionPerformed

    private void btn_luu_pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_pnActionPerformed
        // TODO add your handling code here:
        int mancc = cbo_ncc.getSelectedIndex();
        mancc++;   
        
        //String maNV = "NULL";
        //String quyen = "NULL";
        
        PhieuNhap pn = new PhieuNhap();
        pn.setMaNCC(mancc);
        pn.setNgayNhap(now());
        
        if (PhieuNhapDAO.themPN(pn))
        {
            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công!!!");
            HienThi_PN_chuacoTongTien();
            int n = PhieuNhapDAO.layMAPN_moiThem();
            Form_ChiTiet_PN ctpn = new Form_ChiTiet_PN(n);
            //ctpn.setLocationRelativeTo(null);
            ctpn.setVisible(true);
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thất bại!!!");
        }

        
        
       

    }//GEN-LAST:event_btn_luu_pnActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        HienThi_PN();
        updateRowHeights();
    }//GEN-LAST:event_btn_reloadActionPerformed
    private void HienThi_PN_chuacoTongTien() {
        DefaultTableModel dtb = (DefaultTableModel)tbl_danhsach.getModel();
        
        Vector<Object> vec = new Vector<Object>();
        
        vec.add("");
        vec.add(cbo_ncc.getSelectedItem());
        vec.add(txt_ngaynhap.getText());
        vec.add("");

        dtb.addRow(vec);
        tbl_danhsach.setModel(dtb);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomButton.Button btn_luu_pn;
    private CustomButton.Button btn_reload;
    private CustomButton.Button button1;
    private CustomButton.Button button2;
    private CustomButton.Button button3;
    private combobox.Combobox cbo_ncc;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_danhsach;
    private CustomTextField.TextField txt_mapn;
    private CustomTextField.TextField txt_ngaynhap;
    private CustomTextField.TextField txt_tongnhap;
    // End of variables declaration//GEN-END:variables

    public void HienThi_PN() {
        ArrayList<PhieuNhap> dsPN = PhieuNhapDAO.layDSPN();
        DefaultTableModel dtb = (DefaultTableModel)tbl_danhsach.getModel();
        dtb.setRowCount(0);
        for(PhieuNhap pn : dsPN)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(pn.getMaPN());
            vec.add(pn.getTenNCC());
            vec.add(pn.getNgayNhap());
            vec.add(pn.getTongNhap());
           
            dtb.addRow(vec);
        }
        tbl_danhsach.setModel(dtb);
        
    }

    private void HienThi_CBo_NhaCC() {
        ArrayList<NhaCungCap> dsNCC = NhaCCDAO.layDSNhaCC();
        DefaultTableModel tbmode = (DefaultTableModel) tbl_danhsach.getModel();
        DefaultComboBoxModel cbomode = (DefaultComboBoxModel) cbo_ncc.getModel();
        cbo_ncc.removeAllItems(); // xóa hết dl trong cbo
        for(NhaCungCap ncc : dsNCC)
        {   
            cbomode.addElement(ncc.getTenNCC());
        }
        

    }
    
}
