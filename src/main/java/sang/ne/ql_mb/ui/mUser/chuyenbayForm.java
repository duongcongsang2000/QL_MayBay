/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.ui.mUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sang.ne.ql_mb.Dao.GiaVeDao;
import sang.ne.ql_mb.Dao.HoaDonDao;
import sang.ne.ql_mb.Dao.PhieuDatChoDao;
import sang.ne.ql_mb.Dao.TuyenBayDao;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.entity.HoaDon;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.entity.PhieuDatCho;
import sang.ne.ql_mb.entity.TuyenBay;
import sang.ne.ql_mb.help.MessageHelper;


/**
 *
 * @author CCLaptop.com
 */
public class chuyenbayForm extends javax.swing.JFrame {

    KhachHang khachhang;
    ChuyenBay chuyenbay;
    public static TuyenBay tuyenbay;
    SimpleDateFormat stf= new SimpleDateFormat("dd-MM-yyyy");
    private chooseSeat mchooseSeat;
    

    /**
     * Creates new form chuyenbayForm
     */
    public chuyenbayForm() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public chuyenbayForm (KhachHang kh,ChuyenBay cbay,TuyenBay tbay){
        initComponents();
        setLocationRelativeTo(null);
        LoadData(kh,cbay,tbay);
        this.khachhang= kh;
        this.chuyenbay = cbay;
        this.tuyenbay = tbay;
        
    }
    
    public void LoadData(KhachHang kh, ChuyenBay cbay,TuyenBay tbay){
        txt_sanbaydi.setText(tbay.getSanBayDi());
        txt_sanbayden.setText(tbay.getSanBayDen());
        txt_ngaybay.setText(stf.format(cbay.getNgayGio()));
        txt_thoigianbay.setText(cbay.getThoiGianBay());
        txt_cmnd.setText(kh.getCMND());
        txt_hoten.setText(kh.getTENKH());
        txt_sdt.setText(kh.getSDT());
 
    }
    
    public static void LoadTongTien() throws Exception{
        GiaVeDao gv = new GiaVeDao();
        int dongia = gv.findGiaVe(chuyenbayForm.txt_hangghe.getText());
        TuyenBayDao tb = new TuyenBayDao();
        int chieudai = tb.findChieuDai(tuyenbay.getMaTuyenBay());
        int giave = dongia*chieudai;
        int thue = (int) ((int) giave * 0.1);
        int tongtien = giave + thue;
        chuyenbayForm.giave_txt.setText(Integer.toString(giave));
        chuyenbayForm.thue_txt.setText(Integer.toString(thue));
        chuyenbayForm.tongtien_txt.setText(Integer.toString(tongtien));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_sanbaydi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_sanbayden = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_ngaybay = new javax.swing.JTextField();
        txt_thoigianbay = new javax.swing.JTextField();
        txt_soghe = new javax.swing.JTextField();
        txt_hangghe = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cmnd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        xacnhanBtn = new javax.swing.JButton();
        huyBtn = new javax.swing.JButton();
        selectBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        giave_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        thue_txt = new javax.swing.JTextField();
        tongtien_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 211, 175));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/plane.png"))); // NOI18N
        jLabel1.setText("XÁC NHẬN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/location-pin.png"))); // NOI18N
        jLabel2.setText("SÂN BAY ĐI");

        txt_sanbaydi.setEditable(false);
        txt_sanbaydi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/destination.png"))); // NOI18N
        jLabel3.setText("SÂN BAY ĐẾN");

        txt_sanbayden.setEditable(false);
        txt_sanbayden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/chronometer.png"))); // NOI18N
        jLabel4.setText("NGÀY BAY");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/chronometer.png"))); // NOI18N
        jLabel5.setText("THỜI GIAN BAY");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/safety-seat.png"))); // NOI18N
        jLabel6.setText("SỐ GHẾ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/first-class.png"))); // NOI18N
        jLabel7.setText("HẠNG GHẾ");

        txt_ngaybay.setEditable(false);
        txt_ngaybay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_ngaybay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaybayActionPerformed(evt);
            }
        });

        txt_thoigianbay.setEditable(false);
        txt_thoigianbay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_soghe.setEditable(false);
        txt_soghe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_soghe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sogheActionPerformed(evt);
            }
        });

        txt_hangghe.setEditable(false);
        txt_hangghe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/passport (1).png"))); // NOI18N
        jLabel8.setText("CMND");

        txt_cmnd.setEditable(false);
        txt_cmnd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_cmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cmndActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/name (2).png"))); // NOI18N
        jLabel9.setText("HỌ VÀ TÊN");

        txt_hoten.setEditable(false);
        txt_hoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/contact (1).png"))); // NOI18N
        jLabel10.setText("SỐ ĐIỆN THOẠI");

        txt_sdt.setEditable(false);
        txt_sdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        xacnhanBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        xacnhanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/ok.png"))); // NOI18N
        xacnhanBtn.setText("XÁC NHẬN");
        xacnhanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacnhanBtnActionPerformed(evt);
            }
        });

        huyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        huyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/cancel.png"))); // NOI18N
        huyBtn.setText("ĐÓNG");
        huyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyBtnActionPerformed(evt);
            }
        });

        selectBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectBtn.setText("Chọn");
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/money.png"))); // NOI18N
        jLabel11.setText("GIÁ VÉ");

        giave_txt.setEditable(false);
        giave_txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/taxes.png"))); // NOI18N
        jLabel12.setText("THUẾ");

        thue_txt.setEditable(false);
        thue_txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tongtien_txt.setEditable(false);
        tongtien_txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/wallet.png"))); // NOI18N
        jLabel13.setText("TỔNG TIỀN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(xacnhanBtn)
                .addGap(84, 84, 84)
                .addComponent(huyBtn)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(selectBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_sanbaydi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_sanbayden, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ngaybay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel8)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_thoigianbay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_hangghe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(giave_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thue_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tongtien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sanbaydi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_cmnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel9))
                                        .addGap(2, 2, 2))
                                    .addComponent(txt_sanbayden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_ngaybay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_thoigianbay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(giave_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectBtn)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thue_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tongtien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hangghe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacnhanBtn)
                    .addComponent(huyBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sogheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sogheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sogheActionPerformed

    private void txt_ngaybayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaybayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaybayActionPerformed

    private void txt_cmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cmndActionPerformed

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
        // TODO add your handling code here:
        try {
        mchooseSeat = new chooseSeat(chuyenbay.getMaChuyenBay());
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(chuyenbayForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        mchooseSeat.setVisible(true);
        
        
    }//GEN-LAST:event_selectBtnActionPerformed

    private void xacnhanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacnhanBtnActionPerformed
        // TODO add your handling code here:
        if(MessageHelper.showConfirmMesage(jPanel1, "Đặt Vé", "Xác nhận")==0){
            try{
            String giatri="";
            PhieuDatCho phieudatcho = new PhieuDatCho();
            PhieuDatChoDao pdc = new PhieuDatChoDao();
            phieudatcho.setCMND(khachhang.getCMND());
            phieudatcho.setMaChuyenBay(chuyenbay.getMaChuyenBay());
            phieudatcho.setMaHangVe(txt_hangghe.getText());
            phieudatcho.setMaPhieu("VN" + (pdc.Count()+1));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date ngay = new Date();                           
            phieudatcho.setNgayDat(ngay);
            GiaVeDao gv = new GiaVeDao();
            phieudatcho.setSoGhe(chuyenbayForm.txt_soghe.getText());
            phieudatcho.setTongTien(Integer.valueOf(tongtien_txt.getText()));
            phieudatcho.setThue(Integer.valueOf(thue_txt.getText()));
            try {
            HoaDonDao tb=new HoaDonDao();
            Random random=new Random();
            do 
            {
                giatri="";
                int value=random.nextInt(100)+ 1;
                if (value<10)
                {
                    giatri="HD0"+ String.valueOf(value);
                }  
                else
                {
                    giatri="HD"+ String.valueOf(value);
                }       
            }   while(tb.FindHoaDon(giatri)!=null) ;
        } catch (Exception e) {
        }
            if (pdc.Insert(phieudatcho)==true)
                {
                    HoaDonDao hd = new HoaDonDao();
                    HoaDon hdon = new HoaDon();
                    hdon =hd.findHoaDon(khachhang.getCMND(), ngay);
                    if(hdon == null){
                        MessageHelper.showConfirmMesage(this, "Đã Lưu Phiếu đặt chỗ", "Thông báo");
                        HoaDon hoadon = new HoaDon();
                        hoadon.setCMND(khachhang.getCMND());
                        hoadon.setMaHD(giatri);
                        hoadon.setNgayLap(ngay);
                        hoadon.setTrangThai(1);
                        if(hd.Insert(hoadon)== true){
                            MessageHelper.showConfirmMesage(this, "Đã Lưu Hoá đơn thành công", "Thông báo");
                            this.dispose();
                        }
                        else {
                            MessageHelper.ErrorMesage(this, "Không Lưu Được Do Lỗi ", "Cảnh Báo");
                        }
                    }
                    else {
                        MessageHelper.showConfirmMesage(this, "Đã Lưu Phiếu đặt chỗ", "Thông báo");
                        this.dispose();
                    }
                    

                }
            else
                {
                    MessageHelper.ErrorMesage(this, "Không Lưu Được Do Lỗi ", "Cảnh Báo");
                }
            } catch (Exception e){
                e.printStackTrace();
                MessageHelper.ErrorMesage(this,e.getMessage(),"ERROR");
            }
        }
            
        
                    
    }//GEN-LAST:event_xacnhanBtnActionPerformed

    private void huyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyBtnActionPerformed
        if(MessageHelper.showConfirmMesage(jPanel1, "Thoát", "Xác nhận")==0){
        this.dispose();
        }
    }//GEN-LAST:event_huyBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chuyenbayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chuyenbayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chuyenbayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chuyenbayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chuyenbayForm().setVisible(true);
            }
        });
    }
    
//    txt_soghe.getDocument().addDocumentListener(new DocumentListener() {
//    public void changedUpdate(DocumentEvent e) {
//    doSomethingInAnotherTextfield();
//  }
//  public void doSomethingInAnotherTextfield() {
//     //whatever you have to do
//  }
//});
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField giave_txt;
    private javax.swing.JButton huyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton selectBtn;
    public static javax.swing.JTextField thue_txt;
    public static javax.swing.JTextField tongtien_txt;
    private javax.swing.JTextField txt_cmnd;
    public static javax.swing.JTextField txt_hangghe;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_ngaybay;
    private javax.swing.JTextField txt_sanbayden;
    private javax.swing.JTextField txt_sanbaydi;
    private javax.swing.JTextField txt_sdt;
    public static javax.swing.JTextField txt_soghe;
    private javax.swing.JTextField txt_thoigianbay;
    private javax.swing.JButton xacnhanBtn;
    // End of variables declaration//GEN-END:variables
}