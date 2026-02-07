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

    public void remover(int posicao) {
        int posicaoCorrente = 0;
        No<T> noCorrente = inicio;
        No<T> noAnterior = null;
        while (posicaoCorrente < quantidade) {
            if (posicaoCorrente == posicao) {
                if (noCorrente == inicio && noCorrente == fim) {
                    inicio = null;
                    fim = null;
                    quantidade--;
                    System.out.println("Removeu pq so tem um elemento!");
                    break;
                } else if (noCorrente == inicio) {
                    inicio = noCorrente.getProximo();
                    quantidade--;
                    System.out.println("Removeu o primeiro elemento!");
                    break;
                } else if (noCorrente == fim) {
                    if (noAnterior != null) {
                        noAnterior.setProximo(null);
                        fim = noAnterior;
                    }
                    quantidade--;
                    System.out.println("Removeu o ultimo elemento!");
                    break;
                } else {
                    if (noAnterior != null) {
                        noAnterior.setProximo(noCorrente.getProximo());
                    }
                    quantidade--;
                    System.out.println("Removeu o elemento que esta entre o meio!");
                    break;
                }

            }
            noAnterior = noCorrente;
            posicaoCorrente++;
            noCorrente = noCorrente.getProximo();
        }
    }
}
