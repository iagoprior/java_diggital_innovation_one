package Aulas_Java_Avancado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciasExemplo {

    public static void main(String[] args) throws IOException {

        printarNome("João");
        printarSoma(2,3,5,6,7,8);

    }

    private static void connectAndPrintURL() throws IOException {
        var url = new URL("https://docs.oracle.com/en/database/index.html");
        var urlConnection = url.openConnection();



        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));

    }

    public static void printarNome(String nome){
        System.out.println(nome);

    }

    public static void printarSoma(int... numeros){
        int soma ;
        if(numeros.length > 0){
            soma = 0;
            for (int numero: numeros){
                soma+=numero;
            }
            System.out.println(soma);
        }

    }
}

// Consegue usar var em variáveis locais inicializadas, em variavel do suporte do enhaced for, e for iterativo

// N consegue usar var em : nivel de classe, como parametro, em variaveis locais nao inicializadas