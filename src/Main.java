import auxiliar.Jogador;
import auxiliar.JogadorSerializavel;
import auxiliar.StringIgualdade;
import estruturas.IO;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TesteExecutor;
import testes.TesteCaixa;
import testes.TesteLista;
import testes.TesteTexto;
import utils.Igualdade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);

        //TesteExecutor.TESTAR(testarClasses);


        Lista<Jogador> jogadores = new Lista<Jogador>();

        jogadores.adicionar(new Jogador("Atacante","Calebe",10));
        jogadores.adicionar(new Jogador("Meia","Luan",7));
        jogadores.adicionar(new Jogador("Lateral","Kaio",2));
        jogadores.adicionar(new Jogador("Zagueiro","Diogo",3));
        jogadores.adicionar(new Jogador("Goleiro","William",1));

        IO.guardar("arquivos/ListaDeJogadores.txt", jogadores, new JogadorSerializavel());

        Lista<Jogador> escola = new Lista<>();

        escola = IO.abrir("arquivos/ListaDeJogadores.txt", new JogadorSerializavel());

        for (Jogador jogador : escola){
            System.out.println(jogador.getNome());
        }

    }
}