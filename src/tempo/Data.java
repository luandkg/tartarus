package tempo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private int dia;
    private int mes;
    private int ano;


    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (!validar()) {
            throw new RuntimeException("Erro: Data invalida!");
        }
    }

    public int getDia() {
        return dia;
    }

    public DiaDaSemana getDiaDaSemana(){
        // Atenção: fevereiro = 1 (porque janeiro = 0)
        Calendar calendario = new GregorianCalendar(ano, mes-1, dia);

        // Obter o dia da semana (1 = Domingo, 2 = Segunda, ..., 7 = Sábado)
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        return switch (diaSemana) {
            case 1 -> DiaDaSemana.DOMINGO;
            case 2 -> DiaDaSemana.SEGUNDA;
            case 3 -> DiaDaSemana.TERCA;
            case 4 -> DiaDaSemana.QUARTA;
            case 5 -> DiaDaSemana.QUINTA;
            case 6 -> DiaDaSemana.SEXTA;
            case 7 -> DiaDaSemana.SABADO;
            default -> null;
        };

    }

    public int getMes() {
        return mes;
    }

    public Mes getMesEnum() {
        return switch (mes) {
            case 1 -> Mes.JANEIRO;
            case 2 -> Mes.FEVEREIRO;
            case 3 -> Mes.MARCO;
            case 4 -> Mes.ABRIL;
            case 5 -> Mes.MAIO;
            case 6 -> Mes.JUNHO;
            case 7 -> Mes.JULHO;
            case 8 -> Mes.AGOSTO;
            case 9 -> Mes.SETEMBRO;
            case 10 -> Mes.OUTUBRO;
            case 11 -> Mes.NOVEMBRO;
            case 12 -> Mes.DEZEMBRO;
            default -> null;
        };
    }

    public int getAno() {
        return ano;
    }

    public void set(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (!validar()) {
            throw new RuntimeException("Erro: Data invalida!");
        }
    }

    public void setDia(int dia) {
        this.dia = dia;
        if (!validar()) {
            throw new RuntimeException("Erro: Data com dia invalido!");
        }
    }

    public void setMes(int mes) {
        this.mes = mes;
        if (!validar()) {
            throw new RuntimeException("Erro: Data com mes invalido!");
        }
    }

    public void setMes(Mes mes) {
        this.mes = mes.getMes();
        if (!validar()) {
            throw new RuntimeException("Erro: Data com mes invalido!");
        }
    }

    public void setAno(int ano) {
        this.ano = ano;
        if (!validar()) {
            throw new RuntimeException("Erro: Data com ano invalido!");
        }
    }

    public boolean validar() {
        if (dia < 1 || dia > 365) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (ano < 1) {
            return false;
        }
        return true;
    }

    public String toString() {
        String sDia = String.valueOf(dia);
        String sMes = String.valueOf(mes);
        String sAno = String.valueOf(ano);


        if (sDia.length() == 1) {
            sDia = "0" + sDia;
        }

        if (sMes.length() == 1) {
            sMes = "0" + sMes;
        }

        if (sAno.length() == 1) {
            sAno = "000" + sAno;
        } else if (sAno.length() == 2) {
            sAno = "00" + sAno;
        } else if (sAno.length() == 3) {
            sAno = "0" + sAno;
        }

        return sDia + "/" + sMes + "/" + sAno;
    }

    public String toStringReduzado() {
        String sDia = String.valueOf(dia);
        String sMes = String.valueOf(mes);
        String sAno = String.valueOf(ano);

        if (sAno.length() == 1) {
            sAno = "000" + sAno;
        } else if (sAno.length() == 2) {
            sAno = "00" + sAno;
        } else if (sAno.length() == 3) {
            sAno = "0" + sAno;
        }

        return sDia + "/" + sMes + "/" + sAno;
    }


    public long getTotalEmDias() {
        return (ano * (365L)) + (mes * 31L) + dia;
    }

    public static boolean igual(Data d1, Data d2) {
        return d1.getTotalEmDias() == d2.getTotalEmDias();
    }

    public static boolean diferente(Data d1, Data d2) {
        return d1.getTotalEmDias() != d2.getTotalEmDias();

    }

    public static boolean maior(Data d1, Data d2) {
        return d1.getTotalEmDias() > d2.getTotalEmDias();

    }

    public static boolean menor(Data d1, Data d2) {
        return d1.getTotalEmDias() < d2.getTotalEmDias();

    }

    public static boolean maiorOuIgual(Data d1, Data d2) {
        return d1.getTotalEmDias() >= d2.getTotalEmDias();

    }

    public static boolean menorOuIgual(Data d1, Data d2) {
        return d1.getTotalEmDias() <= d2.getTotalEmDias();

    }
}

