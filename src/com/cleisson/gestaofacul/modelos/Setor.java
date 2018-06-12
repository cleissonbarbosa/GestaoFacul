/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

import java.util.Random;

/**
 * classe modelo
 * @author Cleisson Barbosa
 */
public class Setor {

    Random aleatorio = new Random();
    private final int id;
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
