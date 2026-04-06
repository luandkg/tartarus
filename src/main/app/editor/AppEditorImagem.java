package main.app.editor;

import main.libs.estruturas.fmt;

public class AppEditorImagem {

    public static void executar() {

        fmt.println("----------------------------- EDITOR DE IMAGEM ---------------------------------");
        ImagemEditor imagem = new ImagemEditor(34, 34);
        Cor cor = new Cor(-12488223);
        cor.exibeCores();

        imagem.salvar("arquivos/imagens/img_1.png");

        imagem.desenharRetangulo(1, 1, 10, 10, cor.getValor());
        imagem.desenharRetangulo(23, 1, 32, 10, cor.getValor());
        imagem.desenharRetangulo(12, 12, 21, 22, cor.getValor());


        imagem.salvar("arquivos/imagens/img_1.png");

        fmt.println("--------------------------------------------------------------------------------");
    }
}
