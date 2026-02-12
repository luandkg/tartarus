package testes;

import auxiliar.Ponto;
import auxiliar.PontoIgualdade;
import estruturas.Lista;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import utils.Ferramenta;

import static utils.Ferramenta.confirmaLista;
import static utils.Ferramenta.printListaString;

@TesteClasseCalebe
public class TesteLista {

    public static void testar() {

        //lista_criar();

        //lista_esta_vazia();

       // lista_inserir();

        lista_quantidade();

        lista_remover_por_posicao();

        lista_remover_por_referencia();

        lista_remover_por_valor();

        lista_set();

        lista_set_posicao_invalida();

        lista_existe_valor();

        lista_contagem_valor();
    }

    @TesteCalebe
    public static void lista_criar(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0,l.getQuantidade());
    }

    @TesteCalebe
    public static void lista_esta_vazia(TestandoCalebe teste){
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0,l.getQuantidade());
        teste.deveSerVerdadeiro(l.estaVazia());
    }

    @TesteCalebe
    public static void lista_inserir(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0,l.getQuantidade());

        l.adicionar("primeira");
        teste.deveSerIgual(1,l.getQuantidade());
        l.adicionar("segunda");
        teste.deveSerIgual(2,l.getQuantidade());
        l.adicionar("terceira");
        teste.deveSerIgual(3,l.getQuantidade());
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
        System.out.println("\nTeste: Remover item da lista por posicao\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);

        System.out.println("NOVA--Remove o primeiro");
        l.remover(0);
        printListaString(l);

        System.out.println("NOVA--Adiciona um depois Remove o ultimo");
        l.adicionar("quarta");
        confirmaLista(l, 3);
        printListaString(l);
        l.remover(2);
        printListaString(l);


        System.out.println("NOVA--Adiciona um depois Remove o do meio");
        l.adicionar("quinta");
        confirmaLista(l, 3);
        printListaString(l);
        l.remover(1);
        printListaString(l);
        System.out.println("\n\n\n\n");
    }

    public static void lista_remover_por_referencia() {
        System.out.println("\nTeste: Remover item da lista por referencia\n");
        Lista<String> l = new Lista<String>();
        confirmaLista(l, 0);

        l.adicionar("primeira");
        confirmaLista(l, 1);
        l.adicionar("segunda");
        confirmaLista(l, 2);
        l.adicionar("terceira");
        confirmaLista(l, 3);
        printListaString(l);

        System.out.println("NOVA---Remove o valor primeiro");
        l.removerReferencia("primeira");
        printListaString(l);

        System.out.println("NOVA--Adiciona um depois Remove o valor quarta");
        l.adicionar("quarta");
        confirmaLista(l, 3);
        printListaString(l);
        l.removerReferencia("quarta");
        printListaString(l);


        System.out.println("NOVA--Adiciona um depois Remove o valor terceira");
        l.adicionar("quinta");
        confirmaLista(l, 3);
        printListaString(l);
        l.removerReferencia("terceira");
        printListaString(l);
        System.out.println("\n\n\n\n");
    }

    public static void lista_remover_por_valor() {
        System.out.println("\nTeste: Remover item da lista por valor\n");

        Ponto teste = new Ponto(1,5);

        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0,6));
        l.adicionar(teste);
        l.adicionar(new Ponto(2,4));
        l.adicionar(new Ponto(3,3));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(5,1));
        l.adicionar(new Ponto(6,0));
        Ferramenta.confirmaLista(l,7);
        Ferramenta.printListaPontos(l);

        System.out.println("NOVA-- Remove posoicao 4");
        l.remover(4);
        Ferramenta.printListaPontos(l);

        System.out.println("NOVA-- Remove referencia teste");
        l.removerReferencia(teste);
        Ferramenta.printListaPontos(l);

        System.out.println("NOVA-- Remove valor Ponto(6,0) ");
        l.removerValor(new Ponto(6,0), new PontoIgualdade());
        Ferramenta.printListaPontos(l);
        System.out.println("\n\n\n\n");

    }

    public static void lista_set(){
        System.out.println("\nTeste: Altera item da lista por posicao\n");
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0,6));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(2,4));
        l.adicionar(new Ponto(3,3));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(5,1));
        l.adicionar(new Ponto(6,0));
        Ferramenta.confirmaLista(l,7);
        Ferramenta.printListaPontos(l);

        System.out.println("NOVA-- Altera valor da posicao 0 ");
        l.set(0, new Ponto(9,9));
        Ferramenta.printListaPontos(l);
        System.out.println("\n\n\n\n");

    }

    public static void lista_set_posicao_invalida(){
        System.out.println("\nTeste: Altera item da lista por posicao\n");
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0,6));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(2,4));
        l.adicionar(new Ponto(3,3));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(5,1));
        l.adicionar(new Ponto(6,0));
        Ferramenta.confirmaLista(l,7);
        Ferramenta.printListaPontos(l);

        System.out.println("NOVA-- Altera valor da posicao 0 ");
        try {
            l.set(8, new Ponto(9,9));
        }catch (Exception e){
            System.out.println("Erro esperado: "+ e.getMessage());
        }
        Ferramenta.printListaPontos(l);
        System.out.println("\n\n\n\n");

    }

    public static void lista_existe_valor(){
        System.out.println("\nTeste: Conta item da lista por valor\n");
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0,6));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(2,4));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(4,5));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(3,5));

        Ferramenta.confirmaLista(l,12);
        Ferramenta.printListaPontos(l);

        boolean valor_1_5 = l.existeValor(new Ponto(1,5), new PontoIgualdade());
        System.out.println("A lista possui Ponto(1,5) :" + valor_1_5);

        boolean valor_8_2 = l.existeValor(new Ponto(8,2), new PontoIgualdade());
        System.out.println("A lista possui Ponto(8,2) :" + valor_8_2);

        System.out.println("\n\n\n\n");
    }

    public static void lista_contagem_valor(){
        System.out.println("\nTeste: Conta item da lista por valor\n");
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0,6));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(2,4));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(4,5));
        l.adicionar(new Ponto(4,2));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(1,5));
        l.adicionar(new Ponto(3,5));

        Ferramenta.confirmaLista(l,12);
        Ferramenta.printListaPontos(l);

        int quantidade_1_5 = l.contarValor(new Ponto(1,5), new PontoIgualdade());
        System.out.println("A lista possui Ponto(1,5) " + quantidade_1_5 +" vezes!");

        int quantidade_4_2 = l.contarValor(new Ponto(4,2), new PontoIgualdade());
        System.out.println("A lista possui Ponto(4,2) " + quantidade_4_2 +" vezes!");

        System.out.println("\n\n\n\n");
    }
}
