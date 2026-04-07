package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Estrutura {
    public static void criarEstrutura() {
        String[] pastas = {
                "arquivos/documentos",
                "arquivos/futebol",
                "arquivos/imagens",
                "arquivos/outros",
                "arquivos/testes"
        };

        try {
            for (String caminho : pastas) {
                Files.createDirectories(Paths.get(caminho));
            }
            System.out.println("Estrutura de pastas verificada/criada com sucesso.");
        } catch (IOException e) {
            System.err.println("Falha crítica ao criar diretórios: " + e.getMessage());
        }
    }
}
