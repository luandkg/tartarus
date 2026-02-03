import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {

        // Calebe - vc deve implementar uma estrutura de dados lista
        // O nome da classe deve ser Lista
        // deve ter as funções getQuantidade() e adicionar()

        ListaSimples l =  new ListaSimples();
        System.out.println(l);
        l.inserirInicio("primeira");
        System.out.println(l);
        l.inserirInicio("segunda");
        System.out.println(l);
        l.inserirInicio("terceira");
        System.out.println(l);

        System.out.println("Tamanho : " + l.getQuantidade());

        while (l.retirarInicio() != null) {
            System.out.println(l);
        }

        System.out.println("Tamanho : " + l.getQuantidade());

    }
}