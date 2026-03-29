package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;
import main.libs.tempo.Data;
import main.libs.tempo.Tempo;
import main.libs.utils.Talvez;

import java.util.Scanner;

public class Futebol {

    private FutebolDados futebolDados;
    private GerenciadorDeJogadores gerenciadorDeJogadores;
    private GerenciadorDeTimes gerenciadorDeTimes;

    private boolean executando = false;

    public Futebol() {
        this.futebolDados = new FutebolDados();
        futebolDados.ler();

        this.gerenciadorDeJogadores = new GerenciadorDeJogadores(futebolDados);
        this.gerenciadorDeTimes = new GerenciadorDeTimes(futebolDados);

    }

    public void menu() {
        fmt.println("Menu Futebol");
        menuTime();
        menuJogador();
        fmt.println("\t10 - Exibir Jogadores Mais Velhos");
        fmt.println("\t11 - Exibir Jogadores Mais Novos");

        fmt.println("\t0 - Sair\n");

    }
    public void menuTime() {
        fmt.println("\t1 - Criar Time");
        fmt.println("\t2 - Listar Times");
        fmt.println("\t3 - Remover Time");
        fmt.println("\t4 - Ver Informacoes do Time");
        fmt.println("\t5 - Selecionar Time");
    }

    public void menuJogador() {
        fmt.println("\t6 - Criar Jogador");
        fmt.println("\t7 - Listar Jogadores");
        fmt.println("\t8 - Remover Jogador");
        fmt.println("\t9 - Ver Informacoes do Jogador");
    }

    public void menuVincularJogador() {
        fmt.println("\t1 - Vincular Jogador");
        fmt.println("\t2 - Desvincular Jogador");
        fmt.println("\t3 - Listar Jogadores Do Time");
        fmt.println("\t0 - Voltar");
    }

    public void executar() {
        this.executando = true;

        while (executando) {
            menu();

            fmt.print(">> Digite a opcao desejada: ");

            Scanner leitor = new Scanner(System.in);
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "1" -> cadastrarTime();
                case "2" -> listarTime();
                case "3" -> removerTime();
                case "4" -> verInformacoesDoTime();
                case "5" -> selecionarTime();
                case "6" -> cadastrarJogador();
                case "7" -> listarJogadores();
                case "8" -> removerJogador();
                case "9" -> verInformacoesDoJogador();
                case "10" -> listarJogadoresMaisVelhos();
                case "11" -> listarJogadoresMaisNovos();

                case "0" -> sair();
                case null, default -> {
                    fmt.println("Opcao invalida!");
                }
            }
        }
    }

    private void sair() {
        this.executando = false;
    }

    private void cadastrarJogador() {
        fmt.printCaixa("CADASTRAR JOGADOR ",30);

        Scanner leitor = new Scanner(System.in);

        fmt.print(">> Digite o nome: ");
        String nome = leitor.nextLine();
        if(nome.length()<3){
            fmt.println("Erro: Nome com tamanho invalido!");
            return;
        }
        if(gerenciadorDeJogadores.existe(nome)){
            fmt.println("Erro: Ja existe um jogador cadastrado com esse nome!");
            return;
        }

        fmt.print(">> Digite a data de nascimento: ");
        String dataNascimento = leitor.nextLine();
        try{
            Data data = Tempo.parseData(dataNascimento);

            if(Data.maior(data,Tempo.getDataHoje())){
                fmt.println("Erro: A pessoa nao pode nascer no futuro!");
                return;
            }
        } catch (Exception erro){
            fmt.println(erro.toString());
            return;
        }


        fmt.print(">> Digite o uniforme: ");
        String uni = leitor.nextLine();
        int uniforme;

        try {
            uniforme = Integer.parseInt(uni);
        } catch (Exception e) {
            fmt.println("Erro: O uniforme nao pode ser cadastrado");
            return;
        }
        if(uniforme<1 || uniforme>99){
            fmt.println("Erro: O numero do uniforme deve estar entre 1 e 99");
            return;
        }

        fmt.print(">> Digite a posicao: ");
        String posicao = leitor.nextLine();
        if(!Jogador.validaPosicao(posicao)){
            fmt.println("Erro: Posicao invalida!");
            Jogador.listarPosicoes();
            return;
        }

        Jogador jogador = new Jogador(nome, Tempo.parseData(dataNascimento), uniforme, posicao, Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora());

        gerenciadorDeJogadores.criar(jogador);

        fmt.println("Jogador cadastrado com sucesso!");
    }

    private  void exibirJogadores(Lista<Jogador> jogadores){
        if(jogadores.getQuantidade()>0){
            fmt.println(fmt.repete("-", 120));
            fmt.println("|{centraliza_118}|", "Lista de Jogadores");
            fmt.println(fmt.repete("-", 120));
            fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} | {esquerda_15} | {esquerda_16} |", "JOGADOR","NOME","IDADE","UNIFORME","POSICAO","TIME");
            fmt.println(fmt.repete("-", 120));

            int cont = 1;

            for (Jogador jogador : jogadores){
                String time;

                if(jogador.getTimeID()!=-1){
                    time = gerenciadorDeTimes.obter(jogador.getTimeID());
                }else {
                    time = "";
                }

                fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} | {esquerda_15} | {esquerda_16} |", cont,jogador.getNome(),jogador.getIdade(),jogador.getUniforme(),jogador.getPosicao(),time);
                cont++;
            }
            fmt.println(fmt.repete("-", 120));
        }else{
            fmt.println("A lista de jogadores esta vazia!");
        }
    }

    private void listarJogadores() {
        exibirJogadores(gerenciadorDeJogadores.listar());
    }

    private void removerJogador() {
        fmt.printCaixa("REMOVER JOGADOR ",30);

        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do jogador: ");
        String nome = leitor.nextLine();
        if(gerenciadorDeJogadores.remover(nome)){
            fmt.println("Jogador removido com sucesso!");
        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }
    }

    private void verInformacoesDoJogador() {
        fmt.printCaixa("DETALHES DO JOGADOR ",30);

        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do jogador: ");
        String nome = leitor.nextLine();

        Talvez<Jogador> talvez = gerenciadorDeJogadores.obter(nome);
        if(talvez.temValor()){
            fmt.println(fmt.repete("-", 83));
            fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} |","POSICAO", "NOME","IDADE", "UNIFORME");
            fmt.println(fmt.repete("-", 83));

            fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} |", talvez.getValor().getPosicao(),talvez.getValor().getNome(),talvez.getValor().getIdade(),talvez.getValor().getUniforme());
            fmt.println(fmt.repete("-", 83));
        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }
    }


    private void cadastrarTime(){
        fmt.printCaixa("CADASTRAR TIME",30);
        Scanner leitor = new Scanner(System.in);

        fmt.print(">> Digite o nome: ");
        String nome = leitor.nextLine();
        if(nome.length()<3){
            fmt.println("Erro: Nome com tamanho invalido!");
            return;
        }
        if(gerenciadorDeTimes.existe(nome)){
            fmt.println("Erro: Ja existe um time cadastrado com esse nome!");
            return;
        }

        Time time = new Time(gerenciadorDeTimes.listar().getQuantidade(), nome, Tempo.getDataHoje(),Tempo.getDataHoje(),Tempo.getHorarioAgora(),Tempo.getHorarioAgora());

        gerenciadorDeTimes.criar(time);

        fmt.println("Time cadastrado com sucesso!");

    }

    private void removerTime(){
        fmt.printCaixa("REMOVER TIME",30);

        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do Time: ");
        String nome = leitor.nextLine();
        if(gerenciadorDeTimes.remover(nome)){
            fmt.println("Time removido com sucesso!");
        }else{
            fmt.println("Erro: Time nao encontrado!");
        }
    }
    private void listarTime(){
        if(gerenciadorDeTimes.listar().getQuantidade()>0){
            fmt.println(fmt.repete("-", 44));
            fmt.println("|{centraliza_42}|", "Lista de Times");
            fmt.println(fmt.repete("-", 44));
            fmt.println("| {esquerda_5} | {esquerda_15} | {esquerda_14} |", "ID", "TIME", "QUANTIDADE");
            fmt.println(fmt.repete("-", 44));

            for (Time time : gerenciadorDeTimes.listar()){
                fmt.println("| {esquerda_5} | {esquerda_15} | {esquerda_14} |",time.getId(),time.getNome(), gerenciadorDeJogadores.obterJogadoresDoTime(time.getId()).getQuantidade());
            }
            fmt.println(fmt.repete("-", 44));
        }else{
            fmt.println("A lista de times esta vazia!");
        }
    }

    private void verInformacoesDoTime(){
        fmt.printCaixa("DETALHES DO TIME",30);

        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do Time: ");
        String nome = leitor.nextLine();

        Talvez<Time> talvez = gerenciadorDeTimes.obter(nome);
        if(talvez.temValor()){
            fmt.println(fmt.repete("-", 44));
            fmt.println("| {esquerda_5} | {esquerda_32} |", "ID", "TIME");
            fmt.println(fmt.repete("-", 44));
            fmt.println("| {esquerda_5} | {esquerda_32} |",talvez.getValor().getId(),talvez.getValor().getNome(), talvez.getValor());
            fmt.println(fmt.repete("-", 44));
        }else{
            fmt.println("Erro: Time nao encontrado!");
        }
    }

    private void selecionarTime(){
        fmt.printCaixa("SELECIONAR TIME ",30);

        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do Time: ");
        String nome = leitor.nextLine();

        Talvez<Time> talvez = gerenciadorDeTimes.obter(nome);

        if(talvez.temValor()){
            boolean executandoTime = true;
            while (executandoTime){

                menuVincularJogador();
                fmt.print(">> Digite a opcao desejada: ");
                String opcao = leitor.nextLine();

                switch (opcao) {
                    case "1" -> vincularJogador(talvez.getValor());
                    case "2" -> desvincularJogador(talvez.getValor());
                    case "3" -> listarJogadoresDoTime(talvez.getValor());

                    case "0" -> {
                        executandoTime = false;
                        break;
                    }

                    case null, default -> {
                        fmt.println("Opcao invalida!");
                    }
                }
            }

        }else{
            fmt.println("Erro: Time ao encontrado!");
        }
    }

    private void vincularJogador(Time time){
        fmt.println("Digite o nome do jogador: ");

        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();

        Talvez<Jogador> talvezJogador = gerenciadorDeJogadores.obter(nome);

        if(talvezJogador.temValor()){
            talvezJogador.getValor().setTimeID(time.getId());

            talvezJogador.getValor().setDataModificada(Tempo.getDataHoje());
            talvezJogador.getValor().setHorarioModificado(Tempo.getHorarioAgora());
            gerenciadorDeJogadores.salvar();
        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }

    }

    private void desvincularJogador(Time time){
        fmt.println("Digite o nome do jogador: ");

        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();

        Talvez<Jogador> talvezJogador = gerenciadorDeJogadores.obter(nome);

        if(talvezJogador.temValor()){
            talvezJogador.getValor().setTimeID(-1);

            talvezJogador.getValor().setDataModificada(Tempo.getDataHoje());
            talvezJogador.getValor().setHorarioModificado(Tempo.getHorarioAgora());
            gerenciadorDeJogadores.salvar();

        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }
    }

    private void listarJogadoresDoTime(Time time){
        Lista<Jogador> jogadores = gerenciadorDeJogadores.obterJogadoresDoTime(time.getId());

        if(jogadores.getQuantidade()>0){
            fmt.println(fmt.repete("-", 102));
            fmt.println("|{centraliza_100}|", "Lista de Jogadores Do Time: " + time.getNome());
            fmt.println(fmt.repete("-", 102));
            fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} | {esquerda_16} |", "JOGADOR","NOME","IDADE","UNIFORME","POSICAO");
            fmt.println(fmt.repete("-", 102));

            int cont = 1;

            for (Jogador jogador : jogadores){
                String nomeTime = gerenciadorDeTimes.obter(jogador.getTimeID());

                fmt.println("| {esquerda_15} | {esquerda_25} | {esquerda_15} | {esquerda_15} | {esquerda_16} |", cont,jogador.getNome(),jogador.getIdade(),jogador.getUniforme(),jogador.getPosicao());
                cont++;
            }
            fmt.println(fmt.repete("-", 102));
        }else{
            fmt.println("A lista de jogadores esta vazia!");
        }
    }

    private void listarJogadoresMaisVelhos(){
        Lista<Jogador> jogadores = gerenciadorDeJogadores.listar();
        Lista<Jogador> jVelhos = new Lista<>();
        long maiorIdade = Long.MIN_VALUE;

        for (Jogador jogador : jogadores){

            if(jogador.getIdade()>maiorIdade){
                maiorIdade = jogador.getIdade();
            }
        }

        for (Jogador jogador : jogadores){

            if(jogador.getIdade() == maiorIdade){
                jVelhos.adicionar(jogador);
            }
        }

        exibirJogadores(jVelhos);
    }

    private void listarJogadoresMaisNovos(){
        Lista<Jogador> jogadores = gerenciadorDeJogadores.listar();
        Lista<Jogador> jNovos = new Lista<>();
        long menorIdade = Long.MAX_VALUE;

        for (Jogador jogador : jogadores){

            if(jogador.getIdade()<menorIdade){
                menorIdade = jogador.getIdade();
            }
        }

        for (Jogador jogador : jogadores){

            if(jogador.getIdade() == menorIdade){
                jNovos.adicionar(jogador);
            }
        }

        exibirJogadores(jNovos);
    }
}
