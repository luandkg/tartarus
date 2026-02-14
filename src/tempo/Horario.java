package tempo;

public class Horario {

    private int horas;
    private int minutos;
    private int segundos;


    public Horario(int hora, int minuto, int segundo) {
        this.horas = hora;
        this.minutos = minuto;
        this.segundos = segundo;

        if (!validar()) {
            throw new RuntimeException("Erro: Horario invalido!");
        }
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void set(int hora, int minuto, int segundo) {
        this.horas = hora;
        this.minutos = minuto;
        this.segundos = segundo;

        if (!validar()) {
            throw new RuntimeException("Erro: Horario invalido!");
        }
    }

    public void setHoras(int horas) {
        this.horas = horas;
        if (!validar()) {
            throw new RuntimeException("Erro: Horario com hora invalida!");
        }
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
        if (!validar()) {
            throw new RuntimeException("Erro: Horario com minutos invalido!");
        }
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
        if (!validar()) {
            throw new RuntimeException("Erro: Horario com segundos invalido!");
        }
    }

    public boolean validar() {
        if (horas < 0 || horas > 23) {
            return false;
        }
        if (minutos < 0 || minutos > 60) {
            return false;
        }
        if (segundos < 0 || segundos > 60) {
            return false;
        }
        return true;
    }

    public String toString() {
        String sHora = String.valueOf(horas);
        String sMinuto = String.valueOf(horas);
        String sSegundo = String.valueOf(horas);


        if (sHora.length() == 1) {
            sHora = "0" + sHora;
        }
        if (sMinuto.length() == 1) {
            sMinuto = "0" + sMinuto;
        }
        if (sSegundo.length() == 1) {
            sSegundo = "0" + sSegundo;
        }

        return sHora + ":" + sMinuto + ":" + sSegundo;
    }

    public long getTotalEmSegundos() {
        return (horas * (60L * 60L)) + (minutos * 60L) + segundos;
    }

    public static boolean igual(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() == h2.getTotalEmSegundos();
    }

    public static boolean diferente(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() != h2.getTotalEmSegundos();

    }

    public static boolean maior(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() > h2.getTotalEmSegundos();

    }

    public static boolean menor(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() < h2.getTotalEmSegundos();

    }

    public static boolean maiorOuIgual(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() >= h2.getTotalEmSegundos();

    }

    public static boolean menorOuIgual(Horario h1, Horario h2) {
        return h1.getTotalEmSegundos() <= h2.getTotalEmSegundos();

    }
}
