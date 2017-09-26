/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meuro
 */
public class BachecaFactory {
   
    private String connectionString;
    
    private static BachecaFactory singleton;
    
    public static BachecaFactory getInstance()
    {
        if(singleton==null)
            singleton = new BachecaFactory();
        return singleton;
    }
    
    private BachecaFactory(){};
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
   
    public int getIdByUtente(Utente utente)
    {
      try
      {
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select id_bacheca from bacheca where proprietario = ?";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setInt(1, utente.getId() );
          
          ResultSet res = stmt.executeQuery();
          
          if(res.next())
          {
              int id = res.getInt("id_bacheca"); 
               stmt.close();
               conn.close();
               return id;
          }
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return -1;
    }
    
    public int getPropByIdBac(int id_bac)
    {
      try
      {
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select proprietario from bacheca where id_bacheca =?";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setInt(1, id_bac );
          
          ResultSet res = stmt.executeQuery();
          
          if(res.next())
          {
              int id_prop = res.getInt("proprietario"); 
               stmt.close();
               conn.close();
               return id_prop;
          }
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return -1;
    }
    
}
