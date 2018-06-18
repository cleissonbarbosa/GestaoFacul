/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 * classe modelo
 * @author Cleisson Barbosa
 */
public class Turmas {
    Random aleatorio = new Random();
    private int id;
    private String nome;
    private Disciplinas disciplinas;
    private Professor professor;
    private ArrayList<Aluno> aluno = new ArrayList();

    /**
     * Construtor
     * @param nome
     * @param disciplina
     * @param professor
     */
    public Turmas(String nome, Disciplinas disciplina, Professor professor) {
         id = aleatorio.hashCode();
        this.nome = nome;
        this.disciplinas = disciplina;
        this.professor = professor;
        //this.aluno = getAluno();
    }

    /**
     * Construtor vazio
     */
    public Turmas(){
        
    }

    /**
     *
     * @return
     */
    public int getID() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setID(int id) {
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
    public Disciplinas getDisciplinas() {
        return this.disciplinas;
    }

    /**
     *
     * @param disciplina
     */
    public void setDisciplinas(Disciplinas disciplina) {
        this.disciplinas = disciplina;
    }

    /**
     *
     * @return
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     *
     * @param professor
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     *
     * @return
     */
    public ArrayList getAluno() {
        return aluno;
    }

    /**
     *
     * @param aluno
     */
    public void setAluno(ArrayList aluno) {
        this.aluno = aluno;
    }
    
}
