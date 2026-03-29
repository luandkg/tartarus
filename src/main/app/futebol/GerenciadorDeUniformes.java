package main.app.futebol;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.utils.Talvez;

public class GerenciadorDeUniformes {

    private FutebolDados futebolDados;

    public GerenciadorDeUniformes(FutebolDados futebolDados) {
        this.futebolDados = futebolDados;
    }

    public Lista<Uniforme> getUniforme() {
        return futebolDados.getUniformes();
    }

    public void salvar() {
        futebolDados.salvar();
    }

    public void criar(Uniforme uniforme) {
        this.futebolDados.getUniformes().adicionar(uniforme);
        salvar();
    }

    public boolean remover(String nome) {
        for (Uniforme uniforme : futebolDados.getUniformes()) {
            if (Texto.igual(uniforme.getNome(), nome)) {
                futebolDados.getUniformes().removerReferencia(uniforme);
                salvar();
                return true;
            }
        }
        return false;
    }

    public Lista<Uniforme> listar() {
        return futebolDados.getUniformes();
    }

    public Talvez<Uniforme> obter(int uniformeID) {
        for (Uniforme uniforme : futebolDados.getUniformes()) {
            if (uniforme.getId() == uniformeID) {
                return Talvez.TALVEZ(uniforme);
            }
        }
        return Talvez.NADA();
    }

    public Talvez<Uniforme> obterPorNome(String nome) {
        for (Uniforme uniforme : futebolDados.getUniformes()) {
            if (Texto.igual(uniforme.getNome() , nome)) {
                return Talvez.TALVEZ(uniforme);
            }
        }
        return Talvez.NADA();
    }

    public boolean existe(String nome) {
        for (Uniforme uniforme : futebolDados.getUniformes()) {
            if (Texto.igual(nome, uniforme.getNome())) {
                return true;
            }
        }
        return false;
    }
}
