package com.cleisson.gestaofacul;

import java.util.ArrayList;

/**
 *
 * @author cleisson
 */
public class CadastrosDB {

    private int dataDeAdimissao;
    private String endereco;
    private int matricula;
    private String nome;
    private float salario;
    private int telefone;
    private String escolaOuSetor;

    public CadastrosDB(int dataDeAdimissao, String endereco, int matricula, String nome, float salario, int telefone, String escolaOuSetor) {
        this.dataDeAdimissao = dataDeAdimissao;
        this.endereco = endereco;
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
        this.escolaOuSetor = escolaOuSetor;
    }

    public String getEscolaOuSetor() {
        return escolaOuSetor;
    }

    public void setEscolaOuSetor(String escolaOuSetor) {
        this.escolaOuSetor = escolaOuSetor;
    }

    public int getDataDeAdimissao() {
        return dataDeAdimissao;
    }

    public void setDataDeAdimissao(int dataDeAdimissao) {
        this.dataDeAdimissao = dataDeAdimissao;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}
