/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.Dao;

/**
 *
 * @author CCLaptop.com
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sang.ne.ql_mb.entity.TuyenBay;
import sang.ne.ql_mb.help.DatabaseHelper;

public class TuyenBayDao {
    public TuyenBay findTuyenBay(String SanBayDi, String SanBayDen) throws Exception{
        String sql = "SELECT * FROM [dbo].[TuyenBay] WHERE SanBayDi=? AND SanBayDen =? AND TrangThai=?";
         try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,SanBayDi);
            dtb.setString(2, SanBayDen);
            dtb.setInt(3, 0);
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next()){
                TuyenBay tb= new TuyenBay();
                tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                tb.setSanBayDen(rs.getString("SanBayDen"));
                tb.setSanBayDi(rs.getString("SanBayDi"));
                tb.setMaSanBay(rs.getString("MaSanBay"));
                tb.setChieudai(rs.getInt("Chieudai"));
                return tb;
            }
    }
    return null;
}
    }
    public TuyenBay findTuyenBay(String MaTuyenBay) throws Exception{
        String sql = "SELECT * FROM [dbo].[TuyenBay] WHERE MaTuyenBay=? AND TrangThai=?";
         try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,MaTuyenBay);
            dtb.setInt(2,0);
            
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next()){
                TuyenBay tb= new TuyenBay();
                tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                tb.setSanBayDen(rs.getString("SanBayDen"));
                tb.setSanBayDi(rs.getString("SanBayDi"));
                tb.setMaSanBay(rs.getString("MaSanBay"));
                tb.setChieudai(rs.getInt("Chieudai"));
                return tb;
            }
    }
    return null;
    }
    }
    public TuyenBay findHoaDonTuyenBay(String MaTuyenBay) throws Exception{
        String sql = "SELECT * FROM [dbo].[TuyenBay] WHERE MaTuyenBay=?";
         try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,MaTuyenBay);
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next()){
                TuyenBay tb= new TuyenBay();
                tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                tb.setSanBayDen(rs.getString("SanBayDen"));
                tb.setSanBayDi(rs.getString("SanBayDi"));
                tb.setMaSanBay(rs.getString("MaSanBay"));
                tb.setChieudai(rs.getInt("Chieudai"));
                return tb;
            }
    }
    return null;
    }
    }
    public TuyenBay findSanBay(String sb) throws Exception{
        String sql = "SELECT * FROM [dbo].[TuyenBay] WHERE SanBayDi=? AND TrangThai=? ";
         try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,sb);
            dtb.setInt(2, 0);
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next()){
                TuyenBay tb= new TuyenBay();
                tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                tb.setSanBayDen(rs.getString("SanBayDen"));
                tb.setSanBayDi(rs.getString("SanBayDi"));
                tb.setMaSanBay(rs.getString("MaSanBay"));
                tb.setChieudai(rs.getInt("Chieudai"));
                return tb;
            }
    }
    return null;
    }
    }
    public List< TuyenBay> findalltuyenBay() throws Exception {
        String sql = "SELECT * FROM [dbo].[TuyenBay] Where TrangThai=?";
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        //String sdate = formatter.format(Ngaykh);
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setInt(1,0);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<TuyenBay> list =new ArrayList<TuyenBay>();
               while(rs.next())
                {
                    TuyenBay tb= new TuyenBay();
                    tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    tb.setSanBayDen(rs.getString("SanBayDen"));
                    tb.setSanBayDi(rs.getString("SanBayDi"));
                    tb.setMaSanBay(rs.getString("MaSanBay"));
                    tb.setChieudai(rs.getInt("Chieudai"));
                    list.add(tb); 
                }
               return list;
            }
            
        }
       
    }
     public List< TuyenBay> findtuyenBaydi(String ss) throws Exception {
        String sql = "SELECT * FROM [dbo].[TuyenBay] WHERE SanBayDi=? AND TrangThai=?";
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");";
        //String sdate = formatter.format(Ngaykh);
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, ss);
            dtb.setInt(2, 0);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<TuyenBay> list =new ArrayList<TuyenBay>();
               while(rs.next())
                {
                    TuyenBay tb= new TuyenBay();
                    tb.setMaTuyenBay(rs.getString("MaTuyenBay"));
                    tb.setSanBayDen(rs.getString("SanBayDen"));
                    tb.setSanBayDi(rs.getString("SanBayDi"));
                    tb.setMaSanBay(rs.getString("MaSanBay"));
                    tb.setChieudai(rs.getInt("Chieudai"));
                    list.add(tb); 
                }
               return list;
            }
            
        }
       
    }
    public boolean Insert(TuyenBay TB) throws Exception{
        String sql="INSERT INTO [dbo].[TuyenBay]([MaTuyenBay],[SanBayDi],[SanBayDen],[MaSanBay],[ChieuDai],[TrangThai])" +
                " VALUES(?,?,?,?,?,?)";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, TB.getMaTuyenBay());
            dtb.setString(2, TB.getSanBayDi());
            dtb.setString(3,TB.getSanBayDen());
            dtb.setString(4,TB.getMaSanBay());
            dtb.setInt(5,TB.getChieudai());
            dtb.setInt(6,0);
            return dtb.executeUpdate()>0;
        }    
    }
    public Boolean Update(TuyenBay TB) throws  Exception{
    String sql="UPDATE [dbo].[TuyenBay] "+
            " SET [SanBayDi]= ? ,[SanBayDen]= ?,[MaSanBay]= ?,[ChieuDai]= ?,[TrangThai]=?" +
                " WHERE [MaTuyenBay]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, TB.getSanBayDi());
            dtb.setString(2,TB.getSanBayDen());
            dtb.setString(3,TB.getMaSanBay());
            dtb.setInt(4,TB.getChieudai());
            dtb.setInt(5, TB.getTrangThai());
            dtb.setString(6, TB.getMaTuyenBay());
            return dtb.executeUpdate()>0;
        }    
             
    }
    public Boolean Delete(TuyenBay TB) throws  Exception{
    String sql="DELETE [dbo].[TuyenBay] "+
                " WHERE [MaTuyenBay]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, TB.getMaTuyenBay());
            return dtb.executeUpdate()>0;
        }         
    }
    
    public int findChieuDai (String MaTuyenBay) throws Exception{
        String sql = "SELECT Chieudai FROM [dbo].[TuyenBay] WHERE MaTuyenBay = ? AND TrangThai=?";
        try (
             Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, MaTuyenBay);
            dtb.setInt(2,0);
            try(ResultSet rs=dtb.executeQuery()){
            
                if (rs.next()){
                    int chieudai = rs.getInt("Chieudai");
                    return chieudai;
                }
            }
        }
        return 0;
    }
}
