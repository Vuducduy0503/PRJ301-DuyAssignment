/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vuduc
 */
public  class DBcontext {
   protected Connection connection;
   
   public DBcontext()
   {
       try {
           String url = "jdbc:sqlserver://localhost:1433;databaseName=student2023";
           String user = "sa";
           String pass = "123456";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection = DriverManager.getConnection(url, user, pass);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
  
}
