package main.libs.ordenadores;

import main.app.ordenar.AppOrdenar;
import main.app.ordenar.Comparador;
import main.libs.estruturas.Lista;

public class Ordenador {

    public static boolean estaOrdenadaCrescente(Lista<Integer> numeros, Comparador<Integer> comparar){
        if (numeros == null){
            return false;
        }
        if (numeros.getQuantidade() == 1){
            return true;
        }

        for (int i = 0; i < numeros.getQuantidade(); i++){
            for (int j = i+1; j < numeros.getQuantidade(); j++){
                if (comparar.compare(numeros.get(i), numeros.get(j))){
                    return false;
                }
            }
        }

        return true;
    }




}
