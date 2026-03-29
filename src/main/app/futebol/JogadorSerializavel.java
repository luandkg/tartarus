package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Tempo;
import main.libs.utils.Serializavel;

public class JogadorSerializavel implements Serializavel<Jogador> {

    @Override
    public String transforma(Jogador tipo) {
        return tipo.getNome()+"\t"+tipo.getTimeID()+"\t"+tipo.getUniforme()+"\t"+tipo.getPosicao();
    }

    @Override
    public Jogador destransforma(String valor) {
        Lista<String> lista = Texto.dividirPorSimbolo(valor, "\t");

        Jogador j = new Jogador(lista.get(0),Tempo.parseData(lista.get(2)),Integer.parseInt(lista.get(3)),lista.get(4), Tempo.parseData(lista.get(5)), Tempo.parseData(lista.get(6)), Tempo.parseHorario(lista.get(7)), Tempo.parseHorario(lista.get(8)));
        j.setTimeID(Integer.parseInt(lista.get(1)));
        return j;
    }
}
