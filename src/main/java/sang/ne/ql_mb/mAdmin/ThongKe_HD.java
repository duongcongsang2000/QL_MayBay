/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.mAdmin;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import sang.ne.ql_mb.Dao.ChuyenBayDao;
import sang.ne.ql_mb.Dao.HoaDonDao;
import sang.ne.ql_mb.Dao.KhachHangDao;
import sang.ne.ql_mb.Dao.PhieuDatChoDao;
import sang.ne.ql_mb.Dao.SanBayDao;
import sang.ne.ql_mb.Dao.TuyenBayDao;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.entity.HoaDon;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.entity.PhieuDatCho;
import sang.ne.ql_mb.entity.SanBay;
import sang.ne.ql_mb.entity.TuyenBay;
import sang.ne.ql_mb.help.MessageHelper;

/**
 *
 * @author Yahiko
 */
public class ThongKe_HD extends javax.swing.JPanel {
    private DefaultTableModel tblTableModel;
    private MainFrameAdmin parentForm; 
    int sophieu=0;
    int tongtien=0;
    int i=0;
    String[] arr=new String[100];
    String NOIDI,DIEMDEN;
    Date NGAYKH,Ngaydi,NgayDen,tg;
    SimpleDateFormat stf= new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat stf2= new SimpleDateFormat("yyyy-MM-dd");
    String date1="2021-01-01";
    /**
     * Creates new form ThongKe_HD
     */
    public ThongKe_HD() {
        initComponents();
        initTable();
        LoadTable();
        i=0;
        cb_noikh.removeAllItems();
        cb_diemden.removeAllItems();
        try {
           
            SanBayDao sanbay = new SanBayDao();
            List< SanBay > list = sanbay.FindAllSanBay();
            for (SanBay cb : list){
               arr[i]=cb.getTinhThanh(); 
               i++;
               }             
         } catch (Exception e) {
         }
          for (int j = 0; j<i; j++) {
                    cb_noikh.addItem(arr[j]);
                    cb_diemden.addItem(arr[j]);
             }   
        Date date=new Date();
        txt_ngaykh.setDate(date);
        try {
          tg=stf.parse(date1);  
        } catch (Exception e) {
        }
        txt_tungay.setDate(tg);
        txt_denngay.setDate(date);
    }
    public void initTable(){
        tblTableModel = new DefaultTableModel();
        JScrollPane jsp=new JScrollPane();
        tbl_thongke.add(jsp,BorderLayout.CENTER);
        tblTableModel.setColumnIdentifiers(new String[]{"CMND","Khách Hàng","SĐT","Giới Tính"
                ,"Ngày Đặt Vé","Ngày Bay","Thời Gian Bay","Nơi Đi","Điểm Đến","Số Ghế","Thành Tiền"});
        tbl_thongke.setModel(tblTableModel);
    }
    public void LoadTable(){
        try {
            tongtien=0;
            sophieu=0;
            PhieuDatChoDao HD=new PhieuDatChoDao();
            List<PhieuDatCho> list=HD.findALLPhieuDatCho();
            tblTableModel.setRowCount(0);
           for(PhieuDatCho sb :list)
           {
               String gioitinh="";
               KhachHangDao KH=new KhachHangDao();
               KhachHang KH1=KH.FindKhachHang(sb.getCMND());
               ChuyenBayDao CB=new ChuyenBayDao();
               ChuyenBay sb3=CB.findHoaDonChuyenBay(sb.getMaChuyenBay());
               TuyenBayDao TB=new TuyenBayDao();
               TuyenBay sb2=TB.findHoaDonTuyenBay(sb3.getMaTuyenBay());
               if (KH1.getGIOITINH()==1) gioitinh="Nam";
                       else gioitinh="Nữ";
               tblTableModel.addRow(new Object[]{
                   sb.getCMND(),KH1.getTENKH(),KH1.getSDT(),gioitinh,sb.getNgayDat(),sb3.getNgayGio()
                       ,sb3.getThoiGianBay(),sb2.getSanBayDi(),sb2.getSanBayDen(),sb.getSoGhe(),sb.getTongTien()});
                tongtien=tongtien+sb.getTongTien();
                sophieu++;
           tblTableModel.fireTableDataChanged(); }
            txt_sophieu.setText(String.valueOf(sophieu));
            txt_tongtien.setText(String.valueOf(tongtien));
           }
        catch (Exception e) {
        }
    }
    public void LoadTable2(String noidi,String DiemDen,Date NgayKH){
        try {
            tongtien=0;
            sophieu=0;
            String ngayne=stf.format(NGAYKH);
            PhieuDatChoDao HD=new PhieuDatChoDao();
            List<PhieuDatCho> list=HD.findALLPhieuDatCho();
            tblTableModel.setRowCount(0);
           for(PhieuDatCho sb :list)
           {
               String gioitinh="";
               KhachHangDao KH=new KhachHangDao();
               KhachHang KH1=KH.FindKhachHang(sb.getCMND());
               ChuyenBayDao CB=new ChuyenBayDao();
               ChuyenBay sb3=CB.findHoaDonChuyenBay(sb.getMaChuyenBay());
               TuyenBayDao TB=new TuyenBayDao();
               TuyenBay sb2=TB.findHoaDonTuyenBay(sb3.getMaTuyenBay());
               String ngayne2=stf.format(sb3.getNgayGio());
               Date ngayne3=stf2.parse(ngayne2);
               if (KH1.getGIOITINH()==1) gioitinh="Nam";
                       else gioitinh="Nữ";
               //&&(sb3.getNgayGio().equals(NgayKH))
               if ((sb2.getSanBayDi().equals(noidi)) && (sb2.getSanBayDen().equals(DiemDen))&& (ngayne.equals(ngayne2)))
               {    
               tblTableModel.addRow(new Object[]{
                   sb.getCMND(),KH1.getTENKH(),KH1.getSDT(),gioitinh,sb.getNgayDat(),ngayne2
                       ,sb3.getThoiGianBay(),sb2.getSanBayDi(),sb2.getSanBayDen(),sb.getSoGhe(),sb.getTongTien()});
               tongtien=tongtien+sb.getTongTien();
               sophieu++;
               }
           tblTableModel.fireTableDataChanged(); }
            txt_sophieu.setText(String.valueOf(sophieu));
            txt_tongtien.setText(String.valueOf(tongtien));
           }
        catch (Exception e) {
        }
        
    }
    public void LoadTable3(Date tungay,Date denngay){
        try {
            tongtien=0;
            sophieu=0;
            String tungay1=stf.format(tungay);
            String denngay1=stf.format(denngay);
            PhieuDatChoDao HD=new PhieuDatChoDao();
            List<PhieuDatCho> list=HD.findALLPhieuDatCho();
            tblTableModel.setRowCount(0);
           for(PhieuDatCho sb :list)
           {
               String gioitinh="";
               KhachHangDao KH=new KhachHangDao();
               KhachHang KH1=KH.FindKhachHang(sb.getCMND());
               ChuyenBayDao CB=new ChuyenBayDao();
               ChuyenBay sb3=CB.findHoaDonChuyenBay(sb.getMaChuyenBay());
               TuyenBayDao TB=new TuyenBayDao();
               TuyenBay sb2=TB.findHoaDonTuyenBay(sb3.getMaTuyenBay());
               String ngayne=stf.format(sb3.getNgayGio());
               if (KH1.getGIOITINH()==1) gioitinh="Nam";
                       else gioitinh="Nữ";
               //&&(sb3.getNgayGio().equals(NgayKH))
               if ((sb.getNgayDat().compareTo(tungay)>=0)&&((sb.getNgayDat().compareTo(denngay))<0))
               {    
               tblTableModel.addRow(new Object[]{
                   sb.getCMND(),KH1.getTENKH(),KH1.getSDT(),gioitinh,sb.getNgayDat(),ngayne
                       ,sb3.getThoiGianBay(),sb2.getSanBayDi(),sb2.getSanBayDen(),sb.getSoGhe(),sb.getTongTien()});
               sophieu++;
               tongtien=tongtien+sb.getTongTien();
               }
           tblTableModel.fireTableDataChanged(); }
            txt_sophieu.setText(String.valueOf(sophieu));
            txt_tongtien.setText(String.valueOf(tongtien));
           }
        catch (Exception e) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongke = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        txt_ngaykh = new com.toedter.calendar.JDateChooser();
        cb_noikh = new javax.swing.JComboBox<>();
        cb_diemden = new javax.swing.JComboBox<>();
        txt_tungay = new com.toedter.calendar.JDateChooser();
        txt_denngay = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_statistic = new javax.swing.JButton();
        txt_sophieu = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();

        tbl_thongke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_thongke);

        jLabel1.setText("Ngày Khởi Hành");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Flight/start-up.png"))); // NOI18N
        jLabel2.setText("Nơi Khởi Hành");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Flight/travel.png"))); // NOI18N
        jLabel3.setText("Điểm Đến");

        btn_search.setText("Tìm Kiếm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        txt_ngaykh.setDateFormatString("dd-MM-yyyy");

        cb_noikh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_diemden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_tungay.setDateFormatString("dd-MM-yyyy");

        txt_denngay.setDateFormatString("dd-MM-yyyy");

        jLabel4.setText("Từ Ngày");

        jLabel5.setText("Đến Ngày");

        btn_statistic.setText("Thống Kê");
        btn_statistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statisticActionPerformed(evt);
            }
        });

        jLabel6.setText("Số Phiếu");

        jLabel7.setText("Tổng Tiền");

        jLabel8.setText("Ngày Đặt:");

        btn_new.setText("Làm Mới");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txt_sophieu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_noikh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_diemden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ngaykh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_denngay, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tungay, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(btn_statistic)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_tungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cb_noikh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addComponent(txt_ngaykh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_search))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addComponent(txt_denngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_diemden)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_statistic)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btn_new)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sophieu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
           NOIDI=cb_noikh.getSelectedItem().toString();
           DIEMDEN=cb_diemden.getSelectedItem().toString();   
           NGAYKH=txt_ngaykh.getDate();
           LoadTable2(NOIDI, DIEMDEN, NGAYKH);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_statisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statisticActionPerformed
           Date Ngaydi1=txt_tungay.getDate();
           Date NgayDen1=txt_denngay.getDate();
           Ngaydi=new Date(Ngaydi1.getTime());
           NgayDen=new Date(NgayDen1.getTime());
           if ((Ngaydi.compareTo(NgayDen)>0)) {
             MessageHelper.ErrorMesage(parentForm,"Từ Ngày khởi hành phải nhỏ Hơn Đến Ngày khởi hành","Thông Báo");
             return;
        } else {
                LoadTable3(Ngaydi, NgayDen);
        }
              
    }//GEN-LAST:event_btn_statisticActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        LoadTable();
                
    }//GEN-LAST:event_btn_newActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_statistic;
    private javax.swing.JComboBox<String> cb_diemden;
    private javax.swing.JComboBox<String> cb_noikh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_thongke;
    private com.toedter.calendar.JDateChooser txt_denngay;
    private com.toedter.calendar.JDateChooser txt_ngaykh;
    private javax.swing.JTextField txt_sophieu;
    private javax.swing.JTextField txt_tongtien;
    private com.toedter.calendar.JDateChooser txt_tungay;
    // End of variables declaration//GEN-END:variables
}
