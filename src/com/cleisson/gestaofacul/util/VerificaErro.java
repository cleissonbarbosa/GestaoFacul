/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.util;

import java.awt.Color;

/**
 * classe com metodos para verificar onde esta o erro nos relatorios e destaca-los
 * @author Cleisson Barbosa
 */
public class VerificaErro {

    private javax.swing.JTextField campo;
    private static javax.swing.JComboBox<String> escolha;

    //public VerificaErro(javax.swing.JTextField campo){
    //  this.campo = campo;
    //}

    /**
     *
     * @param campo
     * @return
     */
    public boolean encontrar(javax.swing.JTextField campo) {
        try {
            int aux = Integer.parseInt(campo.getText());
        } catch (NumberFormatException e) {
            campo.setBackground(Color.red);
            campo.setForeground(Color.white);
            campo.setFocusable(true);
            return true;
        }
        return false;
    }

    /**
     *
     * @param campo
     * @return
     */
    public boolean encontrarCampoVazio(javax.swing.JTextField campo) {
        if(!campo.getText().equals("")){
        } else{
            campo.setBackground(Color.red);
            campo.setForeground(Color.white);
            campo.setFocusable(true);
            return true;
        }
        return false;
    }

    /**
     *
     * @param escolha
     * @return
     */
    public boolean encontrar(javax.swing.JComboBox<String> escolha) {
        if (escolha.getSelectedItem() == null) {
            escolha.setBackground(Color.red);
            escolha.setFocusable(true);
            escolha.setToolTipText("É necessario CADASTRAR uma escola na ABA correspondente");
            return true;
        }
        return false;
    }

}
