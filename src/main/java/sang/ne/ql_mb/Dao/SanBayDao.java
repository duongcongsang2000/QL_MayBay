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
import java.util.List;
import sang.ne.ql_mb.entity.SanBay;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author Yahiko
 */
public class SanBayDao {
    public Boolean Insert(SanBay SB) throws  Exception{
    String sql="INSERT INTO [dbo].[SanBay]([MaSanBay],[TenSanBay],[TinhThanh])" +
                " VALUES(?,?,?)";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, SB.getMaSanBay());
            dtb.setString(2, SB.getTenSanBay());
            dtb.setString(3, SB.getTinhThanh());
            return dtb.executeUpdate()>0;
        }    
             
    }
     public Boolean Update(SanBay SB) throws  Exception{
    String sql="UPDATE [dbo].[SanBay] "+
            " SET [TenSanBay]= ?,[TinhThanh]=?" +
                " WHERE [MaSanBay]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, SB.getTenSanBay());
            dtb.setString(3, SB.getMaSanBay());
            dtb.setString(2, SB.getTinhThanh());
            return dtb.executeUpdate()>0;
        }    
             
    }
    public Boolean Delete(SanBay SB) throws  Exception{
    String sql="DELETE [dbo].[SanBay] "+
                " WHERE [MaSanBay]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, SB.getMaSanBay());
            return dtb.executeUpdate()>0;
        }    
             
    }
    public SanBay FindSanBay(String MaSanBay) throws Exception{
     String sql="SELECT * FROM [dbo].[SanBay] WHERE [MaSanBay]=? ";
      try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,MaSanBay);
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next())
        {
            SanBay sb=new SanBay();
            sb.setMaSanBay(rs.getString("MaSanBay"));
            sb.setTenSanBay(rs.getString("TenSanBay"));
            sb.setTinhThanh(rs.getString("TinhThanh"));
            return sb;
        }    
        }
        return null;
    }
    }
    public SanBay FindTenSanBay(String TinhThanh) throws Exception{
     String sql="SELECT * FROM [dbo].[SanBay] WHERE [TinhThanh]=? ";
      try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,TinhThanh);
            try(ResultSet rs=dtb.executeQuery())
        {
            if (rs.next())
        {
            SanBay sb=new SanBay();
            sb.setMaSanBay(rs.getString("MaSanBay"));
            sb.setTenSanBay(rs.getString("TenSanBay"));
            sb.setTinhThanh(rs.getString("TinhThanh"));
            return sb;
        }    
        }
        return null;
    }
    }
    public List< SanBay > FindAllSanBay() throws Exception{
     String sql="SELECT * FROM [dbo].[SanBay]";
      try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
        try(ResultSet rs=dtb.executeQuery())
        {
            List<SanBay> list =new ArrayList<SanBay>();
            while (rs.next())
            {
                SanBay sb=new SanBay();
                sb.setMaSanBay(rs.getString("MaSanBay"));
                sb.setTenSanBay(rs.getString("TenSanBay"));
                sb.setTinhThanh(rs.getString("TinhThanh"));
                list.add(sb); 
            }
            return list;
        }
        }
    }
}
