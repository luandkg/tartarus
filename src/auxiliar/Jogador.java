package auxiliar;

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
}
