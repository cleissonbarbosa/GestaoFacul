package com.cleisson.gestaofacul;

import java.util.ArrayList;

/**
 *
 * @author cleisson
 */
public class Administrativo extends Funcionarios{

    private String setor;

    public Administrativo(String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
    }

    public void inserirAdministrativo(int dataDeAdimissao, float salario, String setor) {
        super.dataDeAdimissao = dataDeAdimissao;
        super.salario = salario;
        this.setor = setor;
    }

    public String getEscolaOuSetor() {
        return setor;
    }

    public void setEscolaOuSetor(String escolaOuSetor) {
        this.setor = escolaOuSetor;
    }

    public int getDataDeAdimissao() {
        return dataDeAdimissao;
    }

    public void setDataDeAdimissao(int dataDeAdimissao) {
        this.dataDeAdimissao = dataDeAdimissao;
    }

}
