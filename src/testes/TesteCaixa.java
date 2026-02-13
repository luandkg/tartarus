package testes;

import auxiliar.Ponto;
import estruturas.Caixa;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import utils.Ferramenta;

@TesteClasseCalebe
public class TesteCaixa {

    @TesteCalebe
    public static void caixa_criar(TestandoCalebe teste) {
        Ponto ponto = new Ponto(1, 5);

        Caixa<Ponto> caixa = new Caixa(7);

        caixa.adicionar(new Ponto(0, 6));
        caixa.adicionar(ponto);
        caixa.adicionar(new Ponto(2, 4));
        caixa.adicionar(new Ponto(3, 3));
        caixa.adicionar(new Ponto(4, 2));
        caixa.adicionar(new Ponto(5, 1));
        caixa.adicionar(new Ponto(6, 0));
        teste.deveSerIgual(7,caixa.getQuantidade());
    }

    @TesteCalebe
    public static void caixa_explodir(TestandoCalebe teste) {
        Ponto ponto = new Ponto(1, 5);

        Caixa<Ponto> caixa = new Caixa(7);

        caixa.adicionar(new Ponto(0, 6));
        caixa.adicionar(ponto);
        caixa.adicionar(new Ponto(2, 4));
        caixa.adicionar(new Ponto(3, 3));
        caixa.adicionar(new Ponto(4, 2));
        caixa.adicionar(new Ponto(5, 1));
        caixa.adicionar(new Ponto(6, 0));
        teste.deveSerIgual(7,caixa.getQuantidade());

        try {
            caixa.adicionar(new Ponto(0, 6));
            teste.falhar();
        }catch (Exception e){
            teste.deveSerIgual("Erro: A caixa esta cheia!",e.getMessage());
        }

    }

    @TesteCalebe
    public static void caixa_percarrendo_itens(TestandoCalebe teste){
        Caixa<Integer> caixaInteger  = new Caixa<>(3);

        caixaInteger.adicionar(55);
        caixaInteger.adicionar(33);
        caixaInteger.adicionar(22);

        int cont = 0;
        for (int i : caixaInteger) {
            cont++;
        }
        teste.deveSerIgual(3,cont);
    }

    @TesteCalebe
    public static void caixa_retorna_item_e_posicao(TestandoCalebe teste){
        Caixa<Integer> caixaInteger  = new Caixa<>(3);

        caixaInteger.adicionar(55);
        caixaInteger.adicionar(33);
        caixaInteger.adicionar(22);
        teste.deveSerIgual(3, caixaInteger.getQuantidade());

        ItemComPosicao<Integer> t1 = caixaInteger.getItensComPosicao().get(0);
        teste.deveSerIgual(55,t1.getItem());
        teste.deveSerIgual(0,t1.getPosicao());

        ItemComPosicao<Integer> t2 = caixaInteger.getItensComPosicao().get(1);
        teste.deveSerIgual(33,t2.getItem());
        teste.deveSerIgual(1,t2.getPosicao());

        ItemComPosicao<Integer> t3 = caixaInteger.getItensComPosicao().get(2);
        teste.deveSerIgual(22,t3.getItem());
        teste.deveSerIgual(2,t3.getPosicao());
    }
}