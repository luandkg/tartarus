package libs.teste;

import estruturas.ItemComPosicao;
import estruturas.Lista;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TesteExecutor {

    public static void TESTAR(Lista<Class<?>> classes) {

        System.out.println("");
        System.out.println("--------------------------------------- EXECUTOR DE TESTES UNITÁRIOS - CALEBE --------------------------------------------");
        System.out.println("");

        Class<?>[] arrayClasses =  new  Class<?>[classes.getQuantidade()];
        for(ItemComPosicao<Class<?>> c : classes.getItensComPosicao()){
            arrayClasses[c.getPosicao()]=c.getItem();
        }

        Arrays.sort(arrayClasses, Comparator.comparing(Class::getName));

        int i = 0;
        int o = classes.getQuantidade();

        Lista<TestandoCalebe> testesRealizados = new Lista<TestandoCalebe>();

        while (i < o) {
            Class<?> testandoClasse = arrayClasses[i];
            if (testandoClasse.isAnnotationPresent(TesteClasseCalebe.class)) {
                TesteClasseCalebe anotacao = testandoClasse.getAnnotation(TesteClasseCalebe.class);
                System.out.println("");
                System.out.println(">> Executando testes da classe :: " + testandoClasse.getName());

                Method[] metodos = testandoClasse.getDeclaredMethods();
                Arrays.sort(metodos, Comparator.comparing(Method::getName));

                for (Method metodo : metodos) {
                    if (metodo.isAnnotationPresent(TesteCalebe.class)) {
                        System.out.println("\t ++ Testando método : " + metodo.getName());

                        TestandoCalebe testando = new TestandoCalebe(testandoClasse.getName() + " -> " + metodo.getName());

                        try {
                            metodo.invoke(null, testando);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }

                        testesRealizados.adicionar(testando);
                    }
                }
                System.out.println("");
            }
            i += 1;
        }

        int testeIndice = 0;
        int testeTotal = testesRealizados.getQuantidade();

        System.out.println(COLUNA_UNICO("-",122));
        System.out.println("|"+COLUNA_UNICO(" ",55) + "RESULTADOS"+COLUNA_UNICO(" ",55) +"|");
        System.out.println(COLUNA_UNICO("-",122));

        String cabecalho = "| " + COLUNA_ESQUERDA("TESTE",5)+ " | "+COLUNA_DIREITA("NOME", 80) + " | " + COLUNA_ESQUERDA("TOTAL", 7) + " | " + COLUNA_ESQUERDA("SUCESSO", 7) + " | " + COLUNA_ESQUERDA("FALHOU", 7) + " |";
        System.out.println(cabecalho);
        System.out.println(COLUNA_UNICO("-",122));

        while (testeIndice < testeTotal) {
            TestandoCalebe teste = testesRealizados.get(testeIndice);

            String linha = "| " + COLUNA_ESQUERDA((testeIndice+1),5)+ " | "+COLUNA_DIREITA(teste.getNome(), 80) + " | " + COLUNA_ESQUERDA(teste.getTotal(), 7) + " | " + COLUNA_ESQUERDA(teste.getSucesso(), 7) + " | " + COLUNA_ESQUERDA(teste.getFalhou(), 7) + " |";

            System.out.println(linha);

            testeIndice += 1;
        }
        System.out.println(COLUNA_UNICO("-",122));

    }

    public static void TESTAR_UNICO(Class<?> testandoClasse) {

        System.out.println("");
        System.out.println("--------------------------------------- EXECUTOR DE TESTES UNITÁRIOS - CALEBE --------------------------------------------");
        System.out.println("");

        Lista<TestandoCalebe> testesRealizados = new Lista<TestandoCalebe>();

            if (testandoClasse.isAnnotationPresent(TesteClasseCalebe.class)) {
                TesteClasseCalebe anotacao = testandoClasse.getAnnotation(TesteClasseCalebe.class);
                System.out.println("");
                System.out.println(">> Executando testes da classe :: " + testandoClasse.getName());

                Method[] metodos = testandoClasse.getDeclaredMethods();
                Arrays.sort(metodos, Comparator.comparing(Method::getName));

                for (Method metodo : metodos) {
                    if (metodo.isAnnotationPresent(TesteCalebe.class)) {
                        System.out.println("\t ++ Testando método : " + metodo.getName());

                        TestandoCalebe testando = new TestandoCalebe(testandoClasse.getName() + " -> " + metodo.getName());

                        try {
                            metodo.invoke(null, testando);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }

                        testesRealizados.adicionar(testando);
                    }
                }
                System.out.println("");
            }

        int testeIndice = 0;
        int testeTotal = testesRealizados.getQuantidade();

        System.out.println(COLUNA_UNICO("-",122));
        System.out.println("|"+COLUNA_UNICO(" ",55) + "RESULTADOS"+COLUNA_UNICO(" ",55) +"|");
        System.out.println(COLUNA_UNICO("-",122));

        String cabecalho = "| " + COLUNA_ESQUERDA("TESTE",5)+ " | "+COLUNA_DIREITA("NOME", 80) + " | " + COLUNA_ESQUERDA("TOTAL", 7) + " | " + COLUNA_ESQUERDA("SUCESSO", 7) + " | " + COLUNA_ESQUERDA("FALHOU", 7) + " |";
        System.out.println(cabecalho);
        System.out.println(COLUNA_UNICO("-",122));

        while (testeIndice < testeTotal) {
            TestandoCalebe teste = testesRealizados.get(testeIndice);

            String linha = "| " + COLUNA_ESQUERDA((testeIndice+1),5)+ " | "+COLUNA_DIREITA(teste.getNome(), 80) + " | " + COLUNA_ESQUERDA(teste.getTotal(), 7) + " | " + COLUNA_ESQUERDA(teste.getSucesso(), 7) + " | " + COLUNA_ESQUERDA(teste.getFalhou(), 7) + " |";

            System.out.println(linha);

            testeIndice += 1;
        }
        System.out.println(COLUNA_UNICO("-",122));

    }

    public static String COLUNA_UNICO(String valor, int colunaTamanho) {
        String linha = "";

        while (linha.length() < colunaTamanho) {
            linha +=  valor;
        }

        return linha;
    }

    public static String COLUNA_ESQUERDA(String valor, int colunaTamanho) {
        String sValor = valor;

        while (sValor.length() < colunaTamanho) {
            sValor = " " + sValor;
        }

        return sValor;
    }


    public static String COLUNA_DIREITA(String valor, int colunaTamanho) {
        String sValor = valor;

        while (sValor.length() < colunaTamanho) {
            sValor = sValor + " ";
        }

        return sValor;
    }

    public static String COLUNA_ESQUERDA(int valor, int colunaTamanho) {
        return COLUNA_ESQUERDA(String.valueOf(valor),colunaTamanho);
    }

}
