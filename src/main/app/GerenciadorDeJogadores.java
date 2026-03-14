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
        }catch (Exception erro){
            jogadores = new Lista<>();
        }

    }

    public void salvar() {
        Dados.guardar(arquivo, jogadores, new JogadorSerializavel());
    }

    public void cadastrar(Jogador jogador) {
        this.jogadores.adicionar(jogador);
        salvar();
    }

    public Lista<Jogador> listar() {
        return jogadores;
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

    public Talvez<Jogador> obter(String nome) {
        for (Jogador jogador : jogadores) {
            if (Texto.igual(jogador.getNome(), nome)) {
                return Talvez.TALVEZ(jogador);
            }
        }
        return Talvez.NADA();
    }
}
