package testes;

import estruturas.fmt;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import tempo.Data;
import tempo.Horario;
import tempo.Tempo;

@TesteClasseCalebe
public class TesteTempo {

    @TesteCalebe
    public static void Tempo_dia_hoje(TestandoCalebe teste){
        Data hoje = Tempo.getDataHoje();
        String sHoje = hoje.toString();
        fmt.println(sHoje);

    }

    @TesteCalebe
    public static void Tempo_hora_agora(TestandoCalebe teste){
        Horario hora = Tempo.getHorarioAgora();
        String sHora = hora.toString();

        fmt.println(sHora);
    }

    @TesteCalebe
    public static void Tempo_dia_entre(TestandoCalebe teste){
        Data d1 = new Data(17,2,2026);
        Data d2 = new Data(21,2,2026);

        teste.deveSerIgual(4,Tempo.getDiasEntre(d1,d2),"Tempo_dia_entre -> Teste_1");

    }

    @TesteCalebe
    public static void Tempo_horas_entre(TestandoCalebe teste){

        Horario h1 = new Horario(1,0,0);
        Horario h2 = new Horario(2,0,0);

        long horas = (Tempo.getHorasEntre(h1,h2));
        teste.deveSerIgual(1,horas,"Tempo_hora_entre -> Teste_1");

    }

    @TesteCalebe
    public static void Tempo_minutos_entre(TestandoCalebe teste){

        Horario h1 = new Horario(1,0,0);
        Horario h2 = new Horario(2,0,0);

        long minutos = (Tempo.getMinutosEntre(h1,h2));
        teste.deveSerIgual(60,minutos,"Tempo_minutos_entre -> Teste_1");

    }

    @TesteCalebe
    public static void Tempo_segundos_entre(TestandoCalebe teste){

        Horario h1 = new Horario(1,0,0);
        Horario h2 = new Horario(2,0,0);

        long segundos = (Tempo.getSegundosEntre(h1,h2));
        teste.deveSerIgual(3600,segundos,"Tempo_segundos_entre -> Teste_1");

    }
}
