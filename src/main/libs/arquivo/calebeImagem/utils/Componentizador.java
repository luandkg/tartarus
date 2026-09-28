package main.libs.arquivo.calebeImagem.utils;

import main.app.editor.Cor;

import java.awt.image.BufferedImage;

public record Componentizador(int compR, int compG, int compB, int compA, boolean r, boolean g, boolean b, boolean a) {

    public static Componentizador processar(BufferedImage imagem, int y, int largura){
        int compR = new Cor(imagem.getRGB(0, y)).getRed();
        int compG = new Cor(imagem.getRGB(0, y)).getGreen();
        int compB = new Cor(imagem.getRGB(0, y)).getBlue();
        int compA = new Cor(imagem.getRGB(0, y)).getAlpha();

        boolean r = true;
        boolean g = true;
        boolean b = true;
        boolean a = true;

        for (int x = 0; x < largura; x++) {
            Cor cor = new Cor(imagem.getRGB(x, y));
            if(compR != cor.getRed()){
                r = false;
            }
            if(compG != cor.getGreen()){
                g = false;
            }
            if(compB != cor.getBlue()){
                b = false;
            }
            if(compA != cor.getAlpha()){
                a = false;
            }
        }
        return new Componentizador(compR, compG, compB, compA, r, g, b, a);
    }
}
