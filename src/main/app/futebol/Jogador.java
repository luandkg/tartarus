package main.app.futebol;

import main.libs.auxiliar.StringIgualdadeInsensitiva;
import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;
import main.libs.tempo.Data;
import main.libs.tempo.Horario;

public class Jogador {

    private String nome;
    private int timeID;
    private int uniforme;
    private String posicao;
    private Data dataCriada, dataModificada;
    private Horario horarioCriado, horarioModificado;

    public Jogador(String nome, int uniforme, String posicao, Data dataCriada, Data dataModificada, Horario horarioCriado, Horario horarioModificado) {
        this.nome = nome;
        this.timeID = -1;
        this.uniforme = uniforme;
        this.posicao = posicao;
        this.dataCriada = dataCriada;
        this.dataModificada = dataModificada;
        this.horarioCriado = horarioCriado;
        this.horarioModificado = horarioModificado;

    }

    public String getNome() {
        return nome;
    }

    public int getUniforme() {
        return uniforme;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getTimeID() {
        return timeID;
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

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public void setUniforme(int uniforme) {
        this.uniforme = uniforme;
    }

    public void setPosicao(String posicao) {

        this.posicao = posicao;
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

    public static boolean validaPosicao(String posicao) {
        return posicoes().existeValor(posicao, new StringIgualdadeInsensitiva());
    }

    public static Lista<String> posicoes() {
        Lista<String> posicoesValidas = new Lista<>();
        posicoesValidas.adicionar("Goleiro");
        posicoesValidas.adicionar("Zagueiro");
        posicoesValidas.adicionar("Lateral");
        posicoesValidas.adicionar("Volante");
        posicoesValidas.adicionar("Meia");
        posicoesValidas.adicionar("Ponta");
        posicoesValidas.adicionar("Atacante");
        posicoesValidas.adicionar("Centroavante");
        return posicoesValidas;
    }

    public static void listarPosicoes() {
        fmt.println("\n=======================");
        fmt.println("LISTA DE POSICOES:");
        for (String posicao : posicoes()) {
            fmt.println("\t" + posicao);
        }
        fmt.println("\n=======================");
    }
}
