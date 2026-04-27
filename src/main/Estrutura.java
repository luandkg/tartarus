package main;

import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Estrutura {
    public static String[] estrutura() {
        String[] pastas = {
                "arquivos/documentos",
                "arquivos/futebol",
                "arquivos/outros",

                "arquivos/editorDeImagem/clonadas",
                "arquivos/editorDeImagem/criadas",
                "arquivos/editorDeImagem/originais",
                "arquivos/editorDeImagem/criadas/tipoPNG",
                "arquivos/editorDeImagem/criadas/tipoCalebeImagem",

                "arquivosDeTestes",
                "arquivosDeTestes/testes",

                "arquivosDeTestes/imagens/calebeImagem",
                "arquivosDeTestes/imagens/editorImagem",
        };
        return pastas;
    }

    public static void criarEstrutura() {
        String[] pastas = estrutura();

        try {
            for (String caminho : pastas) {
                Files.createDirectories(Paths.get(caminho));
            }
            System.out.println("Estrutura de pastas verificada/criada com sucesso.");
        } catch (IOException e) {
            System.err.println("Falha crítica ao criar diretórios: " + e.getMessage());
        }
    }

    public static boolean verificaPasta(String caminho) {
        File pasta = new File(caminho);
        if (pasta.isDirectory()) {
            return true;
        }
        fmt.println("Erro: Pasta nao encontrada!");
        return false;
    }

    public static boolean verificaArquivo(String caminho) {
        File pasta = new File(caminho);
        if (pasta.isFile()) {
            return true;
        }
        fmt.println("Erro: Pasta nao encontrada!");
        return false;
    }
}
