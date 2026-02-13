package testes;

import auxiliar.Ponto;
import estruturas.Caixa;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import utils.Ferramenta;

@TesteClasseCalebe
public class TesteCaixa {

    @TesteCalebe
    public static void teste_criar_caixa(TestandoCalebe teste) {
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
    public static void teste_explodir_caixa(TestandoCalebe teste) {
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
}