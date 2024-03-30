/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import static com.raven.form.Form_LapPhieuNhapHang.DateFormat;
import dao.CT_HoaDonDAO;
import dao.HangHoaDAO;
import dao.KetNoi;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.dsHDDAO;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import pojo.CT_HoaDon;
import pojo.HangHoa;
import pojo.HoaDon;
import pojo.KhachHang;

/**
 *
 * @author RAVEN
 */
public class Form_LapHoaDon extends javax.swing.JPanel {
    
    String tenNV="";
    int maNV=0;   
    double giuTongTienBanDau=0.0;
    //----------------------------------------------------------Chuyển đổi ngày 
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date;
    public static final String DateFormat = "dd/MM/yyyy";    
    /**
     * Creates new form Form_1
     */
    public  void headerTheThanhVien()
    {
          DefaultTableModel tblModel1;
          String tieude1[]={"Mã thẻ", "Tên KH", "Địa chỉ", "Số ĐT","Điểm"};
          DefaultTableModel tbl_mode1 = new DefaultTableModel();
          tblModel1 = (DefaultTableModel) this.tbl_theThanhVien.getModel();
          tbl_mode1.setColumnIdentifiers(tieude1);
          tbl_theThanhVien.setModel(tbl_mode1);
    
    }
    public void headerCTHD()
    {
           DefaultTableModel tblModel2;
           String tieude2[]={"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán ","Thành tiền"};
           DefaultTableModel tbl_mode2 = new DefaultTableModel();
           tblModel2 = (DefaultTableModel) this.tbl_cthd.getModel();
           tbl_mode2.setColumnIdentifiers(tieude2);       
           tbl_cthd.setModel(tbl_mode2);
    }
    public void chinhFont()
    {
        tbl_theThanhVien.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20)); // chỉnh font chữ lại cho title
        tbl_cthd.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
    }
    public Form_LapHoaDon(String tenDN) {
        initComponents();              
        headerTheThanhVien();
        headerCTHD();     
        tenNV=tenDN; 
        layTenNV();
        txt_tenNV.setText(tenNV);                     
        txt_ngayLap.setText(now());       
        maNV= NhanVienDAO.layMaNvTuTendn(tenDN);                
        loadSP();
        HienThi_DSKH();      
        disnableText(); // khóa thuộc tính cần thiết
        chinhFont();     
        updateRowHeights();// chỉnh dòng cho đều của chi thẻ thành viên       
        txt_maHH.setVisible(false);
        txt_maKH.setVisible(false);
        btn_taomoiHD.setVisible(false);
    }
    // Hàm lấy ngày hiện tại
    public static String now(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DateFormat);
        return format.format(cal.getTime());
    }    
    public void layTenNV()
    {
        String s=NhanVienDAO.chuyenDoiTenDNThanhTenNV(tenNV);
        tenNV=s;
    }              
    private void disnableText() // khoa text field can thiet
    {
       txt_sdt.setEnabled(false);
       txt_giaBan.setEnabled(false);
       txt_soHD.setEnabled(false);
       txt_thanhTien.setEnabled(false);
       txt_maKH.setEnabled(false);
       txt_tenNV.setEnabled(false);
       txt_ngayLap.setEnabled(false); 
       txt_tongTien.setEnabled(false);
    }
    private void taoHD()
    {        
        if(txt_soHD.getText().isEmpty()) // Nếu chưa có hóa đơn nào thì thêm 1 hóa đơn vào
        {            
            if(cbox_theTV.isSelected())// hoa don co khach hang
            {                
                themHD_coKH();              
            }
            else // hoa don ko kh
            {
                themHD_khongKh();
            }                          
        }
        else // ngược lại chỉ thêm chi tiết hóa đơn
        {                   
            themCTHD();            
        }
        
    }
    private void themCTHD()    
    {
        try {
            int t= Integer.parseInt(txt_soLuong.getText());
            if(txt_soLuong.getText().isEmpty()||t<=0){
                JOptionPane.showMessageDialog(this,"Số lượng không được để trống và không được âm");                
        }
           else
           {
               CT_HoaDon cthd= new CT_HoaDon();                                                                                                                                   
                    try {    
                        int soHD= Integer.parseInt(txt_soHD.getText());
                        int soLuong= Integer.parseInt(txt_soLuong.getText());
                        int maHH=Integer.parseInt(txt_maHH.getText());                          
                        cthd.setMaHD(soHD);
                        cthd.setMaHH(maHH);
                        cthd.setSoLuong(soLuong);                        
                        System.out.println("mã hd" + cthd.getMaHD());
                        System.out.println("mã hh" + cthd.getMaHH());
                        System.out.println("so luong:"+ cthd.getSoLuong());
                        int sl= dsHDDAO.laySLTon(maHH);
                        if(sl<soLuong)
                        {
                            JOptionPane.showMessageDialog(this,"Không đủ số lượng");
                        }
                        else
                        {
                            boolean kq= CT_HoaDonDAO.them_CTHD(cthd);                         
                        if(kq)
                        {
                          //JOptionPane.showMessageDialog(this, "Thêm thành công");
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(this, "Thêm thất bại");
                        }
                        }                                            
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                 }                    
                 HienThi_DsCTHD();
                 updateRowHeights2();
           }                      
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this,"Số lượng phải là số");
        }        
    }
    private void themHD_khongKh()
    {                           
        try {                                                  
                    HoaDon hd= new HoaDon();                                                                                                                                   
                    try {                                                                          
                        hd.setMaNV(maNV);                       
                        hd.setNgayBan(now());                        
                        System.out.println("mã nhân viên" + hd.getMaNV());                      
                        System.out.println("Ngày lập:"+ hd.getNgayBan());
                        
                        boolean kq= dsHDDAO.themHD_khongKh(hd);                         
                        if(kq)
                        {
                       //   JOptionPane.showMessageDialog(this, "Thêm thành công");
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(this, "Thêm thất bại");
                        }                    
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                 }                                                          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        int mahd=dsHDDAO.layMaHDMoiTao();
        txt_soHD.setText(String.valueOf(mahd));                                                                                                                                                              
    }
    private void themHD_coKH()
    {        
        if(txt_maKH.getText().isEmpty() )
        {
          JOptionPane.showMessageDialog(jPanel4, "Vui lòng nhập đầy đủ thông tin");
        }  
        else
        {              
        try {                                                  
                    HoaDon hd= new HoaDon();                                                                                                                                   
                    try {                                                                          
                        hd.setMaNV(maNV);
                        int tempMaKh=Integer.parseInt(txt_maKH.getText());
                        hd.setMaKH(tempMaKh);                                                
                        //hd.setNgayBan(txt_ngayLap.getText()); 
                        hd.setNgayBan(now());                        
                        System.out.println("mã nhân viên" + hd.getMaNV());
                        System.out.println("mã khách hàng" + hd.getMaKH());
                        System.out.println("Ngày lập:"+ hd.getNgayBan());                        
                        boolean kq= dsHDDAO.themHD_CoKH(hd);                         
                        if(kq)
                        {
                         // JOptionPane.showMessageDialog(this, "Thêm thành công");
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(this, "Thêm thất bại");
                        }
                    
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                 }                                                          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        int mahd=dsHDDAO.layMaHDMoiTao();
        txt_soHD.setText(String.valueOf(mahd));                                                                                                                                                  
    }
        
    }        
    private void loadSP()  // load combobox sản phẩm 
    {
       ArrayList<String> dsSP= HangHoaDAO.layDSTenHH();   
       DefaultComboBoxModel cbomode = (DefaultComboBoxModel) cbo_dsSP.getModel();
       cbo_dsSP.removeAllItems();         
        for(int i=0; i<dsSP.size(); i++)
        {
             cbomode.addElement(dsSP.get(i));
        }   
    }  
    
//     private void loadLoaiSP()  // load combobox sản phẩm 
//    {
//       ArrayList<String> dsSP= HangHoaDAO.layDSLoaiHH();   
//       DefaultComboBoxModel cbomode = (DefaultComboBoxModel) cbo_dsSP.getModel();
//       cbo_dsSP.removeAllItems();         
//        for(int i=0; i<dsSP.size(); i++)
//        {
//             cbomode.addElement(dsSP.get(i));
//        }   
//    }  

      
    private void updateRowHeights2()
    {
        for (int row = 0; row < tbl_cthd.getRowCount(); row++)
        {
            int rowHeight = tbl_cthd.getRowHeight();

            for (int column = 0; column < tbl_cthd.getColumnCount(); column++)
            {
                Component comp = tbl_cthd.prepareRenderer(tbl_cthd.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            tbl_cthd.setRowHeight(row, rowHeight);
        }
              
    }
    private void updateRowHeights()
    {
        for (int row = 0; row < tbl_theThanhVien.getRowCount(); row++)
        {
            int rowHeight = tbl_theThanhVien.getRowHeight();

            for (int column = 0; column < tbl_theThanhVien.getColumnCount(); column++)
            {
                Component comp = tbl_theThanhVien.prepareRenderer(tbl_theThanhVien.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            tbl_theThanhVien.setRowHeight(row, rowHeight);
        }
              
    }
    private void HienThi_DSKH() {
        ArrayList<KhachHang> dsKH = KhachHangDAO.layDSKH();
        DefaultTableModel dtb = (DefaultTableModel)tbl_theThanhVien.getModel();
        dtb.setRowCount(0);
        for(KhachHang kh : dsKH)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKh());
            vec.add(kh.getTenKh());
            vec.add(kh.getDiaChi());
            vec.add(kh.getSoDT());
            vec.add(kh.getDiem());                                 
            dtb.addRow(vec);
        }
        tbl_theThanhVien.setModel(dtb);
        
    }
    private void HienThi_DSKH_MuaHang() {
        ArrayList<KhachHang> dsKH = KhachHangDAO.layKHCoThe(txt_sdt.getText().trim());
        DefaultTableModel dtb = (DefaultTableModel)tbl_theThanhVien.getModel();
        dtb.setRowCount(0);
        for(KhachHang kh : dsKH)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKh());
            vec.add(kh.getTenKh());
            vec.add(kh.getDiaChi());
            vec.add(kh.getSoDT());
            vec.add(kh.getDiem());                                 
            dtb.addRow(vec);
        }
        tbl_theThanhVien.setModel(dtb);
        
    }
    private void HienThi_DsCTHD(){
       int soHD= Integer.parseInt(txt_soHD.getText());
      //int soHD= 1;
      ArrayList<CT_HoaDon> ds_cthd= CT_HoaDonDAO.layDS_CTHD(soHD);

      DefaultTableModel dtb = (DefaultTableModel)tbl_cthd.getModel();
      dtb.setRowCount(0);
      for(CT_HoaDon cthd : ds_cthd)
      {
          Vector<Object> vec = new Vector<Object>();
          vec.add(cthd.getMaHH());
          vec.add(cthd.getTenHH());
          vec.add(cthd.getSoLuong());
          vec.add(cthd.getGiaBan());
          vec.add(cthd.getThanhTien());                                 
          dtb.addRow(vec);
      }
      tbl_cthd.setModel(dtb);

    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbox_theTV = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        btn_kiemTra = new CustomButton.Button();
        txt_sdt = new CustomTextField.TextField();
        txt_maKH = new CustomTextField.TextField();
        btn_reload = new CustomButton.Button();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbo_dsSP = new combobox.Combobox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tenNV = new CustomTextField.TextField();
        txt_soHD = new CustomTextField.TextField();
        txt_ngayLap = new CustomTextField.TextField();
        jLabel12 = new javax.swing.JLabel();
        txt_thanhTien = new CustomTextField.TextField();
        txt_soLuong = new CustomTextField.TextField();
        jLabel9 = new javax.swing.JLabel();
        txt_giaBan = new CustomTextField.TextField();
        txt_maHH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tongTien = new CustomTextField.TextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cthd = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_theThanhVien = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btn_them = new CustomButton.Button();
        btn_inHoaDon = new CustomButton.Button();
        btn_sua = new CustomButton.Button();
        btn_thanhToan = new CustomButton.Button();
        btn_xoa = new CustomButton.Button();
        btn_lamoi = new CustomButton.Button();
        btn_taomoiHD = new CustomButton.Button();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1448, 662));

        jPanel1.setBackground(new java.awt.Color(185, 209, 234));

        jPanel4.setBackground(new java.awt.Color(38, 176, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(947, 533));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đã có thẻ thành viên ?");

        cbox_theTV.setBackground(new java.awt.Color(255, 255, 255));
        cbox_theTV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbox_theTV.setForeground(new java.awt.Color(255, 51, 51));
        cbox_theTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_theTVActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nhập số điện thoại");

        btn_kiemTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-error.gif"))); // NOI18N
        btn_kiemTra.setText("Kiểm tra");
        btn_kiemTra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_kiemTra.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_kiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kiemTraActionPerformed(evt);
            }
        });

        txt_sdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_sdt.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_maKH.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maKHActionPerformed(evt);
            }
        });

        btn_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-synchronize.gif"))); // NOI18N
        btn_reload.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_reload.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbox_theTV)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_kiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(cbox_theTV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reload, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(652, 652, 652))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 255));
        jLabel8.setText("Lập hóa đơn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(185, 209, 234));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));

        jLabel5.setBackground(new java.awt.Color(0, 102, 204));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("1. Nhân viên");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("4. Số lượng");

        cbo_dsSP.setEditable(true);
        cbo_dsSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bánh kẹo", "Mỹ phẩm", "Trái cây, rau củ", "............." }));
        cbo_dsSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_dsSP.setLabeText("");
        cbo_dsSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_dsSPItemStateChanged(evt);
            }
        });
        cbo_dsSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_dsSPActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("2. Ngày lập");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("5. Giá bán");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("3. Sản phẩm");

        txt_tenNV.setBackground(new java.awt.Color(220, 220, 220));
        txt_tenNV.setForeground(new java.awt.Color(0, 0, 0));
        txt_tenNV.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_tenNV.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_tenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenNVActionPerformed(evt);
            }
        });

        txt_soHD.setBackground(new java.awt.Color(220, 220, 220));
        txt_soHD.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_soHD.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_soHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soHDActionPerformed(evt);
            }
        });

        txt_ngayLap.setBackground(new java.awt.Color(220, 220, 220));
        txt_ngayLap.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_ngayLap.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_ngayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngayLapActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("6. Số HĐ");

        txt_thanhTien.setBackground(new java.awt.Color(220, 220, 220));
        txt_thanhTien.setForeground(new java.awt.Color(255, 0, 0));
        txt_thanhTien.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_thanhTien.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_thanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thanhTienActionPerformed(evt);
            }
        });

        txt_soLuong.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_soLuong.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 102));
        jLabel9.setText("Thành tiền");

        txt_giaBan.setBackground(new java.awt.Color(220, 220, 220));
        txt_giaBan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_giaBan.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaBanActionPerformed(evt);
            }
        });

        txt_maHH.setText("maHH");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setText("Tổng tiền");

        txt_tongTien.setBackground(new java.awt.Color(220, 220, 220));
        txt_tongTien.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txt_tongTien.setShadowColor(new java.awt.Color(255, 0, 255));
        txt_tongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cbo_dsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_maHH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soHD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbo_dsSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(185, 209, 234));

        tbl_cthd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_cthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_cthd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cthdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_cthd);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        tbl_theThanhVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_theThanhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_theThanhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_theThanhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_theThanhVien);

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-plus.gif"))); // NOI18N
        btn_them.setText("Thêm SP");
        btn_them.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_them.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_inHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-print.gif"))); // NOI18N
        btn_inHoaDon.setText("In hóa đơn");
        btn_inHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_inHoaDon.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_inHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inHoaDonActionPerformed(evt);
            }
        });

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-edit2.gif"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_sua.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-cash.gif"))); // NOI18N
        btn_thanhToan.setText("Thanh toán");
        btn_thanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_thanhToan.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-trash.gif"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_xoa.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lamoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-synchronize.gif"))); // NOI18N
        btn_lamoi.setText("Làm mới");
        btn_lamoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_lamoi.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_lamoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamoiActionPerformed(evt);
            }
        });

        btn_taomoiHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-new-copy-48.png"))); // NOI18N
        btn_taomoiHD.setText("Thêm HĐ");
        btn_taomoiHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_taomoiHD.setShadowColor(new java.awt.Color(51, 0, 204));
        btn_taomoiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taomoiHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btn_taomoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_lamoi, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_inHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_taomoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lamoi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(970, 970, 970)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_theTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_theTVActionPerformed
                 txt_sdt.setEnabled(true);
                 txt_sdt.requestFocus();
    }//GEN-LAST:event_cbox_theTVActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_ngayLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngayLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngayLapActionPerformed

    private void txt_soHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soHDActionPerformed

    private void txt_tenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenNVActionPerformed

    private void txt_thanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thanhTienActionPerformed

    private void txt_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaBanActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maKHActionPerformed

    private void cbo_dsSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_dsSPItemStateChanged

        int i = cbo_dsSP.getSelectedIndex();
        int t = i + 1;
        int giaban = HangHoaDAO.chuyenDoiGia(t);        
        txt_giaBan.setText(String.valueOf(giaban)); 
        txt_maHH.setText(String.valueOf(t));        
    }//GEN-LAST:event_cbo_dsSPItemStateChanged

    private void cbo_dsSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_dsSPActionPerformed
        
       
    }//GEN-LAST:event_cbo_dsSPActionPerformed

    private void tbl_theThanhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_theThanhVienMouseClicked
        if(cbox_theTV.isSelected()){
             int n = this.tbl_theThanhVien.getSelectedRow();
        this.txt_maKH.setText(String.valueOf(tbl_theThanhVien.getValueAt(n, 0)));             
        this.txt_sdt.setText(String.valueOf(tbl_theThanhVien.getValueAt(n, 3))); 
        }
       
    }//GEN-LAST:event_tbl_theThanhVienMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
       taoHD();
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_cthdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cthdMouseClicked
       
         int n = this.tbl_cthd.getSelectedRow();
         this.txt_maHH.setText(String.valueOf(tbl_cthd.getValueAt(n, 0)));     
         this.txt_soLuong.setText(String.valueOf(tbl_cthd.getValueAt(n, 2)));   
         txt_soLuong.requestFocus();
        
    }//GEN-LAST:event_tbl_cthdMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        if(txt_maHH.getText().isEmpty()|| txt_soLuong.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Chưa chọn sản phẩm cần xóa");
        }
        else
        {
             int maHH=Integer.parseInt(txt_maHH.getText());
             boolean kt= CT_HoaDonDAO.xoa_CTHD(maHH);
             if(kt){
                 JOptionPane.showMessageDialog(this, "Xóa thành công");               
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Xóa thất bại");
                
             }
              HienThi_DsCTHD();
              updateRowHeights2();
        }
       
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lamoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamoiActionPerformed
        txt_soHD.setText("");
        txt_soLuong.setText("");
        txt_thanhTien.setText("");
        DefaultTableModel dtb = (DefaultTableModel)tbl_cthd.getModel();
        dtb.setRowCount(0);
        txt_sdt.setText("");
        txt_sdt.setEnabled(false);
        cbox_theTV.setSelected(false);
        txt_maKH.setText("");       
        txt_tongTien.setText("");
        txt_soLuong.requestFocus();
    }//GEN-LAST:event_btn_lamoiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        
        try {            
        if(txt_soLuong.getText().isEmpty()||txt_soHD.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập số lượng");
        }
        else
        {
             int maHH=Integer.parseInt(txt_maHH.getText());
             int maHD=Integer.parseInt(txt_soHD.getText());
             int soLuong=Integer.parseInt(txt_soLuong.getText());
             CT_HoaDon cthd= new CT_HoaDon();
             cthd.setMaHD(maHD);
             cthd.setMaHH(maHH);
             cthd.setSoLuong(soLuong);
             boolean kt= CT_HoaDonDAO.sua_CTHD(cthd);
             if(kt){
                 JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                 HienThi_DsCTHD();
                 updateRowHeights2();
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
             }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
        }
        
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        
        if(txt_soHD.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Chưa có hóa đơn để thanh toán");
        }
        else
        {
        int maHD=Integer.parseInt(txt_soHD.getText());          
        if(cbox_theTV.isSelected())
        {                    
            int maKH=Integer.parseInt(txt_maKH.getText());                                               
            int layDiem= dsHDDAO.layDiem(txt_sdt.getText().trim());
            
            if(layDiem>=10)
            {            
                boolean capNhatTongTienHD = dsHDDAO.updateTongTienChuaGG(maHD);
                Double layTongTienHD=dsHDDAO.layTongTien(maHD);             
                txt_tongTien.setText(String.valueOf(layTongTienHD));
                giuTongTienBanDau=layTongTienHD;           
                Double phanTramGG= 0.88;
                boolean kq = dsHDDAO.updateTongTienCoGG(maHD,phanTramGG);                          
                double layThanhTienSauGG= dsHDDAO.layTongTien(maHD);  
                System.out.println("thanh tien giam gia: " +layThanhTienSauGG);
                txt_thanhTien.setText(String.valueOf(layThanhTienSauGG));                    
                // cập nhật điểm về 0               
                boolean kt_capNhatdiemve0=dsHDDAO.capNhatDiemve0(maKH);
                if(kt_capNhatdiemve0==true) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");           
                }
                else{
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
                }//-----                        
            }
            else
            {
                boolean kq = dsHDDAO.updateTongTienChuaGG(maHD);                               
                double layTongTienHD= dsHDDAO.layTongTien(maHD);            
                txt_tongTien.setText(String.valueOf(layTongTienHD));
                txt_thanhTien.setText(String.valueOf(layTongTienHD)); 
                giuTongTienBanDau=layTongTienHD;
            }
                        
            // cộng điểm mỗi hóa đơn--------------------------          
            double layTT= giuTongTienBanDau;          
            System.out.println("tong tiền ban đầu là: "+layTT );
            double soDiemCong=layTT/100000;
            int soDiemCong_int= (int)soDiemCong;
            System.out.println("so diem cong: "+soDiemCong_int);
            // cập nhật cộng điểm
            boolean kt_capNhatCongDiem=dsHDDAO.capNhatCongDiem(maKH,soDiemCong_int);        
            if(kt_capNhatCongDiem==true) {
              JOptionPane.showMessageDialog(this, "Cập nhật cộng điểm thành công");           
            }
            else{
                 JOptionPane.showMessageDialog(this, "Cập nhật cộng điểm thất bại");
            }     
            txt_tongTien.setText(String.valueOf(layTT));
            System.out.println("so diem cong:"+soDiemCong_int);
            
            
            headerTheThanhVien();
            HienThi_DSKH_MuaHang();
            updateRowHeights(); 
            
        }
        else{   // Cập nhật thành tiền của hóa đơn ko khách hàng              
            boolean kq = dsHDDAO.updateTongTienChuaGG(maHD);
            if(kq==true) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");           
            }
            else{
                 JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
            double layTT= dsHDDAO.layTongTien(maHD);
            txt_thanhTien.setText(String.valueOf(layTT));
            txt_tongTien.setText(String.valueOf(layTT));            
        } 
        }
   
        
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_kiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kiemTraActionPerformed
       String sdt=txt_sdt.getText().trim();
        System.out.println(sdt);
       boolean kt= KhachHangDAO.kiemtraSDT(sdt);
       if(kt==false)
       {
           JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
       }
       else
       {                       
        headerTheThanhVien();
        HienThi_DSKH_MuaHang();
        updateRowHeights();
       }
    }//GEN-LAST:event_btn_kiemTraActionPerformed

    private void txt_tongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongTienActionPerformed

    private void btn_inHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inHoaDonActionPerformed
        
        if(txt_maKH.getText().isEmpty()){
               try {
               Hashtable map = new  Hashtable();
               JasperReport report  =  JasperCompileManager.compileReport("src/report/Hoadon_KhongKH.jrxml");
               int temp_maHD=Integer.parseInt(txt_soHD.getText().trim());
               map.put("MAHD",temp_maHD);
               String strServer = "MSI\\SQLEXPRESS";
               String strDatabase = "QL_SIEUTHI_GG";
               String strUser = "sa";
               String strPass = "123";
               String connectURL = "jdbc:sqlserver://" + strServer
                                      + ":1433;databaseName=" + strDatabase
                                      + ";user =" + strUser + "; password= " + strPass;
               Connection conn;
               try {
                   conn = DriverManager.getConnection(connectURL);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report,map,conn);
                    JasperViewer.viewReport(jasperPrint,false);
               } catch (SQLException ex) {
                   Logger.getLogger(Form_LapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
               }                       
           } catch (JRException ex) {
               Logger.getLogger(Form_LapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else
        {
                try {
               Hashtable map = new  Hashtable();
               JasperReport report  =  JasperCompileManager.compileReport("src/report/Hoadon_CoKH.jrxml");
               int temp_maHD=Integer.parseInt(txt_soHD.getText().trim());
               map.put("MAHD",temp_maHD);
               String strServer = "MSI\\SQLEXPRESS";
               String strDatabase = "QL_SIEUTHI_GG";
               String strUser = "sa";
               String strPass = "123";
               String connectURL = "jdbc:sqlserver://" + strServer
                                      + ":1433;databaseName=" + strDatabase
                                      + ";user =" + strUser + "; password= " + strPass;
               Connection conn;
               try {
                   conn = DriverManager.getConnection(connectURL);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report,map,conn);
                    JasperViewer.viewReport(jasperPrint,false);
               } catch (SQLException ex) {
                   Logger.getLogger(Form_LapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
               }                       
           } catch (JRException ex) {
               Logger.getLogger(Form_LapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
        
                
    }//GEN-LAST:event_btn_inHoaDonActionPerformed

    private void btn_taomoiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taomoiHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taomoiHDActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        HienThi_DSKH();
        updateRowHeights();
    }//GEN-LAST:event_btn_reloadActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomButton.Button btn_inHoaDon;
    private CustomButton.Button btn_kiemTra;
    private CustomButton.Button btn_lamoi;
    private CustomButton.Button btn_reload;
    private CustomButton.Button btn_sua;
    private CustomButton.Button btn_taomoiHD;
    private CustomButton.Button btn_thanhToan;
    private CustomButton.Button btn_them;
    private CustomButton.Button btn_xoa;
    private combobox.Combobox cbo_dsSP;
    private javax.swing.JCheckBox cbox_theTV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbl_cthd;
    private javax.swing.JTable tbl_theThanhVien;
    private CustomTextField.TextField txt_giaBan;
    private javax.swing.JTextField txt_maHH;
    private CustomTextField.TextField txt_maKH;
    private CustomTextField.TextField txt_ngayLap;
    private CustomTextField.TextField txt_sdt;
    private CustomTextField.TextField txt_soHD;
    private CustomTextField.TextField txt_soLuong;
    private CustomTextField.TextField txt_tenNV;
    private CustomTextField.TextField txt_thanhTien;
    private CustomTextField.TextField txt_tongTien;
    // End of variables declaration//GEN-END:variables
}

