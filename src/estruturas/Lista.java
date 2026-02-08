package estruturas;

import utils.Igualdade;

public class Lista<T> {

    private No<T> inicio = null;
    private No<T> fim = null;
    private int quantidade = 0;

    public Lista() {
        this.inicio = null;
    }

    public void adicionar(T valor) {
        No<T> no = new No<T>(valor);

        if (inicio == null) {
            inicio = no;
            fim = no;
        } else {
            fim.setProximo(no);
            fim = no;
        }

        quantidade++;
    }

    public T get(int posicao) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        while (posicaoCorrente < quantidade) {
            if (posicaoCorrente == posicao) {
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

    private void condicaoParaRemover(No<T> noCorrente, No<T> noAnterior) {
        if (noCorrente == inicio && noCorrente == fim) {
            inicio = null;
            fim = null;
            quantidade--;
        } else if (noCorrente == inicio) {
            inicio = noCorrente.getProximo();
            quantidade--;
        } else if (noCorrente == fim) {
            if (noAnterior != null) {
                noAnterior.setProximo(null);
                fim = noAnterior;
            }
            quantidade--;
        } else {
            if (noAnterior != null) {
                noAnterior.setProximo(noCorrente.getProximo());
            }
            quantidade--;
        }
    }
    public void remover(int posicao) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (posicaoCorrente == posicao) {
                condicaoParaRemover(noCorrente, noAnterior);
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
    }

    public void removerReferencia(T referencia) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (noCorrente.getValor() == referencia) {
                condicaoParaRemover(noCorrente, noAnterior);
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
    }

    public void removerValor(T valor, Igualdade<T> igualdade) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (igualdade.igual(noCorrente.getValor(), valor)) {
                condicaoParaRemover(noCorrente, noAnterior);
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
    }
}
