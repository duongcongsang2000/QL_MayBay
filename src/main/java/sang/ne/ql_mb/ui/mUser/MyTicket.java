/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.ui.mUser;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import sang.ne.ql_mb.Dao.ChuyenBayDao;
import sang.ne.ql_mb.Dao.PhieuDatChoDao;
import sang.ne.ql_mb.Dao.TuyenBayDao;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.entity.PhieuDatCho;
import sang.ne.ql_mb.entity.TuyenBay;

/**
 *
 * @author CCLaptop.com
 */
public class MyTicket extends javax.swing.JPanel {

    private DefaultTableModel tblTableModel;
    /**
     * Creates new form MyTicket
     */
    public MyTicket() {
        initComponents();
    }
    
    public MyTicket(KhachHang kh){
        initComponents();
        initTable();
        LoadDataTable(kh);
    }
    
    private void initTable(){
        tblTableModel = new DefaultTableModel();
        tblTableModel.setColumnIdentifiers(new String[]{"Mã Vé","Ngày Đặt","Ngày bay","Thời Gian Bay","Sân bay đi","Sân bay đến","Số Ghế","Hạng Ghế","Tổng Tiền","Thuế"});
        tb_ChuyenBay.setModel(tblTableModel);
    }
    
    private void LoadDataTable(KhachHang kh){
        try {
            PhieuDatChoDao pdc = new PhieuDatChoDao();
            ChuyenBayDao cb = new ChuyenBayDao();
            TuyenBayDao tb = new TuyenBayDao();
            List <PhieuDatCho> list = pdc.findPhieuDatCho(kh.getCMND());
            tblTableModel.setRowCount(0);
            for (PhieuDatCho phieudatcho : list){
            ChuyenBay chuyenbay = cb.findHoaDonChuyenBay(phieudatcho.getMaChuyenBay());
            TuyenBay tuyenbay = tb.findHoaDonTuyenBay(chuyenbay.getMaTuyenBay());
            tblTableModel.addRow(new Object[]{
                phieudatcho.getMaPhieu(),phieudatcho.getNgayDat(),chuyenbay.getNgayGio(),chuyenbay.getThoiGianBay(),tuyenbay.getSanBayDi()
                    ,tuyenbay.getSanBayDen(),phieudatcho.getSoGhe(),phieudatcho.getMaHangVe(),phieudatcho.getTongTien(),phieudatcho.getThue()
            });
        }
        tblTableModel.fireTableDataChanged();     
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ChuyenBay = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/profile.png"))); // NOI18N
        jLabel1.setText("VÉ CỦA TÔI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tb_ChuyenBay.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_ChuyenBay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_ChuyenBay;
    // End of variables declaration//GEN-END:variables
}
