package main.app;

import main.libs.estruturas.Dados;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;
import main.libs.utils.Talvez;

public class GerenciadorDeTimes {

    private Lista<Time> times;
    private String arquivo;

    public GerenciadorDeTimes() {
        this.times = new Lista<>();
        this.arquivo = "arquivos/Lista_De_Times.csv";
        try {
            times = Dados.abrir(arquivo, new TimeSerealizavel());
        } catch (Exception erro) {
            times = new Lista<>();
        }
    }

    public Lista<Time> getTimes() {
        return times;
    }

    public void setTimes(Lista<Time> times) {
        this.times = times;
    }

    public void salvar() {
        Dados.guardar(arquivo, times, new TimeSerealizavel());
    }

    public void criar(Time time) {
        this.times.adicionar(time);
        salvar();
    }

    public boolean remover(String nome) {
        for (Time time : times) {
            if (Texto.igual(time.getNome(), nome)) {
                times.removerReferencia(time);
                salvar();
                return true;
            }
        }
        return false;
    }

    public Lista<Time> listar() {
        return times;
    }

    public Talvez<Time> obter(String nome) {
        for (Time time : times) {
            if (Texto.igual(time.getNome(), nome)) {
                return Talvez.TALVEZ(time);
            }
        }
        return Talvez.NADA();
    }

    public String obter(int timeID) {
        for (Time time : times) {
            if (time.getId() == timeID) {
                return time.getNome();
            }
        }
        return "";
    }

    public boolean existe(String nome) {
        for (Time time : times) {
            if (Texto.igual(nome, time.getNome())) {
                return true;
            }
        }
        return false;
    }
}
