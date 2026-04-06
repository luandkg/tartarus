package main.app.editor;

import main.libs.estruturas.Lista;
import main.libs.estruturas.fmt;

public class Cor {

    private int Alpha, Red, Green, Blue;

    public Cor(int alpha, int red, int green, int blue) {

        if (!validaCores(alpha) || !validaCores(red) || !validaCores(green) || !validaCores(blue)) {
            throw new IllegalArgumentException("Valores de cor devem estar entre 0 e 255");
        }
        this.Alpha = alpha;
        this.Red = red;
        this.Green = green;
        this.Blue = blue;
    }

    public Cor(int cor) {
        this.Alpha = (cor >> 24) & 0xFF;
        this.Red = (cor >> 16) & 0xFF;
        this.Green = (cor >> 8) & 0xFF;
        this.Blue = (cor & 0xFF);
    }

    public int getAlpha() {
        return Alpha;
    }

    public int getRed() {
        return Red;
    }

    public int getGreen() {
        return Green;
    }

    public int getBlue() {
        return Blue;
    }

    public void setAlpha(int alpha) {
        Alpha = alpha;
    }

    public void setRed(int red) {
        Red = red;
    }

    public void setGreen(int green) {
        Green = green;
    }

    public void setBlue(int blue) {
        Blue = blue;
    }

    private boolean validaCores(int cor) {
        return cor >= 0 && cor <= 255;
    }

    public int getValor() {
        return (Alpha << 24) | (Red << 16) | (Green << 8) | Blue;
    }

    public int valor(int alpha, int red, int green, int blue) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    public void exibeCores() {
        fmt.println(">Valores da Cor({})\n\tAlpha : {}\n\tRed : {}\n\tGreen : {}\n\tBlue : {}", getValor(), Alpha, Red, Green, Blue);
    }

    @Override
    public String toString() {
        // %08X faz o seguinte:
        // % -> inicia a formatação
        // 08 -> garante que terá 8 caracteres (preenche com zero se for menor)
        // X -> converte o int para Hexadecimal em letras MAIÚSCULAS
        return "#" + String.format("%08X", getValor());
    }

    public String getHexRGB() {
        // Ignoramos os bits do Alpha usando a máscara 0xFFFFFF
        return "#" + String.format("%06X", getValor() & 0xFFFFFF);
    }
}
