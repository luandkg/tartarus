package main.app.editorImagem;

import main.libs.estruturas.fmt;

import java.awt.*;

public class AppEditorImagem {

    public static void executar() {

        fmt.println("----------------------------- EDITOR DE IMAGEM ---------------------------------");
        ImagemEditor imagem = new ImagemEditor(10,10);

        imagem.salvar("arquivos/imagens/img_1.png");

        imagem.setPixel(9,9, Color.WHITE.getRGB());

        imagem.salvar("arquivos/imagens/img_1.png");

        fmt.println("--------------------------------------------------------------------------------");
    }
}
