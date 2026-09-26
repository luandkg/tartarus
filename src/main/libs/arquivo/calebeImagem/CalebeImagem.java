package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

import java.awt.image.BufferedImage;

public class CalebeImagem {

    public static BufferedImage criarImagem(String arquivo) {
        String dados = Texto.ler(arquivo);
        String versao = "";

        Lista<String> linhas = Texto.dividirLinhas(dados);

        ImagemEditor editor = new ImagemEditor(1, 1);
        int Y = 0;
        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "!")) {
                Lista<String> imagem = Texto.dividirPorSimbolo(linha, ' ');
                imagem.exibirLista();
                versao = imagem.get(1);
                Lista<String> tamanhos = Texto.dividirPorSimbolo(imagem.get(imagem.getQuantidade() - 1), 'x');
                tamanhos.exibirLista();
                editor = new ImagemEditor(Integer.parseInt(tamanhos.get(0)), Integer.parseInt(tamanhos.get(1)));
                break;
            }
        }

        if (Texto.igual("v1", versao)) {
            CalebeImagemV1.lerImagemV1(linhas, editor);
        } else if (Texto.igual("v2", versao)) {
            CalebeImagemV2.lerImagemV2(linhas, editor);
        }


        return editor.getImagem();
    }

    public static BufferedImage criarImagemV1(String arquivo) {
        String dados = Texto.ler(arquivo);
        String versao = "";

        Lista<String> linhas = Texto.dividirLinhas(dados);

        ImagemEditor editor = new ImagemEditor(1, 1);
        int Y = 0;
        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "!")) {
                Lista<String> imagem = Texto.dividirPorSimbolo(linha, ' ');
                imagem.exibirLista();
                versao = imagem.get(1);
                Lista<String> tamanhos = Texto.dividirPorSimbolo(imagem.get(imagem.getQuantidade() - 1), 'x');
                tamanhos.exibirLista();
                editor = new ImagemEditor(Integer.parseInt(tamanhos.get(0)), Integer.parseInt(tamanhos.get(1)));
                break;
            }
        }

        if (Texto.igual("v1", versao)) {
            CalebeImagemV1.lerImagemV1(linhas, editor);
        } else if (Texto.igual("v2", versao)) {
            throw new RuntimeException("Erro: So e suportada versao v1!");
        }


        return editor.getImagem();
    }

    public static BufferedImage criarImagemV2(String arquivo) {
        String dados = Texto.ler(arquivo);
        String versao = "";

        Lista<String> linhas = Texto.dividirLinhas(dados);

        ImagemEditor editor = new ImagemEditor(1, 1);
        int Y = 0;
        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "!")) {
                Lista<String> imagem = Texto.dividirPorSimbolo(linha, ' ');
                imagem.exibirLista();
                versao = imagem.get(1);
                Lista<String> tamanhos = Texto.dividirPorSimbolo(imagem.get(imagem.getQuantidade() - 1), 'x');
                tamanhos.exibirLista();
                editor = new ImagemEditor(Integer.parseInt(tamanhos.get(0)), Integer.parseInt(tamanhos.get(1)));
                break;
            }
        }

        if (Texto.igual("v1", versao)) {
            throw new RuntimeException("Erro: So e suportada versao v2!");
        } else if (Texto.igual("v2", versao)) {
            CalebeImagemV2.lerImagemV2(linhas, editor);
        }


        return editor.getImagem();
    }


    public static void transformaLinha(int Y, String linha, ImagemEditor editor) {
        //fmt.println("ANTES = |" + linha + "|");
        linha = Texto.removeString(linha, "[ ");
        linha = Texto.removeString(linha, " ]");
        linha = Texto.removeString(linha, ") ");
        linha = Texto.removeLetra(linha, ')');

        //fmt.println("DEPOIS = |" + linha + "|>");

        Lista<String> sCores = Texto.dividirPorSimbolo(linha, '(');

        int X = 0;

        for (String sCor : sCores) {
            if (sCor.length() > 0) {
                Lista<String> rgba = Texto.dividirPorSimbolo(sCor, ' ');

                // rgba.removerValor(" ", new StringIgualdade());
                String ccc = "";
                for (int i = 0; i < rgba.getQuantidade(); i++) {
                    ccc += i + ":" + rgba.get(i) + " ";
                }
                //fmt.println("|" + ccc + "|" + sCor.length());

                boolean tudoOk = true;
                if (rgba.getQuantidade() == 4) {
                    for (int i = 0; i < 4; i++) {
                        if (rgba.get(i).length() == 0 || rgba.get(i) == null) {
                            tudoOk = false;
                        }
                    }
                    if (!tudoOk) {
                        break;
                    }

                    int r = Integer.parseInt(rgba.get(0));
                    int g = Integer.parseInt(rgba.get(1));
                    int b = Integer.parseInt(rgba.get(2));
                    int a = Integer.parseInt(rgba.get(3));

                    Cor cor = new Cor(a, r, g, b);
                    if (X >= editor.getLargura() || Y >= editor.getAltura()) {
                        break;
                    }
                    //fmt.println("x:{} y:{} | r:{} g:{} b:{} a:{}", X, Y, r, g, b, a);
                    editor.setPixelCor(X, Y, cor);
                }
                X++;
            }
        }
        //Y++;
        //fmt.println("Transformei a linha: " + Y);
    }


    public static boolean validarVersao(String arquivo, String versao) {
        if (!Texto.existeString(arquivo, ".calebeImagem")) {
            fmt.println("Erro: Imagem no formato invalido (.calebeImagem)");
            return false;
        }

        String dados = Texto.ler(arquivo);

        Lista<String> linhas = Texto.dividirLinhas(dados);

        if (!Texto.existeString(linhas.get(0), versao)) {
            fmt.println("Erro: Versao da imagem invalida!");
            return false;
        }

        fmt.println("Validação OK!");
        return true;
    }

    public static void gerarDados(BufferedImage imagem, String arquivo) {
        CalebeImagemV2.gerarDadosV2(imagem, arquivo);
    }

    public static void gerarDados(BufferedImage imagem, String arquivo, Formato versao) {
        switch (versao){
            case V1 -> CalebeImagemV1.gerarDadosV1(imagem, arquivo);
            case V2 -> CalebeImagemV2.gerarDadosV2(imagem, arquivo);
            default -> throw new RuntimeException("Erro: Formato desconhecido!");
        }
    }

    public static void gerarDadosV1(BufferedImage imagem, String arquivo) {
        CalebeImagemV1.gerarDadosV1(imagem, arquivo);

    }

    public static void gerarDadosV2(BufferedImage imagem, String arquivo) {
        CalebeImagemV2.gerarDadosV2(imagem, arquivo);
    }
}

