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
public class Post {
     int id_post;
     String cont_testo;
     int tipo_all;
     String cont_all;
     int autore;
     int bacheca; 
    
    public Post()
    {
        id_post = 0;
        cont_testo="";
        tipo_all=0;
        cont_all="";
        autore=0;
        bacheca=0;    
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id_post;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id_post = id;
    }

    /**
     * @return the user
     */
    public int getUser() {
        return autore;
    }

    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.autore = user;
    }

    /**
     * @return the content
     */
    public String getContTesto() {
        return cont_testo;
    }

    /**
     * @param content the content to set
     */
    public void setContTesto(String content) {
        this.cont_testo = content;
    }
    
    /**
     * @return the tipo_allegato
     */
    public int getTipoAll() {
        return tipo_all;
    }

    /**
     * @param tipoall the user to set
     */
    public void setTipoAll(int tipoall) {
        this.tipo_all = tipoall;
    }
    /**
     * @return the postType
     */
    public String getContAll() {
        return cont_all;
    }

    /**
     * @param contall the postType to set
     */
    public void setContAll(String contall) {
        this.cont_all = contall;
    }
    
    
    /**
     * @return the bacheca
     */
    public int getIdBach()
    {
        return bacheca;
    }
     /**
     * @param bach the bacheca to set
     */
    public void setIdBach(int bach)
    {
        this.bacheca=bach;
    }
    
}
