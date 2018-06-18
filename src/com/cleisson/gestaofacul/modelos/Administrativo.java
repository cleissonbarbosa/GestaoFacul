/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.modelos;

/**
 * Classe modelo para os registros administrativo
 * @author Cleisson Barbosa
 */
public class Administrativo extends Funcionarios{

    private Setor setor;

    /**
     *
     * @param setor
     * @param dataDeAdimissao
     * @param salario
     * @param endereco
     * @param matricula
     * @param nome
     * @param telefone
     */
    public Administrativo( Setor setor, int dataDeAdimissao, float salario, String endereco, int matricula, String nome, int telefone) {
        super(dataDeAdimissao, salario, endereco, matricula, nome, telefone);
         this.setor = setor;
    }

    /**
     *
     * @return objeto setor
     */
    public Setor getSetor() {
        return setor;
    }

    /**
     *
     * @param Setor
     */
    public void setSetor(Setor Setor) {
        this.setor = Setor;
    }

    
}
