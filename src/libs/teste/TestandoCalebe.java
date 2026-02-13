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

    public void deveSerFalso(boolean recebido) {
        if(recebido){
            falhou+=1;
        }else{
            sucesso+=1;
        }
    }

    public void deveSerIgual(String esperado,String recebido){
        if(esperado.contentEquals(recebido)){
            sucesso+=1;
        }else{
            falhou+=1;
        }
    }

    public void falhar(){
        falhou+=1;
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
