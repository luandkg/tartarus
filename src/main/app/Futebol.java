package main.app;

import main.libs.estruturas.fmt;
import main.libs.utils.Talvez;

import java.util.Scanner;

public class Futebol {

    private GerenciadorDeJogadores gerenciador;

    private boolean executando = false;

    public Futebol() {
        this.gerenciador = new GerenciadorDeJogadores();
    }

    public void menu() {
        fmt.println("Menu Futebol");
        fmt.println("\t1 - Cadastrar Jogador");
        fmt.println("\t2 - Listar Jogadores");
        fmt.println("\t3 - Remover Jogador");
        fmt.println("\t4 - Ver Informacoes do Jogador");
        fmt.println("\t0 - Sair\n");
    }

    public void executar() {
        this.executando = true;

        while (executando) {
            menu();

            fmt.print(">> Digite a opcao desejada: ");

            Scanner leitor = new Scanner(System.in);
            String opcao = leitor.nextLine();
            fmt.println("O leitor captou: " + opcao);

            switch (opcao) {
                case "1" -> cadastrarJogador();
                case "2" -> listarJogadores();
                case "3" -> removerJogador();
                case "4" -> verInformacoesDoJogador();
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

        Scanner leitor = new Scanner(System.in);

        fmt.print(">> Digite a posicao: ");

        String posicao = leitor.nextLine();
        if(!Jogador.validaPosicao(posicao)){
            fmt.println("Erro: Posicao invalida!");
            Jogador.listarPosicoes();
            return;
        }

        fmt.print(">> Digite o nome: ");
        String nome = leitor.nextLine();
        if(nome.length()<3){
            fmt.println("Erro: Nome com tamanho invalido!");
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

        Jogador jogador = new Jogador(posicao, nome, uniforme);

        gerenciador.cadastrar(jogador);

        fmt.println("Jogador cadastrado com sucesso!");
    }

    private void listarJogadores() {
        if(gerenciador.listar().getQuantidade()>0){
            fmt.println(fmt.repete("-", 73));
            fmt.println("|{centraliza_73}|", "Lista de Jogadores");
            fmt.println(fmt.repete("-", 73));
            fmt.println("| {esquerda_15} | {esquerda_15} | {esquerda_15} | {esquerda_15} |", "JOGADOR", "POSICAO", "NOME", "UNIFORME");
            fmt.println(fmt.repete("-", 73));

            int cont = 1;

            for (Jogador jogador : gerenciador.listar()){
                fmt.println("| {esquerda_15} | {esquerda_15} | {esquerda_15} | {esquerda_15} |", cont,jogador.getPosicao(),jogador.getNome(),jogador.getUniforme());
                cont++;
            }
            fmt.println(fmt.repete("-", 73));
        }else{
            fmt.println("A lista de jogadores esta vazia!");
        }
    }

    private void removerJogador() {
        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do jogador: ");
        String nome = leitor.nextLine();
        if(gerenciador.remover(nome)){
            fmt.println("Jogador removido com sucesso!");
        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }
    }

    private void verInformacoesDoJogador() {
        Scanner leitor = new Scanner(System.in);
        fmt.print(">> Digite o nome do jogador: ");
        String nome = leitor.nextLine();

        Talvez<Jogador> talvez = gerenciador.obter(nome);
        if(talvez.temValor()){
            fmt.println(fmt.repete("-", 55));
            fmt.println("| {esquerda_15} | {esquerda_15} | {esquerda_15} |","POSICAO", "NOME", "UNIFORME");
            fmt.println(fmt.repete("-", 55));
            fmt.println("| {esquerda_15} | {esquerda_15} | {esquerda_15} |", talvez.getValor().getPosicao(),talvez.getValor().getNome(),talvez.getValor().getUniforme());
            fmt.println(fmt.repete("-", 55));
        }else{
            fmt.println("Erro: Jogador nao encontrado!");
        }
    }


}
