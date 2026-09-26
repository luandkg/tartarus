package main.app.ordenar;

import main.libs.estruturas.Inteiros;
import main.libs.estruturas.Lista;
import main.libs.ordenadores.Ordenador;

import java.util.ArrayList;

public class AppOrdenar {

    public static void executar(){
        //Lista<Integer> lista = new Lista<Integer>();

        //int [] l = {9,8,7,6,5,4,3,2,1,0};
        //int [] l = {0,1,2,3,4,5,6,7,8,9};
        //int [] l = {7,8,9,0,1,5,6,2,3,4};
        //int [] l = {7,8,9,0,1,5,6,2,4};

        /*Lista<Pessoa> lista = new Lista<Pessoa>();
        lista.adicionar(new Pessoa("Calebe", 23));
        lista.adicionar(new Pessoa("Luan", 99));
        lista.adicionar(new Pessoa("Kaio", 01));
        lista.adicionar(new Pessoa("Bela", 18));
        lista.adicionar(new Pessoa("Jota", 46));
        lista.adicionar(new Pessoa("Fafa", 31));
        lista.adicionar(new Pessoa("ylguines", 17));
        lista.adicionar(new Pessoa("Mar", 9));
        lista.adicionar(new Pessoa("Dandan", 100));*/

        Lista<Comida> lista = new Lista<Comida>();
        lista.adicionar(new Comida("Abacaxi", 23));
        lista.adicionar(new Comida("chocolate", 99));
        lista.adicionar(new Comida("Lasanha", 01));
        lista.adicionar(new Comida("Bolo", 18));
        lista.adicionar(new Comida("Pizza", 46));
        lista.adicionar(new Comida("Hamburguer", 31));
        lista.adicionar(new Comida("Sushi", 17));
        lista.adicionar(new Comida("Morango", 9));
        lista.adicionar(new Comida("Macarronada", 100));

        /*for (int i = 0; i<l.length; i++){
            lista.adicionar(l[i]);
        }*/


        lista.exibirLista();
        lista.ordenar(Comida.compararPesoMaior());
        System.out.println("-------------------------");
        System.out.println("\n Resultado: \n");
        if (lista.estaOrdenada(Comida.compararPesoMaior())){
            System.out.println("\n Lista Ordenada: \n");
            lista.exibirLista();
            System.out.println("-------------------------");
        }
    }




}
