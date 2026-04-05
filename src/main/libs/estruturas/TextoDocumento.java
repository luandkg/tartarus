package main.libs.estruturas;

public class TextoDocumento {
    private String texto;

    public TextoDocumento() {
        this.texto = "";
    }

    public void adicionar(String texto) {
        this.texto += texto;
    }

    public void adicionarLinha(String texto) {
        this.texto += texto + "\n";
    }
    
    public String toString() {
        return texto;
    }

}
