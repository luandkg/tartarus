package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Tempo;
import main.libs.utils.Serializavel;

public class TimeSerealizavel implements Serializavel<Time> {

    @Override
    public String transforma(Time tipo) {

        return tipo.getId() + "\t" + tipo.getNome();
    }

    @Override
    public Time destransforma(String valor) {
        Lista<String> lista = Texto.dividirPorSimbolo(valor, '\t');

        Time j = new Time(Integer.parseInt(lista.get(0)), lista.get(1), Tempo.parseData(lista.get(2)), Tempo.parseData(lista.get(3)), Tempo.parseHorario(lista.get(4)), Tempo.parseHorario(lista.get(5)), Integer.parseInt(lista.get(6)));
        return j;
    }

}
