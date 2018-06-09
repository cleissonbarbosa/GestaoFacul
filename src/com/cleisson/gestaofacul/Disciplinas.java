/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.util.Random;


/**
 *
 * @author Cleisson Barbosa
 */
public class Disciplinas {
    Random aleatorio = new Random();
    private int id;
    private String nome;
    private Curso curso;

    public Disciplinas( String nome, Curso curso) {
        id = aleatorio.hashCode();
        this.nome = nome;
        this.curso = curso;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
