package testes;

import auxiliar.Ponto;
import auxiliar.PontoIgualdade;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import utils.Condicional;
import utils.CondicionalParametrizado;
import utils.Ferramenta;

@TesteClasseCalebe
public class TesteLista {

    @TesteCalebe
    public static void Lista_criar(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_esta_vazia(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());
        teste.deveSerVerdadeiro(l.estaVazia());
    }

    @TesteCalebe
    public static void Lista_inserir(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade());
        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade());
        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_quantidade(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade());

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_remover_por_posicao(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade());

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade());

        l.remover(0);
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("quarta");
        teste.deveSerIgual(3, l.getQuantidade());

        l.remover(2);
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("quinta");
        teste.deveSerIgual(3, l.getQuantidade());

        l.remover(1);
        teste.deveSerIgual(2, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_remover_por_referencia(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade());

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade());

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade());

        l.removerReferencia("primeira");
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("quarta");
        teste.deveSerIgual(3, l.getQuantidade());

        l.removerReferencia("quarta");
        teste.deveSerIgual(2, l.getQuantidade());

        l.adicionar("quinta");
        teste.deveSerIgual(3, l.getQuantidade());

        l.removerReferencia("terceira");
        teste.deveSerIgual(2, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_remover_por_valor(TestandoCalebe teste) {
        Ponto ponto = new Ponto(1, 5);

        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0, 6));

        l.adicionar(ponto);
        l.adicionar(new Ponto(2, 4));
        l.adicionar(new Ponto(3, 3));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(5, 1));
        l.adicionar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade());

        l.remover(4);
        teste.deveSerIgual(6, l.getQuantidade());

        l.removerReferencia(ponto);
        teste.deveSerIgual(5, l.getQuantidade());

        l.removerValor(new Ponto(6, 0), new PontoIgualdade());
        teste.deveSerIgual(4, l.getQuantidade());
    }

    @TesteCalebe
    public static void Lista_set(TestandoCalebe teste) {
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0, 6));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(2, 4));
        l.adicionar(new Ponto(3, 3));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(5, 1));
        l.adicionar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade());

        teste.deveSerIgual(0, l.get(0).getX());
        teste.deveSerIgual(6, l.get(0).getY());

        l.set(0, new Ponto(9, 9));

        teste.deveSerIgual(9, l.get(0).getX());
        teste.deveSerIgual(9, l.get(0).getY());
    }

    @TesteCalebe
    public static void Lista_set_posicao_invalida(TestandoCalebe teste) {
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0, 6));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(2, 4));
        l.adicionar(new Ponto(3, 3));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(5, 1));
        l.adicionar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade());

        try {
            l.set(8, new Ponto(9, 9));
            teste.falhar();
        } catch (Exception e) {
            teste.deveSerIgual("Erro: Posicao nao encontrada!", e.getMessage());
        }
    }

    @TesteCalebe
    public static void Lista_existe_valor(TestandoCalebe teste) {
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0, 6));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(2, 4));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(4, 5));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(3, 5));

        teste.deveSerIgual(12, l.getQuantidade());

        teste.deveSerVerdadeiro(l.existeValor(new Ponto(1, 5), new PontoIgualdade()));

        teste.deveSerFalso(l.existeValor(new Ponto(8, 2), new PontoIgualdade()));
    }

    @TesteCalebe
    public static void Lista_contagem_valor(TestandoCalebe teste) {
        Lista<Ponto> l = new Lista<Ponto>();

        l.adicionar(new Ponto(0, 6));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(2, 4));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(4, 5));
        l.adicionar(new Ponto(4, 2));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(1, 5));
        l.adicionar(new Ponto(3, 5));

        teste.deveSerIgual(12, l.getQuantidade());

        teste.deveSerIgual(6, l.contarValor(new Ponto(1, 5), new PontoIgualdade()));

        teste.deveSerIgual(2, l.contarValor(new Ponto(4, 2), new PontoIgualdade()));
    }

    @TesteCalebe
    public static void Lista_percarrendo_itens(TestandoCalebe teste) {
        Lista<Integer> listaInteger = new Lista<>();

        listaInteger.adicionar(55);
        listaInteger.adicionar(33);
        listaInteger.adicionar(22);

        int cont = 0;
        for (int i : listaInteger) {
            cont++;
        }
        teste.deveSerIgual(3, cont);
    }

    @TesteCalebe
    public static void Lista_retorna_item_e_posicao(TestandoCalebe teste) {
        Lista<Integer> listaInteger = new Lista<>();

        listaInteger.adicionar(55);
        listaInteger.adicionar(33);
        listaInteger.adicionar(22);
        teste.deveSerIgual(3, listaInteger.getQuantidade());

        ItemComPosicao<Integer> t1 = listaInteger.getItensComPosicao().get(0);
        teste.deveSerIgual(55, t1.getItem());
        teste.deveSerIgual(0, t1.getPosicao());

        ItemComPosicao<Integer> t2 = listaInteger.getItensComPosicao().get(1);
        teste.deveSerIgual(33, t2.getItem());
        teste.deveSerIgual(1, t2.getPosicao());

        ItemComPosicao<Integer> t3 = listaInteger.getItensComPosicao().get(2);
        teste.deveSerIgual(22, t3.getItem());
        teste.deveSerIgual(2, t3.getPosicao());
    }

    @TesteCalebe
    public static void Lista_filtrar(TestandoCalebe teste) {
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(new Condicional<Integer>() {
            @Override
            public boolean condicao(Integer a, Integer b) {
                return a < b;
            }
        }, 3);

        teste.deveSerIgual(3, lista.getQuantidade());

        teste.deveSerIgual(0, lista.get(0));
        teste.deveSerIgual(1, lista.get(1));
        teste.deveSerIgual(2, lista.get(2));

        //Ferramenta.printDuasListas(num,lista);
    }

    @TesteCalebe
    public static void Lista_filtrar_parametrizado(TestandoCalebe teste) {
        Lista<Integer> num = new Lista<>();

        num.adicionar(0);
        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);


        Lista<Integer> lista = num.filtrar(new CondicionalParametrizado<Integer, String>() {
            @Override
            public String getValor() {
                return "2";
            }

            @Override
            public boolean condicao(Integer a) {
                if(Texto.terminaCom(a.toString(), getValor())){
                    return true;
                }
                return false;
            }

        });

        teste.deveSerIgual(1, lista.getQuantidade());

        teste.deveSerIgual(2, lista.get(0));

        //Ferramenta.printDuasListas(num,lista);
    }

    @TesteCalebe
    public static void Lista_clonar(TestandoCalebe teste){
        Lista<Integer> lInt = new Lista<>();

        lInt.adicionar(0);
        lInt.adicionar(1);
        lInt.adicionar(2);
        lInt.adicionar(3);
        lInt.adicionar(4);
        lInt.adicionar(5);

        teste.deveSerIgual(6,lInt.getQuantidade());

        Lista<Integer> clone = new Lista<>();

        teste.deveSerIgual(0,clone.getQuantidade());

        clone = lInt.clonar();

        teste.deveSerIgual(clone.getQuantidade(),lInt.getQuantidade());

        if (clone.getQuantidade()==lInt.getQuantidade()){
            for (int i = 0; i < lInt.getQuantidade(); i++) {
                teste.deveSerIgual(clone.get(i), lInt.get(i));
            }
        }

        //Ferramenta.printDuasListas(lInt,clone);
    }

    @TesteCalebe
    public static void Lista_limpar(TestandoCalebe teste){
        Lista<Integer> lInt = new Lista<>();

        lInt.adicionar(0);
        lInt.adicionar(1);
        lInt.adicionar(2);
        lInt.adicionar(3);
        lInt.adicionar(4);
        lInt.adicionar(5);

        teste.deveSerIgual(6,lInt.getQuantidade());

        lInt.limpar();

        teste.deveSerIgual(0,lInt.getQuantidade());

    }
}
