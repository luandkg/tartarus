package testes;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.fmt;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

import java.awt.*;

import static main.Estrutura.verificaArquivo;

@TesteClasseCalebe
public class TesteEditorImagem {

    @TesteCalebe
    public static void Teste_Set_Cor(TestandoCalebe teste) {
        ImagemEditor imagemOriginal = new ImagemEditor(10,10);

        for (int i = 0; i < imagemOriginal.getLargura(); i++) {
            for (int j = 0; j < imagemOriginal.getAltura(); j++) {
                imagemOriginal.setPixel(i,j, Color.WHITE.getRGB());
            }
        }
        imagemOriginal.salvar("arquivosDeTestes/imagens/editorImagem/pintar.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/editorImagem/pintar.png"),"Teste_Set_Cor -> Teste_1");
    }

    @TesteCalebe
    public static void Teste_Pintar_Retangulo(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);

        imagem.pintarRetangulo(1,1,8,8, Color.WHITE.getRGB());

        imagem.salvar("arquivosDeTestes/imagens/editorImagem/pintarRetangulo1.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/editorImagem/pintarRetangulo1.png"),"Teste_Pintar_Retangulo -> Teste_1");

    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);

        imagem.desenharRetangulo(1,1,8,8, Color.WHITE.getRGB());

        imagem.salvar("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png"),"Teste_Desenhar_Retangulo -> Teste_1");

    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo_Com_Cor(TestandoCalebe teste) {
        ImagemEditor imagem = new ImagemEditor(10,10);
        Cor cor = new Cor(-12488223);
        //cor.exibeCores();

        imagem.desenharRetangulo(1,1,8,8, cor.getValor());

        imagem.salvar("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png"),"Teste_Desenhar_Retangulo_Com_Cor -> Teste_1");

    }

}

