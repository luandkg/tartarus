package teste;

import estruturas.Lista;

import static utils.Ferramenta.confirmaLista;
import static utils.Ferramenta.printListaString;

public class TesteLista {

    public static void testar() {

        lista_criar();

        lista_inserir();

        lista_quantidade();

        lista_remover_por_posicao();

        lista_remover_por_referencia();
    }

    public static void lista_criar() {
        System.out.println("\nTeste: Criar lista\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);
        System.out.println("\n\n\n\n");
    }

    public static void lista_inserir() {
        System.out.println("\nTeste: Inserir na lista\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);
        System.out.println("\n\n\n\n");
    }

    public static void lista_quantidade() {
        System.out.println("\nTeste: Exibe a quantidade da lista\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);

        System.out.println("A lista deve ter 3 elementos! Lista tem :" + l.getQuantidade());
        System.out.println("\n\n\n\n");
    }

    public static void lista_remover_por_posicao() {
        System.out.println("\nTeste: Remover na lista por posicao\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);

        System.out.println("NOVA----------Remove o primeiro");
        l.remover(0);
        printListaString(l);

        System.out.println("NOVA----------Adiciona um depois Remove o ultimo");
        l.adicionar("quarta");
        confirmaLista(l, 3);
        printListaString(l);
        l.remover(2);
        printListaString(l);


        System.out.println("NOVA----------Adiciona um depois Remove o do meio");
        l.adicionar("quinta");
        confirmaLista(l, 3);
        printListaString(l);
        l.remover(1);
        printListaString(l);
        System.out.println("\n\n\n\n");
    }

    public static void lista_remover_por_referencia() {
        System.out.println("\nTeste: Remover na lista por Referencia\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);

        System.out.println("NOVA----------Remove o valor primeiro");
        l.removerReferencia("primeira");
        printListaString(l);

        System.out.println("NOVA----------Adiciona um depois Remove o valor quarta");
        l.adicionar("quarta");
        confirmaLista(l, 3);
        printListaString(l);
        l.removerReferencia("quarta");
        printListaString(l);


        System.out.println("NOVA----------Adiciona um depois Remove o valor terceira");
        l.adicionar("quinta");
        confirmaLista(l, 3);
        printListaString(l);
        l.removerReferencia("terceira");
        printListaString(l);
        System.out.println("\n\n\n\n");
    }
}
