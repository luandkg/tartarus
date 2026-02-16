import estruturas.Inteiros;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TesteExecutor;
import testes.*;
import utils.Condicional;
import utils.CondicionalParametrizado;
import utils.Ferramenta;


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

        //TesteExecutor.TESTAR(testarClasses);

        //TesteExecutor.TESTAR_UNICO(TesteLista.class);


    }

}