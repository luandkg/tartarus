package main.libs.estruturas;

public class Fila<T> {

    No<T> inicio;
    No<T> fim;

    int quantidade = 0;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void enfileirar(T valor) {
        No<T> novoNO = new No<T>(valor);
        int posicaoCorrente = 0;

        if (estaVazia()) {
            inicio = novoNO;
            fim = novoNO;
        } else {
            fim.setProximo(novoNO);
            fim = novoNO;
        }
        quantidade++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            fmt.println("Erro: A pilha esta vazia!");
            return null;
        }
        No<T> noSaindo = inicio;
        inicio = inicio.getProximo();
        quantidade--;
        return noSaindo.getValor();
    }

    public No<T> verPrimeiro() {
        return inicio;
    }

    public T verUltimo() {
        return pegarUltimo().getValor();
    }

    public No<T> pegarUltimo() {
        No<T> noCorrente = inicio;
        int posicaoCorrente = 0;

        while (posicaoCorrente < quantidade) {
            noCorrente = noCorrente.getProximo();
        }
        return noCorrente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }
}
