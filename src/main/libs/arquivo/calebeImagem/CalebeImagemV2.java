package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;

import java.awt.image.BufferedImage;

public class CalebeImagemV2 {


    public static void ler(Lista<String> linhas, ImagemEditor editor) {
        int y = 0;
        String linhaAnterior = "";

        for (String linha : linhas) {
            //fmt.println("---------------------");

            //fmt.println("Lendo linha: " + y);
            if (Texto.comecaCom(linha, "[")) {
                CalebeImagem.transformaLinha(y, linha, editor);
                linhaAnterior = linha;
                y++;
            } else if (Texto.comecaCom(linha, "#")) {
                //fmt.println("Cheguei na edição do #: ");
                CalebeImagem.transformaLinha(y, linhaAnterior, editor);
                y++;
            }


        }
    }

    public static void salvar(BufferedImage imagem, String arquivo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        String linhaAnterior = "";
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem " + CalebeImagem.V2 + " :: " + largura + "x" + altura + "\n");

        for (int y = 0; y < altura; y++) {
            String linha = "[";
            for (int x = 0; x < largura; x++) {
                Cor cor = new Cor(imagem.getRGB(x, y));
                String rgba = cor.getRed() + " " + cor.getGreen() + " " + cor.getBlue() + " " + cor.getAlpha();
                linha += " (" + rgba + ")";
            }

            linha += " ]";

            String copiaLinha = linha;
            if (Texto.igual(linha, linhaAnterior)) {
                linha = "# [1]";
            }
            linhaAnterior = copiaLinha;

            dados.adicionarLinha(linha);

        }

        Texto.escrever(arquivo, dados.toString());
    }

}
