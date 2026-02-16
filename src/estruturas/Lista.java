package estruturas;

import utils.Condicional;
import utils.CondicionalParametrizado;
import utils.Ferramenta;
import utils.Igualdade;

import java.util.Iterator;

public class Lista<T> implements Iterable<T>{

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

    public void set( int posicao, T valor) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        while (posicaoCorrente < quantidade) {
            if (posicaoCorrente == posicao) {
                noCorrente.setValor(valor);
                return;
            }
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        throw new RuntimeException("Erro: Posicao nao encontrada!");
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
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

    public boolean existeValor(T valor, Igualdade<T> igualdade) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (igualdade.igual(noCorrente.getValor(), valor)) {
                return true;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        return false;
    }

    public int contarValor(T valor, Igualdade<T> igualdade) {
        int contValor = 0;
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (igualdade.igual(noCorrente.getValor(), valor)) {
                contValor++;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        return contValor;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            int posicaoCorrente = 0;
            No<T> noCorrente = inicio;


            @Override
            public boolean hasNext() {
                return posicaoCorrente < quantidade;
            }

            @Override
            public T next() {
                No<T> noTemporario = noCorrente;
                noCorrente = noCorrente.getProximo();
                posicaoCorrente++;
                return noTemporario.getValor();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public Lista<ItemComPosicao<T>> getItensComPosicao(){
        Lista<ItemComPosicao<T>>  lista = new Lista<ItemComPosicao<T>>();
        int cont = 0;

        for(T item : this){
            lista.adicionar(new ItemComPosicao<>(item,cont));
            cont++;
        }

        return lista;
    }

    public Lista<T> filtrar(Condicional<T> condicao, T valor){
        Lista<T> lista = new Lista<>();

        for (T item : this){
            if(condicao.condicao(item,valor)){
                lista.adicionar(item);
            }
        }

        return lista;
    }


    public <T2> Lista<T> filtrar(CondicionalParametrizado<T,T2> condicao){
        Lista<T> lista = new Lista<>();

        for (T item : this){
            if(condicao.condicao(item)){
                lista.adicionar(item);
            }
        }

        return lista;
    }

}
