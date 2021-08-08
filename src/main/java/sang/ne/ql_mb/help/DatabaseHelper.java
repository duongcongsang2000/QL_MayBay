/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.help;
/**
 *
 * @author Yahiko
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseHelper {
    public static Connection openConnection() throws Exception {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String connectionUrl = "jdbc:sqlserver://localhost:1433;database=DOAN_MB";
      String username="sa";
      String password="123";
      Connection connect=DriverManager.getConnection(connectionUrl,username,password);
      return connect;
  }
}
