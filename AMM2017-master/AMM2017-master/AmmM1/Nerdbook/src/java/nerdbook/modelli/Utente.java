/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.modelli;


/**
 *
 * @author Meuro
 */
public class Utente {

    private int id;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private String anno;
    private String frase;
    private String urlfoto;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the nome
     */
    public String getNome(){
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    /**
     * @return the cognome
     */
    public String getCognome(){
        return cognome;
    }
    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    
    /**
     * @return the anno
     */
    public String getAnno(){
    return anno;
    }
    
    
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * @return the frase
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * @param anno the anno to set
     **/
    
    public void setAnno(String anno)
    {
        this.anno = anno;
    }
    
    /**
     * @return the frase
     */
    public String getFrase(){
        return frase;
    }
    
    /**
     * @param frase the frase to set
     */public void setFrase(String frase)
    {
        this.frase = frase;
    }
    
    /**
     * @return the urlfoto
     */
    public String getUrlFoto(){
        return urlfoto;
    }
    
    /**
     * @param urlfoto the urlfoto to set
     */
    public void setUrlFoto(String urlfoto)
    {
        this.urlfoto = urlfoto;
    }
    

    
}


