package main.app.editor;

import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.estruturas.fmt;

import java.awt.image.BufferedImage;

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
        String arquivo1 = "arquivos/imagens/img_1.imagem";
        CalebeImagem.salvar(imagem.getImagem(), arquivo1);
        boolean tudoOk = false;
        if (CalebeImagem.validadorVersao(arquivo1, "v1")) {
            BufferedImage imagemTexto = CalebeImagem.abrir(arquivo1);
            ImagemEditor imagem2 = new ImagemEditor(imagemTexto);
            imagem2.salvar("arquivos/imagens/img_2.png");
            tudoOk = true;
        }
        boolean tudoOk2 = false;

        BufferedImage imagemTexto3 = CalebeImagem.abrirPNG("arquivos/imagens/imagem.png");
        String arquivo2 = "arquivos/imagens/imagem2.imagem";
        if (CalebeImagem.validadorVersao(arquivo2, "v1")) {
            ImagemEditor imagem3 = new ImagemEditor(imagemTexto3);
            CalebeImagem.salvar(imagem3.getImagem(), arquivo2);

            BufferedImage imagemTexto2 = CalebeImagem.abrir(arquivo2);

            ImagemEditor imagem22 = new ImagemEditor(imagemTexto2);
            imagem22.salvar("arquivos/imagens/imagem2v.png");
            tudoOk2 = true;
        }

        if (tudoOk && tudoOk2) {
            fmt.println("Imagens TUDOok!");
        }


        fmt.println("--------------------------------------------------------------------------------");
    }
}
