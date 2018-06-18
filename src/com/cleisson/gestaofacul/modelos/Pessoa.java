/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

/**
 * classe modelo pai
 * @author Cleisson Barbosa
 */
abstract public class Pessoa {
    protected String endereco;
    protected int matricula;
    protected String nome;
    protected int telefone;
    /**
     * Construtor
     * @param endereco
     * @param matricula
     * @param nome
     * @param telefone
     */
    public Pessoa(String endereco, int matricula, String nome, int telefone) {
        this.endereco = endereco;
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    /**
     *
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
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
    public int getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
}
