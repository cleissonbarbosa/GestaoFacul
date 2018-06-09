/*
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.awt.Color;

/**
 *
 * @author Cleisson Barbosa
 */
public class VerificaErro {

    private javax.swing.JTextField campo;
    private static javax.swing.JComboBox<String> escolha;

    //public VerificaErro(javax.swing.JTextField campo){
    //  this.campo = campo;
    //}
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
