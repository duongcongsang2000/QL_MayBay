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
import sang.ne.ql_mb.entity.KhachHang;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author Yahiko
 */
public class KhachHangDao {
//     public KhachHang Checklogin(String username,String password,int vaitro) throws Exception{
//        String sql="SELECT Username,Password "+" FROM [KhachHang] " +" WHERE username=? and vaitro=? and trangthai=?";
//        try (
//            Connection con= DatabaseHelper.openConnection();
//            PreparedStatement dtb= con.prepareStatement(sql);
//                )
//        {
//            
//            dtb.setString(1, username);
//            dtb.setInt(2, vaitro);
//            dtb.setInt(3,0);
//            try(ResultSet rs=dtb.executeQuery()) {
//                if(rs.next()){
//                    KhachHang nd= new KhachHang();
//                    nd.setUsername(rs.getString("Username"));
//                    String hash = rs.getString("Password");
//                    boolean match = BCrypt.checkpw("Aa123456", hash);
//                    if(match){
//                        nd.setVaitro(vaitro);
//                        return nd;
//                    }   
//                }
//            }
//                
//        }
//        return null;        
//    }
     
    public KhachHang FindUser (String Username) throws Exception{
        String sql = "SELECT Username,PassWord,VaiTro FROM [dbo].[KhachHang] WHERE Username = ? and trangthai=?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement dtb = con.prepareStatement(sql);
            )
        {
            dtb.setString(1, Username);
            dtb.setInt(2,0);
            try(ResultSet rs = dtb.executeQuery()){
                if(rs.next()){
                    KhachHang nd = new KhachHang();
                    nd.setUsername(rs.getString("Username"));
                    nd.setPassword(rs.getString("Password"));
                    nd.setVaitro(rs.getInt("VaiTro"));
                    return nd   ;
                }
            }
        }
        return null;
    }
    
    public boolean findUserByMail (String email,String username) throws Exception{
        String sql = "SELECT Username,PassWord,VaiTro FROM [dbo].[KhachHang] WHERE Email = ? AND Username= ?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement dtb = con.prepareStatement(sql);
            )
        {
            dtb.setString(1, email);
            dtb.setString(2, username);
            try(ResultSet rs = dtb.executeQuery()){
                if(rs.next()){
                  return true;
                }
            }
            return false;
        }
    }
        
    public boolean IsUser (String Username,String Password) throws Exception{
        KhachHang KH = FindUser (Username);
        boolean check = BCrypt.checkpw(Password, KH.getPassword());
        if (check && (KH.getVaitro()==0)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean IsAdmin (String Username, String Password) throws Exception{
        KhachHang KH = FindUser (Username);
        boolean check = BCrypt.checkpw(Password, KH.getPassword());
        if (check && (KH.getVaitro()==1)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean IsUsernameAvailable(String UserName) throws Exception{
       KhachHang kh = FindUser(UserName);
       if(kh==null){
           return true;
       }
       return false;
        
    }
    
     
    public boolean Insert(KhachHang KH) throws Exception{
        String sql="INSERT INTO [dbo].[KhachHang]([CMND],[TENKH],[SDT],[GIOITINH],[Username],[Password],[VaiTro],[TrangThai],[Email])" +
                " VALUES(?,?,?,?,?,?,?,?,?)";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, KH.getCMND());
            dtb.setString(2, KH.getTENKH());
            dtb.setString(3,KH.getSDT());
            dtb.setInt(4,KH.getGIOITINH());
            dtb.setString(5, KH.getUsername());
            dtb.setString(6, KH.getPassword());
            dtb.setInt(7, KH.getVaitro());
            dtb.setInt(8, 0);
            dtb.setString(9,KH.getEmail());
            
            return dtb.executeUpdate()>0;
        }    
}
public boolean Update(KhachHang KH) throws  Exception{
    String sql="UPDATE [dbo].[KhachHang] "+
            " SET [SDT]= ?,[TENKH]= ?,[UserName]= ?,[GIOITINH]=? ,[TrangThai]=?,[Email]=?" +
                " WHERE [CMND]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, KH.getSDT());
            dtb.setString(2, KH.getTENKH());
            dtb.setString(3, KH.getUsername());
            dtb.setInt(4, KH.getGIOITINH());
            dtb.setInt(5, KH.getTrangThai());
            dtb.setString(6, KH.getEmail());
            dtb.setString(7, KH.getCMND());
            
            return dtb.executeUpdate()>0;
        }    
             
    }
public boolean Delete(KhachHang KH) throws  Exception {
    String sql= "DELETE [dbo].[KhachHang] "+
                " WHERE [CMND]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1, KH.getCMND());
            return dtb.executeUpdate()>0;
        }    
             
    }
    public KhachHang FindKhachHang(String value) throws Exception{
        String sql="SELECT * FROM [dbo].[KhachHang] WHERE [CMND]=? AND [TrangThai]=?";
       
            try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,value);
                dtb.setInt(2,0);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next())
            {
                KhachHang sb=new KhachHang();
                sb.setCMND(rs.getString("CMND"));
                sb.setTENKH(rs.getString("TENKH"));
                sb.setSDT(rs.getString("SDT"));
                sb.setGIOITINH(rs.getInt("GIOITINH"));
                sb.setUsername(rs.getString("Username"));
                sb.setEmail(rs.getString("Email"));
  
                return sb;
            }    
            }
            }
        
        return null;
}
    public KhachHang FindUserName(String value) throws Exception{
        String sql="SELECT * FROM [dbo].[KhachHang] WHERE [Username]=? AND [TrangThai]=?";
       
            try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,value);
                dtb.setInt(2,0);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next())
            {
                KhachHang sb=new KhachHang();
                sb.setCMND(rs.getString("CMND"));
                sb.setTENKH(rs.getString("TENKH"));
                sb.setSDT(rs.getString("SDT"));
                sb.setGIOITINH(rs.getInt("GIOITINH"));
                sb.setUsername(rs.getString("Username"));
                sb.setEmail(rs.getString("Email"));
                
                return sb;
            }    
            }
            }
        
        return null;
}

    public List< KhachHang > FindKhachHang2(String Value,int chose) throws Exception{
    
     String sql;
     String sql_1="SELECT * FROM [dbo].[KhachHang] WHERE [CMND]=? AND [TrangThai]=?";
     String sql_2="SELECT * FROM [dbo].[KhachHang] WHERE [TENKH]=? AND [TrangThai]=?";
     String sql_3="SELECT * FROM [dbo].[KhachHang] WHERE [SDT]=? AND [TrangThai]=?";
      String sql_4="SELECT * FROM [dbo].[KhachHang] WHERE [Username]=? AND [TrangThai]=?";
        if (chose==1) sql=sql_1;
        else
            if (chose==2)  sql=sql_2;
        else   
            
            if (chose==3)  sql=sql_3;
            else 
                sql=sql_4;
     try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
        dtb.setString(1,Value);
        dtb.setInt(2,0);
        try(ResultSet rs=dtb.executeQuery())
        {
            List<KhachHang> list =new ArrayList<KhachHang>();
            while (rs.next())
            {
                KhachHang sb=new KhachHang();
                sb.setCMND(rs.getString("CMND"));
                sb.setTENKH(rs.getString("TENKH"));
                sb.setSDT(rs.getString("SDT"));
                sb.setGIOITINH(rs.getInt("GIOITINH"));
                sb.setUsername(rs.getString("Username"));
                sb.setEmail(rs.getString("Email"));
                list.add(sb); 
            }
            return list;
        }
        }     
    } 
     public List< KhachHang > FindKhachHang3(String Value1,String Value2,int chose) throws Exception{
    
     String sql="";
     String sql_1="SELECT * FROM [dbo].[KhachHang] WHERE [TENKH]=? AND [SDT]=? AND [TrangThai]=?";
     String sql_2="SELECT * FROM [dbo].[KhachHang] WHERE [SDT]=? AND [Username]=? AND [TrangThai]=? ";
     String sql_3="SELECT * FROM [dbo].[KhachHang] WHERE [Username]=? AND [TENKH]=? AND [TrangThai]=?";
        if (chose==5) sql=sql_1;
        else
            if (chose==6)  sql=sql_2;
        else   
            if (chose==7)  sql=sql_3;
        
     try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
        dtb.setString(1,Value1);
        dtb.setString(2,Value2);
        dtb.setInt(3,0);
        try(ResultSet rs=dtb.executeQuery())
        {
            List<KhachHang> list =new ArrayList<KhachHang>();
            while (rs.next())
            {
                KhachHang sb=new KhachHang();
                sb.setCMND(rs.getString("CMND"));
                sb.setTENKH(rs.getString("TENKH"));
                sb.setSDT(rs.getString("SDT"));
                sb.setGIOITINH(rs.getInt("GIOITINH"));
                sb.setUsername(rs.getString("Username"));
                sb.setEmail(rs.getString("Email"));
                list.add(sb); 
            }
            return list;
        }
        }     
    }  
    public List< KhachHang > FindAllKhachHang() throws Exception{
     String sql="SELECT * FROM [dbo].[KhachHang] WHERE [VaiTro]=? AND [TrangThai]=?";
      try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
        dtb.setInt(1, 0);
        dtb.setInt(2, 0);
        try(ResultSet rs=dtb.executeQuery())
        {
            List<KhachHang> list =new ArrayList<KhachHang>();
            while (rs.next())
            {
                KhachHang sb=new KhachHang();
                sb.setCMND(rs.getString("CMND"));
                sb.setTENKH(rs.getString("TENKH"));
                sb.setSDT(rs.getString("SDT"));
                sb.setGIOITINH(rs.getInt("GIOITINH"));
                sb.setUsername(rs.getString("Username"));
                sb.setEmail(rs.getString("Email"));
                list.add(sb); 
            }
            return list;
        }
        }     
    }
    public boolean changePwd (KhachHang kh) throws Exception{
        String sql = "UPDATE [dbo].[KhachHang] SET [Password] = ? WHERE [CMND]= ?";
        try (
            Connection con= DatabaseHelper.openConnection();
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            dtb.setString(1,kh.getPassword());
            dtb.setString(2, kh.getCMND());
            return dtb.executeUpdate()>0;
        }
    }
    
    public boolean changePwdToDefault (String email) throws Exception{
        String sql = "UPDATE [dbo].[KhachHang] SET [Password] = ? WHERE [Email]= ?";
        try(
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);  
            )
        {
            String salt = BCrypt.gensalt(4);
            String hash = BCrypt.hashpw("1", salt);
           dtb.setString(1, hash );
           dtb.setString(2, email);
           return dtb.executeUpdate()>0;
        }
    }
    
    
}
