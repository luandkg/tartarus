package main.app.editor.Geometria;

import java.awt.image.DataBufferInt;

public class Retangulo {

    private int x1, y1, x2, y2;

    public Retangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getAltura() {
        return y2-y1;
    }

    public int getLargura() {
        return x2-x1;
    }

    public int areaRetangulo(int posInicialX, int posInicialY, int posFinalX, int posFinalY){
        int altura = getAltura();
        int largura = getAltura();

        return (largura*altura)/2;
    }

    public int areaRetangulo(int altura, int largura){
        return (largura*altura)/2;
    }
}
