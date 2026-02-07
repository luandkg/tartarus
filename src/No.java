public class No<T> {

    private T valor;
    private No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

}
