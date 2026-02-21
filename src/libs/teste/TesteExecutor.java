package libs.teste;

import estruturas.ItemComPosicao;
import estruturas.Lista;
import estruturas.fmt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class TesteExecutor {

    public static void TESTAR(Lista<Class<?>> classes) {

        fmt.println("\n{centraliza_122}\n", "EXECUTOR DE TESTES UNITÁRIOS - CALEBE ");

        Class<?>[] arrayClasses = new Class<?>[classes.getQuantidade()];
        for (ItemComPosicao<Class<?>> c : classes.getItensComPosicao()) {
            arrayClasses[c.getPosicao()] = c.getItem();
        }

        Arrays.sort(arrayClasses, Comparator.comparing(Class::getName));

        int i = 0;
        int o = classes.getQuantidade();

        Lista<TestandoCalebe> testesRealizados = new Lista<TestandoCalebe>();

        while (i < o) {
            Class<?> testandoClasse = arrayClasses[i];
            if (testandoClasse.isAnnotationPresent(TesteClasseCalebe.class)) {
                TesteClasseCalebe anotacao = testandoClasse.getAnnotation(TesteClasseCalebe.class);
                fmt.println("\n>> Executando testes da classe :: " + testandoClasse.getName());

                Method[] metodos = testandoClasse.getDeclaredMethods();
                Arrays.sort(metodos, Comparator.comparing(Method::getName));

                for (Method metodo : metodos) {
                    if (metodo.isAnnotationPresent(TesteCalebe.class)) {
                        fmt.println("\t ++ Testando método : " + metodo.getName());

                        TestandoCalebe testando = new TestandoCalebe(testandoClasse.getName() + " -> " + metodo.getName());

                        try {
                            metodo.invoke(null, testando);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }

                        testesRealizados.adicionar(testando);
                    }
                }
                fmt.println("");
            }
            i += 1;
        }

        EXIBIR_TESTES(testesRealizados);

        fmt.println("\n\n");

        EXIBIR_ERROS(testesRealizados);
    }

    public static void TESTAR_UNICO(Class<?> testandoClasse) {

        fmt.println("\n{centraliza_122}\n", "EXECUTOR DE TESTES UNITÁRIOS - CALEBE ");

        Lista<TestandoCalebe> testesRealizados = new Lista<TestandoCalebe>();

        if (testandoClasse.isAnnotationPresent(TesteClasseCalebe.class)) {
            TesteClasseCalebe anotacao = testandoClasse.getAnnotation(TesteClasseCalebe.class);

            fmt.println("\n>> Executando testes da classe :: " + testandoClasse.getName());

            Method[] metodos = testandoClasse.getDeclaredMethods();
            Arrays.sort(metodos, Comparator.comparing(Method::getName));

            for (Method metodo : metodos) {
                if (metodo.isAnnotationPresent(TesteCalebe.class)) {
                    fmt.println("\t ++ Testando método : " + metodo.getName());

                    TestandoCalebe testando = new TestandoCalebe(testandoClasse.getName() + " -> " + metodo.getName());

                    try {
                        metodo.invoke(null, testando);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }

                    testesRealizados.adicionar(testando);
                }
            }
            fmt.println("");
        }

        EXIBIR_TESTES(testesRealizados);

        fmt.println("\n\n");

        EXIBIR_ERROS(testesRealizados);

    }

    public static void EXIBIR_TESTES(Lista<TestandoCalebe> testesRealizados) {

        fmt.println(fmt.repete("-", 122));
        fmt.println("|{centraliza_120}|", "RESULTADOS");
        fmt.println(fmt.repete("-", 122));
        fmt.println("| {esquerda_5} | {esquerda_80} | {esquerda_7} | {esquerda_7} | {esquerda_7} |", "TESTE", "NOME", "TOTAL", "SUCESSO", "FALHOU");
        fmt.println(fmt.repete("-", 122));

        for (ItemComPosicao<TestandoCalebe> teste : testesRealizados.getItensComPosicao()) {
            //String linha = "| " + fmt.esquerda(String.valueOf((teste.getPosicao()+1)),5)+ " | "+fmt.esquerda(teste.getItem().getNome(), 80) + " | " + fmt.esquerda(String.valueOf(teste.getItem().getTotal()), 7) + " | " + fmt.esquerda(String.valueOf(teste.getItem().getSucesso()), 7) + " | " + fmt.esquerda(String.valueOf(teste.getItem().getFalhou()), 7) + " |";
            fmt.println("| {esquerda_5} | {esquerda_80} | {esquerda_7} | {esquerda_7} | {esquerda_7} |", teste.getPosicao() + 1, teste.getItem().getNome(), teste.getItem().getTotal(), teste.getItem().getSucesso(), teste.getItem().getFalhou());

            //fmt.println(linha);
        }

        fmt.println(fmt.repete("-", 122));
    }

    public static void EXIBIR_ERROS(Lista<TestandoCalebe> testesRealizados) {
        int totalErros = 0;
        for (TestandoCalebe teste : testesRealizados) {
            totalErros += teste.getErros().getQuantidade();
        }

        if (totalErros > 0) {
            fmt.println(fmt.repete("-", 122));
            //fmt.println("|{repete_57}ERROS{repete_58}|" , " ", " ");
            fmt.println("|{centraliza_120}|", "ERROS ");

            fmt.println(fmt.repete("-", 122));

            fmt.println("| " + fmt.esquerda("TESTE", 5) + " | " + fmt.esquerda("NOME", 110) + " |");
            fmt.println(fmt.repete("-", 122));


            for (TestandoCalebe teste : testesRealizados) {
                Lista<String> erros = teste.getErros();
                if (!erros.estaVazia()) {
                    for (ItemComPosicao<String> erro : erros.getItensComPosicao()) {
                        fmt.println("| {esquerda_5} | {esquerda_110} |", erro.getPosicao() + 1, erro.getItem());
                    }
                }
            }
            fmt.println(fmt.repete("-", 122));
        }
    }
}

