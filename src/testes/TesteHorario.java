package testes;

import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import tempo.Horario;

@TesteClasseCalebe
public class TesteHorario {

    @TesteCalebe
    public static void Horario_valido(TestandoCalebe teste){
        Horario hora1 = new Horario(23,60,60);

        teste.deveSerVerdadeiro(hora1.validar(),"Horario_valido -> Teste_1");
    }

    @TesteCalebe
    public static void Horario_invalido(TestandoCalebe teste){
        try{
            Horario hora1 = new Horario(60,1,1);
            teste.falhar(" -> Teste_1");
        }catch (Exception e){
            teste.deveSerIgual("Erro: Horario invalido!",e.getMessage(),"Horario_invalido -> Teste_2");
        }
    }

    @TesteCalebe
    public static void Horario_igual(TestandoCalebe teste){
        Horario hora1 = new Horario(23,60,60);


        Horario hora2 = new Horario(23,60,60);


        teste.deveSerVerdadeiro(Horario.igual(hora1,hora2),"Horario_igual -> Teste_1");

    }

    @TesteCalebe
    public static void Horario_diferente(TestandoCalebe teste){
        Horario hora1 = new Horario(23,60,60);


        Horario hora2 = new Horario(15,2,2);

        teste.deveSerVerdadeiro(Horario.diferente(hora1,hora2),"Horario_diferente -> Teste_1");

    }



    @TesteCalebe
    public static void Horario_maior(TestandoCalebe teste){
        Horario hora1 = new Horario(23,60,60);


        Horario hora2 = new Horario(15,2,2);

        teste.deveSerVerdadeiro(Horario.maior(hora1,hora2),"Horario_maior -> Teste_1");

    }

    @TesteCalebe
    public static void Horario_menor(TestandoCalebe teste){
        Horario hora1 = new Horario(1,1,1);


        Horario hora2 = new Horario(15,2,2);

        teste.deveSerVerdadeiro(Horario.menor(hora1,hora2),"Horario_menor -> Teste_1");

    }
    @TesteCalebe
    public static void Horario_maior_ou_igual(TestandoCalebe teste){
        Horario hora1 = new Horario(23,60,60);


        Horario hora2 = new Horario(23,60,60);


        Horario hora3 = new Horario(15,2,2);

        teste.deveSerVerdadeiro(Horario.igual(hora1,hora2),"Horario_maior_ou_igual -> Teste_1");
        teste.deveSerVerdadeiro(Horario.maior(hora1,hora3),"Horario_maior_ou_igual -> Teste_2");

        teste.deveSerVerdadeiro(Horario.maiorOuIgual(hora1,hora3),"Horario_maior_ou_igual -> Teste_3");

    }
    @TesteCalebe
    public static void Horario_menor_ou_igual(TestandoCalebe teste){
        Horario hora1 = new Horario(1,1,1);

        Horario hora2 = new Horario(1,1,1);

        Horario hora3 = new Horario(15,2,2);

        teste.deveSerVerdadeiro(Horario.igual(hora1,hora2),"Horario_menor_ou_igual -> Teste_1");
        teste.deveSerVerdadeiro(Horario.menor(hora1,hora3),"Horario_menor_ou_igual -> Teste_2");

        teste.deveSerVerdadeiro(Horario.menorOuIgual(hora1,hora3),"Horario_menor_ou_igual -> Teste_3");

    }


}
