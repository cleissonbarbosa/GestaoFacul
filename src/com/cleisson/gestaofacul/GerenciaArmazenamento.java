/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gerenciar o armazenamento dos registros salvos, criando o arquivo
 * e atribuindo a ele os registros do usuario
 * @author Cleisson Barbosa
 */
public class GerenciaArmazenamento {
    
    public static void WriteFile(String json, String caminho) {
        Path arquivo = Paths.get(caminho);
        
        //se o arquivo não existir
        if (!Files.exists(arquivo)) {
            BufferedWriter bw = null;
            try {
                //cria o arquivo
                Files.createFile(arquivo);
                //escreve no arquivo os registros do usuario
                bw = new BufferedWriter(new FileWriter(arquivo.toFile(), true));
                bw.write(json);
            } catch (IOException ex) {
                Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    
                    bw.close();
                    //passando para o arquivo o atributo SOMENTE LEITURA
                    File file = new File(caminho);
                    file.setWritable(false);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            //se o arquivo ja existe, então apenas atualizar
            BufferedWriter bw = null;
            BufferedWriter bw2 = null;
            try {
                //Deixando o arquivo editavel temporariamente
                File file = new File(caminho);
                file.setWritable(true);
                
                //Atualizando o arquivo com o novo registro
                bw2 = new BufferedWriter(new FileWriter(arquivo.toFile()));
                bw = new BufferedWriter(new FileWriter(arquivo.toFile(), true));
                //bw.newLine();

                bw.write(json);
            } catch (IOException ex) {
                Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bw2.close();
                    bw.close();
                    //passando para o arquivo o atributo SOMENTE LEITURA
                    File file = new File(caminho);
                    file.setWritable(false);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     * metodo para ler os registros salvos em JSON e passar para arrayList
     * @param caminho
     * @return
     */
    public static ArrayList<String> ReadFile(String caminho) {
        ArrayList<String> linhas = new ArrayList<>();
        Path arquivo = Paths.get(caminho);
        if (Files.exists(arquivo)) {
            try {
                linhas = (ArrayList<String>) Files.readAllLines(arquivo, Charset.defaultCharset());
            } catch (IOException ex) {
                Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return linhas;
    }
}