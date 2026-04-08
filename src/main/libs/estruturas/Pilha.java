package main.libs.estruturas;

public class Pilha<T> {

    No<T> cabeca;

    int quantidade = 0;

    public Pilha() {
        this.cabeca = null;
        this.quantidade = 0;
    }

    public void empilhar(T valor) {
        No<T> novoNO = new No<T>(valor);
        novoNO.setProximo(cabeca);
        cabeca = novoNO;
        quantidade++;
    }

    public T desempilhar() {
        if (estaVazia()) {
            fmt.println("Erro: A pilha esta vazia!");
            return null;
        }
        No<T> noSaindo = cabeca;
        cabeca = cabeca.getProximo();
        quantidade--;
        return noSaindo.getValor();
    }

    public No<T> verTopo() {
        return cabeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }
}
