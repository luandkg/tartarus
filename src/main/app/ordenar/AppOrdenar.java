package main.app.ordenar;

import main.libs.estruturas.Lista;
import main.libs.ordenadores.Ordenador;

import java.util.ArrayList;

public class AppOrdenar {

    public static void executar(){
        Lista<Integer> lista = new Lista<Integer>();

        //int [] l = {9,8,7,6,5,4,3,2,1,0};
        //int [] l = {0,1,2,3,4,5,6,7,8,9};
        //int [] l = {7,8,9,0,1,5,6,2,3,4};
        int [] l = {7,8,9,0,1,5,6,2,4};

        for (int i = 0; i<l.length; i++){
            lista.adicionar(l[i]);
        }

        lista.exibirLista();
        Ordenador.ordenarDecrescente(lista);
        System.out.println("-------------------------");
        System.out.println("\n Resultado: \n");
        if (Ordenador.estaOrdenadaDecrescente(lista)){
            System.out.println("\n Lista Ordenada: \n");
            lista.exibirLista();
            System.out.println("-------------------------");
        }
    }
}
