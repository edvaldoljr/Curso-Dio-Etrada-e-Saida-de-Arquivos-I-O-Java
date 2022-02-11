package me.dio.web.projeto.aulas.IOBytes;

import java.io.*;

//Faça uma cópia do arquivo “recomendacoes-copy.txt”.
public class ExemploIOBytes {

    public static void copiarArquivos() throws IOException {
        //Classe utilizada para especificar arquivos ou diretorios
        File f = new File("C:\\Users\\Edvaldo junior\\Documents\\Curso-Dio-Entrada-e-Saida-de-Arquivos-I-O-Java\\recomendacoes-copy.txt");
        //método para recuperar o nome do arquivo ou diretório
        String nomeArquivo = f.getName();

//        //Abrindo arquivo que será copiado
//        //Fluxo de entrada que lê de um arquivo
//        InputStream is = new FileInputStream(nomeArquivo);
//        //Fluxo de entrada que armazena em um buffer
//        BufferedInputStream bis = new BufferedInputStream(is);

        //Padrão decorator
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo));

        //Preparando o nome do novo arquivo cópia
        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf(".txt")).concat("-copy2");
        //Classe utilizada para especificaar arquivos ou diretporios
        File fcopy = new File(nomeArquivoCopy);

//        //Fluxo de saída que grava em um arquivo
//        OutputStream os = new FileOutputStream(fcopy.getName());
//        //Fluxo de saída armazena em um buffer
//        BufferedOutputStream bos = new BufferedOutputStream(os);

        //Padrão decoraator
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fcopy));

        int line = 0;
        while ((line = bis.read()) != -1){
            bos.write((char)line);
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fcopy.getName(), fcopy.getAbsolutePath(), fcopy.length());
    }

    public static void main(String[] args) throws IOException {
        copiarArquivos();
    }
}
