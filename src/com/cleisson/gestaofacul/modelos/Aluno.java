/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

/**
 * Classe modelo para os registros de aluno, classe filha da classe Pessoa
 * @author Cleisson Barbosa
 */
public class Aluno extends Pessoa {

    private Curso Curso;

    /**
     * Construtor
     * @param curso
     * @param endereco
     * @param matricula
     * @param nome
     * @param telefone
     */
    public Aluno(Curso curso, String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
        this.Curso = curso;
    }

    /**
     *
     * @return objeto curso
     */
    public Curso getCurso() {
        return Curso;
    }

    /**
     *
     * @param Curso
     */
    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }
}
