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
        teste.deveSerIgual(3, cont,"Texto_igualdade_entre_Strings -> Teste_1");
    }

    @TesteCalebe
    public static void Texto_transforma_em_minusculo(TestandoCalebe teste){

        String texto = "O GAMBA É FEDORENTO!";
        String textoMinusculo = Texto.minusculo(texto);

        teste.deveSerIgual("o gamba é fedorento!", textoMinusculo,"Texto_transforma_em_minusculo -> Teste_1");

    }

    @TesteCalebe
    public static void Texto_transforma_em_maiusculo(TestandoCalebe teste){

        String texto = "o gamba é fedorento!";
        String textoMaiuscula = Texto.maiusculo(texto);

        teste.deveSerIgual("O GAMBA É FEDORENTO!", textoMaiuscula,"Texto_transforma_em_maiusculo -> Teste_1");

    }

    @TesteCalebe
    public static void Texto_compara_se_comeca_com(TestandoCalebe teste){
        teste.deveSerVerdadeiro(Texto.comecaCom("Ola mundo!", "Ol"),"Texto_compara_se_comeca_com -> Teste_1");
        teste.deveSerFalso(Texto.comecaCom("Ola mundo!", "a"),"Texto_compara_se_comeca_com -> Teste_2");
        teste.deveSerFalso(Texto.comecaCom("Ola mundo!", "ffffff"),"Texto_compara_se_comeca_com -> Teste_3");
        teste.deveSerFalso(Texto.comecaCom("Ola mundo!", "la"),"Texto_compara_se_comeca_com -> Teste_4");
        teste.deveSerFalso(Texto.comecaCom("Ola mundo!", "ola"),"Texto_compara_se_comeca_com -> Teste_5");
    }

    @TesteCalebe
    public static void Texto_compara_se_termina_com(TestandoCalebe teste){
        teste.deveSerVerdadeiro(Texto.terminaCom("Ola mundo!", "!"),"Texto_compara_se_termina_com -> Teste_1");
        teste.deveSerFalso(Texto.terminaCom("Ola mundo!", "a"),"Texto_compara_se_termina_com -> Teste_2");
        teste.deveSerFalso(Texto.terminaCom("Ola mundo!", "ffffff"),"Texto_compara_se_termina_com -> Teste_3");
        teste.deveSerFalso(Texto.terminaCom("Ola mundo!", "la"),"Texto_compara_se_termina_com -> Teste_4");
        teste.deveSerFalso(Texto.terminaCom("Ola mundo!", "UNDO!"),"Texto_compara_se_termina_com -> Teste_5");
    }
}
