package main.app;

import main.libs.estruturas.Dados;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.utils.Talvez;

public class GerenciadorDeJogadores {

    private Lista<Jogador> jogadores;

    private String arquivo;

    public GerenciadorDeJogadores() {
        this.jogadores = new Lista<>();
        this.arquivo = "arquivos/Lista_De_Jogadores.csv";
        try {
            jogadores = Dados.abrir(arquivo, new JogadorSerializavel());
        } catch (Exception erro) {
            jogadores = new Lista<>();
        }

    }

    public void salvar() {
        Dados.guardar(arquivo, jogadores, new JogadorSerializavel());
    }

    public void criar(Jogador jogador) {
        this.jogadores.adicionar(jogador);
        salvar();
    }

    public boolean remover(String nome) {
        for (Jogador jogador : jogadores) {
            if (Texto.igual(jogador.getNome(), nome)) {
                jogadores.removerReferencia(jogador);
                salvar();
                return true;
            }
        }
        return false;
    }

    public Lista<Jogador> listar() {
        return jogadores;
    }

    public Talvez<Jogador> obter(String nome) {
        for (Jogador jogador : jogadores) {
            if (Texto.igual(jogador.getNome(), nome)) {
                return Talvez.TALVEZ(jogador);
            }
        }
        return Talvez.NADA();
    }

    public Lista<Jogador> obterJogadoresDoTime(int timeID) {
        Lista<Jogador> jogadoresDoTime = new Lista<>();

        for (Jogador jogador : jogadores) {
            if (jogador.getTimeID()==timeID) {
                jogadoresDoTime.adicionar(jogador);
            }
        }
        return jogadoresDoTime;
    }

    public boolean existe(String nome) {
        for (Jogador jogador : jogadores) {
            if (Texto.igual(nome, jogador.getNome())) {
                return true;
            }
        }
        return false;
    }
}
