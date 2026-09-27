package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;
import main.libs.estruturas.fmt;

import java.awt.image.BufferedImage;

public class CalebeImagemV3 {

    public void lerImagemV3(Lista<String> linhas, ImagemEditor editor) {
        Lista<String> historico = new Lista<String>();
        int y = 0;

        for (String linha : linhas) {
            //fmt.println("---------------------");

            //fmt.println("Lendo linha: " + y);
            if (Texto.comecaCom(linha, "[")) {
                historico.inserirAntes(0, linha);
                CalebeImagem.transformaLinha(y, linha, editor);
                y++;
            } else if (Texto.comecaCom(linha, "#")) {
                fmt.println("Cheguei na edição do #: ");

                String nLinha = Texto.limpandoCaracteres(linha);
                fmt.println("linha: " + nLinha);


                String linhaHistorico = historico.get(Integer.parseInt(nLinha) - 1);
                fmt.println("linhaHistorico: " + linhaHistorico);

                CalebeImagem.transformaLinha(y, linhaHistorico, editor);
                y++;
            }


        }
    }

    public static void gerarDadosV3(BufferedImage imagem, String arquivo) {
        CalebeImagemV3 dados = new CalebeImagemV3();
        dados.salvarDadosV3(imagem, arquivo);
    }


    public void salvarDadosV3(BufferedImage imagem, String arquivo) {
        Lista<String> historico = new Lista<String>();
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        String linhaAnterior = "";
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem v3 :: " + largura + "x" + altura + "\n");

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


            if (!existe){
                historico.inserirAntes(0, linha);
            }

            if (historico.getQuantidade() > 255) {
                historico.remover(historico.getQuantidade() - 1);
            }
        }

        Texto.escrever(arquivo, dados.toString());
    }
}
