import estruturas.fmt;
import estruturas.Lista;
import libs.teste.TesteExecutor;
import testes.*;


public class Main {

    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);
        testarClasses.adicionar(TesteIO.class);
        testarClasses.adicionar(TesteHorario.class);
        testarClasses.adicionar(TesteData.class);
        testarClasses.adicionar(TesteInteiros.class);
        testarClasses.adicionar(TesteFMT.class);
        testarClasses.adicionar(TesteTempo.class);


        //TesteExecutor.TESTAR(testarClasses);

        TesteExecutor.TESTAR_UNICO(TesteTempo.class);


    }

}