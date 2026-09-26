package main.app.editor;

import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.arquivo.calebeImagem.Formato;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

public class AppEditorImagem {

    public static void executar() {

        fmt.println("------------------------------------------------- EDITOR DE IMAGEM -------------------------------------------------");
        ImagemEditor imagem1 = new ImagemEditor(34, 34);
        imagem1.salvar("arquivos/editorDeImagem/criadas/tipoPNG/blocoPreto.png");

        ImagemEditor clone1 = imagem1;
        Cor cor = new Cor(-12488223);
        clone1.desenharRetangulo(1, 1, 10, 10, cor.getValor());
        clone1.desenharRetangulo(23, 1, 32, 10, cor.getValor());
        clone1.desenharRetangulo(12, 12, 21, 22, cor.getValor());
        clone1.salvar("arquivos/editorDeImagem/clonadas/blocoPretoComQuadrados.png");

        String caminhoDados1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V1.calebeImagem";
        String caminhoDados2 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V2.calebeImagem";
        fmt.println(">> Salvando imagem :: " + caminhoDados1);
        fmt.println(">> Salvando imagem :: " + caminhoDados2);

        CalebeImagem.gerarDadosV1(clone1.getImagem(), caminhoDados1);
        CalebeImagem.gerarDadosV2(clone1.getImagem(), caminhoDados2);

        boolean parte_a_status = false;
        if (CalebeImagem.validarVersao(caminhoDados1, "v1")) {

            ImagemEditor imagemDoTextoDoClone1 = new ImagemEditor(CalebeImagem.criarImagemV1(caminhoDados1));
            imagemDoTextoDoClone1.salvar("arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados-v1.png");
            parte_a_status = true;
        }
        if (CalebeImagem.validarVersao(caminhoDados2, "v2")) {

            ImagemEditor imagemDoTextoDoClone2 = new ImagemEditor(CalebeImagem.criarImagemV2(caminhoDados2));
            imagemDoTextoDoClone2.salvar("arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados-v2.png");
            parte_a_status = true;
        }


        boolean parte_b_status = false;

        String caminhoGatinho = "arquivos/editorDeImagem/originais/gatinho.png";

        ImagemEditor imagemGatinho = new ImagemEditor(Imagem.criarImagemPNG(caminhoGatinho));

        String caminhoDodosGatinho1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho-v1.calebeImagem";
        String caminhoDodosGatinho2 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho-v2.calebeImagem";

        CalebeImagem.gerarDadosV1(imagemGatinho.getImagem(), caminhoDodosGatinho1);
        CalebeImagem.gerarDadosV2(imagemGatinho.getImagem(), caminhoDodosGatinho2);

        fmt.println(">> Salvando imagem :: "+caminhoDodosGatinho1);
        fmt.println(">> Salvando imagem :: "+caminhoDodosGatinho2);

        compararVersoes(caminhoDodosGatinho1, caminhoDodosGatinho2);

        if (CalebeImagem.validarVersao(caminhoDodosGatinho1, "v1")) {

            ImagemEditor gatinhoClone1 = new ImagemEditor(CalebeImagem.criarImagem(caminhoDodosGatinho1));

            gatinhoClone1.salvar("arquivos/editorDeImagem/clonadas/imagemDados-gatinho-v1.png");
            parte_b_status = true;
        }
        if (CalebeImagem.validarVersao(caminhoDodosGatinho2, "v2")) {

            ImagemEditor gatinhoClone2 = new ImagemEditor(CalebeImagem.criarImagem(caminhoDodosGatinho2));

            gatinhoClone2.salvar("arquivos/editorDeImagem/clonadas/imagemDados-gatinho-v2.png");
            parte_b_status = true;
        }



        fmt.println("");
        if (parte_a_status && parte_b_status) {
            fmt.println("Imagens TUDO OK !");
        }


        fmt.println("-------------------------------------------------------------------------------------------------------------------");

    }


    public static void testandoComparador() {

        Cor cor = new Cor(-12488223);
        ImagemEditor imagem = new ImagemEditor(34, 34);
        imagem.desenharRetangulo(1, 1, 10, 10, cor.getValor());
        imagem.desenharRetangulo(23, 1, 32, 10, cor.getValor());
        imagem.desenharRetangulo(12, 12, 21, 22, cor.getValor());


        String caminhoDados1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V1.calebeImagem";
        String caminhoDados2 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V2.calebeImagem";
        fmt.println(">> Salvando imagem :: " + caminhoDados1);
        fmt.println(">> Salvando imagem :: " + caminhoDados2);

        CalebeImagem.gerarDados(imagem.getImagem(), caminhoDados1, Formato.V1);
        CalebeImagem.gerarDados(imagem.getImagem(), caminhoDados2, Formato.V2);

        compararVersoes(caminhoDados1, caminhoDados2);

    }

    public static void compararVersoes(String caminhoDados1, String caminhoDados2) {
        String conteudo1 = Texto.ler(caminhoDados1);
        String conteudo2 = Texto.ler(caminhoDados2);

        fmt.println("\nO arquivo (" + caminhoDados1 + ") possui tamanho: " + conteudo1.length());
        fmt.println("O arquivo (" + caminhoDados2 + ") possui tamanho: " + conteudo2.length());

        if (conteudo1.length() < conteudo2.length()) {
            fmt.println("\nSendo assim O arquivo (" + caminhoDados1 + ") possui " + (conteudo2.length() - conteudo1.length()) + " dados a menos que o arquivo (" + caminhoDados2 + ") !");
        }else{
            fmt.println("\nSendo assim O arquivo (" + caminhoDados2 + ") possui " + (conteudo1.length() - conteudo2.length()) + " dados a menos que o arquivo (" + caminhoDados1 + ") !");
        }
    }
}
