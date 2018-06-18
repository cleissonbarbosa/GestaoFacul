/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

/**
 * classe modelo
 * @author Cleisson Barbosa
 */
public class Professor extends Funcionarios{

    private Escolas escola;

    /**
     * Construtor
     * @param escola
     * @param dataDeAdimissao
     * @param salario
     * @param endereco
     * @param matricula
     * @param nome
     * @param telefone
     */
    public Professor(Escolas escola, int dataDeAdimissao, float salario, String endereco, int matricula, String nome, int telefone) {
        super(dataDeAdimissao, salario, endereco, matricula, nome, telefone);
        this.escola = escola;
    }

    /**
     *
     * @return
     */
    public Escolas getEscola() {
        return escola;
    }

    /**
     *
     * @param escola
     */
    public void setEscola(Escolas escola) {
        this.escola = escola;
    }
}
