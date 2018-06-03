/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cleisson.gestaofacul;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cleisson
 */
public class GerarRelatorio {

    public class Tabela {

        protected PdfPTable table;
        protected float tableHeight;

        public Tabela(ArrayList lista, String objeto) {
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14, 3, BaseColor.BLUE);
            table = new PdfPTable(2);
            table.setTotalWidth(523);
            table.setLockedWidth(true);
            table.addCell(new ListItem("Nome  ", font));
            table.addCell(new ListItem("Matricula  ", font));
            switch (objeto) {
                case "Professor":
                    for (int i = 0; i < lista.size(); i++) {
                        Professor professor = (Professor) lista.get(i);
                        table.addCell(professor.getNome());
                        table.addCell(Integer.toString(professor.getMatricula()));
                    }
                    break;
                case "Aluno":
                    for (int i = 0; i < lista.size(); i++) {
                        Aluno aluno = (Aluno) lista.get(i);
                        table.addCell(aluno.getNome());
                        table.addCell(Integer.toString(aluno.getMatricula()));
                    }
                    break;
                case "Funcionario":
                    for (int i = 0; i < lista.size(); i++) {
                        Administrativo adm = (Administrativo) lista.get(i);
                        table.addCell(adm.getNome());
                        table.addCell(Integer.toString(adm.getMatricula()));
                    }
                    break;
            }
            tableHeight = table.getTotalHeight();
        }

        public float getTableHeight() {
            return tableHeight;
        }

        public void onEndPage(PdfWriter writer, Document document) {
            table.writeSelectedRows(0, -1,
                    document.left(),
                    document.top() + ((document.topMargin() + tableHeight) / 2),
                    writer.getDirectContent());
        }
    }

    public void gerarPDF(ArrayList lista, String classe) {
        // criação do documento
        Document document = new Document();
        Professor professor;

        try {
            Tabela tabela = new Tabela(lista, classe);
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio-Completo__Gestão-Faculdade__" + classe + ".pdf"));

            document.open();
            // adicionando ao documento
            Font font = new Font(Font.FontFamily.HELVETICA, 18, 3);
            document.addTitle("Relatorio Completo  -  Gestão Faculdade - Projeto de P.O.O.");
            document.add(new ListItem("Relatorio Completo  -  Gestão Faculdade - Projeto de P.O.O.", font));
            document.add(new LineSeparator(1, 100, BaseColor.RED, 1, -4));
            document.add(new Paragraph("\n\n"));
            document.add(new PdfPTable(tabela.table));
            JOptionPane.showMessageDialog(null, "PDF foi criado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            java.awt.Desktop.getDesktop().open(new File("Relatorio-Completo__Gestão-Faculdade__" + classe + ".pdf"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
    }
}
