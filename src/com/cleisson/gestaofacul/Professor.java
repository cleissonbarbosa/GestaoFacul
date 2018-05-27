package com.cleisson.gestaofacul;

/**
 *
 * @author cleisson
 */
public class Professor extends Funcionarios{

    
    private String escola;

    public Professor(String endereco, int matricula, String nome, int telefone) {
        super(endereco, matricula, nome, telefone);
    }

    public void inserirProfessor( int dataDeAdimissao, float salario,  String escola) {
        super.dataDeAdimissao = dataDeAdimissao;
        super.salario = salario;
        this.escola = escola;
    }

    public String getEscolaOuSetor() {
        return escola;
    }

    public void setEscolaOuSetor(String escolaOuSetor) {
        this.escola = escolaOuSetor;
    }

    public int getDataDeAdimissao() {
        return dataDeAdimissao;
    }

    public void setDataDeAdimissao(int dataDeAdimissao) {
        this.dataDeAdimissao = dataDeAdimissao;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }
}
