package libs.teste;

public class TestandoCalebe {

    private final String nome;

    private int sucesso = 0;
    private int falhou = 0;

    public TestandoCalebe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void deveSerIgual(int esperado,int recebido){
        if(esperado==recebido){
            sucesso+=1;
        }else{
            falhou+=1;
        }
    }

    public void deveSerVerdadeiro(boolean recebido){
        if(recebido){
            sucesso+=1;
        }else{
            falhou+=1;
        }
    }


    public int getTotal(){
        return sucesso+falhou;
    }

    public int getSucesso(){
        return sucesso;
    }

    public int getFalhou(){
        return falhou;
    }
}
