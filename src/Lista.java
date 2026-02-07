public class Lista {

    private No inicio = null;
    private No fim = null;
    private int quantidade = 0;

    public Lista() {
        this.inicio = null;
    }

    public void adicionar(String valor) {
        No no = new No(valor);

        if(inicio==null){
            inicio = no;
            fim = no;
        }else{
            fim.setProximo(no);
            fim = no;
        }

        quantidade++;
    }

    public String get(int posicao) {
        int posicaoCorrente = 0;
        No noCorrente = inicio;
        while(posicaoCorrente<quantidade){
            if(posicaoCorrente == posicao){
                return noCorrente.getValor();
            }
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        return null;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
