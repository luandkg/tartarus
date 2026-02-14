package testes;

import auxiliar.StringIgualdade;
import estruturas.Lista;
import estruturas.Texto;
import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteTexto {

    @TesteCalebe
    public static void Texto_igualdade_entre_Strings(TestandoCalebe teste){
        Lista<String> listaS = new Lista<>();

        listaS.adicionar("Fedorento");
        listaS.adicionar("Fedorento");
        listaS.adicionar("Luan");
        listaS.adicionar("Fedorento");

        int cont = listaS.contarValor("Fedorento",  new StringIgualdade());
        teste.deveSerIgual(3, cont);
    }

    @TesteCalebe
    public static void Texto_transforma_em_minusculo(TestandoCalebe teste){

        String texto = "O GAMBA É FEDORENTO!";
        String textoMinusculo = Texto.minusculo(texto);

        teste.deveSerIgual("o gamba é fedorento!", textoMinusculo);

    }

    @TesteCalebe
    public static void Texto_transforma_em_maiusculo(TestandoCalebe teste){

        String texto = "o gamba é fedorento!";
        String textoMaiuscula = Texto.maiusculo(texto);

        teste.deveSerIgual("O GAMBA É FEDORENTO!", textoMaiuscula);

    }
}
