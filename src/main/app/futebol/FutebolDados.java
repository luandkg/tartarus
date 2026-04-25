package main.app.futebol;

import main.libs.arquivo.calebeDocumento.CalebeDocumento;
import main.libs.arquivo.calebeDocumento.Objeto;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.tempo.Data;
import main.libs.tempo.Horario;
import main.libs.tempo.Tempo;

public class FutebolDados {

    private String arquivo;
    private Lista<Jogador> jogadores;
    private Lista<Time> times;
    private Lista<Uniforme> uniformes;

    private int timeId, jogadorId, uniformeId;

    public FutebolDados() {
        this.arquivo = "arquivos/futebol/futebol";

        this.timeId = 0;
        this.jogadorId = 0;
        this.uniformeId = 0;
        this.jogadores = new Lista<>();
        this.times = new Lista<>();
        this.uniformes = new Lista<>();
    }

    public void ler() {
        CalebeDocumento cd = new CalebeDocumento();

        cd.abrir(arquivo+".documento");

        Objeto objFutebol = cd.objetoUnico("Futebol");
        timeId = Integer.parseInt(objFutebol.getAtributo("Id_Time").getValor());
        jogadorId = Integer.parseInt(objFutebol.getAtributo("Id_Jogador").getValor());
        uniformeId = Integer.parseInt(objFutebol.getAtributo("Id_Uniforme").getValor());

        Objeto objTimes = objFutebol.objetoUnico("Times");
        for (Objeto objTime : objTimes.getObjetos()) {
            int id = Integer.parseInt(objTime.atributo("Id").getValor());
            String nome = objTime.atributo("Nome").getValor();
            Data dataCriada = Tempo.parseData(objTime.atributo("Data_Criada").getValor());
            Data dataModificada = Tempo.parseData(objTime.atributo("Data_Modificada").getValor());
            Horario horarioCriado = Tempo.parseHorario(objTime.atributo("Horario_Criado").getValor());
            Horario horarioModificado = Tempo.parseHorario(objTime.atributo("Horario_Modificado").getValor());
            int idUniforme = Integer.parseInt(objTime.atributo("Id_Uniforme").getValor());

            Time time = new Time(id, nome, dataCriada, dataModificada, horarioCriado, horarioModificado, idUniforme);
            times.adicionar(time);

        }

        Objeto objJogadores = objFutebol.objetoUnico("Jogadores");
        for (Objeto objJogador : objJogadores.getObjetos()) {
            int id = Integer.parseInt(objJogador.atributo("Id").getValor());
            String nome = objJogador.atributo("Nome").getValor();
            Data dataNascimento = Tempo.parseData(objJogador.atributo("Data_De_Nascimento").getValor());
            int uniforme = Integer.parseInt(objJogador.atributo("Uniforme").getValor());
            String posicao = objJogador.atributo("Posicao").getValor();
            Data dataCriada = Tempo.parseData(objJogador.atributo("Data_Criada").getValor());
            Data dataModificada = Tempo.parseData(objJogador.atributo("Data_Modificada").getValor());
            Horario horarioCriado = Tempo.parseHorario(objJogador.atributo("Horario_Criado").getValor());
            Horario horarioModificado = Tempo.parseHorario(objJogador.atributo("Horario_Modificado").getValor());

            Jogador jogador = new Jogador(nome, dataNascimento, uniforme, posicao, dataCriada, dataModificada, horarioCriado, horarioModificado);
            jogador.setId(id);

            jogadores.adicionar(jogador);
        }

        Objeto objUniformes = objFutebol.objetoUnico("Uniformes");
        for (Objeto objUniforme : objUniformes.getObjetos()) {
            int id = Integer.parseInt(objUniforme.atributo("Id").getValor());
            String nome = objUniforme.atributo("Nome").getValor();

            Objeto objCores = objUniforme.objeto("Cores");

            Data dataCriada = Tempo.parseData(objUniforme.atributo("Data_Criada").getValor());
            Data dataModificada = Tempo.parseData(objUniforme.atributo("Data_Modificada").getValor());
            Horario horarioCriado = Tempo.parseHorario(objUniforme.atributo("Horario_Criado").getValor());
            Horario horarioModificado = Tempo.parseHorario(objUniforme.atributo("Horario_Modificado").getValor());

            Uniforme uniforme = new Uniforme(id, nome, dataCriada, dataModificada, horarioCriado, horarioModificado);

            for (Objeto cor : objCores.getObjetos()) {
                String corNome = cor.atributo("Cor").getValor();
                uniforme.adicionarCor(corNome);
            }
            uniformes.adicionar(uniforme);
        }
    }

    public void lerTSV() {
        String doc = Texto.ler(arquivo + ".tsv");

        Lista<String> linhas = Texto.dividirLinhas(doc);

        for (String linha : linhas) {
            Lista<String> valores = Texto.dividirPorSimbolo(linha, '\t');

            if (Texto.igual(valores.get(0), "JOGADOR")) {
                Jogador j = new Jogador(valores.get(1), Tempo.parseData(valores.get(2)), Integer.parseInt(valores.get(4)), valores.get(5), Tempo.parseData(valores.get(6)), Tempo.parseData(valores.get(7)), Tempo.parseHorario(valores.get(8)), Tempo.parseHorario(valores.get(9)));
                j.setId(Integer.parseInt(valores.get(3)));
                jogadores.adicionar(j);
            } else if (Texto.igual(valores.get(0), "TIME")) {
                Time t = new Time(Integer.parseInt(valores.get(1)), valores.get(2), Tempo.parseData(valores.get(3)), Tempo.parseData(valores.get(4)), Tempo.parseHorario(valores.get(5)), Tempo.parseHorario(valores.get(6)), Integer.parseInt(valores.get(7)));
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
            doc += "JOGADOR\t" + jogador.getNome() + "\t" + jogador.getDataNascimento().toString() + "\t" + jogador.getId() + "\t" + jogador.getUniforme() + "\t" + jogador.getPosicao() + "\t" + jogador.getDataCriada().toString() + "\t" + jogador.getDataModificada().toString() + "\t" + jogador.getHorarioCriado().toString() + "\t" + jogador.getHorarioModificado().toString() + "\n";
        }

        for (Time time : times) {
            doc += "TIME\t" + time.getId() + "\t" + time.getNome() + "\t" + time.getDataCriada().toString() + "\t" + time.getDataModificada().toString() + "\t" + time.getHorarioCriado().toString() + "\t" + time.getHorarioModificado().toString() + "\t" + time.getUniformeID() + "\n";
        }

        for (Uniforme uniforme : uniformes) {
            String c1 = "";
            String c2 = "";
            String c3 = "";

            if (uniforme.getCores().getQuantidade() >= 1) {
                c1 = uniforme.getCores().get(0);
            }
            if (uniforme.getCores().getQuantidade() >= 2) {
                c2 = uniforme.getCores().get(1);
            }
            if (uniforme.getCores().getQuantidade() >= 3) {
                c3 = uniforme.getCores().get(2);
            }

            doc += "UNIFORME\t" + uniforme.getId() + "\t" + uniforme.getNome() + "\t" + c1 + "\t" + c2 + "\t" + c3 + "\t" + uniforme.getDataCriada().toString() + "\t" + uniforme.getDataModificada().toString() + "\t" + uniforme.getHorarioCriado().toString() + "\t" + uniforme.getHorarioModificado().toString() + "\n";
        }

        Texto.escrever(arquivo + ".tsv", doc);
    }

    public void salvarDocumento() {
        CalebeDocumento cd = new CalebeDocumento();

        Objeto objFutebol = cd.objetoUnico("Futebol");
        objFutebol.atributo("Id_Time",String.valueOf(timeId));
        objFutebol.atributo("Id_Jogador",String.valueOf(jogadorId));
        objFutebol.atributo("Id_Uniforme",String.valueOf(uniformeId));

        Objeto objTimes = objFutebol.objetoUnico("Times");
        for (Time time : times) {
            Objeto t = objTimes.objetoCriar("Time");
            t.atributo("Id", String.valueOf(time.getId()));
            t.atributo("Nome", time.getNome());
            t.atributo("Data_Criada", time.getDataCriada().toString());
            t.atributo("Data_Modificada", time.getDataModificada().toString());
            t.atributo("Horario_Criado", time.getHorarioCriado().toString());
            t.atributo("Horario_Modificado", time.getHorarioModificado().toString());
            t.atributo("Id_Uniforme", String.valueOf(time.getUniformeID()));
        }

        Objeto objJogadores = objFutebol.objetoUnico("Jogadores");
        for (Jogador jogador : jogadores) {
            Objeto j = objJogadores.objetoCriar("Jogador");
            j.atributo("Id", String.valueOf(jogador.getId()));
            j.atributo("Nome", jogador.getNome());
            j.atributo("Data_De_Nascimento", jogador.getDataNascimento().toString());
            j.atributo("Uniforme", String.valueOf(jogador.getUniforme()));
            j.atributo("Posicao", jogador.getPosicao());
            j.atributo("Data_Criada", jogador.getDataCriada().toString());
            j.atributo("Data_Modificada", jogador.getDataModificada().toString());
            j.atributo("Horario_Criado", jogador.getHorarioCriado().toString());
            j.atributo("Horario_Modificado", jogador.getHorarioModificado().toString());
        }

        Objeto objUniformes = objFutebol.objetoUnico("Uniformes");

        for (Uniforme uniforme : uniformes) {
            Objeto u = objUniformes.objetoCriar("Uniforme");
            u.atributo("Id", String.valueOf(uniforme.getId()));
            u.atributo("Nome", uniforme.getNome());

            Objeto objCor = u.objetoUnico("Cores");
            for (String cor : uniforme.getCores()) {
                Objeto c = objCor.objetoCriar("Cor");
                c.atributo("Cor", cor);
            }

            u.atributo("Data_Criada", uniforme.getDataCriada().toString());
            u.atributo("Data_Modificada", uniforme.getDataModificada().toString());
            u.atributo("Horario_Criado", uniforme.getHorarioCriado().toString());
            u.atributo("Horario_Modificado", uniforme.getHorarioModificado().toString());
        }

        cd.salvar(arquivo + ".documento");
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

    public int obterTimeId(){
        return timeId++;
    }
    public int obterJogadorId(){
        return jogadorId++;
    }
    public int obterUniformeId(){
        return uniformeId++;
    }
}
