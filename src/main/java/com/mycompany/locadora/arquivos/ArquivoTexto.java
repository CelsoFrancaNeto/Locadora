/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.locadora.arquivos;

import com.mycompany.locadora.locadora.Filmes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Celso França Neto
 */
public class ArquivoTexto {

    private static FileWriter arquivo;
    private static PrintWriter gravarArquivo;

    public static boolean openFile() {
        try {
            arquivo = new FileWriter("filmeList.txt", true);
            return true;
        } catch (IOException e) {
            System.err.println("Erro: Arquivo nao encontrado!");
            return false;
        }
    }

    public static void writer(Filmes filme) {
        try {
            arquivo = new FileWriter("filmeList.txt", true);
            gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.format("%s;%s;%s;%B\n", filme.getNome(),filme.getCategoria(),filme.getPreco(),filme.isEstado());
            gravarArquivo.close();

        } catch (NullPointerException nullPointerException) {
            System.out.println("Erro: Arquivo nao foi criado previamente ou deletado!");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Erro: Arquivo nao encontrado!");
        }
    }

    public static void cleaner() {
        try {
            arquivo = new FileWriter("filmeList.txt");
        } catch (IOException e) {
            System.err.println("Erro: Arquivo nao encontrado!");
        }
        try {
            arquivo = new FileWriter("filmeList.txt", true);
        } catch (IOException e) {
            System.err.println("Erro: Arquivo nao encontrado!");
        }
    }

    public static void close() {
        try {
            arquivo.close();
            gravarArquivo.close();
        } catch (IOException e) {
            System.err.println("Erro: Nao foi possivel encontrar o aqruivo!");
        }
    }

    public static ArrayList reader() {
        ArrayList<String> content = new ArrayList();
        try {
            FileReader arq = new FileReader("filmeList.txt");
            BufferedReader lerArquivo = new BufferedReader(arq);
            try {
                String line = lerArquivo.readLine();
                while (line != null) {
                    content.add(line);
                    line = lerArquivo.readLine();
                }

            } catch (IOException e) {
                System.err.println("Erro: Nao foi possivel ler o arquivo!");

            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo nao encontrado!");
        }

        return content;
    }
}
