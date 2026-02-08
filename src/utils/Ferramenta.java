package utils;

import auxiliar.Ponto;
import estruturas.Lista;

public class Ferramenta {

    public static void confirmaLista(Lista l, int tamanho) {
        if (l.getQuantidade() == tamanho) {
            System.out.println("A lista esta OK");
        } else {
            System.out.println("A Lista esta corrompida!");
        }
    }

    public static void printListaString(Lista<String> l) {
        System.out.println("------------------Ligada Simples------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            String valor = l.get(i);
            System.out.println("Indice: " + i + " | Valor: " + valor);
        }
        System.out.println("--------------------------------------------------------\n\n");
    }

    public static void printListaPontos(Lista<Ponto> l) {
        System.out.println("------------------Ligada Simples------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            Ponto valor = l.get(i);
            System.out.println("Indice: " + i + " | Valor: " + valor.toString());
        }
        System.out.println("--------------------------------------------------------\n\n");
    }
}
