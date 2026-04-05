package main.app.editorImagem;

import main.libs.estruturas.Lista;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

public class ImagemEditor {

    private int altura, largura;

    private BufferedImage imagem;

    private int[] pixels;

    public ImagemEditor(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
        this.imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        // pega referência direta ao array interno do BufferedImage
        this.pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
    }

    public int getPixel(int posX, int posY){
        return pixels[(posY*largura) + posX];
    }

    public void setPixel(int posX, int posY, int cor){
        pixels[(posY*largura) + posX] = cor;
    }

    public void salvar (String arquivo){
        try {
            // Cria o objeto File com o nome do arquivo
            File outputfile = new File(arquivo);

            // ImageIO.write recebe a imagem, o formato ("png") e o arquivo de destino
            ImageIO.write(imagem, "png", outputfile);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

}
