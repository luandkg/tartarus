package testes;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.fmt;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

import java.awt.*;

@TesteClasseCalebe
public class TesteEditorImagem {

    @TesteCalebe
    public static void Teste_Set_Cor(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);

        //imagem.salvar("arquivos/imagens/img_1.png");

        imagem.setPixel(9,9, Color.WHITE.getRGB());

        //imagem.salvar("arquivos/imagens/img_1.png");
    }

    @TesteCalebe
    public static void Teste_Pintar_Retangulo(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);

        //imagem.salvar("arquivos/imagens/img_1.png");

        imagem.pintarRetangulo(1,1,8,8, Color.WHITE.getRGB());

        //imagem.salvar("arquivos/imagens/img_1.png");
    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);

        //imagem.salvar("arquivos/imagens/img_1.png");

        imagem.desenharRetangulo(1,1,8,8, Color.WHITE.getRGB());

        //imagem.salvar("arquivos/imagens/img_1.png");
    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo_Com_Cor(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);
        Cor cor = new Cor(-12488223);
        cor.exibeCores();

        //imagem.salvar("arquivos/imagens/img_1.png");

        imagem.desenharRetangulo(1,1,8,8, cor.getValor());

        //imagem.salvar("arquivos/imagens/img_1.png");
    }

}

