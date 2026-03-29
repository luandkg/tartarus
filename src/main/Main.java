package main;

import main.app.futebol.Futebol;
import main.libs.estruturas.Lista;
import main.libs.teste.TesteExecutor;
import testes.*;


public class Main {

    public static void main(String[] args) {

        if (args.length > 0) {
            String comando = args[0];
            switch (comando) {
                case "-testes":
                    System.out.println("Executando bateria de testes...");
                    executarTestes();
                    break;
                case "-futebol":
                    System.out.println("Carregando dados de futebol...");
                    executarFutebol();
                    break;
                default:
                    System.out.println("Comando desconhecido: " + comando);
            }
        } else {
            System.out.println("Nenhum comando enviado.");
        }
    }

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

        TesteExecutor.TESTAR(testarClasses);

        //TesteExecutor.TESTAR_UNICO(TesteCronometro.class);
    }

    public static void executarFutebol() {
        Futebol jogo = new Futebol();
        jogo.executar();
    }
}