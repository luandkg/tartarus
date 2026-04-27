package testes;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

import java.awt.*;

import static main.Estrutura.verificaArquivo;
import static main.Estrutura.verificaPasta;

@TesteClasseCalebe
public class TesteCalebeImagem {

    @TesteCalebe
    public static void Teste_Set_Cor(TestandoCalebe teste) {
        ImagemEditor nImagem = new ImagemEditor(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/pintar.png"));
        CalebeImagem.gerarDados(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/pintar.png"),"arquivosDeTestes/imagens/calebeImagem/dados1-pintar.calebeImagem");

        for (int i = 0; i < nImagem.getLargura(); i++) {
            for (int j = 0; j < nImagem.getAltura(); j++) {
                nImagem.setPixel(i,j, Color.RED.getRGB());
            }
        }
        nImagem.salvar("arquivosDeTestes/imagens/calebeImagem/pintar.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/pintar.png"),"Teste_Set_Cor -> Teste_1");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/dados1-pintar.png"),"Teste_Set_Cor -> Teste_2");

    }

    @TesteCalebe
    public static void Teste_Pintar_Retangulo(TestandoCalebe teste) {
        ImagemEditor nImagem = new ImagemEditor(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/pintarRetangulo1.png"));
        CalebeImagem.gerarDados(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/pintarRetangulo1.png"),"arquivosDeTestes/imagens/calebeImagem/dados1-pintarRetangulo1.calebeImagem");

        nImagem.pintarRetangulo(1,1,8,8, Color.RED.getRGB());

        nImagem.salvar("arquivosDeTestes/imagens/calebeImagem/pintarRetangulo1.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/pintarRetangulo1.png"),"Teste_Pintar_Retangulo -> Teste_1");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/dados1-pintarRetangulo1.png"),"Teste_Pintar_Retangulo -> Teste_2");
    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo(TestandoCalebe teste) {
        ImagemEditor nImagem = new ImagemEditor(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png"));
        CalebeImagem.gerarDados(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png"),"arquivosDeTestes/imagens/calebeImagem/dados1-desenharRetanguloColorido1.calebeImagem");

        nImagem.desenharRetangulo(1,1,8,8, Color.RED.getRGB());

        nImagem.salvar("arquivosDeTestes/imagens/calebeImagem/desenharRetanguloColorido1.png");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/desenharRetanguloColorido1.png"),"Teste_Desenhar_Retangulo -> Teste_1");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/dados1-desenharRetanguloColorido1.png"),"Teste_Desenhar_Retangulo -> Teste_2");
    }

    @TesteCalebe
    public static void Teste_Desenhar_Retangulo_Com_Cor(TestandoCalebe teste) {
        ImagemEditor nImagem = new ImagemEditor(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/editorImagem/desenharRetanguloColorido1.png"));

        Cor cor = new Cor(-50000);
        //cor.exibeCores();

        nImagem.desenharRetangulo(1,1,8,8, cor.getValor());

        nImagem.salvar("arquivosDeTestes/imagens/calebeImagem/desenharRetanguloColorido2.png");
        CalebeImagem.gerarDados(CalebeImagem.criarImagemPNG("arquivosDeTestes/imagens/calebeImagem/desenharRetanguloColorido2.png"),"arquivosDeTestes/imagens/calebeImagem/dados2-desenharRetanguloColorido2.calebeImagem");

        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/desenharRetanguloColorido2.png"),"Teste_Desenhar_Retangulo_Com_Cor -> Teste_1");
        teste.deveSerVerdadeiro(verificaArquivo("arquivosDeTestes/imagens/calebeImagem/dados2-desenharRetanguloColorido2.png"),"Teste_Desenhar_Retangulo_Com_Cor -> Teste_2");
    }
}
