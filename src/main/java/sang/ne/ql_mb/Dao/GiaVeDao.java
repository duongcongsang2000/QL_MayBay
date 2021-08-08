/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sang.ne.ql_mb.help.DatabaseHelper;


public class GiaVeDao {
    String MaVe;
    
    public int findGiaVe(String MaHangVe) throws Exception{
        String sql_1 =" SELECT MaVe FROM [dbo].[HangVe] WHERE MaHangVe= ?";
        try (
                Connection con_1= DatabaseHelper.openConnection();
                PreparedStatement dtb_1= con_1.prepareStatement(sql_1);
            )
            {
                dtb_1.setString(1,MaHangVe);
                try(ResultSet rs=dtb_1.executeQuery()){
                    if (rs.next()){
                        MaVe = rs.getString("MaVe");
                    }
                }
            }
        String sql_2 = "SELECT DonGia FROM [dbo].[VeChuyenBay] WHERE MaVe = ?";
        try (
                Connection con_2= DatabaseHelper.openConnection();
                PreparedStatement dtb_2= con_2.prepareStatement(sql_2);
            )
            {
                dtb_2.setString(1,MaVe);
                try(ResultSet rs=dtb_2.executeQuery()){
            
                    if (rs.next()){
                        int i = rs.getInt("DonGia");
                        return i;
                    }
                }
            }
        return 0;
    }
}

