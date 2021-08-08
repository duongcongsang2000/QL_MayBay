/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sang.ne.ql_mb.entity.HoaDon;
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.entity.TuyenBay;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author Yahiko
 */
public class HoaDonDao {
    public HoaDon FindHoaDon(String value) throws Exception{
        String sql="SELECT * FROM [dbo].[HoaDon] WHERE [MaHD]=? AND [TrangThai]=1";
       
            try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,value);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next())
            {
                HoaDon tb=new HoaDon();
                tb.setMaHD(rs.getString("MaHD"));
                tb.setCMND(rs.getString("CMND"));
                tb.setNgayLap(rs.getDate("NgayLap"));
                tb.setThanhTien(rs.getInt("ThanhTien"));
                tb.setTrangThai(rs.getInt("TrangThai"));
                return tb;
            }    
            }
            }
        
        return null;
}
    
    public int Count() throws Exception{
        String sql = "SELECT COUNT(MaHD) FROM  [dbo].[HoaDon] Where [TrangThai]=?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement dtb = con.prepareStatement(sql);   
            )
        {
            dtb.setInt(1,1);
            try(ResultSet rs=dtb.executeQuery())
            {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public List<HoaDon> findallHoaDon() throws Exception {
        String sql = "SELECT * FROM [dbo].[HoaDon] Where [TrangThai]=? ORDER BY NgayLap";
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        //String sdate = formatter.format(Ngaykh);
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            //dtb.setDate(1,java.sql.Date.valueOf(sdate));
            dtb.setInt(1,1);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<HoaDon> list =new ArrayList<HoaDon>();
               while(rs.next())
                {
                    HoaDon tb= new HoaDon();
                    tb.setMaHD(rs.getString("MaHD"));
                    tb.setCMND(rs.getString("CMND"));
                    tb.setNgayLap(rs.getDate("NgayLap"));
                    tb.setThanhTien(rs.getInt("ThanhTien"));
                    tb.setTrangThai(rs.getInt("TrangThai"));
                    list.add(tb); 
                }
               return list;
            }
            
        }
       
    }
    
    public boolean Insert(HoaDon hd) throws Exception{
        String sql="INSERT INTO [dbo].[HoaDon]([MaHD],[NgayLap],[ThanhTien],[CMND],[TrangThai]) VALUES(?,?,?,?,?)";
        java.sql.Date sqldate = new java.sql.Date(hd.getNgayLap().getTime()); 
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, hd.getMaHD());
            dtb.setDate(2, sqldate);
            dtb.setInt(3,hd.getThanhTien());
            dtb.setString(4, hd.getCMND());
            dtb.setInt(5,1);
            return dtb.executeUpdate()>0;
        }
    }
    
    public HoaDon findHoaDon (String value,Date date) throws Exception{
        String sql = "SELECT * FROM [dbo].[HoaDon] WHERE [CMND]=? AND [NgayLap]=? AND [TrangThai]=?";
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        try(
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);      
            )
        {
            dtb.setString(1,value);
            dtb.setDate(2, sqldate);
            dtb.setInt(3,1);
            try(ResultSet rs=dtb.executeQuery())
            {
                if(rs.next()){
                HoaDon tb=new HoaDon();
                tb.setMaHD(rs.getString("MaHD"));
                tb.setCMND(rs.getString("CMND"));
                tb.setNgayLap(rs.getDate("NgayLap"));
                tb.setThanhTien(rs.getInt("ThanhTien"));
                tb.setTrangThai(rs.getInt("TrangThai"));
                return tb;
            }
            
        }
        return null;
        
     }
    
    }
    public HoaDon findHoaDonbyCMND (String value) throws Exception{
        String sql = "SELECT * FROM [dbo].[HoaDon] WHERE [CMND]=?  AND [TrangThai]=?";
        try(
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);      
            )
        {
            dtb.setString(1,value);
            dtb.setInt(2,1);
            try(ResultSet rs=dtb.executeQuery())
            {
                if(rs.next()){
                HoaDon tb=new HoaDon();
                tb.setMaHD(rs.getString("MaHD"));
                tb.setCMND(rs.getString("CMND"));
                tb.setNgayLap(rs.getDate("NgayLap"));
                tb.setThanhTien(rs.getInt("ThanhTien"));
                tb.setTrangThai(rs.getInt("TrangThai"));
                return tb;
            }
            
        }
        return null;
        
     }
    
    }
}
