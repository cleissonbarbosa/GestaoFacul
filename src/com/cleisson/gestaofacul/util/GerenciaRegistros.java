/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.util;

import com.cleisson.gestaofacul.Main;
import com.cleisson.gestaofacul.modelos.Disciplinas;
import com.cleisson.gestaofacul.modelos.Setor;
import com.cleisson.gestaofacul.modelos.Turmas;
import com.cleisson.gestaofacul.modelos.Curso;
import com.cleisson.gestaofacul.modelos.Pessoa;
import com.cleisson.gestaofacul.modelos.Escolas;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Gerenciar os registros salvos, modificando o arquivo ou excluindo-o 
 * completamente.
 * @author Cleisson Barbosa
 */
public class GerenciaRegistros {

    //Variavel para identificar se o arquivo foi modificado ou deletado!
    private boolean deletado;
    //Variavel para atualizar o arrayList modificado
    public ArrayList listaAtualizada;

    public void DeletFile(ArrayList lista, String deletar, String caminho) {
        //Convertendo o caminho do arquivo em path
        Path arquivo = Paths.get(caminho);

        //Verifica se o arquivo ja existe no caminho inserido
        if (!Files.exists(arquivo)) {
            //se o arquivo não existe então não faz nada
        } else {
            //se o arquivo existe
            try {
                //se o usuario digitar tudo (ignorando a Case)
                if (deletar.equalsIgnoreCase("tudo")) {
                    //deleta o arquivo por completo
                    File file = new File(caminho);
                    file.setWritable(true);
                    Files.deleteIfExists(arquivo);
                } else {
                    /*se o usuario qualquer outra coisa, passa para a lista atualizada
                      o retorno do metodo remover
                     */
                    listaAtualizada = remover(lista, deletar);
                }
            } catch (IOException ex) {
                Logger.getLogger(GerenciaRegistros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Metodo para deletar todos os registros de uma unica vez
    public boolean todosRegistros(File arquivo) {
        //convertendo todos os caminhos em path
        if (arquivo.isDirectory()) {
            File[] files = arquivo.listFiles();
            for (int i = 0; i < files.length; ++i) {
                todosRegistros (files[i]);
            }
        }
        arquivo.delete();
        return true;
    }

    //metodo para remover um elemento da lista e dos registros
    public ArrayList remover(ArrayList lista, String deletar) {
        for (int i = 0; i < lista.size(); i++) {

            try {
                //professores
                if (lista.equals(Main.professorDB) || lista.equals(Main.alunoDB) || lista.equals(Main.funcionarioDB)) {
                    Pessoa pessoa = (Pessoa) lista.get(i);
                    try{
                    if (pessoa.getMatricula() == Integer.parseInt(deletar)) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + pessoa.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos este Professor no banco de dados!");
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "É permitido apenas numeros!");
                    }
                    //turmas
                } else if (lista.equals(Main.turmasDB)) {
                    Turmas turmas = (Turmas) lista.get(i);
                    if (turmas.getNome().toLowerCase().contains(deletar.toLowerCase())) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + turmas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos esta Turma no banco de dados!");
                        }
                    //cursos
                } else if (lista.equals(Main.cursosDB)) {
                    Curso curso = (Curso) lista.get(i);
                    if (curso.getNome().toLowerCase().contains(deletar.toLowerCase())) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + curso.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos este curso no banco de dados!");
                        }
                    //disciplinas
                } else if (lista.equals(Main.disciplinaDB)) {
                    Disciplinas disciplinas = (Disciplinas) lista.get(i);
                    if (disciplinas.getNome().toLowerCase().contains(deletar.toLowerCase())) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + disciplinas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos esta Disciplina no banco de dados!");
                        }
                    //setor
                } else if (lista.equals(Main.setorDB)) {
                    Setor setor = (Setor) lista.get(i);
                    if (setor.getNome().toLowerCase().contains(deletar.toLowerCase())) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + setor.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos este Setor no banco de dados!");
                        }
                    //escolas
                } else if (lista.equals(Main.escolasDB)) {
                    Escolas escolas = (Escolas) lista.get(i);
                    if (escolas.getNome().toLowerCase().contains(deletar.toLowerCase())) {
                        if (JOptionPane.showConfirmDialog(null, "Você quer excluir: " + escolas.getNome(), "ATENÇÃO!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            lista.remove(i);
                            this.deletado = true;
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "não encontramos esta Escola no banco de dados!");
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
