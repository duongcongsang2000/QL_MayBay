/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.mAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import sang.ne.ql_mb.Dao.BCrypt;
import sang.ne.ql_mb.Dao.KhachHangDao;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.help.DataValidator;
import sang.ne.ql_mb.help.MessageHelper;
import sang.ne.ql_mb.Dao.Check;

/**
 *
 * @author Yahiko
 */
public class Customer_Manager extends javax.swing.JPanel {
    private MainFrameAdmin parentForm; 
    private DefaultTableModel tblTableModell;
    /**
     * Creates new form Customer_Manager
     */
    public Customer_Manager() {
        initComponents();
        initTable();
        LoadDataTable();
    }
    public void initTable(){
        tblTableModell = new DefaultTableModel();
        JScrollPane pane=new JScrollPane();
        table_customer.add(pane,BorderLayout.CENTER);
        tblTableModell.setColumnIdentifiers(new String[]{"CMND","Họ Và Tên","SĐT","UserName","Giới Tính","Email"});
        table_customer.setModel(tblTableModell);
        //table_customer.setFont(new java.awt.Font("Times New Roman", 3, 14));
        table_customer.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        //rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        //table_customer.getTableHeader().setDefaultRenderer(rightRenderer);
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        table_customer.setDefaultRenderer(Object.class,rightRenderer);
    }
    private void LoadDataTable(){
        
        try {
           KhachHangDao khachhang=new KhachHangDao();
           List <KhachHang> list=khachhang.FindAllKhachHang();
           tblTableModell.setRowCount(0);
           String gioitinh;
           for(KhachHang sb :list){
               if (sb.getGIOITINH()==1) {
                   gioitinh="Nam";
               }
               else 
                   gioitinh="Nữ";
               tblTableModell.addRow(new Object[]{
                   sb.getCMND(),sb.getTENKH(),sb.getSDT(),sb.getUsername(),gioitinh,sb.getEmail()});
           }
           tblTableModell.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    private void LoadDataTable2(){
        String id="",id1="";
        int choose=1;
         if (!find_cmnd.getText().equals("")) {
                    id=find_cmnd.getText();
                    choose=1;
                   
                }
                else
                if (!find_hovaten.getText().equals("")) {
                    id=find_hovaten.getText();
                    choose=2;
                     if (!find_sdt.getText().equals("")) 
                        {
                            id1=find_sdt.getText();
                            choose=5;
                        }
                }
                else 
                    if (!find_sdt.getText().equals("")) 
                        {
                            id=find_sdt.getText();
                            choose=3;
                            if (!find_username.getText().equals(""))
                            {   
                                id1=find_username.getText();
                                choose=6;
                            }
                }
                else 
                    if(!find_username.getText().equals(""))    
                    {
                        id=find_username.getText();
                        choose=4;
                        if (!find_hovaten.getText().equals(""))
                            {
                                id1=find_hovaten.getText();
                                choose=7;
                             }
                        
                    }
        try {
               
           KhachHangDao khachhang=new KhachHangDao();
           if (choose<=4)
           {
            List <KhachHang> list=khachhang.FindKhachHang2(id,choose);
           tblTableModell.setRowCount(0);
           String gioitinh;
           for(KhachHang sb :list){
               if (sb.getGIOITINH()==1) {
                   gioitinh="Nam";
                }
               else 
                    gioitinh="Nữ";
                    tblTableModell.addRow(new Object[]{
                    sb.getCMND(),sb.getTENKH(),sb.getSDT(),sb.getUsername(),gioitinh,sb.getEmail()});
                 }
                tblTableModell.fireTableDataChanged();
           }
           else
           {
//               id=find_cmnd.getText();
//               id1=find_hovaten.getText();
               List <KhachHang> list=khachhang.FindKhachHang3(id,id1,choose);
           tblTableModell.setRowCount(0);
           String gioitinh;
           for(KhachHang sb :list){
               if (sb.getGIOITINH()==1) {
                   gioitinh="Nam";
               }
               else 
                   gioitinh="Nữ";
               tblTableModell.addRow(new Object[]{
                   sb.getCMND(),sb.getTENKH(),sb.getSDT(),sb.getUsername(),gioitinh,sb.getEmail()});
           }
                tblTableModell.fireTableDataChanged();
           }
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

        rbd_Male = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdb_gioitinh = new javax.swing.JLabel();
        txt_CMND = new javax.swing.JTextField();
        txt_TENKH = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        find_cmnd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        find_hovaten = new javax.swing.JTextField();
        find_sdt = new javax.swing.JTextField();
        find_username = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        rdb_Male = new javax.swing.JRadioButton();
        rdb_female = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(247, 246, 246));
        setPreferredSize(new java.awt.Dimension(999, 566));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/id-card.png"))); // NOI18N
        jLabel2.setText(" CMND");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/user-data_32.png"))); // NOI18N
        jLabel3.setText(" Họ Và Tên");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/phone.png"))); // NOI18N
        jLabel4.setText(" SĐT");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/User12.png"))); // NOI18N
        jLabel5.setText(" Username");

        rdb_gioitinh.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdb_gioitinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/male-female.png"))); // NOI18N
        rdb_gioitinh.setText("   Giới Tính");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/id-card.png"))); // NOI18N
        jLabel1.setText(" CMND");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/user-data_32.png"))); // NOI18N
        jLabel6.setText(" Họ Và Tên");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/phone.png"))); // NOI18N
        jLabel7.setText(" SĐT");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/User12.png"))); // NOI18N
        jLabel8.setText(" UserName");

        find_hovaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_hovatenActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/search.png"))); // NOI18N
        btn_search.setText("Tìm Kiếm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(find_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(find_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(find_username, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(find_hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_search)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(find_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(find_hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(find_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(find_username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rbd_Male.add(rdb_Male);
        rdb_Male.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdb_Male.setText("Nam");

        rbd_Male.add(rdb_female);
        rdb_female.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdb_female.setText("Nữ");

        table_customer.setBackground(new java.awt.Color(214, 224, 223));
        table_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "USERNAME", "TÊN KHÁCH HÀNG", "CMND", "SĐT", "GIỚI TÍNH", "GHI CHÚ"
            }
        ));
        table_customer.setPreferredSize(new java.awt.Dimension(999, 566));
        table_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_customer);

        btn_add.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/new.png"))); // NOI18N
        btn_add.setText("Tạo Mới");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/delete.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/edit.png"))); // NOI18N
        btn_edit.setText("Cập Nhật");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Account/add.png"))); // NOI18N
        btn_save.setText("Thêm");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Flight/chimluonnho.gif"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/Flight/planenho.gif"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sang/ne/ql_mb/icon/gmail.png"))); // NOI18N
        jLabel11.setText("    Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_edit)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdb_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_CMND)
                                    .addComponent(txt_username)
                                    .addComponent(txt_SDT)
                                    .addComponent(txt_TENKH)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(rdb_Male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdb_female, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)))))
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_TENKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_username))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdb_Male)
                                    .addComponent(rdb_female)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdb_gioitinh)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        StringBuilder sb=new StringBuilder();
        DataValidator.validateEmpty(txt_TENKH, sb, "TENKH không được để trống");
        DataValidator.validateEmpty(txt_SDT, sb, "SDT không được để trống");
        DataValidator.validateEmpty(txt_email, sb, "Email không được để trống");
        if (sb.length()>0) {
            MessageHelper.ErrorMesage(parentForm, sb.toString(), "ERROR");
            return;
        }
        String sdt=txt_SDT.getText();
        if (Check.CheckSDT(sdt)==false) 
        {
            MessageHelper.ErrorMesage(parentForm,"Số Điện Thoại Không Hợp Lệ\n"+"Vui Lòng Kiểm Tra Lại","Lỗi");
            return;
        }
        try {
            KhachHang KH=new KhachHang();
            KH.setCMND(txt_CMND.getText());
            KH.setTENKH(txt_TENKH.getText());
           // KH.setSDT(Integer.parseInt(txt_SDT.getText()));
            KH.setSDT(txt_SDT.getText());
            KH.setUsername(txt_username.getText());
            KH.setGIOITINH(rdb_Male.isSelected()?1 :0);
            KH.setEmail(txt_email.getText());
            
            KhachHangDao dao= new KhachHangDao();
            if (dao.Update(KH)==true) // Lệnh Insert để lưu 
            {
                MessageHelper.showConfirmMesage(parentForm, "Đã Cập Nhật", "Thông báo");
                LoadDataTable();
            }
            else {
                MessageHelper.ErrorMesage(parentForm, "Không Cập Nhật Được", "Cảnh Báo");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.ErrorMesage(parentForm,e.getMessage(),"ERROR");
        }
                                                
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
            txt_CMND.setText("");
            txt_TENKH.setText("");
            txt_SDT.setText("");
            txt_username.setText("");
            txt_email.setText("");
            txt_CMND.setBackground(Color.WHITE);
            txt_TENKH.setBackground(Color.WHITE);
            txt_SDT.setBackground(Color.WHITE);
            txt_username.setBackground(Color.WHITE);
            txt_email.setBackground(Color.WHITE);
            LoadDataTable();
    }//GEN-LAST:event_btn_addActionPerformed
    
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        StringBuilder sb=new StringBuilder();
        DataValidator.validateEmpty(txt_CMND, sb, "CMND không được để trống");
        DataValidator.validateEmpty(txt_TENKH, sb, "Tên Khách Hàng không được để trống");
        DataValidator.validateEmpty(txt_SDT, sb, "SDT không được để trống");
        DataValidator.validateEmpty(txt_username, sb, "UserName không được để trống");
        DataValidator.validateEmpty(txt_email, sb, "Email không được để trống");
        if (sb.length()>0) {
            MessageHelper.ErrorMesage(parentForm, sb.toString(), "ERROR");
            return;
        }
        String sdt=txt_SDT.getText();
        if (Check.CheckSDT(sdt)==false) 
        {
            MessageHelper.ErrorMesage(parentForm,"Số Điện Thoại Không Hợp Lệ\n"+"Vui Lòng Kiểm Tra Lại","Lỗi");
            return;
        }
       KhachHangDao KK=new KhachHangDao();
       KhachHang KK1=new KhachHang();
       KhachHang KK2=new KhachHang();
        try {
            KK1=KK.FindKhachHang(txt_CMND.getText());
            KK2=KK.FindUserName(txt_username.getText());
        } catch (Exception e) {
        }
       if (KK1!=null)
       {
            MessageHelper.ErrorMesage(parentForm,"CMND đã Tồn Tại\n"+"Vui Lòng Kiểm Tra Lại","Lỗi");
            return;
       }
       if (KK2!=null)
       {
            MessageHelper.ErrorMesage(parentForm,"Username đã Tồn Tại\n"+"Vui Lòng Kiểm Tra Lại","Lỗi");
            return;
       }
        try {
            KhachHang KH=new KhachHang();
            KH.setCMND(txt_CMND.getText());
            KH.setTENKH(txt_TENKH.getText());
           // KH.setSDT(Integer.parseInt(txt_SDT.getText()));
            KH.setSDT(txt_SDT.getText());
            KH.setUsername(txt_username.getText());
            KH.setGIOITINH(rdb_Male.isSelected()?1 :0);
            KH.setEmail(txt_email.getText());
            String salt = BCrypt.gensalt(4);
            String hash = BCrypt.hashpw("123", salt);
            KH.setPassword(hash);
            
            KhachHangDao dao= new KhachHangDao();
            if (dao.Insert(KH)==true) // Lệnh Insert để lưu 
            {
                MessageHelper.showConfirmMesage(parentForm, "Đã Lưu", "Thông báo");
                LoadDataTable();
            }
            else {
                MessageHelper.ErrorMesage(parentForm, "Không Lưu Được", "Cảnh Báo");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.ErrorMesage(parentForm,e.getMessage(),"ERROR");
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void table_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customerMouseClicked
       try {
            int row=table_customer.getSelectedRow();
            if (row>=0) 
            {
                String id=(String) tblTableModell.getValueAt(row,0);
                KhachHangDao sb=new KhachHangDao();
                KhachHang khachhang=sb.FindKhachHang(id);
                if (khachhang!=null) {
                    txt_CMND.setText(khachhang.getCMND());
                    txt_TENKH.setText(khachhang.getTENKH());
                    txt_username.setText(khachhang.getUsername());
                    txt_SDT.setText(khachhang.getSDT());
                    rdb_Male.setSelected(khachhang.getGIOITINH()==1? Boolean.TRUE:Boolean.FALSE);
                    rdb_female.setSelected(khachhang.getGIOITINH()==0? Boolean.TRUE:Boolean.FALSE);
                    txt_email.setText(khachhang.getEmail());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.ErrorMesage(parentForm,"Lỗi","Lỗi");
        }
    }//GEN-LAST:event_table_customerMouseClicked

    private void find_hovatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_hovatenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_find_hovatenActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        LoadDataTable2();
       
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here: 
        StringBuilder sb=new StringBuilder();
        //DataValidator.validateEmpty(txt_CMND, sb, "Mã Khách Hàng Không Được Để Trống ");
        if (sb.length()>0) {
            MessageHelper.ErrorMesage(parentForm, sb.toString(), "ERROR");
            return;
        }
        if (MessageHelper.showConfirmMesage(parentForm, "Bạn Có muốn Xóa không ","Thông Báo") 
                == JOptionPane.NO_OPTION)
        {
            return;
        }
        try {
            KhachHang KH=new KhachHang();
            KH.setCMND(txt_CMND.getText());
            KH.setTENKH(txt_TENKH.getText());
           // KH.setSDT(Integer.parseInt(txt_SDT.getText()));
            KH.setSDT(txt_SDT.getText());
            KH.setUsername(txt_username.getText());
            KH.setGIOITINH(rdb_Male.isSelected()?1 :0);
            KH.setEmail(txt_email.getText());
            KH.setTrangThai(1);
            KhachHangDao dao=new KhachHangDao();
            if (dao.Update(KH)==true)
            {
                MessageHelper.ErrorMesage(parentForm, "Đã Xóa ", "Cảnh Báo");
                LoadDataTable();
            }     
            else 
            {
                MessageHelper.showConfirmMesage(parentForm, "Không Xóa Được", "Thông báo");
            }
        }catch (Exception e) {
             e.printStackTrace();
            MessageHelper.ErrorMesage(parentForm,e.getMessage(),"ERROR");
        }                                    
    }//GEN-LAST:event_btn_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JTextField find_cmnd;
    private javax.swing.JTextField find_hovaten;
    private javax.swing.JTextField find_sdt;
    private javax.swing.JTextField find_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup rbd_Male;
    private javax.swing.JRadioButton rdb_Male;
    private javax.swing.JRadioButton rdb_female;
    private javax.swing.JLabel rdb_gioitinh;
    private javax.swing.JTable table_customer;
    private javax.swing.JTextField txt_CMND;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TENKH;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
