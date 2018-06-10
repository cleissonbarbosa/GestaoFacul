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

    public Curso(String nome, Escolas escola) {
        id = aleatorio.hashCode();
        this.nome = nome;
        this.escola = escola;
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

    public Escolas getEscola() {
        return this.escola;
    }

    public void setEscola(Escolas escola) {
        this.escola = escola;
    }

}
