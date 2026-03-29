package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Tempo;

public class FutebolDados {

    private String arquivo;
    private Lista<Jogador> jogadores;
    private Lista<Time> times;


    public FutebolDados() {
        this.arquivo = "arquivos/futebol.tsv";

        this.jogadores = new Lista<>();
        this.times = new Lista<>();
    }

    public void ler() {
        String doc = Texto.ler(arquivo);

        Lista<String> linhas = Texto.dividirLinhas(doc);

        for (String linha : linhas) {
            Lista<String> valores = Texto.dividirPorSimbolo(linha, "\t");

            if (Texto.igual(valores.get(0), "JOGADOR")) {
                Jogador j = new Jogador(valores.get(1),Tempo.parseData(valores.get(2)), Integer.parseInt(valores.get(4)), valores.get(5), Tempo.parseData(valores.get(6)), Tempo.parseData(valores.get(7)), Tempo.parseHorario(valores.get(8)), Tempo.parseHorario(valores.get(9)));
                j.setTimeID(Integer.parseInt(valores.get(3)));
                jogadores.adicionar(j);
            } else if (Texto.igual(valores.get(0), "TIME")) {
                Time t = new Time(Integer.parseInt(valores.get(1)), valores.get(2), Tempo.parseData(valores.get(3)), Tempo.parseData(valores.get(4)), Tempo.parseHorario(valores.get(5)), Tempo.parseHorario(valores.get(6)));
                times.adicionar(t);
            }


        }
    }

    public void salvar() {
        String doc = "";

        for (Jogador jogador : jogadores) {
            doc += "JOGADOR\t" + jogador.getNome() + "\t" + jogador.getDataNascimento().toString() + "\t"+ jogador.getTimeID() + "\t" + jogador.getUniforme() + "\t" + jogador.getPosicao() + "\t" + jogador.getDataCriada().toString() + "\t" + jogador.getDataModificada().toString() + "\t" + jogador.getHorarioCriado().toString() + "\t" + jogador.getHorarioModificado().toString() + "\n";
        }

        for (Time time : times) {
            doc += "TIME\t" + time.getId() + "\t" + time.getNome() + "\t" + time.getDataCriada().toString() + "\t" + time.getDataModificada().toString() + "\t" + time.getHorarioCriado().toString() + "\t" + time.getHorarioModificado().toString() + "\n";
        }

        Texto.escrever(arquivo, doc);
    }

    public Lista<Jogador> getJogadores() {
        return jogadores;
    }

    public Lista<Time> getTimes() {
        return times;
    }
}
