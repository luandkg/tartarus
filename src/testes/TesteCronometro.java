package testes;

import estruturas.fmt;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import tempo.Cronometro;

@TesteClasseCalebe
public class TesteCronometro {

    @TesteCalebe
    public static void Cronometro(TestandoCalebe teste){
        Cronometro c = new Cronometro();

        c.iniciar();

        c.gastarTempoAlgoComplexo(5);

        c.terminar();

        //fmt.println("Duracao Direta   : {}", c.getDuracaoNano());
        //fmt.println("Duracao toString : {}", c.toString());

        c.zerar();

        teste.deveSerIgual("1","1","Cronometro -> Teste_1");
    }
}
