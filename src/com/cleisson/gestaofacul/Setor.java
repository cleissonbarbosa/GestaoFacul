/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.security.SecureRandom;

/**
 *
 * @author Cleisson Barbosa
 */
public class Setor {

    SecureRandom aleatorio = new SecureRandom();
    private int id;
    private String nome;

    public Setor(String Nome) {
        this.nome = Nome;
        id = aleatorio.hashCode();
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

}
