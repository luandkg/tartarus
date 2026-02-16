package utils;

import auxiliar.Ponto;
import estruturas.Caixa;
import estruturas.ItemComPosicao;
import estruturas.Lista;

public class Ferramenta {

    public static void confirmaQuantidade(int recebido, int tamanho) {
        if (recebido == tamanho) {
            System.out.println("A lista esta OK");
        } else {
            System.out.println("A Lista esta corrompida!");
        }
    }

    public static void printListaString(Lista<String> l) {
        System.out.println("------------------Lista Ligada------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            String valor = l.get(i);
            System.out.println("Indice: " + i + " | Valor: " + valor);
        }
        System.out.println("--------------------------------------------------------\n\n");
    }

    public static void printListaPontos(Lista<Ponto> l) {
        System.out.println("------------------Lista Ligada------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            Ponto valor = l.get(i);
            System.out.println("Indice: " + i + " | Valor: " + valor.toString());
        }
        System.out.println("--------------------------------------------------------\n\n");
    }

    public static void printCaixaPontos(Caixa<Ponto> c) {
        System.out.println("------------------Caixa Simples------------------");
        for (int i = 0; i < c.getQuantidade(); i++) {
            Ponto valor = c.get(i);
            System.out.println("Indice: " + i + " | Valor: " + valor.toString());
        }
        System.out.println("--------------------------------------------------------\n\n");
    }

    public static <T> void printLista(Lista<T> l1){
        System.out.println("---Lista Original---");
        for (ItemComPosicao<T> itemComPosicao : l1.getItensComPosicao()){
            System.out.println("Index : "+itemComPosicao.getPosicao()+" Valor : "+ itemComPosicao.getItem());
        }
        System.out.println("--------------------");
    }

    public static <T> void printDuasListas(Lista<T> l1, Lista<T> l2){
        System.out.println("---Lista Original---");
        for (ItemComPosicao<T> itemComPosicao : l1.getItensComPosicao()){
            System.out.println("Index : "+itemComPosicao.getPosicao()+" Valor : "+ itemComPosicao.getItem());
        }
        System.out.println("--------------------");

        System.out.println("---Lista Filtrada---");
        for (ItemComPosicao<T> itemComPosicao : l2.getItensComPosicao()){
            System.out.println("Index : "+itemComPosicao.getPosicao()+" Valor : "+ itemComPosicao.getItem());
        }
        System.out.println("--------------------");
    }
}
