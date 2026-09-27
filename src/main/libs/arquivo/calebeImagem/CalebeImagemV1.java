package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;

import java.awt.image.BufferedImage;

public class CalebeImagemV1 {

    public static void ler(Lista<String> linhas, ImagemEditor editor) {
        int Y = 0;
        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "[")) {

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
                Y++;
            }
        }
    }

    public static void salvar(BufferedImage imagem, String arquivo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem " + CalebeImagem.V1 + " :: " + largura + "x" + altura + "\n");
        for (int y = 0; y < altura; y++) {
            String linha = "[";
            for (int x = 0; x < largura; x++) {
                Cor cor = new Cor(imagem.getRGB(x, y));
                String rgba = cor.getRed() + " " + cor.getGreen() + " " + cor.getBlue() + " " + cor.getAlpha();
                linha += " (" + rgba + ")";
            }

            linha += " ]";
            dados.adicionarLinha(linha);
        }

        Texto.escrever(arquivo, dados.toString());
    }

}
