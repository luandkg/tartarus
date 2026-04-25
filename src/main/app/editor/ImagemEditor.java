package main.app.editor;

import main.app.editor.Geometria.Retangulo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ImagemEditor {

    private int altura, largura;

    private BufferedImage imagem;

    private int[] pixels;

    public ImagemEditor(int largura, int altura) {
        this.altura = altura;
        this.largura = largura;
        this.imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        // pega referência direta ao array interno do BufferedImage
        this.pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
    }

    public ImagemEditor(BufferedImage img) {
        this.altura = img.getHeight();
        this.largura = img.getWidth();
        this.imagem = img;

        // pega referência direta ao array interno do BufferedImage
        this.pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
    }

    public int getPixel(int posX, int posY) {
        return pixels[(posY * largura) + posX];
    }

    public Cor getPixelCor(int posX, int posY) {
        int valor = pixels[(posY * largura) + posX];
        Cor cor = new Cor(valor);
        return cor;
    }

    public BufferedImage getImagem(){return imagem;}

    public int getLargura(){
        return largura;
    }

    public int getAltura(){
        return altura;
    }

    public void setPixel(int posX, int posY, int cor) {
        pixels[(posY * largura) + posX] = cor;
    }

    public void setPixelCor(int posX, int posY, Cor cor) {
        pixels[(posY * largura) + posX] = cor.getValor();
    }

    public void salvar(String arquivo) {
        try {
            // ImageIO.write recebe a imagem, o formato ("png") e o arquivo de destino
            ImageIO.write(imagem, "png", new File(arquivo));

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    public void pintarRetangulo(int posX, int posY, int largura, int altura, int cor) {
        for (int y = posY; y < (posY + altura); y++) {
            for (int x = posX; x < (posX + largura); x++) {
                setPixel(x, y, cor);
            }
        }
    }

    public void pintarRetangulo(Retangulo retangulo, Cor cor) {
        for (int y = retangulo.getY1(); y < (retangulo.getY1() + retangulo.getAltura()); y++) {
            for (int x = retangulo.getX1(); x < (retangulo.getX1() + retangulo.getLargura()); x++) {
                setPixel(x, y, cor.getValor());
            }
        }
    }

    public void desenharRetangulo(int posInicialX, int posInicialY, int posFinalX, int posFinalY, int cor) {
        for (int y = posInicialY; y <= (posFinalY); y++) {
            setPixel(posInicialX, y, cor);
            setPixel(posFinalX, y, cor);
        }
        for (int x = posInicialX; x <= (posFinalX); x++) {
            setPixel(x, posInicialY, cor);
            setPixel(x, posFinalY, cor);
        }
    }

    public void desenharRetangulo(Retangulo retangulo, Cor cor) {
        for (int y = retangulo.getY1(); y < (retangulo.getY1() + retangulo.getAltura()); y++) {
            setPixel(retangulo.getX1(), y, cor.getValor());
            setPixel(retangulo.getX2(), y, cor.getValor());
        }
        for (int x = retangulo.getX1(); x < (retangulo.getX1() + retangulo.getLargura()); x++) {
            setPixel(x, retangulo.getY1(), cor.getValor());
            setPixel(x, retangulo.getY2(), cor.getValor());
        }
    }


}
