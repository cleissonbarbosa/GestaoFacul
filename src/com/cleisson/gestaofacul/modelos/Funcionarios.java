/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

/**
 * classe modelo para o registro de funcionarios classe filha da classe pessoa
 * @author Cleisson Barbosa
 */
public class Funcionarios extends Pessoa{
    
    protected float salario;
    protected int dataDeAdimissao;
    
    public Funcionarios(int dataDeAdimissao, float salario, String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
        this.dataDeAdimissao = dataDeAdimissao;
        this.salario = salario;
    }
    

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getDataDeAdmissão() {
        return dataDeAdimissao;
    }

    public void setDataDeAdmissão(int dataDeAdmissão) {
        this.dataDeAdimissao = dataDeAdmissão;
    }
    
}
