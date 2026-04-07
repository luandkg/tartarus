package main;

import main.app.documento.AppDocumento;
import main.app.editor.AppEditorImagem;
import main.app.futebol.AppFutebol;
import main.app.teste.AppTeste;

import static main.Estrutura.criarEstrutura;


public class Main {

    public static void main(String[] args) {
        criarEstrutura();

        if (args.length > 0) {
            String comando = args[0];
            switch (comando) {
                case "-testes":
                    System.out.println("Executando Bateria de Testes...");
                    AppTeste.executarTestes();
                    break;
                case "-futebol":
                    System.out.println("Carregando Aplicação Futebol...");
                    AppFutebol.executarFutebol();
                    break;
                case "-documento":
                    System.out.println("Carregando Dados de Documento...");
                    AppDocumento.executarDocumento();
                    break;
                case "-editorDeImagem":
                    System.out.println("Carregando Editor de Imagem...");
                    AppEditorImagem.executar();
                    break;
                default:
                    System.out.println("Comando desconhecido: " + comando);
            }
        } else {
            System.out.println("Nenhum comando enviado.");
        }
    }
}