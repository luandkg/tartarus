package testes;

import estruturas.Texto;
import estruturas.fmt;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteFMT {

    @TesteCalebe
    public static void FMT_esquerda(TestandoCalebe teste){
        String texto = "calebe";

        String novoTexto = fmt.esquerda(texto,10);
        //System.out.println(novoTexto+"|");;

        teste.deveSerIgual("calebe    ", novoTexto,"FMT_esquerda -> Teste_1");


    }

    @TesteCalebe
    public static void FMT_direita(TestandoCalebe teste){
        String texto = "calebe";

        String novoTexto = fmt.direita(texto,10);
        //System.out.println(novoTexto+"|");;

        teste.deveSerIgual("    calebe", novoTexto,"FMT_direita -> Teste_1");
    }

    @TesteCalebe
    public static void FMT_multiplas(TestandoCalebe teste){
        String texto0 = "\n\naksdmjoausdo\n\nafjoaf[pa";
        String texto1 = "\n\naksdmjoausdo\n\nafjoaf[pa";

        //fmt.printEsquerdaMultiplasLinhas(texto1,50);
        //System.out.print("|");

        //fmt.printDireitaMultiplasLinhas(texto1,50);
        //System.out.print("|");
    }

    @TesteCalebe
    public static void FMT_println(TestandoCalebe teste){
        String t1 = fmt.formatar("Calebe e ");
        teste.deveSerIgual("Calebe e ", t1,"FMT_println -> Teste_1");

        String t2 = fmt.formatar("Calebe e {}","lindo");
        teste.deveSerIgual("Calebe e lindo", t2,"FMT_println -> Teste_2");

        String t3 = fmt.formatar("Calebe e {}, tem {} anos","lindo", 23);
        teste.deveSerIgual("Calebe e lindo, tem 23 anos", t3,"FMT_println -> Teste_3");

        String t4 = fmt.formatar("|Calebe e {direita_10}|","lindo");
        teste.deveSerIgual("|Calebe e      lindo|", t4,"FMT_println -> Teste_4");

        String t5 = fmt.formatar("|Calebe e {esquerda_10}|","lindo");
        teste.deveSerIgual("|Calebe e lindo     |", t5,"FMT_println -> Teste_5");

        int a = 1;
        int b = 2;
        int c = 3;
        String t6 = fmt.formatar("|{} + {} = {}|",a,b,a+b);
        teste.deveSerIgual("|"+a+" + "+b+" = "+c + "|", t6,"FMT_println -> Teste_6");
    }
}
