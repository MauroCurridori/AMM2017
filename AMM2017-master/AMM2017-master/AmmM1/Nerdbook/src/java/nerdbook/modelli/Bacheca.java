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
public class Bacheca {
    protected int id_bacheca;
    protected int proprietario;
    
    public Bacheca()
    {
        id_bacheca=0;
        proprietario=0;
    }
    
    public int getId()
    {       
        return id_bacheca;
    }
    
        
    public void setId(int bac)
    {
        this.id_bacheca = bac;
        
    }
    
    public int getProp()
    {
        return proprietario;
    }
    
    public void setProp(int prop)
    {
        this.proprietario = prop;
    }
}
