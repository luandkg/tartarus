package main.libs.teste;

import main.libs.estruturas.ItemComPosicao;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;
import main.libs.tempo.Data;
import main.libs.tempo.Horario;
import main.libs.tempo.Tempo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class TesteExecutor {

    public static void TESTAR(Lista<Class<?>> classes) {

        File arquivo = new File("arquivos");

        if(!arquivo.exists()){
            arquivo.mkdir();
        }

        Data inicioData = Tempo.getDataHoje();
        Horario inicioHorario = Tempo.getHorarioAgora();
        long inicioTempo=System.nanoTime();

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

        Data fimData = Tempo.getDataHoje();
        Horario fimHorario = Tempo.getHorarioAgora();
        long fimTempo=System.nanoTime();

        String duracao=Tempo.formatarNanossegundos(fimTempo-inicioTempo);

        //TESTE_HISTORICO(testesRealizados, inicioData, fimData, inicioHorario, fimHorario,duracao);

        EXIBIR_TESTES(testesRealizados);
        //SALVAR_RESULTADOS_DOS_TESTES(testesRealizados);

        fmt.println("\n\n");

        EXIBIR_ERROS(testesRealizados);
        //SALVAR_ERROS(testesRealizados);
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

    public static void SALVAR_RESULTADOS_DOS_TESTES(Lista<TestandoCalebe> testesRealizados) {

        String resultado = "";

        resultado += fmt.formatar("{}\t{}\t{}\t{}\t{}\n", "TESTE", "NOME", "TOTAL", "SUCESSO", "FALHOU");

        for (ItemComPosicao<TestandoCalebe> teste : testesRealizados.getItensComPosicao()) {
            resultado += fmt.formatar("{}\t{}\t{}\t{}\t{}\n", teste.getPosicao() + 1, teste.getItem().getNome(), teste.getItem().getTotal(), teste.getItem().getSucesso(), teste.getItem().getFalhou());
        }
        Texto.escrever("arquivosDeTestes/testes/Testes_Resultados.tsv", resultado);
    }

    public static void TESTE_HISTORICO(Lista<TestandoCalebe> testesRealizados, Data inicioData, Data fimData, Horario inicioHorario, Horario fimHorario,String duracao) {

        final String arquivo = "arquivosDeTestes/testes/Teste_Historico.tsv";

        File registro = new File(arquivo);

        String conteudo = "";

        if (registro.exists()) {
            conteudo = Texto.ler(arquivo);
        }

        String novoRegistro = "";
        int contTotal = 0;
        int contTotalSucessos = 0;
        int contTotalFalhas = 0;
        String statusFinal = "Sucesso";

        if (conteudo.length() > 0) {
            novoRegistro = conteudo;
        } else {
            novoRegistro += fmt.formatar("{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n", "DATA INICIO", "DATA FIM", "HORARIO INICIO", "HORARIO FIM",  "DURAÇÃO","TOTAL EXECUTADOS", "TOTAL DE SUCESSOS", "TOTAL DE FALHAS", "STATUS FINAL");
        }

        for (ItemComPosicao<TestandoCalebe> teste : testesRealizados.getItensComPosicao()) {
            contTotal += teste.getItem().getTotal();
            contTotalSucessos += teste.getItem().getSucesso();
            contTotalFalhas += teste.getItem().getFalhou();
        }

        if (contTotalFalhas > 0) {
            statusFinal = "Falhou";
        }

        novoRegistro += fmt.formatar("{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n", inicioData.toString(), fimData.toString(), inicioHorario.toString(), fimHorario.toString(),duracao, contTotal, contTotalSucessos, contTotalFalhas, statusFinal);

        Texto.escrever(arquivo, novoRegistro);
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

    public static void SALVAR_ERROS(Lista<TestandoCalebe> testesRealizados) {
        int totalErros = 0;
        for (TestandoCalebe teste : testesRealizados) {
            totalErros += teste.getErros().getQuantidade();
        }

        if (totalErros > 0) {
            String resultado = "";

            resultado += fmt.formatar("{}\t{}\n", "TESTE", "NOME");

            for (TestandoCalebe teste : testesRealizados) {
                Lista<String> erros = teste.getErros();
                if (!erros.estaVazia()) {
                    for (ItemComPosicao<String> erro : erros.getItensComPosicao()) {
                        resultado += fmt.formatar("{}\t{}\n", erro.getPosicao() + 1, erro.getItem());


                    }
                }
            }
            Texto.escrever("arquivosDeTestes/testes/Testes_Com_Erros.tsv", resultado);
            Texto.escrever("arquivosDeTestes/testes/Teste_Resultado_Status.txt", "PROBLEMA");

        } else {
            Texto.escrever("arquivosDeTestes/testes/Teste_Resultado_Status.txt", "SUCESSO");
        }
    }
}

