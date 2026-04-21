package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Tempo;
import main.libs.utils.Serializavel;

public class JogadorSerializavel implements Serializavel<Jogador> {

    @Override
    public String transforma(Jogador tipo) {
        return tipo.getNome()+"\t"+tipo.getId()+"\t"+tipo.getDataNascimento().toString()+"\t"+tipo.getUniforme()+"\t"+tipo.getPosicao()+"\t"+tipo.getDataCriada().toString()+"\t"+tipo.getDataModificada().toString()+"\t"+tipo.getHorarioCriado().toString()+"\t"+tipo.getHorarioModificado().toString();
    }

    @Override
    public Jogador destransforma(String valor) {
        Lista<String> lista = Texto.dividirPorSimbolo(valor, "\t");

        Jogador j = new Jogador(lista.get(0),Tempo.parseData(lista.get(2)),Integer.parseInt(lista.get(3)),lista.get(4), Tempo.parseData(lista.get(5)), Tempo.parseData(lista.get(6)), Tempo.parseHorario(lista.get(7)), Tempo.parseHorario(lista.get(8)));
        j.setId(Integer.parseInt(lista.get(1)));
        return j;
    }
}
