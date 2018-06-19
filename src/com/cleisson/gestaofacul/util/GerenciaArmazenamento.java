/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.util;

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
 * @version 1.0.4
 */
public class GerenciaArmazenamento {
    
    /**
     *
     * @param json
     * @param caminho
     */
    public static void WriteFile(String json, String caminho) {
        Path pasta = Paths.get("arquivos");
        Path arquivo;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            arquivo = Paths.get("." + caminho);
        } else {
            arquivo = Paths.get("arquivos\\" + caminho);
        }
        
        
        //se o arquivo não existir
        if (!Files.exists(arquivo)) {
            BufferedWriter bw = null;
            try {
                //cria o arquivo
                
                
                if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                    File file = new File("." + caminho);
                    bw = new BufferedWriter(new FileWriter(file, true));
                    bw.write(json);
                } else {
                    Files.createDirectories(pasta);
                    File file = new File("arquivos\\" + caminho);
                    bw = new BufferedWriter(new FileWriter(file, true));
                    bw.write(json);
                }
                //Files.createFile(arquivo);
                //escreve no arquivo os registros do usuario
            } catch (IOException ex) {
                Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    
                    bw.close();
                    //passando para o arquivo o atributo SOMENTE LEITURA
                    File file = new File(caminho);
                    file.setWritable(false);
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                    String comando = "C:\\WINDOWS\\System32\\ATTRIB.EXE +H arquivos";
                    Runtime.getRuntime().exec(comando );
                    }
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
                if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                    File file = new File("." + caminho);
                    file.setWritable(true);
                    //Atualizando o arquivo com o novo registro
                    bw2 = new BufferedWriter(new FileWriter(file));
                    bw = new BufferedWriter(new FileWriter(file, true));
                } else {
                    File file = new File("arquivos\\" + caminho);
                    file.setWritable(true);
                    //Atualizando o arquivo com o novo registro
                    bw2 = new BufferedWriter(new FileWriter(file));
                    bw = new BufferedWriter(new FileWriter(file, true));
                }
                bw.write(json);
            } catch (IOException ex) {
                Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    bw2.close();
                    bw.close();
                    //passando para o arquivo o atributo SOMENTE LEITURA
                    File file = new File("arquivos\\" + caminho);
                    file.setWritable(false);
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                    String comando = "C:\\WINDOWS\\System32\\ATTRIB.EXE +H arquivos";
                    Runtime.getRuntime().exec(comando );
                    }
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
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            Path arquivo = Paths.get("." + caminho);
            if (Files.exists(arquivo)) {
                try {
                    linhas = (ArrayList<String>) Files.readAllLines(arquivo, Charset.defaultCharset());
                } catch (IOException ex) {
                    Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            Path arquivo = Paths.get("arquivos\\" + caminho);
            if (Files.exists(arquivo)) {
                try {
                    linhas = (ArrayList<String>) Files.readAllLines(arquivo, Charset.defaultCharset());
                } catch (IOException ex) {
                    Logger.getLogger(GerenciaArmazenamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return linhas;
    }
}
