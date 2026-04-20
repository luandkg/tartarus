package main.app.futebol;

import main.libs.calebeDocumento.CalebeDocumento;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Tempo;

public class FutebolDados {

    private String arquivo;
    private Lista<Jogador> jogadores;
    private Lista<Time> times;
    private Lista<Uniforme> uniformes;



    public FutebolDados() {
        this.arquivo = "arquivos/futebol/futebol";

        this.jogadores = new Lista<>();
        this.times = new Lista<>();
        this.uniformes = new Lista<>();
    }

    public void ler() {
        String doc = Texto.ler(arquivo+".tsv");

        Lista<String> linhas = Texto.dividirLinhas(doc);

        for (String linha : linhas) {
            Lista<String> valores = Texto.dividirPorSimbolo(linha, "\t");

            if (Texto.igual(valores.get(0), "JOGADOR")) {
                Jogador j = new Jogador(valores.get(1),Tempo.parseData(valores.get(2)), Integer.parseInt(valores.get(4)), valores.get(5), Tempo.parseData(valores.get(6)), Tempo.parseData(valores.get(7)), Tempo.parseHorario(valores.get(8)), Tempo.parseHorario(valores.get(9)));
                j.setTimeID(Integer.parseInt(valores.get(3)));
                jogadores.adicionar(j);
            } else if (Texto.igual(valores.get(0), "TIME")) {
                Time t = new Time(Integer.parseInt(valores.get(1)), valores.get(2), Tempo.parseData(valores.get(3)), Tempo.parseData(valores.get(4)), Tempo.parseHorario(valores.get(5)), Tempo.parseHorario(valores.get(6)),Integer.parseInt(valores.get(7)));
                times.adicionar(t);
            } else if (Texto.igual(valores.get(0), "UNIFORME")) {
                Uniforme u = new Uniforme(Integer.parseInt(valores.get(1)), valores.get(2), Tempo.parseData(valores.get(6)), Tempo.parseData(valores.get(7)), Tempo.parseHorario(valores.get(8)), Tempo.parseHorario(valores.get(9)));
                u.adicionarCor(valores.get(3));
                u.adicionarCor(valores.get(4));
                u.adicionarCor(valores.get(5));
                uniformes.adicionar(u);
            }


        }
    }

    public void salvar() {
        salvarTSV();
        salvarDocumento();
    }

    public void salvarTSV() {
        String doc = "";

        for (Jogador jogador : jogadores) {
            doc += "JOGADOR\t" + jogador.getNome() + "\t" + jogador.getDataNascimento().toString() + "\t"+ jogador.getTimeID() + "\t" + jogador.getUniforme() + "\t" + jogador.getPosicao() + "\t" + jogador.getDataCriada().toString() + "\t" + jogador.getDataModificada().toString() + "\t" + jogador.getHorarioCriado().toString() + "\t" + jogador.getHorarioModificado().toString() + "\n";
        }

        for (Time time : times) {
            doc += "TIME\t" + time.getId() + "\t" + time.getNome() + "\t" + time.getDataCriada().toString() + "\t" + time.getDataModificada().toString() + "\t" + time.getHorarioCriado().toString() + "\t" + time.getHorarioModificado().toString() + "\t" + time.getUniformeID() + "\n";
        }

        for (Uniforme uniforme : uniformes) {
            String c1 = "";
            String c2 = "";
            String c3 = "";

            if(uniforme.getCores().getQuantidade()>=1){
                c1 = uniforme.getCores().get(0);
            }
            if(uniforme.getCores().getQuantidade()>=2){
                c2 = uniforme.getCores().get(1);
            }
            if(uniforme.getCores().getQuantidade()>=3){
                c3 = uniforme.getCores().get(2);
            }

            doc += "UNIFORME\t" + uniforme.getId() + "\t" + uniforme.getNome() + "\t" + c1 + "\t" + c2 + "\t" + c3 + "\t" + uniforme.getDataCriada().toString() + "\t" + uniforme.getDataModificada().toString() + "\t" + uniforme.getHorarioCriado().toString() + "\t" + uniforme.getHorarioModificado().toString() + "\n";
        }

        Texto.escrever(arquivo+".tsv", doc);
    }

    public void salvarDocumento() {
        CalebeDocumento cd = new CalebeDocumento();

        cd.objetoUnico("Futebol");

        cd.salvar(arquivo+".documento");
    }

    public Lista<Jogador> getJogadores() {
        return jogadores;
    }

    public Lista<Time> getTimes() {
        return times;
    }

    public Lista<Uniforme> getUniformes() {
        return uniformes;
    }
}
