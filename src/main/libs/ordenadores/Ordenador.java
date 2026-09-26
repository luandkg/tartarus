package main.libs.ordenadores;

import main.libs.estruturas.Lista;

public class Ordenador {

    public static boolean estaOrdenadaCrescente(Lista<Integer> numeros){
        if (numeros == null){
            return false;
        }
        if (numeros.getQuantidade() == 1){
            return true;
        }

        for (int i = 0; i < numeros.getQuantidade(); i++){
            for (int j = i+1; j < numeros.getQuantidade(); j++){
                if (numeros.get(i) > numeros.get(j)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean estaOrdenadaDecrescente(Lista<Integer> numeros){
        if (numeros == null){
            return false;
        }
        if (numeros.getQuantidade() == 1){
            return true;
        }

        for (int i = 0; i < numeros.getQuantidade(); i++){
            for (int j = i+1; j < numeros.getQuantidade(); j++){
                if (numeros.get(i) < numeros.get(j)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean ordenarCrescente(Lista<Integer> numeros){
        if (numeros == null){
            return false;
        }
        if (numeros.getQuantidade() == 1){
            return true;
        }

        for (int i = 0; i < numeros.getQuantidade(); i++){
            for (int j = i+1; j < numeros.getQuantidade(); j++){
                if (numeros.get(i) > numeros.get(j)){
                    //System.out.println("-------------");
                    //System.out.println("Trocando valor da posicao ["+ i +"] = "+ numeros.get(i) + " com o valor da posicao [" + j +"] = "+ numeros.get(j));
                    int chave = numeros.get(i);
                    numeros.set(i, numeros.get(j));
                    numeros.set(j, chave);
                    //numeros.exibirLista();
                    //System.out.println("-------------");
                }
            }
        }

        return true;
    }

    public static boolean ordenarDecrescente(Lista<Integer> numeros){
        if (numeros == null){
            return false;
        }
        if (numeros.getQuantidade() == 1){
            return true;
        }

        for (int i = 0; i < numeros.getQuantidade(); i++){
            for (int j = i+1; j < numeros.getQuantidade(); j++){
                if (numeros.get(i) < numeros.get(j)){
                    //System.out.println("-------------");
                    //System.out.println("Trocando valor da posicao ["+ i +"] = "+ numeros.get(i) + " com o valor da posicao [" + j +"] = "+ numeros.get(j));
                    int chave = numeros.get(i);
                    numeros.set(i, numeros.get(j));
                    numeros.set(j, chave);
                    //numeros.exibirLista();
                    //System.out.println("-------------");
                }
            }
        }

        return true;
    }
}
