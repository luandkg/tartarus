import auxiliar.Ponto;
import auxiliar.PontoIgualdade;
import estruturas.Lista;
import teste.TesteLista;
import utils.Ferramenta;

public class Main {
    public static void main(String[] args) {

        // Calebe - vc deve implementar uma estrutura de dados lista
        // O nome da classe deve ser estruturas.Lista
        // deve ter as funções getQuantidade() e adicionar()

        //TesteLista.testar();

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


        l.remover(4);
        Ferramenta.printListaPontos(l);


        l.removerReferencia(teste);
        Ferramenta.printListaPontos(l);

        l.removerValor(new Ponto(6,0), new PontoIgualdade());
        Ferramenta.printListaPontos(l);

    }
}