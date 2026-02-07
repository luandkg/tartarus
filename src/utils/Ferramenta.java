package utils;

import estruturas.Lista;

public class Ferramenta {

    public static void confirmaLista(Lista l, int valor) {
        if (l.getQuantidade() == valor) {
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
}
