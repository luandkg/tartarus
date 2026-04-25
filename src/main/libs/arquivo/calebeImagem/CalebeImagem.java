package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;
import main.libs.estruturas.fmt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CalebeImagem {


    public static BufferedImage abrir(String arquivo) {
        String dados = Texto.ler(arquivo);

        Lista<String> linhas = Texto.dividirLinhas(dados);

        ImagemEditor editor = new ImagemEditor(1, 1);
        int Y = 0;
        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "!")) {
                Lista<String> imagem = Texto.dividirPorSimbolo(linha, ' ');
                Lista<String> tamanhos = Texto.dividirPorSimbolo(imagem.get(imagem.getQuantidade() - 1), 'x');
                editor = new ImagemEditor(Integer.parseInt(tamanhos.get(0)), Integer.parseInt(tamanhos.get(1)));
            } else if (Texto.comecaCom(linha, "[")) {

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

        return editor.getImagem();
    }

    public static BufferedImage abrirPNG(String caminho) {
        try {
            // 1. Carrega a imagem original (pode vir como DataBufferByte)
            BufferedImage original = ImageIO.read(new File(caminho));

            if (original == null) return null;

            // 2. Cria uma nova BufferedImage garantindo o formato de INTEIROS
            BufferedImage formatada = new BufferedImage(
                    original.getWidth(),
                    original.getHeight(),
                    BufferedImage.TYPE_INT_ARGB
            );

            // 3. Copia os pixels da original para a formatada
            Graphics2D g = formatada.createGraphics();
            g.drawImage(original, 0, 0, null);
            g.dispose();

            return formatada;

        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo: " + e.getMessage());
            return null;
        }
    }

    public static void salvar(BufferedImage imagem, String arquivo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem v1 :: " + largura + "x" + altura + "\n");
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

    public static boolean validadorVersao(String arquivo, String versao){
        if(!Texto.existeString(arquivo,".imagem")){
            fmt.println("Erro: Imagem no formato invalido (.imagem)");
            return false;
        }

        String dados = Texto.ler(arquivo);

        Lista<String> linhas = Texto.dividirLinhas(dados);

        if(!Texto.existeString(linhas.get(0),versao)){
            fmt.println("Erro: Versao da imagem invalida!");
            return false;
        }

        fmt.println("Validação OK!");
        return true;
    }

}

