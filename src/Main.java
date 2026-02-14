import auxiliar.StringIgualdade;
import estruturas.ItemComPosicao;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TesteExecutor;
import testes.TesteCaixa;
import testes.TesteLista;
import testes.TesteTexto;
import utils.Igualdade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);

        //TesteExecutor.TESTAR(testarClasses);

        String arquivo = "arquivos/Controle de Empenhos.csv";

        String texto = Texto.ler(arquivo);

        Lista<String> linhas = Texto.dividirLinhas(texto);

        //Texto.escrever(arquivo, "Calebe e lindo!");

        for (String linha : linhas){
            //System.out.println("--->"+linha+"<---");

            Lista<String> celulas = Texto.dividirPorSimbolo(linha, "\t");
            for (String celula : celulas){
                //System.out.println("\t+>"+celula);
            }
        }

    }
}