/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.modelli;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nerdbook.modelli.UtenteFactory;
import nerdbook.modelli.Utente;
import nerdbook.modelli.Bacheca;


/**
 *
 * @author Meuro
 */
public class PostFactory {

    private String connectionString;
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance()
    {
        if(singleton==null)
            singleton = new PostFactory();
        return singleton;
    }
    
    private PostFactory(){};
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public int getIdPostByUsername(String autore)
    { 
      try{
          Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select id_post from post where autore= (select id_utente from utente where username = ?)";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setString(1, autore );
          
          ResultSet res = stmt.executeQuery();
          
          if(res.next())
          {
               int id = res.getInt("id_post"); 
               stmt.close();
               conn.close();
               return id;
              
          }
          stmt.close();
          conn.close();
          
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return -1;
    }
    
    public int getIdPostByTipoAll(int tipoall)
    { 
      try{
          Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select id_post from post where tipo_all=?";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setInt(1, tipoall );
          
          ResultSet res = stmt.executeQuery();
          
          if(res.next())
          {
               int id = res.getInt("id_post"); 
               stmt.close();
               conn.close();
               return id;
              
          }
          stmt.close();
          conn.close();
          
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return -1;
    }
    
    public Post getPostbyID(int idpost)
    { 
      try{
          Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select * from post where id_post=?";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setInt(1, idpost);
          
          ResultSet res = stmt.executeQuery();
         
          
          if(res.next())
          {
               Post current = new Post();
               //imposto id post
               current.setId(res.getInt("id_post"));
               //imposto contenuto del testo
               current.setContTesto(res.getString("cont_testo"));
               //impposto il tipo di allegato
               current.setTipoAll(res.getInt("tipo_all"));
               //imposto il contenuto dell'allegato (url o foto)
               current.setContAll(res.getString("cont_all"));
               //imposto l'autore del post
               current.setUser(res.getInt("autore"));
               //imposto il prop della bacheca
               current.setIdBach(res.getInt("bacheca"));
                             
               
               stmt.close();
               conn.close();
               return current;
              
          }
          stmt.close();
          conn.close();
          
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return null;
    }
    
    
    public Post getPostbyIDBac(int idbac)
    { 
      try{
          Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
          String query = "select * from post where bacheca= ?";
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setInt(1, idbac);
          
          ResultSet res = stmt.executeQuery();
         
          
          if(res.next())
          {
               Post current = new Post();
               //imposto id post
               current.setId(res.getInt("id_post"));
               //imposto contenuto del testo
               current.setContTesto(res.getString("cont_testo"));
               //impposto il tipo di allegato
               current.setTipoAll(res.getInt("tipo_all"));
               //imposto il contenuto dell'allegato (url o foto)
               current.setContAll(res.getString("cont_all"));
               //imposto l'autore del post
               current.setUser(res.getInt("autore"));
             
                             
               
               stmt.close();
               conn.close();
               return current;
              
          }
          stmt.close();
          conn.close();
          
      }
      catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
      return null;
    }
    
    public void addPost(Post post,Utente autore,int bac)
    {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            
            String query = 
                      "insert into post (id_post, cont_testo, tipo_all, cont_all, autore, bacheca) "
                    + "values (default, ? , ? , ? , ? , ?)";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Contenuto del post
            stmt.setString(1, post.getContTesto());
            //Tipo allegato
            stmt.setInt(2, post.getTipoAll());
            //Contenuto allegato
            stmt.setString(3, post.getContAll());
            //Autore
            stmt.setInt(4, autore.getId());
            //Bacheca
            stmt.setInt(5, bac);
            
            // Esecuzione query
            stmt.executeUpdate();
            
            
            
            
        }
        catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public List getPostList(Utente user) {
        List<Post> listaPost = new ArrayList<>();
        
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "select * from post "
                    + "where autore = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("id_post"));
                //impost il contenuto del post
                current.setContTesto(res.getString("cont_testo"));
                //imposto il tipo del post
                current.setTipoAll(res.getInt("tipo_all"));
                //imposto il contenuto dell'allegato
                current.setContAll(res.getString("cont_all"));
                //imposto l'autore del post
                current.setUser(user.getId());
                //Proprietario bacheca
                current.setIdBach(BachecaFactory.getInstance().getIdByUtente(user));
                //Aggiungo l'oggetto Post alla lista
                listaPost.add(current);
                
                return listaPost;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }

        return listaPost;
    }
}
