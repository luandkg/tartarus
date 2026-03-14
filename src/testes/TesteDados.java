package testes;

import main.app.Jogador;
import main.app.JogadorSerializavel;
import main.libs.estruturas.Dados;
import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteDados {

    @TesteCalebe
    public static void io_ler_arquivo(TestandoCalebe teste){
        Lista<Jogador> jogadores = new Lista<Jogador>();

        jogadores.adicionar(new Jogador("Atacante","Calebe",10));
        jogadores.adicionar(new Jogador("Meia","Luan",7));
        jogadores.adicionar(new Jogador("Lateral","Kaio",2));
        jogadores.adicionar(new Jogador("Zagueiro","Diogo",3));
        jogadores.adicionar(new Jogador("Goleiro","William",1));

        Dados.guardar("arquivos/ListaDeJogadores.txt", jogadores, new JogadorSerializavel());

        Lista<Jogador> escola = new Lista<>();

        escola = Dados.abrir("arquivos/ListaDeJogadores.txt", new JogadorSerializavel());

        for (Jogador jogador : escola){
            fmt.println(jogador.getNome());
        }

        teste.deveSerIgual(jogadores.getQuantidade(), escola.getQuantidade(),"io_ler_arquivo -> Teste_1");

        for (int i = 0; i < jogadores.getQuantidade(); i++) {
            teste.deveSerIgual(jogadores.get(i).getNome(), escola.get(i).getNome(),"io_ler_arquivo -> Teste_2");
        }
    }
}
