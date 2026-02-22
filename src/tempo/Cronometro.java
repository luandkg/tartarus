package tempo;

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
      return Tempo.formatarNanossegundos(getDuracaoNano());
    }

}
