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
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_criar -> Teste_1");
    }

    @TesteCalebe
    public static void Lista_esta_vazia(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_esta_vazia -> Teste_1");
        teste.deveSerVerdadeiro(l.estaVazia(),"Lista_esta_vazia -> Teste_2");
    }

    @TesteCalebe
    public static void Lista_inserir(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_inserir -> Teste_1");

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(),"Lista_inserir -> Teste_2");
        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_inserir -> Teste_3");
        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_inserir -> Teste_4");
    }

    @TesteCalebe
    public static void Lista_quantidade(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_quantidade -> Teste_1");

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(),"Lista_quantidade -> Teste_2");

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_quantidade -> Teste_3");

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_quantidade -> Teste_4");
    }

    @TesteCalebe
    public static void Lista_remover_por_posicao(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_1");

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_2");

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_3");

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_4");

        l.remover(0);
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_5");

        l.adicionar("quarta");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_6");

        l.remover(2);
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_7");

        l.adicionar("quinta");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_8");

        l.remover(1);
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_posicao -> Teste_9");
    }

    @TesteCalebe
    public static void Lista_remover_por_referencia(TestandoCalebe teste) {
        Lista<String> l = new Lista<String>();
        teste.deveSerIgual(0, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_1");

        l.adicionar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_2");

        l.adicionar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_3");

        l.adicionar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_4");

        l.removerReferencia("primeira");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_5");

        l.adicionar("quarta");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_6");

        l.removerReferencia("quarta");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_7");

        l.adicionar("quinta");
        teste.deveSerIgual(3, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_8");

        l.removerReferencia("terceira");
        teste.deveSerIgual(2, l.getQuantidade(),"Lista_remover_por_referencia -> Teste_9");
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
        teste.deveSerIgual(7, l.getQuantidade(),"Lista_remover_por_valor -> Teste_1");

        l.remover(4);
        teste.deveSerIgual(6, l.getQuantidade(),"Lista_remover_por_valor -> Teste_2");

        l.removerReferencia(ponto);
        teste.deveSerIgual(5, l.getQuantidade(),"Lista_remover_por_valor -> Teste_3");

        l.removerValor(new Ponto(6, 0), new PontoIgualdade());
        teste.deveSerIgual(4, l.getQuantidade(),"Lista_remover_por_valor -> Teste_4");
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
        teste.deveSerIgual(7, l.getQuantidade(),"Lista_set -> Teste_1");

        teste.deveSerIgual(0, l.get(0).getX(),"Lista_set -> Teste_2");
        teste.deveSerIgual(6, l.get(0).getY(),"Lista_set -> Teste_3");

        l.set(0, new Ponto(9, 9));

        teste.deveSerIgual(9, l.get(0).getX(),"Lista_set -> Teste_4");
        teste.deveSerIgual(9, l.get(0).getY(),"Lista_set -> Teste_5");
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
        teste.deveSerIgual(7, l.getQuantidade(),"Lista_set_posicao_invalida -> Teste_1");

        try {
            l.set(8, new Ponto(9, 9));
            teste.falhar("Lista_set_posicao_invalida -> Teste_2");
        } catch (Exception e) {
            teste.deveSerIgual("Erro: Posicao nao encontrada!", e.getMessage(),"Lista_set_posicao_invalida -> Teste_3");
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

        teste.deveSerIgual(12, l.getQuantidade(),"Lista_existe_valor -> Teste_1");

        teste.deveSerVerdadeiro(l.existeValor(new Ponto(1, 5), new PontoIgualdade()),"Lista_existe_valor -> Teste_2");

        teste.deveSerFalso(l.existeValor(new Ponto(8, 2), new PontoIgualdade()),"Lista_existe_valor -> Teste_3");
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

        teste.deveSerIgual(12, l.getQuantidade(),"Lista_contagem_valor -> Teste_1");

        teste.deveSerIgual(6, l.contarValor(new Ponto(1, 5), new PontoIgualdade()),"Lista_contagem_valor -> Teste_2");

        teste.deveSerIgual(2, l.contarValor(new Ponto(4, 2), new PontoIgualdade()),"Lista_contagem_valor -> Teste_3");
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
        teste.deveSerIgual(3, cont,"Lista_percarrendo_itens -> Teste_1");
    }

    @TesteCalebe
    public static void Lista_retorna_item_e_posicao(TestandoCalebe teste) {
        Lista<Integer> listaInteger = new Lista<>();

        listaInteger.adicionar(55);
        listaInteger.adicionar(33);
        listaInteger.adicionar(22);
        teste.deveSerIgual(3, listaInteger.getQuantidade(),"Lista_retorna_item_e_posicao -> Teste_1");

        ItemComPosicao<Integer> t1 = listaInteger.getItensComPosicao().get(0);
        teste.deveSerIgual(55, t1.getItem(),"Lista_retorna_item_e_posicao -> Teste_2");
        teste.deveSerIgual(0, t1.getPosicao(),"Lista_retorna_item_e_posicao -> Teste_3");

        ItemComPosicao<Integer> t2 = listaInteger.getItensComPosicao().get(1);
        teste.deveSerIgual(33, t2.getItem(),"Lista_retorna_item_e_posicao -> Teste_4");
        teste.deveSerIgual(1, t2.getPosicao(),"Lista_retorna_item_e_posicao -> Teste_5");

        ItemComPosicao<Integer> t3 = listaInteger.getItensComPosicao().get(2);
        teste.deveSerIgual(22, t3.getItem(),"Lista_retorna_item_e_posicao -> Teste_6");
        teste.deveSerIgual(2, t3.getPosicao(),"Lista_retorna_item_e_posicao -> Teste_7");
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

        teste.deveSerIgual(3, lista.getQuantidade(),"Lista_filtrar -> Teste_1");

        teste.deveSerIgual(0, lista.get(0),"Lista_filtrar -> Teste_2");
        teste.deveSerIgual(1, lista.get(1),"Lista_filtrar -> Teste_3");
        teste.deveSerIgual(2, lista.get(2),"Lista_filtrar -> Teste_4");

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

        teste.deveSerIgual(1, lista.getQuantidade(),"Lista_filtrar_parametrizado -> Teste_1");

        teste.deveSerIgual(2, lista.get(0),"Lista_filtrar_parametrizado -> Teste_2");

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

        teste.deveSerIgual(6,lInt.getQuantidade(),"Lista_clonar -> Teste_1");

        Lista<Integer> clone = new Lista<>();

        teste.deveSerIgual(0,clone.getQuantidade(),"Lista_clonar -> Teste_2");

        clone = lInt.clonar();

        teste.deveSerIgual(clone.getQuantidade(),lInt.getQuantidade(),"Lista_clonar -> Teste_3");

        if (clone.getQuantidade()==lInt.getQuantidade()){
            for (int i = 0; i < lInt.getQuantidade(); i++) {
                teste.deveSerIgual(clone.get(i), lInt.get(i),"Lista_clonar -> Teste_4");
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

        teste.deveSerIgual(6,lInt.getQuantidade(),"Lista_limpar -> Teste_1");

        lInt.limpar();

        teste.deveSerIgual(0,lInt.getQuantidade(),"Lista_limpar -> Teste_2");

    }
}
