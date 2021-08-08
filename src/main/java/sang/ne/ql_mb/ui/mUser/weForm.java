/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.ui.mUser;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sang.ne.ql_mb.Dao.ChuyenBayDao;
import sang.ne.ql_mb.Dao.PhieuDatChoDao;
import sang.ne.ql_mb.Dao.SanBayDao;
import sang.ne.ql_mb.Dao.TuyenBayDao;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.entity.PhieuDatCho;
import sang.ne.ql_mb.entity.SanBay;
import sang.ne.ql_mb.entity.TuyenBay;
import sang.ne.ql_mb.help.MessageHelper;


/**
 *
 * @author CCLaptop.com
 */
public class weForm extends javax.swing.JPanel {

    private DefaultTableModel tblTableModel;
    //String ngaykh;
    Date Ngaykh;
    KhachHang khachhang= new KhachHang();
    String diemKh;
    String diemDen;
    private chuyenbayForm mchuyenbayform;
    ChuyenBay chuyenbay = new ChuyenBay();
    TuyenBay tuyenbay = new TuyenBay();
    String[] arr=new String[100];
    int i;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY"); 
   
    public weForm() {
       
    }
    
    public weForm (KhachHang kh) throws Exception{
        initComponents();       
        this.khachhang = kh;
        DiemKHcbx.removeAllItems();
        DiemDencbx.removeAllItems();
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
                    DiemKHcbx.addItem(arr[j]);
                    DiemDencbx.addItem(arr[j]);
             }   
        DiemKHcbx.addItem("");
        DiemDencbx.addItem("");
        Date date = new Date(); 
        ngayKH.setDate(date);
        initTable();
        //LoadDataTableNew();
        
    }
    
    public void initTable(){
        tblTableModel = new DefaultTableModel();
        tblTableModel.setColumnIdentifiers(new String[]{"Mã Chuyến Bay","Ngày cất cánh","Thời gian bay","Sân bay đi","Sân bay đến"});
        tb_ChuyenBay.setModel(tblTableModel);
    }
    
    private void LoadDataTable(){
        try{
            ChuyenBayDao chuyenbay = new ChuyenBayDao();
            List<ChuyenBay> list = chuyenbay.findChuyenBay(Ngaykh);
            TuyenBayDao tb = new TuyenBayDao();
            TuyenBay tnbay = tb.findTuyenBay(diemKh, diemDen);
            
            this.tuyenbay= tnbay;
            
            tblTableModel.setRowCount(0);
            for (ChuyenBay cb : list){
                if(cb.getMaTuyenBay().equals(tuyenbay.getMaTuyenBay()) ){
                
                    tblTableModel.addRow(new Object[]{
                   cb.getMaChuyenBay(),cb.getNgayGio(),cb.getThoiGianBay(),tuyenbay.getSanBayDi(),tuyenbay.getSanBayDen()
               });
                
                }
            }
            
            tblTableModel.fireTableDataChanged();
            
        } catch (Exception e) {
            
        }
    }
    private void LoadDataTable2(){
        try{
            ChuyenBayDao chuyenbay = new ChuyenBayDao();
            List<ChuyenBay> list = chuyenbay.findChuyenBay();
            TuyenBayDao tb = new TuyenBayDao();
            TuyenBay tnbay = tb.findTuyenBay(diemKh, diemDen);
            
            this.tuyenbay= tnbay;
            
            tblTableModel.setRowCount(0);
            for (ChuyenBay cb : list){
                if(cb.getMaTuyenBay().equals(tuyenbay.getMaTuyenBay()) ){
                
                    tblTableModel.addRow(new Object[]{
                   cb.getMaChuyenBay(),cb.getNgayGio(),cb.getThoiGianBay(),tuyenbay.getSanBayDi(),tuyenbay.getSanBayDen()
               });
                
                }
            }
            
            tblTableModel.fireTableDataChanged();
            
        } catch (Exception e) {
            
        }
    }
     private void LoadDataTableNew(){
        try{
            ChuyenBayDao chuyenbay = new ChuyenBayDao();
            List<ChuyenBay> list = chuyenbay.findChuyenBay();
            TuyenBayDao tb = new TuyenBayDao();
            tblTableModel.setRowCount(0);
            for (ChuyenBay cb : list){
                    TuyenBay tb1=tb.findTuyenBay(cb.getMaTuyenBay());
                    tblTableModel.addRow(new Object[]{
                   cb.getMaChuyenBay(),cb.getNgayGio(),cb.getThoiGianBay(),tb1.getSanBayDi(),tb1.getSanBayDen()
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ChuyenBay = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        tieptucBtn = new javax.swing.JButton();
        DiemKHcbx = new javax.swing.JComboBox<>();
        DiemDencbx = new javax.swing.JComboBox<>();
        ngayKH = new com.toedter.calendar.JDateChooser();
        showBtn = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(471, 655));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/destination.png"))); // NOI18N
        jLabel3.setText("ĐIỂM ĐẾN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/location-pin.png"))); // NOI18N
        jLabel4.setText("ĐIỂM KHỞI HÀNH");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/chronometer.png"))); // NOI18N
        jLabel1.setText("NGÀY BAY");

        tb_ChuyenBay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Chuyến Bay", "Ngày Bay", "Thời Gian Bay", "Sân Bay Đi", "Sân Bay Đến", "Số ghế hạng 1", "Số ghế hạng 2"
            }
        ));
        tb_ChuyenBay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_ChuyenBayKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ChuyenBay);

        tieptucBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/right-arrow.png"))); // NOI18N
        tieptucBtn.setText("Tiếp tục");
        tieptucBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tieptucBtnActionPerformed(evt);
            }
        });

        DiemKHcbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DiemDencbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ngayKH.setDateFormatString("dd-MM-yyyy");

        showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/magnifying-glass.png"))); // NOI18N
        showBtn.setText("Xem");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        btn_find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/magnifying-glass.png"))); // NOI18N
        btn_find.setText("Tìm Kiếm");
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/refresh_1.png"))); // NOI18N
        btn_new.setText("Làm Mới");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(17, 17, 17)
                        .addComponent(DiemKHcbx, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(DiemDencbx, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_find)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ngayKH, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tieptucBtn)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DiemKHcbx, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DiemDencbx, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_find)
                        .addComponent(btn_new))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ngayKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showBtn))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tieptucBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tieptucBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tieptucBtnActionPerformed
        // TODO add your handling code here:
        
        try{
            int row = tb_ChuyenBay.getSelectedRow();
           if (row>=0){
                String id=(String) tblTableModel.getValueAt(row,0);
                ChuyenBayDao cb = new ChuyenBayDao();
                ChuyenBay cbay = cb.find1ChuyenBay(id);
                this.chuyenbay = cbay;
                if(chuyenbay!=null){
                       try{
                           
                            mchuyenbayform = new chuyenbayForm(khachhang, chuyenbay,tuyenbay);
                            mchuyenbayform.setVisible(true);

                        }catch (Exception e) {
                            e.printStackTrace();
                            MessageHelper.ErrorMesage(this,e.getMessage(),"ERROR");
                        }
                }
            }

        } catch (Exception E) {

        }

    }//GEN-LAST:event_tieptucBtnActionPerformed

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        // TODO add your handling code here:
        StringBuilder sb= new StringBuilder();
     SimpleDateFormat stf= new SimpleDateFormat("yyyy-MM-dd");
     Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
     //java.sql.Date sqldate = new java.sql.Date (ngayKH.getDate().getTime());
        
     
     
//       String diemKh;
//       String diemDen;
       
       diemKh=DiemKHcbx.getSelectedItem().toString();
       diemDen=DiemDencbx.getSelectedItem().toString();
       
        if (diemKh.equals(diemDen)) {
           JOptionPane.showMessageDialog(this, sb.toString(),"Nơi Đến không được trùng với Nơi đi",JOptionPane.ERROR_MESSAGE); 
            return;
        }
        Ngaykh = ngayKH.getDate();
        String sdate = formatter.format(Ngaykh);
        java.sql.Date sqldate = new java.sql.Date(Ngaykh.getTime());
        //ngaykh= stf.format(ngayKH.getDate());
        //JOptionPane.showMessageDialog(this, sqldate.toString(),sdate,JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(this, sb.toString(),diemKh,JOptionPane.ERROR_MESSAGE);
//       JOptionPane.showMessageDialog(this, sb.toString(),diemDen,JOptionPane.ERROR_MESSAGE);
       
//        //String sdate = formatter.format(ngaykh);
//        JOptionPane.showMessageDialog(this, sb.toString(),sqldate.toString(),JOptionPane.ERROR_MESSAGE);
        TuyenBayDao tb= new TuyenBayDao();
        TuyenBay tuyenbay = new TuyenBay();
        try {
            tuyenbay = tb.findTuyenBay(diemKh, diemDen);
        } catch (Exception ex) {
            Logger.getLogger(weForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       // JOptionPane.showMessageDialog(this, sb.toString(),tuyenbay.getMaTuyenBay(),JOptionPane.ERROR_MESSAGE);
        //JOptionPane.showMessageDialog(this, sb.toString(),tuyenbay.getSanBayDen(),JOptionPane.ERROR_MESSAGE);
        LoadDataTable();
    }//GEN-LAST:event_showBtnActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
       
       diemKh=DiemKHcbx.getSelectedItem().toString();
       diemDen=DiemDencbx.getSelectedItem().toString();
        if (diemKh.equals(diemDen)) {
           MessageHelper.showMesage(this, "Nơi Đến không được trùng với Nơi đi", "Lỗi");
            return;
        }
        
        LoadDataTable2();
        
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        LoadDataTableNew();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tb_ChuyenBayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ChuyenBayKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
            int row = tb_ChuyenBay.getSelectedRow();
           if (row>=0){
                String id=(String) tblTableModel.getValueAt(row,0);
                ChuyenBayDao cb = new ChuyenBayDao();
                ChuyenBay cbay = cb.find1ChuyenBay(id);
                this.chuyenbay = cbay;
                if(chuyenbay!=null){
                       try{
                           
                            mchuyenbayform = new chuyenbayForm(khachhang, chuyenbay,tuyenbay);
                            mchuyenbayform.setVisible(true);

                        }catch (Exception e) {
                            e.printStackTrace();
                            MessageHelper.ErrorMesage(this,e.getMessage(),"ERROR");
                        }
                }
            }

        } catch (Exception E) {

        }
            
            
        }
        
        
    }//GEN-LAST:event_tb_ChuyenBayKeyPressed

    private void tb_ChuyenBayMouseClicked(java.awt.event.MouseEvent evt) {                                          
        try {
            int row=tb_ChuyenBay.getSelectedRow();
            if (row>=0) 
            {
                diemKh=(String) tb_ChuyenBay.getValueAt(row,3);
                diemDen=(String) tb_ChuyenBay.getValueAt(row,4);
                TuyenBayDao tb = new TuyenBayDao();
                TuyenBay tnbay = tb.findTuyenBay(diemKh, diemDen);
                this.tuyenbay= tnbay;
            }
        } catch (Exception e) {
            
        }
    }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DiemDencbx;
    private javax.swing.JComboBox<String> DiemKHcbx;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_new;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser ngayKH;
    private javax.swing.JButton showBtn;
    private javax.swing.JTable tb_ChuyenBay;
    private javax.swing.JButton tieptucBtn;
    // End of variables declaration//GEN-END:variables

}
