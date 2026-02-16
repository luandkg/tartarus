package utils;

public interface CondicionalParametrizado<T1,T2> {
    T2 getValor();
    boolean condicao(T1 a);
}
