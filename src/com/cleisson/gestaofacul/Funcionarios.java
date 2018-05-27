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
public class Funcionarios extends Pessoa{
    
    protected float salario;
    protected int dataDeAdimissao;
    public Funcionarios(String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
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
