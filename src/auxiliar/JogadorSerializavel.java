package auxiliar;

import estruturas.Lista;
import estruturas.Texto;
import utils.Serializavel;

public class JogadorSerializavel implements Serializavel<Jogador> {

    @Override
    public String transforma(Jogador tipo) {
        return tipo.getPosicao()+"\t"+tipo.getNome()+"\t"+tipo.getUniforme();
    }

    @Override
    public Jogador destransforma(String valor) {
        Lista<String> lista = Texto.dividirPorSimbolo(valor, "\t");

        Jogador j = new Jogador(lista.get(0),lista.get(1),Integer.parseInt(lista.get(2)));
        return j;
    }
}
