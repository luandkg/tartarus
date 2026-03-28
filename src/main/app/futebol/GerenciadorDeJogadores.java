package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.utils.Talvez;

public class GerenciadorDeJogadores {

    private FutebolDados futebolDados;

    public GerenciadorDeJogadores(FutebolDados futebolDados) {
        this.futebolDados = futebolDados;

    }

    public void salvar() {
        futebolDados.salvar();
    }

    public void criar(Jogador jogador) {
        futebolDados.getJogadores().adicionar(jogador);
        salvar();
    }

    public boolean remover(String nome) {
        for (Jogador jogador : futebolDados.getJogadores()) {
            if (Texto.igual(jogador.getNome(), nome)) {
                futebolDados.getJogadores().removerReferencia(jogador);
                salvar();
                return true;
            }
        }
        return false;
    }

    public Lista<Jogador> listar() {
        return futebolDados.getJogadores();
    }

    public Talvez<Jogador> obter(String nome) {
        for (Jogador jogador : futebolDados.getJogadores()) {
            if (Texto.igual(jogador.getNome(), nome)) {
                return Talvez.TALVEZ(jogador);
            }
        }
        return Talvez.NADA();
    }

    public Lista<Jogador> obterJogadoresDoTime(int timeID) {
        Lista<Jogador> jogadoresDoTime = new Lista<>();

        for (Jogador jogador : futebolDados.getJogadores()) {
            if (jogador.getTimeID()==timeID) {
                jogadoresDoTime.adicionar(jogador);
            }
        }
        return jogadoresDoTime;
    }

    public boolean existe(String nome) {
        for (Jogador jogador : futebolDados.getJogadores()) {
            if (Texto.igual(nome, jogador.getNome())) {
                return true;
            }
        }
        return false;
    }
}
