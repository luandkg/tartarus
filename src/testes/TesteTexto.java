package testes;

import main.libs.auxiliar.StringIgualdade;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

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

    @TesteCalebe
    public static void Texto_remove_String(TestandoCalebe teste){
        String t = "[ ( Textando : Luan ) ]";
        t = Texto.removeString(t,"[ ( ");
        teste.deveSerVerdadeiro(Texto.terminaCom("Textando : Luan ) ]", t),"Texto_remove_String -> Teste_1");

        t = Texto.removeString(t," )");
        teste.deveSerVerdadeiro(Texto.terminaCom("Textando : Luan ]", t),"Texto_remove_String -> Teste_2");

        t = Texto.removeString(t," ]");
        teste.deveSerVerdadeiro(Texto.terminaCom("Textando : Luan", t),"Texto_remove_String -> Teste_3");
    }

    @TesteCalebe
    public static void Texto_existe_String(TestandoCalebe teste){
        String t = "[ ( Textando : Luan ) ]";
        teste.deveSerVerdadeiro(Texto.existeString(t,"Textando"),"Texto_existe_String -> Teste_1");

        teste.deveSerVerdadeiro(Texto.existeString(t,"Luan"),"Texto_existe_String -> Teste_2");

        teste.deveSerVerdadeiro(Texto.existeString(t,"]"),"Texto_existe_String -> Teste_3");

    }

}
