/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleisson.gestaofacul;

/**
 *
 * @author cleisson
 */
public class Curso {

    private int ID;
    private String nome;
    private String escola;

    public Curso(int id, String nome, String escola) {
        this.ID = id;
        this.nome = nome;
        this.escola = escola;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscola() {
        return this.escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

}
