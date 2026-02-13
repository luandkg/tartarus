package estruturas;

public class ItemComPosicao<T> {

    private T item;
    private int posicao;

    public ItemComPosicao(T item, int posicao) {
        this.item = item;
        this.posicao = posicao;
    }

    public T getItem() {
        return item;
    }

    public int getPosicao() {
        return posicao;
    }


}
