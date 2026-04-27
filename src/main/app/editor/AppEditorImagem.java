package main.app.editor;

import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.estruturas.fmt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppEditorImagem {

    public static void executar() {
        fmt.println("----------------------------- EDITOR DE IMAGEM ---------------------------------");
        ImagemEditor imagem1 = new ImagemEditor(34, 34);
        imagem1.salvar("arquivos/editorDeImagem/criadas/tipoPNG/blocoPreto.png");

        ImagemEditor clone1 = imagem1;
        Cor cor = new Cor(-12488223);
        clone1.desenharRetangulo(1, 1, 10, 10, cor.getValor());
        clone1.desenharRetangulo(23, 1, 32, 10, cor.getValor());
        clone1.desenharRetangulo(12, 12, 21, 22, cor.getValor());
        clone1.salvar("arquivos/editorDeImagem/clonadas/blocoPretoComQuadrados.png");

        String caminhoDados1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados.calebeImagem";
        CalebeImagem.gerarDados(clone1.getImagem(), caminhoDados1);

        boolean tudoOk = false;
        if (CalebeImagem.validadorVersao(caminhoDados1, "v1")) {

            ImagemEditor imagemDoTextoDoClone1 = new ImagemEditor(CalebeImagem.criarImagem(caminhoDados1));
            imagemDoTextoDoClone1.salvar("arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados.png");
            tudoOk = true;
        }
        boolean tudoOk2 = false;

        String caminhoGatinho = "arquivos/editorDeImagem/originais/gatinho.png";

        ImagemEditor imagemGatinho = new ImagemEditor(CalebeImagem.criarImagemPNG(caminhoGatinho));

        String caminhoDodosGatinho = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho.calebeImagem";
        CalebeImagem.gerarDados(imagemGatinho.getImagem(), caminhoDodosGatinho);

        if (CalebeImagem.validadorVersao(caminhoDodosGatinho, "v1")) {

            ImagemEditor gatinhoClone = new ImagemEditor(CalebeImagem.criarImagem(caminhoDodosGatinho));

            gatinhoClone.salvar("arquivos/editorDeImagem/clonadas/imagemDados-gatinho.png");
            tudoOk2 = true;
        }

        if (tudoOk && tudoOk2) {
            fmt.println("Imagens TUDOok!");
        }


        fmt.println("--------------------------------------------------------------------------------");
    }
}
