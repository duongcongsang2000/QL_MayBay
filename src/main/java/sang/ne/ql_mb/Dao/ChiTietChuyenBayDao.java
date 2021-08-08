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
import sang.ne.ql_mb.entity.Chitietchuyenbay;
import sang.ne.ql_mb.entity.ChuyenBay;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author Yahiko
 */
public class ChiTietChuyenBayDao {
    public List<Chitietchuyenbay> findAllChuyenBay() throws Exception {
        String sql = "SELECT * FROM [dbo].[ChiTietChuyenBay]";
        //Format formatter = new  SimpleDateFormat("yyyy-MM-dd");
        //String sdate = formatter.format(Ngaykh);
        try (
                Connection con= DatabaseHelper.openConnection();
                PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
            //dtb.setInt(1, 0);
            try(ResultSet rs=dtb.executeQuery())
            {
                List<Chitietchuyenbay> list =new ArrayList<Chitietchuyenbay>();
               while(rs.next())
                {
                    Chitietchuyenbay cb = new Chitietchuyenbay();
                    cb.setMaChiTiet(rs.getString("MaChiTietChuyenBay"));
                    cb.setHangBay(rs.getString("HangBay"));
                    cb.setSoHieu(rs.getString("SoHieu"));
                    list.add(cb); 
                }
               return list;
            }
            
        }
       
    }
}
