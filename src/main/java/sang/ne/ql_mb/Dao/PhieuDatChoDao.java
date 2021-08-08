/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import sang.ne.ql_mb.entity.PhieuDatCho;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author CCLaptop.com
 */
public class PhieuDatChoDao {
    
    public boolean Insert (PhieuDatCho pdc) throws Exception{
        String sql ="INSERT INTO [dbo].[PhieuDatCho] ([MaPhieu],[NgayDat],[SoGhe],[CMND],[MaHangVe],[MaChuyenBay],[TongTien],[Thue])"
                + " VALUES(?,?,?,?,?,?,?,?)";
        Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        String sdate = formatter.format(pdc.getNgayDat());
        try (
              Connection con = DatabaseHelper.openConnection();
                PreparedStatement dtb = con.prepareStatement(sql);
            )
        {
            dtb.setString(1, pdc.getMaPhieu());
            dtb.setDate(2, java.sql.Date.valueOf(sdate));
            dtb.setString(3, pdc.getSoGhe());
            dtb.setString(4, pdc.getCMND());
            dtb.setString(5, pdc.getMaHangVe());
            dtb.setString(6, pdc.getMaChuyenBay());
            dtb.setInt(7, pdc.getTongTien());
            dtb.setInt(8, pdc.getThue());
            
            return dtb.executeUpdate()>0;
            
        }
    }
    public int Count () throws Exception{
        String sql = "SELECT COUNT(*) FROM  [dbo].[PhieuDatCho]";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement dtb = con.prepareStatement(sql);   
            )
        {
            try(ResultSet rs=dtb.executeQuery())
            {
                rs.next();
                return rs.getInt(1);
            }
        }
    }
    
    public List <PhieuDatCho> findPhieuDatCho(String CMND) throws Exception {
        String sql = "SELECT * FROM [dbo].[PhieuDatCho] WHERE CMND= ?";
        try(
             Connection con = new DatabaseHelper().openConnection();
             PreparedStatement dtb= con.prepareStatement(sql);   
            )
        {
             dtb.setString(1, CMND);
             try(ResultSet rs=dtb.executeQuery())
            {
                List<PhieuDatCho> list =new ArrayList<PhieuDatCho>();
               while(rs.next())
               {
                   PhieuDatCho phieudatcho = new PhieuDatCho();
                   phieudatcho.setMaPhieu(rs.getString("MaPhieu"));
                   phieudatcho.setNgayDat(rs.getDate("NgayDat"));
                   phieudatcho.setSoGhe(rs.getString("SoGhe"));
                   phieudatcho.setCMND(rs.getString("CMND"));
                   phieudatcho.setMaHangVe(rs.getString("CMND"));
                   phieudatcho.setMaChuyenBay(rs.getString("MaChuyenBay"));
                   phieudatcho.setTongTien(rs.getInt("TongTien"));
                   phieudatcho.setThue(rs.getInt("Thue"));
                   list.add(phieudatcho);
               }
               return list;
            }
        }
    }
    public List <PhieuDatCho> findChitietPhieuDatCho(String CMND,String Date) throws Exception {
        String sql = "SELECT * FROM [dbo].[PhieuDatCho] WHERE [CMND]=? AND [NgayDat]=?";
        try(
             Connection con = new DatabaseHelper().openConnection();
             PreparedStatement dtb= con.prepareStatement(sql);   
            )
        {
             dtb.setString(1,CMND);
             dtb.setDate(2,java.sql.Date.valueOf(Date));
             try(ResultSet rs=dtb.executeQuery())
            {
                List<PhieuDatCho> list =new ArrayList<PhieuDatCho>();
               while(rs.next())
               {
                   PhieuDatCho phieudatcho = new PhieuDatCho();
                   phieudatcho.setMaPhieu(rs.getString("MaPhieu"));
                   phieudatcho.setNgayDat(rs.getDate("NgayDat"));
                   phieudatcho.setSoGhe(rs.getString("SoGhe"));
                   phieudatcho.setCMND(rs.getString("CMND"));
                   phieudatcho.setMaHangVe(rs.getString("MaHangVe"));
                   phieudatcho.setMaChuyenBay(rs.getString("MaChuyenBay"));
                   phieudatcho.setTongTien(rs.getInt("TongTien"));
                   phieudatcho.setThue(rs.getInt("Thue"));
                   list.add(phieudatcho);
               }
               return list;
            }
        }
    }
    public List <PhieuDatCho> findALLPhieuDatCho() throws Exception {
        String sql = "SELECT * FROM [dbo].[PhieuDatCho]";
        try(
             Connection con = new DatabaseHelper().openConnection();
             PreparedStatement dtb= con.prepareStatement(sql);   
            )
        {
             try(ResultSet rs=dtb.executeQuery())
            {
                List<PhieuDatCho> list =new ArrayList<PhieuDatCho>();
               while(rs.next())
               {
                   PhieuDatCho phieudatcho = new PhieuDatCho();
                   phieudatcho.setMaPhieu(rs.getString("MaPhieu"));
                   phieudatcho.setNgayDat(rs.getDate("NgayDat"));
                   phieudatcho.setSoGhe(rs.getString("SoGhe"));
                   phieudatcho.setCMND(rs.getString("CMND"));
                   phieudatcho.setMaHangVe(rs.getString("CMND"));
                   phieudatcho.setMaChuyenBay(rs.getString("MaChuyenBay"));
                   phieudatcho.setTongTien(rs.getInt("TongTien"));
                   phieudatcho.setThue(rs.getInt("Thue"));
                   list.add(phieudatcho);
               }
               return list;
            }
        }
    }         
}
