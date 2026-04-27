package main.app.teste;

import main.libs.estruturas.Lista;
import main.libs.teste.TesteExecutor;
import testes.*;

public class AppTeste {

    public static void executarTestes() {
        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);
        testarClasses.adicionar(TesteDados.class);
        testarClasses.adicionar(TesteHorario.class);
        testarClasses.adicionar(TesteData.class);
        testarClasses.adicionar(TesteInteiros.class);
        testarClasses.adicionar(TesteFMT.class);
        testarClasses.adicionar(TesteTempo.class);
        testarClasses.adicionar(TesteCronometro.class);
        testarClasses.adicionar(TesteTalvez.class);
        testarClasses.adicionar(TesteCalebeDocumento.class);
        testarClasses.adicionar(TesteEditorImagem.class);
        testarClasses.adicionar(TesteCalebeImagem.class);
        testarClasses.adicionar(TestePilha.class);
        testarClasses.adicionar(TesteFila.class);

        TesteExecutor.TESTAR(testarClasses);

        //TesteExecutor.TESTAR_UNICO(TesteCronometro.class);
    }
}
