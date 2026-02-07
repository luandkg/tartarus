public class Lista<T> {

    private No<T> inicio = null;
    private No<T>fim = null;
    private int quantidade = 0;

    public Lista() {
        this.inicio = null;
    }

    public void adicionar(T valor) {
        No<T> no = new No<T>(valor);

        if(inicio==null){
            inicio = no;
            fim = no;
        }else{
            fim.setProximo(no);
            fim = no;
        }

        quantidade++;
    }

    public T get(int posicao) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
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
