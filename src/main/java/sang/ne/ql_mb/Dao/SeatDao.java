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
import sang.ne.ql_mb.entity.Seat;
import sang.ne.ql_mb.help.DatabaseHelper;

/**
 *
 * @author CCLaptop.com
 */
public class SeatDao {
    public List <String> findSeatId(String MaChuyenBay ) throws Exception{
       
        
        
        
        String sql = "SELECT SoGhe FROM [dbo].[PhieuDatCho] WHERE PhieuDatCho.MaChuyenBay = ?";
        try(
             Connection con = new DatabaseHelper().openConnection();
             PreparedStatement dtb= con.prepareStatement(sql); 
             )
        {
             dtb.setString(1, MaChuyenBay);
             
             try(ResultSet rs=dtb.executeQuery())
             {
                List<String> list = new ArrayList<>() ;
                 while(rs.next())
                 {
                     list.add(rs.getString("SoGhe"));
      
                 }
                 return list;
             }
        }
    }
        
    public List <Seat> makeSeat() throws Exception{
        String columnChar = null ;
        String rowChar ;
        String seatId;
        List<Seat> list = new ArrayList<>();
                 for(int row=0;row<10;row++){
                     for(int j=0;j<6;j++){
                         switch(j){
                        case 0:
                            columnChar = "A";
                            break;
                        case 1:
                            columnChar = "B";
                            break;
                        case 2:
                            columnChar = "C";
                            break;
                        case 3:
                            columnChar = "D"; 
                            break;
                        case 4:
                            columnChar = "E";
                            break;
                        case 5:
                            columnChar = "F";
                            break;
                        }
                        rowChar=Integer.toString(row+1);
                        seatId= columnChar + rowChar;
                        Seat s = new Seat(seatId,true);
                        list.add(s); 
                     }    
                 }
                 return list;
   
    }
}

