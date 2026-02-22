package tempo;

import estruturas.fmt;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tempo {

    public static Data getDataHoje() {
        Calendar hoje = new GregorianCalendar();
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int mes = hoje.get(Calendar.MONTH) + 1;
        // meses começam em 0 → janeiro=0
        int ano = hoje.get(Calendar.YEAR);

        return new Data(dia, mes, ano);
    }

    public static Horario getHorarioAgora() {
        Calendar agora = new GregorianCalendar();
        int hora = agora.get(Calendar.HOUR_OF_DAY); // 0–23
        int minuto = agora.get(Calendar.MINUTE);
        int segundo = agora.get(Calendar.SECOND);

        return new Horario(hora, minuto, segundo);
    }

    public static long getDiasEntre(Data d1, Data d2) {
        // Lembre-se: meses começam em 0 → janeiro=0, fevereiro=1
        Calendar data1 = new GregorianCalendar(d1.getAno(), d1.getMes() - 1, d1.getDia());
        Calendar data2 = new GregorianCalendar(d2.getAno(), d2.getMes() - 1, d2.getDia());
        // Obter diferença em milissegundos
        long millis1 = data1.getTimeInMillis();
        long millis2 = data2.getTimeInMillis();
        long diffMillis = millis2 - millis1;
        // Converter para dias
        long dias = diffMillis / (24 * 60 * 60 * 1000);

        return dias;
    }

    public static long getSegundosEntre(Horario h1, Horario h2) {
        long s1 = h1.getTotalEmSegundos();
        long s2 = h2.getTotalEmSegundos();

        return s2 - s1;
    }

    public static long getMinutosEntre(Horario h1, Horario h2) {
        return getSegundosEntre(h1,h2)/(60);
    }

    public static long getHorasEntre(Horario h1, Horario h2) {

        return getSegundosEntre(h1,h2)/3600;

    }


    public static String formatarNanossegundos(long dNano){
        long dMili = dNano / 1_000_000;
        long dSegundo = dMili / 1000;
        long dMinuto =dSegundo/ 60;
        long dHora = dMinuto/60;

        if(dHora>23){
            dHora = dHora % 24;
        }
        if(dMinuto>60){
            dMinuto = dMinuto % 60;
        }
        if(dSegundo>60){
            dSegundo = dSegundo % 60;
        }
        if(dMili>1000){
            dMili = dMili % 1000;
        }
        if(dNano>1000000){
            dNano= dNano % 1000000;
        }

        /*
        fmt.formatar("Tempo em Nanossegundo : {}", dNano);
        fmt.formatar("Tempo em Milissegundo : {}", dMili);
        fmt.formatar("Tempo em Segundo : {}", dSegundo);
        fmt.formatar("Tempo em Minuto : {}", dMinuto);
        fmt.formatar("Tempo em Hora : {}", dHora);
        */

        if(dHora>0){

            return fmt.formatar("{}:{}:{}:{}:{} Horas", dHora, dMinuto, dSegundo, dMili, dNano);
        }else if(dMinuto>0){
            return fmt.formatar("{}:{}:{}:{} Minutos",  dMinuto, dSegundo, dMili, dNano);
        }else if(dSegundo>0){
            return fmt.formatar("{}:{}:{} Segundos", dSegundo, dMili, dNano);
        }else if(dMili>0){
            return fmt.formatar("{}:{} Milissegundos", dMili, dNano);
        }else {
            return fmt.formatar("{} Nanossegundos", dNano);
        }

    }
}
