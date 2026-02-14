import auxiliar.Jogador;
import auxiliar.JogadorSerializavel;
import auxiliar.StringIgualdade;
import estruturas.IO;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TesteExecutor;
import tempo.Horario;
import testes.*;
import utils.Igualdade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);
        testarClasses.adicionar(TesteIO.class);
        testarClasses.adicionar(TesteHorario.class);


        TesteExecutor.TESTAR(testarClasses);

        Horario hora1 = new Horario(23,60,60);


        Horario hora2 = new Horario(15,2,2);

        System.out.println(Horario.maiorOuIgual(hora1,hora2));;

        System.out.println(hora1.getTotalEmSegundos());
        System.out.println(hora2.getTotalEmSegundos());


    }
}