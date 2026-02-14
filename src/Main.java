import auxiliar.StringIgualdade;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import libs.teste.TesteExecutor;
import testes.TesteCaixa;
import testes.TesteLista;
import testes.TesteTexto;
import utils.Igualdade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);

        TesteExecutor.TESTAR(testarClasses);
    }
}