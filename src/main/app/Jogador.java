package main.app;

import main.libs.auxiliar.StringIgualdade;
import main.libs.auxiliar.StringIgualdadeInsensitiva;
import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;

public class Jogador{

    private String posicao;
    private String nome;
    private int uniforme;

    public Jogador(String posicao, String nome, int uniforme){
        this.posicao = posicao;
        this.nome = nome;
        this.uniforme = uniforme;
    }

    public String getPosicao(){
        return posicao;
    }

    public String getNome(){
        return nome;
    }

    public int getUniforme(){
        return uniforme;
    }

    public void setPosicao(String posicao){

        this.posicao = posicao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setUniforme(int uniforme){
        this.uniforme = uniforme;
    }

    public static boolean validaPosicao(String posicao){
        return posicoes().existeValor(posicao, new StringIgualdadeInsensitiva());
    }

    public static Lista<String> posicoes(){
        Lista<String> posicoesValidas = new Lista<>();
        posicoesValidas.adicionar("Goleiro");
        posicoesValidas.adicionar("Zagueiro");
        posicoesValidas.adicionar("Lateral");
        posicoesValidas.adicionar("Volante");
        posicoesValidas.adicionar("Meia");
        posicoesValidas.adicionar("Ponta");
        posicoesValidas.adicionar("Atacante");
        posicoesValidas.adicionar("Centroavante");
        return posicoesValidas;
    }

    public static void listarPosicoes(){
        fmt.println("\n=======================");
        fmt.println("LISTA DE POSICOES:");
        for (String posicao:posicoes()){
            fmt.println("\t"+posicao);
        }
        fmt.println("\n=======================");
    }
}
