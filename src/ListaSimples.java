public class ListaSimples {

    private No inicio = null;
    private int tamanho = 0;

    public ListaSimples() {
        this.inicio = null;
    }

    public ListaSimples(int tamanho) {
        this.inicio = null;
        this.tamanho = tamanho;
    }

    public void inserirInicio(String info) {
        No no = new No();
        no.info = info;
        no.proximo = inicio;
        inicio = no;
        tamanho++;
    }

    public String retirarInicio() {
        if (inicio == null) {
            return null;
        }
        String info = inicio.info;
        inicio = inicio.proximo;
        tamanho--;
        return info;
    }

    public String toString() {
        String str = " ("+ tamanho+ ") ";
        No local = inicio;
        while (local != null) {
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
    }

    public int getQuantidade() {
        return tamanho;
    }
}
