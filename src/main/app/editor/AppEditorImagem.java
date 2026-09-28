package main.app.editor;

import main.libs.arquivo.calebeImagem.CalebeImagem;
import main.libs.arquivo.calebeImagem.Formato;
import main.libs.estruturas.FS;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

import java.awt.image.BufferedImage;

import static main.libs.arquivo.calebeImagem.Formato.V1;
import static main.libs.arquivo.calebeImagem.Formato.V2;


public class AppEditorImagem {


    public static Lista<String> getPastas() {
        Lista<String> pastas = new Lista<String>();
        pastas.adicionar("arquivos/editorDeImagem/clonadas");
        pastas.adicionar("arquivos/editorDeImagem/criadas/tipoCalebeImagem");
        pastas.adicionar("arquivos/editorDeImagem/criadas/tipoPNG");

        return pastas;
    }

    public static void limpar(Lista<String> pastas) {
        int contador1 = 0;
        int contador2 = 0;
        for (String pasta : pastas) {
            contador1++;
            fmt.println("Inicio da pasta (" + contador1 + "): " + pasta + "\n");

            for (String arquivo : FS.listarArquivos(pasta)) {
                contador2++;
                fmt.println("Arquivo " + contador2 + ": " + arquivo);
                FS.deletar(arquivo);
            }

            fmt.println("Fim da pasta: " + contador1 + "\n");
            contador2 = 0;
        }

        fmt.println("Pasta limpa com sucesso!");
        /*if(pastas.estaVazia()){
            fmt.println("Pasta limpa com sucesso!");
        }else{
            throw new RuntimeException("Erro: A pasta foi corrompida ou ainda existem arquivos!");
        }*/
    }

    public static void executar() {

        limpar(getPastas());
        //testandoV1();
        //testandoV2();
        //testandoV3();
        //testandoV4();
        testandoV5();
    }

    public static ImagemEditor criaImagemGrande() {
        ImagemEditor imagem = new ImagemEditor(100, 100);
        imagem.salvar("arquivos/editorDeImagem/criadas/tipoPNG/imagemCriada.png");

        Cor cor = new Cor(0, 0, 0, 255);

        imagem.desenharRetangulo(0, 0, 99, 99, new Cor(255, 255, 255, 255).getValor());

        imagem.desenharRetangulo(5, 5, 15, 15, cor.getValor());
        imagem.desenharRetangulo(23, 5, 32, 15, cor.getValor());
        imagem.desenharRetangulo(12, 20, 21, 30, cor.getValor());

        imagem.desenharRetangulo(5, 35, 15, 45, cor.getValor());
        imagem.desenharRetangulo(23, 35, 32, 45, cor.getValor());

        imagem.pintarRetangulo(30, 20, 5, 10, new Cor(0, 255, 255, 0).getValor());
        imagem.pintarRetangulo(40, 20, 5, 10, new Cor(0, 255, 0, 0).getValor());


        imagem.pintarRetangulo(10, 70, 10, 10, new Cor(0, 76, 175, 80).getValor());
        imagem.pintarRetangulo(30, 70, 10, 10, new Cor(0, 253, 216, 53).getValor());
        imagem.pintarRetangulo(50, 70, 10, 10, new Cor(0, 244, 81, 30).getValor());
        imagem.pintarRetangulo(70, 70, 10, 10, new Cor(0, 142, 36, 170).getValor());

        imagem.pintarRetangulo(10, 85, 10, 10, new Cor(0, 66, 165, 245).getValor());
        imagem.pintarRetangulo(30, 85, 10, 10, new Cor(0, 0, 121, 107).getValor());
        imagem.pintarRetangulo(50, 85, 10, 10, new Cor(0, 224, 64, 251).getValor());
        imagem.pintarRetangulo(70, 85, 10, 10, new Cor(0, 238, 238, 238).getValor());


        imagem.pintarRetangulo(0, 55, 100, 2, new Cor(0, 0, 0, 255).getValor());
        imagem.pintarRetangulo(0, 60, 100, 2, new Cor(0, 255, 0, 0).getValor());
        imagem.pintarRetangulo(50, 65, 50, 2, new Cor(0, 100, 50, 200).getValor());
        imagem.pintarRetangulo(0, 65, 50, 2, new Cor(0, 0, 0, 200).getValor());

        imagem.salvar("arquivos/editorDeImagem/clonadas/imagemCriadaEditada.png");

        return imagem;
    }


    public static ImagemEditor criaImagemPequena() {
        ImagemEditor imagem = new ImagemEditor(5, 5);
        imagem.salvar("arquivos/editorDeImagem/criadas/tipoPNG/imagemCriada.png");

        Cor cor = new Cor(0, 0, 0, 255);

        imagem.desenharRetangulo(0, 0, 4, 4, new Cor(255, 255, 255, 255).getValor());



        imagem.salvar("arquivos/editorDeImagem/clonadas/imagemCriadaEditada.png");

        return imagem;
    }

    public static String caminhoOriginais(String nome) {
        return "arquivos/editorDeImagem/originais/" + nome + ".png";
    }

    public static String caminhoDados(String nome, Formato versao) {
        return "arquivos/editorDeImagem/criadas/tipoCalebeImagem/" + nome + "_" + versao + ".calebeImagem";
    }

    public static String caminhoClone(String nome, Formato versao) {
        return "arquivos/editorDeImagem/clonadas/" + nome + "_" + versao + ".png";
    }

    public static void gerarDadosApartirDeImagemExemplo(String caminhoDados, Formato versao) {
        BufferedImage imagem = criaImagemGrande().getImagem();
        fmt.println(">> Gerando dados :: " + caminhoDados);

        CalebeImagem.salvar(imagem, caminhoDados, versao);
    }

    public static void salvarFormatoCalebeImagem(BufferedImage imagem, String caminhoDados, Formato versao) {
        fmt.println(">> Salvando arquivo no formato CalebeImagem :: " + caminhoDados);

        CalebeImagem.salvar(imagem, caminhoDados, versao);
    }

    public static boolean validarClonarDadosParaImagem(String caminhoDados, Formato versao, String nomeClone) {
        String caminhoClone = caminhoClone(nomeClone, versao);
        fmt.println(">> Clonando dados :: " + caminhoDados + " e gerendo imagem :: " + caminhoClone);

        if (validaVersao(caminhoDados, versao, caminhoClone)) {
            fmt.println("Clone :: " + caminhoClone + " gerada com sucesso");
            return true;
        } else {
            throw new RuntimeException("Erro: Dados da imagem na versão :: " + versao + " (" + caminhoDados + ")  estao corrompidos!");
        }
    }


    public static boolean publicarVersao(Formato versao) {

        String caminhoDados1 = caminhoDados("dados_imagemCriada", versao);
        gerarDadosApartirDeImagemExemplo(caminhoDados1, versao);
        boolean parte_a_status = validarClonarDadosParaImagem(caminhoDados1, versao, "imagemCloneDados_imagemCriada");

        String caminhoGatinho = caminhoOriginais("gatinho");

        String caminhoDadosGatinho = caminhoDados("dados_gatinho", versao);
        ImagemEditor imagemGatinho = new ImagemEditor(Imagem.criarImagemPNG(caminhoGatinho));
        salvarFormatoCalebeImagem(imagemGatinho.getImagem(), caminhoDadosGatinho, versao);

        boolean parte_b_status = validarClonarDadosParaImagem(caminhoDadosGatinho, versao, "imagemCloneDados_gatinho");

        return parte_a_status && parte_b_status;

    }

    public static void testandoV1() {
        fmt.println("------------------------------------------------- Testando V1 -------------------------------------------------");

        boolean statusV1 = publicarVersao(V1);

        fmt.println("#################");

        if (statusV1) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("------------------------------------------------- Concluido V1 -------------------------------------------------");

    }


    public static void testandoV2() {
        fmt.println("------------------------------------------------- Testando V2 -------------------------------------------------");

        boolean statusV1 = publicarVersao(V1);
        boolean statusV2 = publicarVersao(V2);

        if (statusV1 && statusV2) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("------------------------------------------------- Concluido V2 -------------------------------------------------");
    }

    public static void testandoV3() {
        fmt.println("------------------------------------------------- Testando V3 -------------------------------------------------");

        boolean statusV1 = publicarVersao(V1);
        boolean statusV2 = publicarVersao(V2);
        boolean statusV3 = publicarVersao(Formato.V3);

        if (statusV1 && statusV2 && statusV3) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("------------------------------------------------- Concluido V3 -------------------------------------------------");

    }

    public static void testandoV4() {
        fmt.println("------------------------------------------------- Testando V4 -------------------------------------------------");

        boolean statusV1 = publicarVersao(V1);
        boolean statusV2 = publicarVersao(V2);
        boolean statusV3 = publicarVersao(Formato.V3);
        boolean statusV4 = publicarVersao(Formato.V4);

        if (statusV1 && statusV2 && statusV3 && statusV4) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("------------------------------------------------- Concluido V4 -------------------------------------------------");

    }

    public static void testandoV5() {
        fmt.println("------------------------------------------------- Testando V5 -------------------------------------------------");

        boolean statusV1 = publicarVersao(V1);
        boolean statusV2 = publicarVersao(V2);
        boolean statusV3 = publicarVersao(Formato.V3);
        boolean statusV4 = publicarVersao(Formato.V4);
        boolean statusV5 = publicarVersao(Formato.V5);

        if (statusV1 && statusV2 && statusV3 && statusV4 && statusV5) {
            fmt.println("Imagens TUDO OK !");
        }
        fmt.println("------------------------------------------------- Concluido V5 -------------------------------------------------");

    }

    public static boolean validaVersao(String caminhoDados, Formato versao, String caminhoImagem) {
        if (CalebeImagem.validarVersao(caminhoDados, versao.toString().toLowerCase())) {
            clonarImagemDeDados(caminhoDados, caminhoImagem);
            return true;
        }
        return false;
    }

    public static void clonarImagemDeDados(String caminhoEntrada, String caminhoDestino) {
        ImagemEditor imagemDoTextoDoClone = new ImagemEditor(CalebeImagem.ler(caminhoEntrada));
        imagemDoTextoDoClone.salvar(caminhoDestino);
    }

    public static void testandoComparador() {

        Cor cor = new Cor(0, 0, 0, 255);
        ImagemEditor imagem = new ImagemEditor(34, 34);
        imagem.desenharRetangulo(1, 1, 10, 10, cor.getValor());
        imagem.desenharRetangulo(23, 1, 32, 10, cor.getValor());
        imagem.desenharRetangulo(12, 12, 21, 22, cor.getValor());


        String caminhoDados1 = caminhoDados("dados_imagemCriada", V1);
        String caminhoDados2 = caminhoDados("dados_imagemCriada", V2);

        CalebeImagem.salvar(imagem.getImagem(), caminhoDados1, V1);
        CalebeImagem.salvar(imagem.getImagem(), caminhoDados2, V2);

        compararVersoes(caminhoDados1, caminhoDados2);

    }

    public static void compararVersoes(String caminhoDados1, String caminhoDados2) {
        String conteudo1 = Texto.ler(caminhoDados1);
        String conteudo2 = Texto.ler(caminhoDados2);

        fmt.println("\nO arquivo (" + caminhoDados1 + ") possui tamanho: " + conteudo1.length());
        fmt.println("O arquivo (" + caminhoDados2 + ") possui tamanho: " + conteudo2.length());

        if (conteudo1.length() < conteudo2.length()) {
            fmt.println("\nSendo assim O arquivo (" + caminhoDados1 + ") possui " + (conteudo2.length() - conteudo1.length()) + " dados a menos que o arquivo (" + caminhoDados2 + ") !");
        } else {
            fmt.println("\nSendo assim O arquivo (" + caminhoDados2 + ") possui " + (conteudo1.length() - conteudo2.length()) + " dados a menos que o arquivo (" + caminhoDados1 + ") !");
        }
    }
}
