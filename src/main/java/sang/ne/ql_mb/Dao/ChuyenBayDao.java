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
import java.util.Date;
import java.util.List;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author Yahiko
 */
public class ChuyenBayDao {
    public List< ChuyenBay > findChuyenBay(Date Ngaykh) throws Exception {
        String sql = "SELECT * FROM [dbo].[ChuyenBay] Where NgayGio= ? AND TrangThai=?";
        //java.sql.Date sqldate = new java.sql.Date (Ngaykh.getTime());
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        //String sdate = formatter.format(Ngaykh);
        java.sql.Date sqldate = new java.sql.Date(Ngaykh.getTime()) ;
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            //dtb.setDate(1,java.sql.Date.valueOf(sdate));
            dtb.setDate(1, sqldate);
            dtb.setInt(2, 0);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<ChuyenBay> list =new ArrayList<ChuyenBay>();
               while(rs.next())
                {
                    ChuyenBay cb = new ChuyenBay();
                    cb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                    cb.setNgayGio(rs.getDate("NgayGio"));
                    cb.setThoiGianBay(rs.getString("ThoiGianBay"));
                    cb.setSoGheTrong(rs.getInt("SoGheTrong"));
                    cb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    cb.setMaChiTietChuyenBay(rs.getString("MaChiTietChuyenBay"));
                    list.add(cb); 
                }
               return list;
            }
            
        }
       
    }
    public ChuyenBay find1ChuyenBay(String value) throws Exception{
        String sql="SELECT * FROM [dbo].[ChuyenBay] WHERE [MaChuyenBay]=? and TrangThai=?";
       
            try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,value);
                dtb.setInt(2, 0);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next()){
                    ChuyenBay cb = new ChuyenBay();
                    cb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                    cb.setNgayGio(rs.getDate("NgayGio"));
                    cb.setThoiGianBay(rs.getString("ThoiGianBay"));
                    cb.setSoGheTrong(rs.getInt("SoGheTrong"));
                    cb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    cb.setMaChiTietChuyenBay(rs.getString("MaChiTietChuyenBay"));
                    return cb;
                }
            }
            }
            return null;
    }
    public ChuyenBay findHoaDonChuyenBay(String value) throws Exception{
        String sql="SELECT * FROM [dbo].[ChuyenBay] WHERE [MaChuyenBay]=?";
       
            try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,value);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next()){
                    ChuyenBay cb = new ChuyenBay();
                    cb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                    cb.setNgayGio(rs.getDate("NgayGio"));
                    cb.setThoiGianBay(rs.getString("ThoiGianBay"));
                    cb.setSoGheTrong(rs.getInt("SoGheTrong"));
                    cb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    cb.setMaChiTietChuyenBay(rs.getString("MaChiTietChuyenBay"));
                    return cb;
                }
            }
            }
            return null;
    }
    public List< ChuyenBay > findChuyenBay() throws Exception {
        String sql = "SELECT * FROM [dbo].[ChuyenBay] WHERE TrangThai=? ORDER BY NgayGio, ThoiGianBay";
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        //String sdate = formatter.format(Ngaykh);
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setInt(1, 0);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<ChuyenBay> list =new ArrayList<ChuyenBay>();
               while(rs.next())
                {
                    ChuyenBay cb = new ChuyenBay();
                    cb.setMaChuyenBay(rs.getString("MaChuyenBay"));
                    cb.setNgayGio(rs.getDate("NgayGio"));
                    cb.setThoiGianBay(rs.getString("ThoiGianBay"));
                    cb.setSoGheTrong(rs.getInt("SoGheTrong"));
                    cb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    cb.setMaChiTietChuyenBay(rs.getString("MaChiTietChuyenBay"));
                    list.add(cb); 
                }
               return list;
            }
            
        }
       
    }
     public boolean Insert(ChuyenBay CB) throws Exception{
        String sql="INSERT INTO [dbo].[ChuyenBay]([MaChuyenBay],[NgayGio],[ThoiGianBay],[SoGheTrong],[MaTuyenBay],[MaChiTietChuyenBay],[TrangThai])" +
                " VALUES(?,?,?,?,?,?,?)";
         java.sql.Date sqldate = new java.sql.Date(CB.getNgayGio().getTime()) ;
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, CB.getMaChuyenBay());
            dtb.setDate(2,sqldate);
            dtb.setString(3,CB.getThoiGianBay());
            dtb.setInt(4,CB.getSoGheTrong());
            dtb.setString(5,CB.getMaTuyenBay());
            dtb.setString(6,CB.getMaChiTietChuyenBay());
            dtb.setInt(7,0);
            return dtb.executeUpdate()>0;
        }  
    
}
     public boolean Update(ChuyenBay CB) throws  Exception{
    String sql="UPDATE [dbo].[ChuyenBay] "+
            " SET [NgayGio]=?,[ThoiGianBay]=?,[SoGheTrong]=?,[MaTuyenBay]=?,[MaChiTietChuyenBay]=?,[TrangThai]=?" +
                " WHERE [MaChuyenBay]= ?";
    java.sql.Date sqldate = new java.sql.Date(CB.getNgayGio().getTime()) ;
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(7, CB.getMaChuyenBay());
            dtb.setDate(1,sqldate);
            dtb.setString(2,CB.getThoiGianBay());
            dtb.setInt(3,CB.getSoGheTrong());
            dtb.setString(4,CB.getMaTuyenBay());
            dtb.setString(5,CB.getMaChiTietChuyenBay());
            dtb.setInt(6,CB.getTrangThai());
            return dtb.executeUpdate()>0;
        }    
             
    }
public boolean Delete(ChuyenBay CB) throws  Exception {
    String sql= "DELETE [dbo].[ChuyenBay] "+
                " WHERE [MaChuyenBay]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, CB.getMaChuyenBay());
            return dtb.executeUpdate()>0;
        }    
             
    }
   
}
