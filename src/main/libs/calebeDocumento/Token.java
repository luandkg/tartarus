package main.libs.calebeDocumento;

public class Token {

    private TokenTipo tipo;
    private String valor;


    public Token(TokenTipo tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TokenTipo getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }
}
