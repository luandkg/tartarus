package main;

import main.app.documento.AppDocumento;
import main.app.futebol.AppFutebol;
import main.app.futebol.Futebol;
import main.app.teste.AppTeste;
import main.libs.calebeDocumento.CalebeDocumento;
import main.libs.calebeDocumento.Objeto;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;
import main.libs.teste.TesteExecutor;
import testes.*;


public class Main {

    public static void main(String[] args) {

        if (args.length > 0) {
            String comando = args[0];
            switch (comando) {
                case "-testes":
                    System.out.println("Executando bateria de testes...");
                    AppTeste.executarTestes();
                    break;
                case "-futebol":
                    System.out.println("Carregando dados de futebol...");
                    AppFutebol.executarFutebol();
                    break;
                case "-documento":
                    System.out.println("Carregando dados de documento...");
                    AppDocumento.executarDocumento();
                    break;
                default:
                    System.out.println("Comando desconhecido: " + comando);
            }
        } else {
            System.out.println("Nenhum comando enviado.");
        }
    }
}