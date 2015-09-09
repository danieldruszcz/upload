/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.cf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DanielDruszcz
 */
public class ConnectionFactory {
    public Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
            
            String url = "jdbc:postgresql://localhost:5432/tcc";  
            String user = "postgres";  
            String senha = "12345";  
  
            Class.forName("org.postgresql.Driver");  
  
          
            Connection con = DriverManager.getConnection(url, user, senha);  
        System.out.println( con );
      return con;
      
        
  }
    
}
