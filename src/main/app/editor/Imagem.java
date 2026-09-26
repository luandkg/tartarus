package main.app.editor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagem {

    public static BufferedImage criarImagemPNG(String caminho) {
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
}
