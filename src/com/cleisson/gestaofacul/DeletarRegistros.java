/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleisson.gestaofacul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cleisson
 */
public class DeletarRegistros {

    private boolean deletado;
    public ArrayList listaAtualizada;

    public void DeletFile(ArrayList lista, String deletar, String caminho) {
        Path arquivo = Paths.get(caminho);

        if (!Files.exists(arquivo)) {

        } else {
            try {
                if (deletar.equalsIgnoreCase("tudo")) {
                    Files.deleteIfExists(arquivo);
                } else {
                    listaAtualizada = remover(lista, deletar);
                }
            } catch (IOException ex) {
                Logger.getLogger(DeletarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean todosRegistros() {
        Path arquivo0 = Paths.get("registroProfessor.txt");
        Path arquivo1 = Paths.get("registroAluno.txt");
        Path arquivo2 = Paths.get("registroCurso.txt");
        Path arquivo3 = Paths.get("registroDisciplina.txt");
        Path arquivo4 = Paths.get("registroTurma.txt");
        Path arquivo5 = Paths.get("registroSetor.txt");
        Path arquivo6 = Paths.get("registroAdm.txt");
        Path arquivo7 = Paths.get("registroEscolas.txt");
        try {
            Files.deleteIfExists(arquivo0);
            Files.deleteIfExists(arquivo1);
            Files.deleteIfExists(arquivo2);
            Files.deleteIfExists(arquivo3);
            Files.deleteIfExists(arquivo4);
            Files.deleteIfExists(arquivo5);
            Files.deleteIfExists(arquivo6);
            Files.deleteIfExists(arquivo7);
            this.deletado = true;
        } catch (IOException ex) {
            this.deletado = false;
            Logger.getLogger(DeletarRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deletado;
    }

    public ArrayList remover(ArrayList lista, String deletar) {
        for (int i = 0; i < lista.size(); i++) {

            try {
                if (lista.equals(Main.professorDB) || lista.equals(Main.alunoDB) || lista.equals(Main.funcionarioDB)) {
                    Pessoa pessoa = (Pessoa) lista.get(i);
                    if (pessoa.getMatricula() == Integer.parseInt(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + pessoa.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                } else if (lista.equals(Main.turmasDB)) {
                    Turmas turmas = (Turmas) lista.get(i);
                    if (turmas.getNome().contains(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + turmas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                } else if (lista.equals(Main.cursosDB)) {
                    Curso curso = (Curso) lista.get(i);
                    if (curso.getNome().contains(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + curso.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                } else if (lista.equals(Main.disciplinaDB)) {
                    Disciplinas disciplinas = (Disciplinas) lista.get(i);
                    if (disciplinas.getNome().contains(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + disciplinas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                } else if (lista.equals(Main.setorDB)) {
                    Setor setor = (Setor) lista.get(i);
                    if (setor.getNome().contains(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + setor.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                } else if (lista.equals(Main.escolasDB)) {
                    Escolas escolas = (Escolas) lista.get(i);
                    if (escolas.getNome().contains(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + escolas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }
                }
            } catch (Exception e) {
                this.deletado = false;
            }
        }

        return lista;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

}
