public class Main {
    public static void main(String[] args) {

        // Calebe - vc deve implementar uma estrutura de dados lista
        // O nome da classe deve ser Lista
        // deve ter as funções getQuantidade() e adicionar()


        Lista<String> l =  new Lista<String>();
        confirmaLista(l,0);

        l.adicionar("primeira");
        confirmaLista(l,1);
        l.adicionar("segunda");
        confirmaLista(l,2);
        l.adicionar("terceira");
        confirmaLista(l,3);
        printListaString(l);

        System.out.println("NOVA----------Remove o primeiro");
        l.remover(0);
        printListaString(l);

        System.out.println("NOVA----------Adiciona um depois Remove o ultimo");
        l.adicionar("quarta");
        confirmaLista(l,3);
        printListaString(l);
        l.remover(2);
        printListaString(l);


        System.out.println("NOVA----------Adiciona um depois Remove o do meio");
        l.adicionar("quinta");
        confirmaLista(l,3);
        printListaString(l);
        l.remover(1);
        printListaString(l);

        //TesteLista.testar();



    }

    public static  void confirmaLista(Lista l, int valor){
        if(l.getQuantidade()==valor){
            System.out.println("A lista esta OK");
        }else{
            System.out.println("A Lista esta corrompida!");
        }
    }

    public static  void printListaString(Lista<String> l){
        System.out.println("------------------Lista Ligada Simples------------------");
        for (int i = 0; i < l.getQuantidade(); i++) {
            String valor = l.get(i);
            System.out.println("Indice: "+ i + " | Valor: " + valor);
        }
        System.out.println("--------------------------------------------------------");
    }


}