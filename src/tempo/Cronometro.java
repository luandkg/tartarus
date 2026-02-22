package tempo;

import estruturas.Lista;
import estruturas.fmt;

import java.util.Random;

public class Cronometro {

    private long iniciado;
    private long finalizado;

    public Cronometro() {
        this.iniciado = 0;
        this.finalizado = 0;
    }

    public long getIniciado() {
        return iniciado;
    }

    public long getFinalizado() {
        return finalizado;
    }

    public long getDuracaoNano() {
        return finalizado - iniciado;
    }

    public long getDuracaoMili() {
        return getDuracaoNano() / 1000000;
    }

    public long getDuracaoSegundos() {
        return getDuracaoMili() / 1000;
    }

    public long getDuracaoMinutos() {
        return getDuracaoSegundos() / 60;
    }

    public long getDuracaoHoras() {
        return getDuracaoMinutos() / 60;
    }

    public void iniciar() {
        this.iniciado = System.nanoTime();
    }

    public void terminar() {
        this.finalizado = System.nanoTime();
    }

    public void zerar() {
        this.iniciado = 0;
        this.finalizado = 0;
    }

    public String toString() {
        long dNano = getDuracaoNano() % 1000000;
        long dMili = getDuracaoMili() % 1000;
        long dSegundo = getDuracaoSegundos() % 60;
        long dMinuto = getDuracaoMinutos() % 60;
        long dHora = getDuracaoHoras();

        fmt.formatar("Tempo em Nanossegundo : {}", dNano);
        fmt.formatar("Tempo em Milissegundo : {}", dMili);
        fmt.formatar("Tempo em Segundo : {}", dSegundo);
        fmt.formatar("Tempo em Minuto : {}", dMinuto);
        fmt.formatar("Tempo em Hora : {}", dHora);

        if(dHora>0){
            return fmt.formatar("Tempo : {}:{}:{}:{}:{} Horas", dHora, dMinuto, dSegundo, dMili, dNano);
        }else if(dMinuto>0){
            return fmt.formatar("Tempo : {}:{}:{}:{} Minutos",  dMinuto, dSegundo, dMili, dNano);
        }else if(dSegundo>0){
            return fmt.formatar("Tempo : {}:{}:{} Segundos", dSegundo, dMili, dNano);
        }else if(dMili>0){
            return fmt.formatar("Tempo : {}:{} Mili Segundos", dMili, dNano);
        }else {
            return fmt.formatar("Tempo : {} Nano Segundos", dNano);
        }
    }

    public void gastarTempoAlgoComplexo(int repetir) {


        for (int etapa = 0; etapa < repetir; etapa++) {

            fmt.println("\n\t ++ Etapa :: {} ", etapa);

            int contagem = 0;

            while (contagem < 5) {
                contagem += 1;
                int aguardar = new Random().nextInt(30);
                fmt.println("\t----------- Aguardar T{} :: {} ms -------------", contagem, aguardar);
                try {
                    Thread.sleep(aguardar);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}
