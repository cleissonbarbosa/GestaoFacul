/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

import java.util.Random;

/**
 * classe modelo para registro de cursos
 * @author Cleisson Barbosa
 */
public class Curso {

    Random aleatorio = new Random();
    private int id;
    private String nome;
    private Escolas escola;

    /**
     * Construtor
     * @param nome
     * @param escola
     */
    public Curso(String nome, Escolas escola) {
        id = aleatorio.hashCode();
        this.nome = nome;
        this.escola = escola;
    }

    /**
     *
     * @return id
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
    public Escolas getEscola() {
        return this.escola;
    }

    /**
     *
     * @param escola
     */
    public void setEscola(Escolas escola) {
        this.escola = escola;
    }

}
