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
public class Turmas {
    private int ID;
    private String nome;
    private String disciplinas;
    private String professor;

    public Turmas(int id, String nome, String disciplina, String professor) {
        this.ID = id;
        this.nome = nome;
        this.disciplinas = disciplina;
        this.professor = professor;
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
        return this.disciplinas;
    }

    public void setEscola(String disciplina) {
        this.disciplinas = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
}
