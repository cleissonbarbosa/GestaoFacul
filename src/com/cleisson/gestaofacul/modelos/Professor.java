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

    public Professor(Escolas escola, int dataDeAdimissao, float salario, String endereco, int matricula, String nome, int telefone) {
        super(dataDeAdimissao, salario, endereco, matricula, nome, telefone);
        this.escola = escola;
    }

    public Escolas getEscola() {
        return escola;
    }

    public void setEscola(Escolas escola) {
        this.escola = escola;
    }
}
