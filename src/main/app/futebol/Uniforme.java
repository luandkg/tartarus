package main.app.futebol;

import main.libs.estruturas.Caixa;
import main.libs.estruturas.Lista;
import main.libs.tempo.Data;
import main.libs.tempo.Horario;

public class Uniforme {

    private int id;
    private String nome;
    private Caixa<String> cores;

    private Data dataCriada, dataModificada;
    private Horario horarioCriado, horarioModificado;

    public Uniforme(int id, String nome, Data dataCriada, Data dataModificada, Horario horarioCriado, Horario horarioModificado) {
        this.id = id;
        this.nome = nome;
        this.cores = new Caixa<>(3);
        this.dataCriada = dataCriada;
        this.dataModificada = dataModificada;
        this.horarioCriado = horarioCriado;
        this.horarioModificado = horarioModificado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Caixa<String> getCores() {
        return cores;
    }

    public Data getDataCriada() {
        return dataCriada;
    }

    public Data getDataModificada() {
        return dataModificada;
    }

    public Horario getHorarioCriado() {
        return horarioCriado;
    }

    public Horario getHorarioModificado() {
        return horarioModificado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCores(Caixa<String> cores) {
        this.cores = cores;
    }

    public void setDataCriada(Data dataCriada) {
        this.dataCriada = dataCriada;
    }


    public void setDataModificada(Data dataModificada) {
        this.dataModificada = dataModificada;
    }


    public void setHorarioCriado(Horario horarioCriado) {
        this.horarioCriado = horarioCriado;
    }

    public void setHorarioModificado(Horario horarioModificado) {
        this.horarioModificado = horarioModificado;
    }

    public void adicionarCor(String cor) {
        if (validaCor(cor)){
            cores.adicionar(cor);
        }
    }

    public boolean validaCor(String cor) {
        return cor != null;
    }

    public static Lista<String> possiveisCores() {
        Lista<String> cores = new Lista<>();

        cores.adicionar("Branco");
        cores.adicionar("Preto");
        cores.adicionar("Vermelho");
        cores.adicionar("Azul");
        cores.adicionar("Verde");
        cores.adicionar("Amarelo");
        cores.adicionar("Laranja");
        cores.adicionar("Roxo");
        cores.adicionar("Rosa");
        cores.adicionar("Cinza");
        cores.adicionar("Marrom");
        cores.adicionar("Ciano");
        cores.adicionar("Magenta");
        cores.adicionar("Dourado");
        cores.adicionar("Prateado");
        return cores;
    }
}
