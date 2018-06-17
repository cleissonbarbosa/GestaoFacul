/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

import java.util.Random;

/**
 * classe modelo para registro de escolas
 * @author Cleisson Barbosa
 */
public class Escolas {

    Random aleatorio = new Random();
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

}
