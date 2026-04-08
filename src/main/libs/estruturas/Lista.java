package main.libs.estruturas;

import main.libs.utils.Condicional;
import main.libs.utils.CondicionalParametrizado;
import main.libs.utils.Igualdade;

import java.util.Iterator;

public class Lista<T> implements Iterable<T> {

    private No<T> inicio;
    private No<T> fim;
    private int quantidade;

    public Lista() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
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

    public void inserirAntes(int posicao, T valor) {
        if (posicao < 0 || posicao > quantidade) {
            throw new RuntimeException("Erro: Posicao nao encontrada!");
        }

        No<T> novoNO = new No<T>(valor);

        if (estaVazia()) {
            inicio = novoNO;
            fim = novoNO;
            quantidade++;
        } else {
            int posicaoCorrente = 0;
            No<T> noAnterior = null;
            No<T> noCorrente = inicio;

            while (posicaoCorrente < quantidade) {
                if (posicaoCorrente == posicao) {
                    break;
                }
                noAnterior = noCorrente;
                noCorrente = noCorrente.getProximo();
                posicaoCorrente++;
            }
            condicaoParaAdicionarAntes(noAnterior, novoNO, noCorrente);
        }
    }

    public void inserirDepois(int posicao, T valor) {
        if (posicao < 0 || posicao > quantidade) {
            throw new RuntimeException("Erro: Posicao nao encontrada!");
        }

        No<T> novoNO = new No<T>(valor);

        if (estaVazia()) {
            inicio = novoNO;
            fim = novoNO;
            quantidade++;
        } else {
            int posicaoCorrente = 0;
            No<T> noCorrente = inicio;

            while (posicaoCorrente < quantidade) {
                if (posicaoCorrente == posicao) {
                    break;
                }
                noCorrente = noCorrente.getProximo();
                posicaoCorrente++;
            }
            condicaoParaAdicionarDepois(noCorrente, novoNO);
        }
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
        throw new RuntimeException("Erro: Posicao nao encontrada!");
    }

    public void set(int posicao, T valor) {
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

    private boolean condicaoParaAdicionarAntes(No<T> noAnterior, No<T> novoNO, No<T> noCorrente) {
        boolean tudoOK = false;
        if (noAnterior == null) {
            novoNO.setProximo(inicio);
            inicio = novoNO;

        } else {
            noAnterior.setProximo(novoNO);
            novoNO.setProximo(noCorrente);
            if (noCorrente == null) {
                fim = novoNO;
            }
        }
        quantidade++;
        return tudoOK;
    }

    private boolean condicaoParaAdicionarDepois(No<T> noCorrente, No<T> novoNO) {
        boolean tudoOK = false;

        if (noCorrente != null) {
            novoNO.setProximo(noCorrente.getProximo());
            noCorrente.setProximo(novoNO);
            if (noCorrente == fim) {
                fim = novoNO;
            }
            quantidade++;
            tudoOK = true;
        }
        return tudoOK;
    }

    private boolean condicaoParaRemover(No<T> noCorrente, No<T> noAnterior) {
        boolean tudoOK = false;

        if (noCorrente == inicio && noCorrente == fim) {
            inicio = null;
            fim = null;
            quantidade--;
            tudoOK = true;
        } else if (noCorrente == inicio) {
            inicio = noCorrente.getProximo();
            quantidade--;
            tudoOK = true;
        } else if (noCorrente == fim) {
            if (noAnterior != null) {
                noAnterior.setProximo(null);
                fim = noAnterior;
            }
            quantidade--;
            tudoOK = true;
        } else {
            if (noAnterior != null) {
                noAnterior.setProximo(noCorrente.getProximo());
            }
            quantidade--;
            tudoOK = true;
        }
        return tudoOK;
    }


    public void remover(int posicao) {
        if (posicao < 0 || posicao >= quantidade) { // Verificação antecipada
            throw new RuntimeException("Erro: Posicao invalida!");
        }

        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (posicaoCorrente == posicao) {
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        condicaoParaRemover(noCorrente, noAnterior);
    }

    public void removerReferencia(T referencia) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (noCorrente.getValor() == referencia) {
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
        if(posicaoCorrente<quantidade){
            condicaoParaRemover(noCorrente, noAnterior);
        }else{
            throw new RuntimeException("Erro: Item nao encontrado!");
        }
    }

    public void removerValor(T valor, Igualdade<T> igualdade) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (igualdade.igual(noCorrente.getValor(), valor)) {
                break;
            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }

        if(posicaoCorrente<quantidade){
            condicaoParaRemover(noCorrente, noAnterior);
        }else{
            throw new RuntimeException("Erro: Item nao encontrado!");
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
        while (posicaoCorrente < quantidade) {
            if (igualdade.igual(noCorrente.getValor(), valor)) {
                contValor++;
            }
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
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T valor = noCorrente.getValor();
                noCorrente = noCorrente.getProximo();
                posicaoCorrente++;
                return valor;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public Lista<ItemComPosicao<T>> getItensComPosicao() {
        Lista<ItemComPosicao<T>> lista = new Lista<ItemComPosicao<T>>();
        int cont = 0;

        for (T item : this) {
            lista.adicionar(new ItemComPosicao<>(item, cont));
            cont++;
        }

        return lista;
    }

    public Lista<T> filtrar(Condicional<T> condicao, T valor) {
        Lista<T> lista = new Lista<>();

        for (T item : this) {
            if (condicao.condicao(item, valor)) {
                lista.adicionar(item);
            }
        }

        return lista;
    }


    public <T2> Lista<T> filtrar(CondicionalParametrizado<T, T2> condicao) {
        Lista<T> lista = new Lista<>();

        for (T item : this) {
            if (condicao.condicao(item)) {
                lista.adicionar(item);
            }
        }

        return lista;
    }

    public Lista<T> clonar() {
        Lista<T> clone = new Lista<>();

        for (T item : this) {
            clone.adicionar(item);
        }
        return clone;
    }

    public void limpar() {
        inicio = null;
        fim = null;
        quantidade = 0;
    }

    public void exibirLista() {
        if (!estaVazia()) {
            int posicaoCorrente = 0;
            No<T> noCorrente = inicio;
            while (posicaoCorrente < quantidade) {
                fmt.println("Item {}: {}", posicaoCorrente, noCorrente.getValor());

                posicaoCorrente++;
                noCorrente = noCorrente.getProximo();
            }
        }
    }
}
