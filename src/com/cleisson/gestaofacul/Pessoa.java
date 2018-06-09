/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

/**
 * 
 * @author Cleisson Barbosa
 */
public class Pessoa {
    
    protected String endereco;
    protected int matricula;
    protected String nome;
    protected int telefone;

    public Pessoa(String endereco, int matricula, String nome, int telefone) {
        this.endereco = endereco;
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
}
