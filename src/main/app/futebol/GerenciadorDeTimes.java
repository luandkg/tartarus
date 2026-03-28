package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.utils.Talvez;

public class GerenciadorDeTimes {

    private FutebolDados futebolDados;

    public GerenciadorDeTimes(FutebolDados futebolDados) {
        this.futebolDados = futebolDados;
    }

    public Lista<Time> getTimes() {
        return futebolDados.getTimes();
    }

    public void salvar() {
        futebolDados.salvar();
    }

    public void criar(Time time) {
        this.futebolDados.getTimes().adicionar(time);
        salvar();
    }

    public boolean remover(String nome) {
        for (Time time : futebolDados.getTimes()) {
            if (Texto.igual(time.getNome(), nome)) {
                futebolDados.getTimes().removerReferencia(time);
                salvar();
                return true;
            }
        }
        return false;
    }

    public Lista<Time> listar() {
        return futebolDados.getTimes();
    }

    public Talvez<Time> obter(String nome) {
        for (Time time : futebolDados.getTimes()) {
            if (Texto.igual(time.getNome(), nome)) {
                return Talvez.TALVEZ(time);
            }
        }
        return Talvez.NADA();
    }

    public String obter(int timeID) {
        for (Time time : futebolDados.getTimes()) {
            if (time.getId() == timeID) {
                return time.getNome();
            }
        }
        return "";
    }

    public boolean existe(String nome) {
        for (Time time : futebolDados.getTimes()) {
            if (Texto.igual(nome, time.getNome())) {
                return true;
            }
        }
        return false;
    }
}
