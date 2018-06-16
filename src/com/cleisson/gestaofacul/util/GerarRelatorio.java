/*
 * GNU GENERAL PUBLIC LICENSE
    Version 3, 29 June 2007
 */
package com.cleisson.gestaofacul.util;

import com.cleisson.gestaofacul.modelos.Administrativo;
import com.cleisson.gestaofacul.modelos.Aluno;
import com.cleisson.gestaofacul.modelos.Curso;
import com.cleisson.gestaofacul.modelos.Disciplinas;
import com.cleisson.gestaofacul.modelos.Escolas;
import com.cleisson.gestaofacul.modelos.Professor;
import com.cleisson.gestaofacul.modelos.Turmas;
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
 * classe com metodos para gerar relatorio dos registros salvos
 * essa classe salva os reistros no formato PDF
 * @author Cleisson Barbosa
 */
public class GerarRelatorio {

    public class Tabela {

        protected PdfPTable table;
        protected float tableHeight;

        public Tabela(ArrayList lista, String objeto) {
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14, 3, BaseColor.BLUE);
            switch (objeto) {
                case "Professor":
                    table = new PdfPTable(2);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("Nome  ", font));
                    table.addCell(new ListItem("Matricula  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Professor professor = (Professor) lista.get(i);
                        table.addCell(professor.getNome());
                        table.addCell(Integer.toString(professor.getMatricula()));
                    }
                    break;
                case "Aluno":
                    table = new PdfPTable(2);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("Nome  ", font));
                    table.addCell(new ListItem("Matricula  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Aluno aluno = (Aluno) lista.get(i);
                        table.addCell(aluno.getNome());
                        table.addCell(Integer.toString(aluno.getMatricula()));
                    }
                    break;
                case "Funcionario":
                    table = new PdfPTable(2);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("Nome  ", font));
                    table.addCell(new ListItem("Matricula  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Administrativo adm = (Administrativo) lista.get(i);
                        table.addCell(adm.getNome());
                        table.addCell(Integer.toString(adm.getMatricula()));
                    }
                    break;
                case "Turmas":
                    table = new PdfPTable(4);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("Nome  ", font));
                    table.addCell(new ListItem("Disciplina  ", font));
                    table.addCell(new ListItem("Professor  ", font));
                    table.addCell(new ListItem("Alunos  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                    Turmas turma = (Turmas) lista.get(i);
                    String exibirAlunos = "";
                    for (int x = 0; x < turma.getAluno().size(); x++) {
                    Aluno aluno = (Aluno) turma.getAluno().get(x);
                    exibirAlunos += aluno.getNome() + "\n";
                    }
                    table.addCell(turma.getNome());
                    table.addCell(turma.getDisciplinas().getNome());
                    table.addCell(turma.getProfessor().getNome());
                    table.addCell(exibirAlunos);
                    }
                    break;
                case "Escolas":
                    table = new PdfPTable(2);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("ID  ", font));
                    table.addCell(new ListItem("Nome da Escola  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Escolas escola = (Escolas) lista.get(i);
                        table.addCell(Integer.toString(escola.getId()));
                        table.addCell(escola.getNome());
                    }
                    break;
                 case "Cursos":
                    table = new PdfPTable(3);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("ID  ", font));
                    table.addCell(new ListItem("Nome do Curso  ", font));
                    table.addCell(new ListItem("Nome da Escola  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Curso curso = (Curso) lista.get(i);
                        table.addCell(Integer.toString(curso.getId()));
                        table.addCell(curso.getNome());
                        table.addCell(curso.getEscola().getNome());
                    }
                    break;
                case "Disciplinas":
                    table = new PdfPTable(3);
                    table.setTotalWidth(523);
                    table.setLockedWidth(true);
                    table.addCell(new ListItem("ID  ", font));
                    table.addCell(new ListItem("Nome da Disciplina  ", font));
                    table.addCell(new ListItem("Nome do Curso  ", font));
                    for (int i = 0; i < lista.size(); i++) {
                        Disciplinas disc = (Disciplinas) lista.get(i);
                        table.addCell(Integer.toString(disc.getId()));
                        table.addCell(disc.getNome());
                        table.addCell(disc.getCurso().getNome());
                    }
                    break;
                default:
                    System.err.println("Nenhuma das opções correspondentes");
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
        //Professor professor;

        try {
            Tabela tabela = new Tabela(lista, classe);
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio-Completo__Gestão-Faculdade__" + classe + ".pdf"));

            document.open();
            // adicionando ao documento
            Font font = new Font(Font.FontFamily.HELVETICA, 18, 3);
            document.addTitle("Relatorio Completo de " + classe + " - Projeto de P.O.O.");
            document.add(new ListItem("Relatorio Completo de " + classe + " - Gestão Faculdade", font));
            document.add(new LineSeparator(1, 100, BaseColor.RED, 1, -4));
            document.add(new Paragraph("\n\n"));
            document.add(new PdfPTable(tabela.table));
            JOptionPane.showMessageDialog(null, "PDF de " + classe + " foi criado com sucesso!\nClique em OK para abrir o PDF !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            java.awt.Desktop.getDesktop().open(new File("Relatorio-Completo__Gestão-Faculdade__" + classe + ".pdf"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
    }
}
