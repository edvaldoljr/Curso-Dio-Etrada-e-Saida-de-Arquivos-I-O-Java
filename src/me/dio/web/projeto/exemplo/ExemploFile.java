package me.dio.web.projeto.exemplo;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploFile {

    public static void main(String[] args) {

        File f = new File("dica-para-ler-arquivos-java-IO.txt");
        System.out.println("Nome do arquivo: " + f.getName());
        System.out.println("Caminho do arquivo: " + f.getPath());
        System.out.println("Caminho absoluto; " + f.getAbsolutePath());
        System.out.println("Diretorio Pai: " +f.getParent());
        System.out.println(f.exists() ? "Existe" : "Não existe");
        System.out.println(f.canWrite() ?"Pode ser gravado" : "Não pode ser gravado");
        System.out.println(f.canRead() ? "Pode ser lido" : "Não pode ser lido");
        System.out.println(f.isDirectory() ? "É um Diretório" : "Não é um Diretório");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date(f.lastModified());
        System.out.println("Ultima modificação do arquivo: " + df.format(data));
        System.out.println("Tamanho do aquivo: " + f.length() + "bytes.");
    }
}
