import estruturas.ItemComPosicao;
import estruturas.Lista;
import libs.teste.TesteExecutor;
import testes.TesteCaixa;
import testes.TesteLista;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);

        TesteExecutor.TESTAR(testarClasses);

    }
}