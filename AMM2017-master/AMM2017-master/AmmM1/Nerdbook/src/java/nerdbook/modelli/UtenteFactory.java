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




/**
 *
 * @author Meuro
 */
public class UtenteFactory {

    private String connectionString;
    
    private static UtenteFactory singleton;
    
    public static UtenteFactory getInstance()
    {
        if(singleton==null)
            singleton = new UtenteFactory();
        return singleton;
    }
    
    private UtenteFactory(){};
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public int getIdUtente(String username,String password)
    { 
        try
        { 
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","ammdb");
            String query = "select id_utente from utente where username= ? and password= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2,password);
            /*Interrogazioni executeQuery -------Modifiche executeUpdate*/
            ResultSet res = stmt.executeQuery();
            
            
            if(res.next())
            {
               int id = res.getInt("id_utente"); 
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
    
    public boolean getEmptyfields(String username,String password)
    { 
        try
        { 
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","ammdb");
            String query = "select id_utente from utente where username= ? and password= ? "
                            + "and (nome is null "
                            + "or cognome is null " 
                            + "or anno is null "
                            + "or email is null "
                            + "or frase is null " 
                            + "or urlfoto is null)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2,password);
            /*Interrogazioni executeQuery -------Modifiche executeUpdate*/
            ResultSet res = stmt.executeQuery();
            
            
            if(res.next())
            {   //Controllo se la query restituisce una riga
               int ris = res.getInt("id_utente"); 
               stmt.close();
               conn.close();
               if (ris != 0)
               {
                   return true;
               }   
               
            }
            stmt.close();
            conn.close();      
        }
        
        catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
        return false;
    }
    
    public boolean setProfile(String nome,String cognome,String anno,String email,String urlfoto,String frase,
                                String username,String password)
    { 
        try
        { 
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","ammdb");
            String query = "update utente set nome = ? ,cognome = ? ,anno = ? ,email=? ,urlfoto = ? ,frase = ? ,username = ? ,password = ? "
                    + "where id_utente = ?";
            int id = getIdUtente(username,password);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, anno);
            stmt.setString(4,email);
            stmt.setString(5, urlfoto);
            stmt.setString(6, frase);
            stmt.setString(7, username);
            stmt.setString(8, password);
            stmt.setInt(9, id);
             
            /*Interrogazioni executeQuery -------Modifiche executeUpdate*/
            stmt.executeUpdate();
            //Controlla se ci sono campi vuoti
            boolean ris = getEmptyfields(username,password);
               
            if (ris == false)
            {
                  //Se non vi sono,la procedura è andata a buon fine  
                stmt.close();
                conn.close();
                return true;  
            }
            else
            {//Altrimenti qualche campo non è stato aggiornato correttamente
                stmt.close();
                conn.close();
                return false;
            }
            
        }
        catch(SQLException e)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
        return false;           
    }
    
    public Utente getProfile(String username,String password)
    {
        try
        { 
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","ammdb");
            String query = "select * from utente where id_utente = ?";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
           int id = UtenteFactory.getInstance().getIdUtente(username, password);
                   
            stmt.setInt(1, id);
            
            /*Interrogazioni executeQuery -------Modifiche executeUpdate*/
            ResultSet res = stmt.executeQuery();
            
            //Cerco l'utente tramite le sue credenziali e creo un'altro oggetto a cui passo 
            //i suoi valori,per poterli visualizzare in profilo.jsp
            if (res.next())
            {
                Utente current = new Utente(); 
                current.setId(id);
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setAnno(res.getString("anno"));
                current.setNome(res.getString("nome"));
                current.setEmail(res.getString("email"));
                current.setCognome(res.getString("cognome"));
                current.setFrase(res.getString("frase"));
                current.setUrlFoto(res.getString("urlfoto"));
                
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
            
        }
        catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
        return null;          
    
    }
    
    public Utente getUtenteById(int iduser)
    {
        try
        { 
            Connection conn = DriverManager.getConnection(connectionString,"ammdb","ammdb");
            String query = "select * from utente where id_utente = ?";
                    
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, iduser);
            
            /*Interrogazioni executeQuery -------Modifiche executeUpdate*/
            ResultSet res = stmt.executeQuery();
            
            //Cerco l'utente tramite le sue credenziali e creo un'altro oggetto a cui passo 
            //i suoi valori,per poterli visualizzare in profilo.jsp
            if (res.next())
            {
                Utente current = new Utente(); 
                current.setId(res.getInt("id_utente"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setAnno(res.getString("anno"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setFrase(res.getString("frase"));
                current.setUrlFoto(res.getString("urlfoto"));
                
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
            
        }
        catch (SQLException e) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null, e);
        }
        return null;          
    
    }
    
}
