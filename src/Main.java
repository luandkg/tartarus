import estruturas.Lista;
import libs.teste.TesteExecutor;
import testes.TesteLista;

public class Main {
    public static void main(String[] args) {

        // Calebe - vc deve implementar uma estrutura de dados lista
        // O nome da classe deve ser estruturas.Lista
        // deve ter as funções getQuantidade() e adicionar()

        // TesteLista.testar();

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);

        TesteExecutor.TESTAR(testarClasses);

    }
}