package testes;

import estruturas.Texto;
import estruturas.fmt;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import tempo.Cronometro;

import java.util.Random;

@TesteClasseCalebe
public class TesteCronometro {

    @TesteCalebe
    public static void Cronometro(TestandoCalebe teste){
        Cronometro c = new Cronometro();

        teste.deveSerIgual(0,c.getIniciado(),"Cronometro -> Teste_1");
        teste.deveSerIgual(0,c.getFinalizado(),"Cronometro -> Teste_2");

        c.iniciar();
        gastarTempoAlgoComplexo(5);
        c.terminar();
        teste.deveSerVerdadeiro(c.getFinalizado()>c.getIniciado(),"Cronometro -> Teste_3");
        teste.deveSerVerdadeiro(Texto.terminaCom(c.toString(),"Milissegundos"),"Cronometro -> Teste_4");

        c.zerar();

        c.iniciar();
        gastarTempoAlgoComplexo(50);
        c.terminar();
        teste.deveSerVerdadeiro(c.getFinalizado()>c.getIniciado(),"Cronometro -> Teste_5");
        teste.deveSerVerdadeiro(Texto.terminaCom(c.toString(),"Segundos"),"Cronometro -> Teste_6");
    }

    public static void gastarTempoAlgoComplexo(int repetir) {


        for (int etapa = 1; etapa <= repetir; etapa++) {

            //fmt.println("\n\t ++ Etapa :: {} ", etapa);

            int contagem = 0;

            while (contagem < 5) {
                contagem += 1;
                int aguardar = new Random().nextInt(10,20);
                //fmt.println("\t----------- Aguardar T{} :: {} ms -------------", contagem, aguardar);
                try {
                    Thread.sleep(aguardar);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
