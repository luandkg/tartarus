package estruturas;

import utils.Igualdade;

public class Caixa<T> {

    private int tamanhoMaximo;
    private Lista<T> lista;

    public Caixa(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        lista = new Lista<>();
    }

    public T get(int posicao) {
        return lista.get(posicao);
    }

    public void set(int posicao, T valor) {
        lista.set(posicao, valor);
    }

    public int getQuantidade() {
        return lista.getQuantidade();
    }

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void adicionar(T t) {
        if (estaCheia()) {
            throw new RuntimeException("Erro: A caixa esta cheia!");
        } else {
            lista.adicionar(t);
        }
    }

    public int contarValor(T valor, Igualdade<T> igualdade) {
        return lista.contarValor(valor, igualdade);
    }

    public void remover(int posicao) {
        lista.remover(posicao);
    }

    public void removerReferencia(T referencia) {
        lista.removerReferencia(referencia);
    }

    public void removerValor(T valor, Igualdade<T> igualdade) {
        lista.removerValor(valor, igualdade);
    }

    public boolean existeValor(T valor, Igualdade<T> igualdade) {
        return lista.existeValor(valor, igualdade);
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public boolean estaCheia() {
        return tamanhoMaximo == lista.getQuantidade();
    }
}
