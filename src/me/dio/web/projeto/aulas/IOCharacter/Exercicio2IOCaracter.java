package me.dio.web.projeto.aulas.IOCharacter;

/**
 * - Abra o teclado para escrever 3 filmes
 * que você recomendaria e armazene em "recomendacoes.txt"
 */

import java.io.*;
import java.util.Scanner;

/**
 * - Utilizamos a classe Scanner para abrir o teclado
 * - Utilizamos a classe File pra termos controle do nosso arquivo.
 * - Classe FileWriter para criação e escrita do arquivo "recomendacoes.txt"
 * - BufferedWriter para melhorar a escrita dos characteres
 * - PrintWhiter para escrever mensagem no console
 */

public class Exercicio2IOCaracter {

    public static void lerTecladoEscreverDocumento() throws IOException {

        //Escrevendo no console
        PrintWriter pw = new PrintWriter(System.out);
        //Mensagem que será exibida no console
        pw.write("Recomende 3 filmes e para finalizar digite 'fim': ");
        //Criando uma nova linha
        pw.println();
        //Descarregue o conteudo do método write no console
        pw.flush();

        //Abertura do teclado
        Scanner scanner = new Scanner(System.in);
        //Captura da linha do teclado
        String line = scanner.nextLine();

        //Classe utilizada para especificar arquivos ou diretorios.
        File f = new File("recomendacoes.txt");

//        //Criando o documento recomentacoes.txt
//        Writer w = new FileWriter(f.getName());
//        //Criando um buffer interno para armazenar os characters em vez de gravar diretamente no disco.
//        //Assim que buffer preenchido ou o gravador fechado, todos os characters do buffer são gravados no disco.
//        BufferedWriter bw = new BufferedWriter(w);

        //Utilizando o padrão decorator
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do { //faça
            //Escreva no buffer interno alinha capturada pelo scanner
            bw.write(line);
            //Pule para próxima linha
            bw.newLine();
            //Pegue a próxima linha do teclado
            line = scanner.nextLine();

            //Repita as operações do laço do-while. Quando digitado a palavra 'fim', pare
        } while (!line.equalsIgnoreCase("fim"));
        //Terminando o laço descarregue as informações capturadas pelo teclado no arquivo recomendacoes.txt
        bw.flush();

        //Utilizando o método printf da classe PrintWrite para foramtar a mensagaem que será exibida no console
        pw.printf("Tudo certo! Arquivo '%s' foi criado com tamanho '%d' bytes.", f.getName(), f.length());
        //Descarregue o conteúdo do método write no console
        pw.flush();
        //(Neste caso não precisaremos do método flush já que em seguida fechamos o fluxo: pw.close())

        //Fechamos o fluxos
        bw.close(); //Fechamos o fluxo de saída para escrita no documento
        pw.close(); //Fechamos o fluxo de saída para o console
    }


    public static void main(String[] args) throws IOException {

        //Chamando método
        lerTecladoEscreverDocumento();
    }
}
