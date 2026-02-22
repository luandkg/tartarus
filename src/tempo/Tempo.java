package tempo;

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
}
