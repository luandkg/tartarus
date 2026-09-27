package main.app.editor;

import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.arquivo.calebeImagem.Formato;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

public class AppEditorImagem {

    public static void executar() {
        //testandoV1();
        //testandoV2();
        testandoV3();
    }

    public static ImagemEditor criaImagem(){
        ImagemEditor imagem = new ImagemEditor(100, 100);
        imagem.salvar("arquivos/editorDeImagem/criadas/tipoPNG/blocoPreto.png");

        Cor cor = new Cor(-12488223);

        imagem.desenharRetangulo(0, 0, 99, 99, new Cor(255,255,255,255).getValor());

        imagem.desenharRetangulo(5, 5, 15, 15, cor.getValor());
        imagem.desenharRetangulo(23, 5, 32, 15, cor.getValor());
        imagem.desenharRetangulo(12, 20, 21, 30, cor.getValor());

        imagem.desenharRetangulo(5, 35, 15, 45, cor.getValor());
        imagem.desenharRetangulo(23, 35, 32, 45, cor.getValor());

        imagem.pintarRetangulo(30, 20, 5, 10, new Cor(0,255,255,0).getValor());
        imagem.pintarRetangulo(40, 20, 5, 10, new Cor(0,255,0,0).getValor());

        imagem.pintarRetangulo(10, 70, 10, 10, new Cor(0,255,255,0).getValor());
        imagem.pintarRetangulo(30, 70, 10, 10, new Cor(0,100,200,50).getValor());
        imagem.pintarRetangulo(50, 70, 10, 10, new Cor(0,150,200,150).getValor());
        imagem.pintarRetangulo(70, 70, 10, 10, new Cor(0,200,150,0).getValor());

        imagem.pintarRetangulo(10, 85, 10, 10, new Cor(0,0,255,0).getValor());
        imagem.pintarRetangulo(30, 85, 10, 10, new Cor(0,100,50,20).getValor());
        imagem.pintarRetangulo(50, 85, 10, 10, new Cor(0,150,190,0).getValor());
        imagem.pintarRetangulo(70, 85, 10, 10, new Cor(0,255,0,0).getValor());

        imagem.pintarRetangulo(0, 55, 100, 2, new Cor(0,0,0,255).getValor());

        imagem.pintarRetangulo(0, 60, 100, 2, new Cor(0,255,0,0).getValor());

        imagem.pintarRetangulo(50, 65, 50, 2, new Cor(0,100,50,200).getValor());
        imagem.pintarRetangulo(0, 65, 50, 2, new Cor(0,0,0,200).getValor());

        imagem.salvar("arquivos/editorDeImagem/clonadas/blocoPretoComQuadrados.png");

        return imagem;
    }
    public static void testandoV1(){
        fmt.println("------------------------------------------------- EDITOR DE IMAGEM -------------------------------------------------");
        boolean parte_a_status = false;
        boolean parte_b_status = false;

        String caminhoDados1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V1.calebeImagem";
        fmt.println(">> Salvando imagem :: " + caminhoDados1);

        CalebeImagem.gerarDadosV1(criaImagem().getImagem(), caminhoDados1);

        if (validaVersao(caminhoDados1, "v1", "arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados-v1.png")){
            parte_b_status = true;
        }

        String caminhoGatinho = "arquivos/editorDeImagem/originais/gatinho.png";

        ImagemEditor imagemGatinho = new ImagemEditor(Imagem.criarImagemPNG(caminhoGatinho));

        String caminhoDodosGatinho1 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho-v1.calebeImagem";

        CalebeImagem.gerarDadosV1(imagemGatinho.getImagem(), caminhoDodosGatinho1);

        fmt.println(">> Salvando imagem :: "+caminhoDodosGatinho1);

        if (validaVersao(caminhoDodosGatinho1, "v1", "arquivos/editorDeImagem/clonadas/imagemDados-gatinho-v1.png")){
            parte_b_status = true;
        }


        fmt.println("");
        if (parte_a_status && parte_b_status) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public static void testandoV2(){
        fmt.println("------------------------------------------------- EDITOR DE IMAGEM -------------------------------------------------");
        boolean parte_a_status = false;
        boolean parte_b_status = false;

        String caminhoDados2 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V2.calebeImagem";
        fmt.println(">> Salvando imagem :: " + caminhoDados2);

        CalebeImagem.gerarDadosV2(criaImagem().getImagem(), caminhoDados2);

        if (validaVersao(caminhoDados2, "v2", "arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados-v2.png")){
            parte_a_status = true;
        }

        String caminhoGatinho = "arquivos/editorDeImagem/originais/gatinho.png";

        ImagemEditor imagemGatinho = new ImagemEditor(Imagem.criarImagemPNG(caminhoGatinho));

        String caminhoDodosGatinho2 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho-v2.calebeImagem";

        CalebeImagem.gerarDadosV2(imagemGatinho.getImagem(), caminhoDodosGatinho2);

        fmt.println(">> Salvando imagem :: "+caminhoDodosGatinho2);

        if (validaVersao(caminhoDodosGatinho2, "v2", "arquivos/editorDeImagem/clonadas/imagemDados-gatinho-v2.png")){
            parte_b_status = true;
        }

        fmt.println("");
        if (parte_a_status && parte_b_status) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public static void testandoV3(){
        fmt.println("------------------------------------------------- EDITOR DE IMAGEM -------------------------------------------------");
        boolean parte_a_status = false;
        boolean parte_b_status = false;

        String caminhoDados3 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_blocoPretoComQuadrados-V3.calebeImagem";
        fmt.println(">> Salvando imagem :: " + caminhoDados3);

        CalebeImagem.gerarDadosV3(criaImagem().getImagem(), caminhoDados3);

        if (validaVersao(caminhoDados3, "v3", "arquivos/editorDeImagem/clonadas/imagemDados-blocoComQuadrados-v3.png")){
            parte_a_status = true;
        }


        String caminhoGatinho = "arquivos/editorDeImagem/originais/gatinho.png";

        ImagemEditor imagemGatinho = new ImagemEditor(Imagem.criarImagemPNG(caminhoGatinho));

        String caminhoDodosGatinho3 = "arquivos/editorDeImagem/criadas/tipoCalebeImagem/dados_gatinho-v3.calebeImagem";

        CalebeImagem.gerarDadosV3(imagemGatinho.getImagem(), caminhoDodosGatinho3);

        fmt.println(">> Salvando imagem :: "+caminhoDodosGatinho3);

        if (validaVersao(caminhoDodosGatinho3, "v3", "arquivos/editorDeImagem/clonadas/imagemDados-gatinho-v3.png")){
            parte_b_status = true;
        }

        fmt.println("");
        if (parte_a_status && parte_b_status) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public static boolean validaVersao(String caminhoDados, String versao, String arquivo){
        if (CalebeImagem.validarVersao(caminhoDados, versao)) {

            ImagemEditor imagemDoTextoDoClone = new ImagemEditor(CalebeImagem.criarImagem(caminhoDados));
            imagemDoTextoDoClone.salvar(arquivo);
            return true;
        }
        return false;
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
