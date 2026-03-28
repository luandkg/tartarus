package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;

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

            if(Texto.igual(valores.get(0),"JOGADOR")){
                Jogador j = new Jogador(valores.get(1),Integer.parseInt(valores.get(3)),valores.get(4));
                j.setTimeID(Integer.parseInt(valores.get(2)));
                jogadores.adicionar(j);
            }else if(Texto.igual(valores.get(0),"TIME")){
                Time t = new Time(Integer.parseInt(valores.get(1)),valores.get(2));
                times.adicionar(t);
            }


        }
    }

    public void salvar() {
        String doc = "";

        for (Jogador jogador : jogadores) {
            doc += "JOGADOR\t" + jogador.getNome() + "\t" + jogador.getTimeID() + "\t" + jogador.getUniforme() + "\t" + jogador.getPosicao() + "\n";
        }

        for (Time time : times) {
            doc += "TIME\t" + time.getId() + "\t" + time.getNome() + "\n";
        }

        Texto.escrever(arquivo, doc);
    }

    public Lista<Jogador> getJogadores() {
        return jogadores;
    }

    public Lista<Time> getTimes() {
        return times;
    }


    /*
    * try {
            jogadores = Dados.abrir(arquivo, new JogadorSerializavel());
        } catch (Exception erro) {
            jogadores = new Lista<>();
        }

        try {
            times = Dados.abrir(arquivo, new TimeSerealizavel());
        } catch (Exception erro) {
            times = new Lista<>();
        }*/
}
