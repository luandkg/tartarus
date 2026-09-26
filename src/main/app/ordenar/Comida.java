package main.app.ordenar;

public record Comida (String nome, float peso){

    public static Comparador<Comida> compararPesoMaior() {
        return new Comparador<Comida>() {
            @Override
            public boolean compare(Comida c1, Comida c2) {
                return c1.peso() > c2.peso();
            }
        };
    }

    public static Comparador<Comida> compararPesoMenor() {
        return new Comparador<Comida>() {
            @Override
            public boolean compare(Comida c1, Comida c2) {
                return c1.peso() < c2.peso();
            }
        };
    }
}
