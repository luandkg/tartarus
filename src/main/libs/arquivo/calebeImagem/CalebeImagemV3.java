package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;

import java.awt.image.BufferedImage;

public class CalebeImagemV3 {

    public static void ler(Lista<String> linhas, ImagemEditor editor) {
        Lista<String> historico = new Lista<String>();
        int y = 0;

        for (String linha : linhas) {
            //fmt.println("---------------------");

            //fmt.println("Lendo linha: " + y);
            if (Texto.comecaCom(linha, "[")) {
                historico.inserirAntes(0, linha);
                transformaLinhaV2(y, linha, editor);
                y++;
            } else if (Texto.comecaCom(linha, "#")) {
                //fmt.println("Cheguei na edição do #: ");

                String nLinha = Texto.limpandoCaracteres(linha);
                //fmt.println("linha: " + nLinha);


                String linhaHistorico = historico.get(Integer.parseInt(nLinha) - 1);
                //fmt.println("linhaHistorico: " + linhaHistorico);

                transformaLinhaV2(y, linhaHistorico, editor);
                y++;
            }


        }
    }

    public static void salvar(BufferedImage imagem, String arquivo) {
        Lista<String> historico = new Lista<String>();
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        String linhaAnterior = "";
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem " + CalebeImagem.V3 + " :: " + largura + "x" + altura + "\n");

        for (int y = 0; y < altura; y++) {
            String linha = "[";
            for (int x = 0; x < largura; x++) {
                Cor cor = new Cor(imagem.getRGB(x, y));
                String rgba = cor.getRed() + " " + cor.getGreen() + " " + cor.getBlue() + " " + cor.getAlpha();
                linha += " (" + rgba + ")";
            }

            linha += " ]";

            boolean existe = false;
            int contador = 1;
            for (String item : historico) {
                if (Texto.igual(linha, item)) {
                    linha = "# [" + contador + "]";
                    existe = true;
                    break;
                }
                contador++;
            }

            dados.adicionarLinha(linha);


            if (!existe) {
                historico.inserirAntes(0, linha);
            }

            if (historico.getQuantidade() > 255) {
                historico.remover(historico.getQuantidade() - 1);
            }
        }

        Texto.escrever(arquivo, dados.toString());
    }

    private static Lista<String> listaDeCoresV2(String linha){
        //fmt.println("ANTES = |" + linha + "|");
        linha = Texto.removeString(linha, "[ ");
        linha = Texto.removeString(linha, " ]");
        linha = Texto.removeString(linha, ") ");
        linha = Texto.removeLetra(linha, ')');

        //fmt.println("DEPOIS = |" + linha + "|>");

        Lista<String> sCores = Texto.dividirPorSimbolo(linha, '(');

        return sCores;
    }

    private static void transformaLinhaV2(int Y, String linha, ImagemEditor editor) {

        int X = 0;

        for (String sCor : listaDeCoresV2(linha)) {
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
}
