package estruturas;

import java.io.*;

public class Texto {


    public static String ler(String arquivo) {
        String texto = "";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = "";
            while ((linha = br.readLine()) != null) {
                texto += linha + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto;
    }

    public static void escrever(String arquivo, String novoTexto) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(novoTexto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Lista<String> dividirLinhas(String texto) {
        Lista<String> linhas = new Lista<>();

        int i = 0;
        int o = texto.length();
        String linha = "";

        while (i < o) {
            String letra = String.valueOf(texto.charAt(i));

            if (letra.contentEquals("\n")){
                linhas.adicionar(linha);
                linha = "";
            }else{
                linha += letra;
            }

            i++;
        }
        linhas.adicionar(linha);
        return linhas;
    }

    public static Lista<String> dividirPorSimbolo(String linha, String simbolo){
        Lista<String> linhas = new Lista<>();

        int i = 0;
        int o = linha.length();
        String celula = "";

        while (i < o) {
            String letra = String.valueOf(linha.charAt(i));

            if (letra.contentEquals(simbolo)){
                linhas.adicionar(celula);
                celula = "";
            }else{
                celula += letra;
            }

            i++;
        }
        linhas.adicionar(celula);
        return linhas;
    }

    public static String minusculo(String texto){
        int i = 0;
        int o = texto.length();
        String textoMinusculo = "";

        while (i < o) {
            char letra = texto.charAt(i);

            textoMinusculo += Character.toLowerCase(letra);

            i++;
        }

        return textoMinusculo;
    }

    public static String maiusculo(String texto){
        int i = 0;
        int o = texto.length();
        String textoMaiusculo = "";

        while (i < o) {
            char letra = texto.charAt(i);

            textoMaiusculo += Character.toUpperCase(letra);

            i++;
        }

        return textoMaiusculo;
    }
}
