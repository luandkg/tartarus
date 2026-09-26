package main.app.ordenar;

public record Pessoa(String nome, int idade) {
    public static Comparador<Pessoa> compararIdadeMaior() {
        return new Comparador<Pessoa>() {
            @Override
            public boolean compare(Pessoa p1, Pessoa p2) {
                return p1.idade() > p2.idade();
            }
        };
    }

    public static Comparador<Pessoa> compararIdadeMenor() {
        return new Comparador<Pessoa>() {
            @Override
            public boolean compare(Pessoa p1, Pessoa p2) {
                return p1.idade() < p2.idade();
            }
        };
    }
}
