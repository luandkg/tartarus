package utils;

public interface Serializavel<T> {
    String transforma(T tipo);
    T destransforma(String valor);
}
