package main;

import main.app.Futebol;
import main.libs.estruturas.Lista;
import testes.*;



public class Main {

    public static void main(String[] args) {

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


        //TesteExecutor.TESTAR(testarClasses);

        //TesteExecutor.TESTAR_UNICO(TesteCronometro.class);

        Futebol jogo = new Futebol();
        jogo.executar();

    }
}