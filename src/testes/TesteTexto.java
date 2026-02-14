package testes;

import auxiliar.StringIgualdade;
import estruturas.Lista;
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
}
