package tempo;

public enum DiaDaSemana {

    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    private final int diaDaSemana;

    DiaDaSemana(int diaDaSemana) {

        this.diaDaSemana = diaDaSemana;
    }

    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    public String diaSimples() {
        return switch (diaDaSemana) {
            case (1) -> "Domingo";
            case (2) -> "Segunda";
            case (3) -> "Terca";
            case (4) -> "Quarta";
            case (5) -> "Quinta";
            case (6) -> "Sexta";
            case (7) -> "Sabado";
            default -> null;
        };
    }

    public String diaComposto() {
        return switch (diaDaSemana) {
            case (1) -> "Domingo";
            case (2) -> "Segunda-Feira";
            case (3) -> "Terca-Feira";
            case (4) -> "Quarta-Feira";
            case (5) -> "Quinta-Feira";
            case (6) -> "Sexta-Feira";
            case (7) -> "Sabado";
            default -> null;
        };
    }


    public String diaEmSigla() {
        return switch (diaDaSemana) {
            case (1) -> "Dom";
            case (2) -> "Seg";
            case (3) -> "Ter";
            case (4) -> "Qua";
            case (5) -> "Qui";
            case (6) -> "Sex";
            case (7) -> "Sab";
            default -> null;
        };
    }
}


