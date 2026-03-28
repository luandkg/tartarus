package main.app.futebol;

import main.libs.tempo.Data;
import main.libs.tempo.Horario;

public class Time {
    private int id;
    private String nome;
    private Data dataCriada, dataModificada;
    private Horario horarioCriado, horarioModificado;

    public Time(int id, String nome, Data dataCriada, Data dataModificada, Horario horarioCriado, Horario horarioModificado) {
        this.id = id;
        this.nome = nome;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
