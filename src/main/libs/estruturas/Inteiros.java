package main.libs.estruturas;

import main.app.ordenar.Comparador;
import main.app.ordenar.Pessoa;
import main.libs.utils.CondicionalParametrizado;

public class Inteiros {

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_MAIOR_QUE(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a>getValor();
            }
        };
    }

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_MENOR_QUE(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                    return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a<getValor();
            }
        };
    }

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_IGUAL(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a==getValor();
            }
        };
    }

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_DIFERENTE(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a!=getValor();
            }
        };
    }

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_MAIOR_OU_IGUAL(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a>=getValor();
            }
        };
    }

    public static CondicionalParametrizado<Integer, Integer> INTEIRO_MENOR_OU_IGUAL(int valor) {
        return new CondicionalParametrizado<Integer, Integer>() {
            @Override
            public Integer getValor() {
                return valor;
            }

            @Override
            public boolean condicao(Integer a) {
                return a<=getValor();
            }
        };
    }

    public static Comparador<Integer> compararMaior() {
        return new Comparador<Integer>() {
            @Override
            public boolean compare(Integer n1, Integer n2) {
                return n1 > n2;
            }
        };
    }

    public static Comparador<Integer> compararMenor() {
        return new Comparador<Integer>() {
            @Override
            public boolean compare(Integer n1, Integer n2) {
                return n1 < n2;
            }
        };
    }

}
