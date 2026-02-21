package testes;

import estruturas.Inteiros;
import estruturas.Lista;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import utils.Ferramenta;

@TesteClasseCalebe
public class TesteInteiros {

    @TesteCalebe
    public static void Inteiros_maior(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_MAIOR_QUE(4));

        teste.deveSerIgual(1, lista.getQuantidade(),"Inteiros_maior -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }

    @TesteCalebe
    public static void Inteiros_menor(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_MENOR_QUE(4));

        teste.deveSerIgual(4, lista.getQuantidade(),"Inteiros_menor -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }

    @TesteCalebe
    public static void Inteiros_igual(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_IGUAL(4));

        teste.deveSerIgual(1, lista.getQuantidade(),"Inteiros_igual -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }

    @TesteCalebe
    public static void Inteiros_diferente(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_DIFERENTE(4));

        teste.deveSerIgual(5, lista.getQuantidade(),"Inteiros_diferente -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }

    @TesteCalebe
    public static void Inteiros_maior_igual(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_MAIOR_OU_IGUAL(4));

        teste.deveSerIgual(2, lista.getQuantidade(),"Inteiros_maior_igual -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }

    @TesteCalebe
    public static void Inteiros_menor_igual(TestandoCalebe teste){
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(Inteiros.INTEIRO_MENOR_OU_IGUAL(4));

        teste.deveSerIgual(5, lista.getQuantidade(),"Inteiros_menor_igual -> Teste_1");

        Ferramenta.printDuasListas(num, lista);
    }
}
