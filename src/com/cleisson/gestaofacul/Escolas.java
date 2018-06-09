/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Cleisson Barbosa
 */
public class Escolas {

    SecureRandom aleatorio = new SecureRandom();
    private String nome;
    private int id;
    public Escolas(String Nome) {
        this.nome = Nome;
        id = aleatorio.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

}
