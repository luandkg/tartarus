package testes;

import main.app.futebol.Jogador;
import main.app.futebol.JogadorSerializavel;
import main.libs.estruturas.Dados;
import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;
import main.libs.tempo.Tempo;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteDados {

    @TesteCalebe
    public static void io_ler_arquivo(TestandoCalebe teste){
        Lista<Jogador> jogadores = new Lista<Jogador>();

        jogadores.adicionar(new Jogador("Calebe",Tempo.parseData("23/03/2002"),10,"Atacante", Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora()));
        jogadores.adicionar(new Jogador("Luan",Tempo.parseData("23/03/2002"),7,"Meia", Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora()));
        jogadores.adicionar(new Jogador("Kaio",Tempo.parseData("23/03/2002"),2,"Lateral", Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora()));
        jogadores.adicionar(new Jogador("Diogo",Tempo.parseData("23/03/2002"),3,"Zagueiro", Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora()));
        jogadores.adicionar(new Jogador("William",Tempo.parseData("23/03/2002"),1,"Goleiro", Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora()));

        Dados.guardar("arquivos/futebol/ListaDeJogadores.txt", jogadores, new JogadorSerializavel());

        Lista<Jogador> escola = new Lista<>();

        escola = Dados.abrir("arquivos/futebol/ListaDeJogadores.txt", new JogadorSerializavel());

        for (Jogador jogador : escola){
            fmt.println(jogador.getNome());
        }

        teste.deveSerIgual(jogadores.getQuantidade(), escola.getQuantidade(),"io_ler_arquivo -> Teste_1");

        for (int i = 0; i < jogadores.getQuantidade(); i++) {
            teste.deveSerIgual(jogadores.get(i).getNome(), escola.get(i).getNome(),"io_ler_arquivo -> Teste_2");
        }
    }
}
