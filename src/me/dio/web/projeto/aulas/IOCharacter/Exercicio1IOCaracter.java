package me.dio.web.projeto.aulas.IOCharacter;


import java.io.*;

/**
 * Abra no teclado para escrever 3 filmes que você recomendaria
 * e exiba esses filmes no console.
 *
 * - Usaremos o fluxo predefinido System.in para abrir o teclado
 * - Classe InputStremReader para transformar fluxo dos dados de entrada
 * - BufferedWriter para transformar o fluxo do System.out para imprimir no console
 * - Usaremos o fluxo predefinido System.out para imprimir no console
 * - Classes OutputStremWriter para transformar o fluxo do System.out em bytes
 * - BufferedWhiter para meçlhorar a manioulação dos dados de saída
 * */

public class Exercicio1IOCaracter {

    public static void abrirTecladoExibirConsole() throws IOException{
        System.out.println("Digite 3 sugestões de filmes: ");
//        //Abrindo teclado
//        //Abrindo um fluxo de daddos para receber entrada através do teclado
//        InputStream is = System.in;
//        //Ponte que tranforma o fluxo do InputStream em character
//        Reader isr = new InputStreamReader(is);
//        //Lê o strem de character e armazena em um buffer para facilitar a leitura desses characteres
//        BufferedReader br = new BufferedReader(isr);
//        String Line = br.readLine();

        /**
         * O Decoretor é um padrão estrutural que permite adicionar novos
         * comportamentos aos objetos denamicamente, colocando-os dentro de objetos wrapper especiais
         *
         * - Usando decoradores podemos agrupar objetos inúmeras vezes, pois os objetos de destino
         * e os decoradores seguem a mesma interface. O objeto resultante terá um comportamento
         * de empilhamento de todos os wrappers.
         */

        //Decoretor
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Line = br.readLine();

//        //preparando a escrita no console
//        //Abrindo um floxo de dados para enciar dados para console
//        OutputStream os = System.out;
//        //Ponte que transforma o fluxo OutputStrem em character
//        OutputStreamWriter osr = new OutputStreamWriter(os);
//        //Grava o strem de character (texto) e armazena em um Buffer para facilitar a esvrita desses characteres
//        BufferedWriter bw = new BufferedWriter(osr);

        //Decoretor
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Agora precisamos ler do teclado e enviar para o console
        //Método readLine lê cada linha do texto e retorna uma String.
        String line = br.readLine();

        do { //faça:
            //pegue a linha lide através do teclado e armazene em um buffer
            bw.write(line);
            //Depois insira uma linha
            bw.newLine();
            //Depois de realizado a cópia de linha acima, preenchemos a linha novamente
            line = br.readLine();
        }while (!line.isEmpty());

        //Precisamos descarregar nossas informações utilizando o método flush
        bw.flush();

        //Fechamos o fluxo de entrada
        br.close();
        //Fechamos o fluxo de saída
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoExibirConsole();
    }
}