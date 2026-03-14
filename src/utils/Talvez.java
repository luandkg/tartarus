package utils;

public class Talvez<T> {
    private T valor;
    private boolean existe;


    public Talvez(){
        this.valor=null;
        this.existe=false;
    }

    public Talvez(T valor){
        if(valor!=null){
            this.valor=valor;
            this.existe=true;
        }else {
            this.existe=false;
        }
    }

    public T getValor(){
        return valor;
    }

    public void setValor(T valor){
        this.valor=valor;
    }

    public boolean temValor(){
        return existe;
    }

    public boolean estaVazia(){
        return !existe;
    }

    public static  <T> Talvez<T> TALVEZ(T valor){
        return new Talvez<T>(valor);
    }

    public static  <T> Talvez<T> NADA(){
        return new Talvez<T>();
    }

}
