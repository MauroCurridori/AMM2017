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
public class Gruppo {
    
    int id_gruppo;
    String nome;
 
    /**
     * @return the id
     */
    public int getId() {
        return id_gruppo;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id_gruppo = id;
    }
    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
