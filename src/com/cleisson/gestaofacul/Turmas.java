/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author Cleisson Barbosa
 */
public class Turmas {
    SecureRandom aleatorio = new SecureRandom();
    private int id;
    private String nome;
    private Disciplinas disciplinas;
    private Professor professor;
    private ArrayList<Aluno> aluno = new ArrayList();

    public Turmas(String nome, Disciplinas disciplina, Professor professor) {
         id = aleatorio.hashCode();
        this.nome = nome;
        this.disciplinas = disciplina;
        this.professor = professor;
        //this.aluno = getAluno();
    }
    public Turmas(){
        
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplinas getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplina) {
        this.disciplinas = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList getAluno() {
        return aluno;
    }

    public void setAluno(ArrayList aluno) {
        this.aluno = aluno;
    }
    
}
