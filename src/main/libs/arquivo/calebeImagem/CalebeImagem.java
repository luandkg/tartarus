package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

import java.awt.image.BufferedImage;

public class CalebeImagem {

    public static final String V1 = "v1";
    public static final String V2 = "v2";
    public static final String V3 = "v3";
    public static final String V4 = "v4";

    public static BufferedImage ler(String caminho) {
        ProcessandoImagem imagem = ProcessandoImagem.obterCabecalho(caminho);

        if (Texto.igual(V1, imagem.versao())) {
            CalebeImagemV1.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V2, imagem.versao())) {
            CalebeImagemV2.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V3, imagem.versao())) {
            CalebeImagemV3.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V4, imagem.versao())) {
            CalebeImagemV4.ler(imagem.linhas(), imagem.editor());
        } else {
            throw new RuntimeException("Erro: Versao (" + imagem.versao() + ") nao encontrada!");
        }
        return imagem.editor().getImagem();
    }

    public static BufferedImage lerImagemV1(String caminho) {
        ProcessandoImagem imagem = ProcessandoImagem.obterCabecalho(caminho);

        if (Texto.igual(V1, imagem.versao())) {
            CalebeImagemV1.ler(imagem.linhas(), imagem.editor());
        } else {
            throw new RuntimeException("Erro: Versao (" + imagem.versao() + ") nao encontrada!");
        }
        return imagem.editor().getImagem();
    }

    public static BufferedImage lerImagemV2(String caminho) {
        ProcessandoImagem imagem = ProcessandoImagem.obterCabecalho(caminho);

        if (Texto.igual(V1, imagem.versao())) {
            CalebeImagemV1.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V2, imagem.versao())) {
            CalebeImagemV2.ler(imagem.linhas(), imagem.editor());
        } else {
            throw new RuntimeException("Erro: Versao (" + imagem.versao() + ") nao encontrada!");
        }
        return imagem.editor().getImagem();
    }

    public static BufferedImage lerImagemV3(String caminho) {
        ProcessandoImagem imagem = ProcessandoImagem.obterCabecalho(caminho);

        if (Texto.igual(V1, imagem.versao())) {
            CalebeImagemV1.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V2, imagem.versao())) {
            CalebeImagemV2.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V3, imagem.versao())) {
            CalebeImagemV3.ler(imagem.linhas(), imagem.editor());
        } else {
            throw new RuntimeException("Erro: Versao (" + imagem.versao() + ") nao encontrada!");
        }
        return imagem.editor().getImagem();
    }

    public static BufferedImage lerImagemV4(String caminho) {
        ProcessandoImagem imagem = ProcessandoImagem.obterCabecalho(caminho);

        if (Texto.igual(V1, imagem.versao())) {
            CalebeImagemV1.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V2, imagem.versao())) {
            CalebeImagemV2.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V3, imagem.versao())) {
            CalebeImagemV3.ler(imagem.linhas(), imagem.editor());
        } else if (Texto.igual(V4, imagem.versao())) {
            CalebeImagemV4.ler(imagem.linhas(), imagem.editor());
        } else {
            throw new RuntimeException("Erro: Versao (" + imagem.versao() + ") nao encontrada!");
        }
        return imagem.editor().getImagem();
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

    public static void salvar(BufferedImage imagem, String arquivo) {
        salvar(imagem, arquivo, Formato.V4);
    }

    public static void salvar(BufferedImage imagem, String arquivo, Formato versao) {
        switch (versao) {
            case V1 -> CalebeImagemV1.salvar(imagem, arquivo);
            case V2 -> CalebeImagemV2.salvar(imagem, arquivo);
            case V3 -> CalebeImagemV3.salvar(imagem, arquivo);
            case V4 -> CalebeImagemV4.salvar(imagem, arquivo);
            default -> throw new RuntimeException("Erro: Formato desconhecido!");
        }
    }

    public static void salvarV1(BufferedImage imagem, String arquivo) {
        CalebeImagemV1.salvar(imagem, arquivo);

    }

    public static void salvarV2(BufferedImage imagem, String arquivo) {
        CalebeImagemV2.salvar(imagem, arquivo);
    }

    public static void salvarV3(BufferedImage imagem, String arquivo) {
        CalebeImagemV3.salvar(imagem, arquivo);
    }

    public static void salvarV4(BufferedImage imagem, String arquivo) {
        CalebeImagemV4.salvar(imagem, arquivo);
    }
}

