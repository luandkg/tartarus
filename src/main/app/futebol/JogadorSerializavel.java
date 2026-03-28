package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.utils.Serializavel;

public class JogadorSerializavel implements Serializavel<Jogador> {

    @Override
    public String transforma(Jogador tipo) {
        return tipo.getNome()+"\t"+tipo.getTimeID()+"\t"+tipo.getUniforme()+"\t"+tipo.getPosicao();
    }

    @Override
    public Jogador destransforma(String valor) {
        Lista<String> lista = Texto.dividirPorSimbolo(valor, "\t");

        Jogador j = new Jogador(lista.get(0),Integer.parseInt(lista.get(2)),lista.get(3));
        j.setTimeID(Integer.parseInt(lista.get(1)));
        return j;
    }
}
