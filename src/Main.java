import estruturas.Lista;
import estruturas.fmt;
import libs.teste.TesteExecutor;
import tempo.Horario;
import tempo.Tempo;
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
        testarClasses.adicionar(TesteCronometro.class);


        //TesteExecutor.TESTAR(testarClasses);

        TesteExecutor.TESTAR_UNICO(TesteCronometro.class);

    }
}