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

        jogadores.adicionar(new Jogador("Calebe",10,"Atacante"));
        jogadores.adicionar(new Jogador("Luan",7,"Meia"));
        jogadores.adicionar(new Jogador("Kaio",2,"Lateral"));
        jogadores.adicionar(new Jogador("Diogo",3,"Zagueiro"));
        jogadores.adicionar(new Jogador("William",1,"Goleiro"));

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
