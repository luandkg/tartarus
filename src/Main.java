import teste.TesteLista;

public class Main {
    public static void main(String[] args) {

        // Calebe - vc deve implementar uma estrutura de dados lista
        // O nome da classe deve ser Lista
        // deve ter as funções getQuantidade() e adicionar()


        Lista l =  new Lista();
        confirmaLista(l,0);

        l.adicionar("primeira");
        confirmaLista(l,1);
        l.adicionar("segunda");
        confirmaLista(l,2);
        l.adicionar("terceira");
        confirmaLista(l,3);
        System.out.println("Tamanho : " + l.getQuantidade()+ "\n");

        System.out.println("------------------Lista Ligada Simples------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            String valor = l.get(i);
            System.out.println("Indice: "+ i + " | Valor: " + valor);
        }
        System.out.println("--------------------------------------------------------");
        //TesteLista.testar();
    }

    public static  void confirmaLista(Lista l, int valor){
        if(l.getQuantidade()==valor){
            System.out.println("A lista esta OK");
        }else{
            System.out.println("A Lista esta corrompida!");
        }
    }


}