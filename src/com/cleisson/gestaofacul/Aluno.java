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
public class Aluno extends Pessoa{
    private String Curso;
    
    public Aluno(String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
    }
    
    public void inserirAluno(String curso){
        this.Curso = curso;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }
    
    
    
}
