package testes;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;
import main.libs.utils.Talvez;

@TesteClasseCalebe
public class TesteTalvez {

    @TesteCalebe
    public static void Talvez_existe(TestandoCalebe teste) {
        Lista<String> lista = new Lista<>();

        lista.adicionar("ola");
        lista.adicionar("bom");
        lista.adicionar("dia");
        lista.adicionar("vc");
        lista.adicionar("ele");
        lista.adicionar("vc");

        Talvez<String> existeVC = procurarPalavraNaLista(lista,"vc");

        teste.deveSerIgual(true,existeVC.temValor(),"Talvez_existe -> Teste_1");
        teste.deveSerIgual("vc",existeVC.getValor(),"Talvez_existe -> Teste_2");
    }

    @TesteCalebe
    public static void Talvez_nao_existe(TestandoCalebe teste) {
        Lista<String> lista = new Lista<>();

        lista.adicionar("ola");
        lista.adicionar("bom");
        lista.adicionar("dia");
        lista.adicionar("vc");
        lista.adicionar("ele");
        lista.adicionar("vc");

        Talvez<String> existeVC = procurarPalavraNaLista(lista,"jao");

        teste.deveSerIgual(false,existeVC.temValor(),"Talvez_nao_existe -> Teste_1");
    }


    public static Talvez<String> procurarPalavraNaLista(Lista<String> lista, String palavra) {
        for (String item : lista) { // graças ao Iterable
            if (Texto.igual(item, palavra)) {
                return Talvez.TALVEZ(item); // Encontrou a palavra
            }
        }
        return Talvez.NADA(); // Não encontrou
    }

}
