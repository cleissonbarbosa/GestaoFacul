/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

import java.util.Random;


/**
 * classe modelo para registro de disciplinas
 * @author Cleisson Barbosa
 */
public class Disciplinas {
    Random aleatorio = new Random();
    private int id;
    private String nome;
    private Curso curso;

    /**
     * Construtor
     * @param nome
     * @param curso
     */
    public Disciplinas( String nome, Curso curso) {
        id = aleatorio.hashCode();
        this.nome = nome;
        this.curso = curso;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Curso getCurso() {
        return this.curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
