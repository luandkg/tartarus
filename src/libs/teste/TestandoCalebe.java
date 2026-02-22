package libs.teste;

import estruturas.Lista;

public class TestandoCalebe {

    private final String nome;

    private int sucesso = 0;
    private int falhou = 0;
    private Lista<String> erros = null;

    public TestandoCalebe(String nome) {
        this.nome = nome;
        this.erros = new Lista<>();
    }

    public String getNome() {
        return nome;
    }


    public void deveSerIgual(int esperado,int recebido, String teste){
        if(esperado==recebido){
            sucesso+=1;
        }else{
            falhou+=1;
            erros.adicionar(teste);
        }
    }

    public void deveSerIgual(long esperado,long recebido, String teste){
        if(esperado==recebido){
            sucesso+=1;
        }else{
            falhou+=1;
            erros.adicionar(teste);
        }
    }

    public void deveSerVerdadeiro(boolean recebido, String teste){
        if(recebido){
            sucesso+=1;
        }else{
            falhou+=1;
            erros.adicionar(teste);
        }
    }

    public void deveSerFalso(boolean recebido, String teste) {
        if(recebido){
            falhou+=1;
            erros.adicionar(teste);
        }else{
            sucesso+=1;
        }
    }

    public void deveSerIgual(String esperado,String recebido, String teste){
        if(esperado.contentEquals(recebido)){
            sucesso+=1;
        }else{
            falhou+=1;
            erros.adicionar(teste);
        }
    }

    public void falhar(String teste){
        falhou+=1;
        erros.adicionar(teste);
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

    public Lista<String> getErros(){ return erros;}


}
