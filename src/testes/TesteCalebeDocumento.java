package testes;

import main.libs.calebeDocumento.CalebeDocumento;
import main.libs.calebeDocumento.Objeto;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteCalebeDocumento {

    @TesteCalebe
    public static void criarObjetoVerficaSeExiste(TestandoCalebe teste) {

        CalebeDocumento documento = new CalebeDocumento();

        teste.deveSerIgual(0, documento.getObjetos().getQuantidade(), "criarObjetoVerficaSeExiste -> Teste_1");

        documento.objetoCriar("Habilidades");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "criarObjetoVerficaSeExiste -> Teste_2");
        teste.deveSerIgual(true, documento.objetoExiste("Habilidades"), "criarObjetoVerficaSeExiste -> Teste_3");

        documento.objetoUnico("Poderes");
        teste.deveSerIgual(2, documento.getObjetos().getQuantidade(), "criarObjetoVerficaSeExiste -> Teste_4");
        teste.deveSerIgual(false, documento.objetoExiste("Pessoas"), "criarObjetoVerficaSeExiste -> Teste_5");

        teste.deveSerIgual(2, documento.getObjetos().getQuantidade(), "criarObjetoVerficaSeExiste -> Teste_6");

    }

    @TesteCalebe
    public static void removeObjetoVerficaSeExiste(TestandoCalebe teste) {

        CalebeDocumento documento = new CalebeDocumento();

        teste.deveSerIgual(0, documento.getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_1");

        documento.objetoCriar("Habilidades");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_2");
        teste.deveSerIgual(true, documento.objetoExiste("Habilidades"), "removeObjetoVerficaSeExiste -> Teste_3");

        documento.objetoUnico("Habilidades").objetoCriar("Força");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_4");
        teste.deveSerIgual(true, documento.objetoExiste("Habilidades"), "removeObjetoVerficaSeExiste -> Teste_5");
        documento.objetoUnico("Habilidades").objetoRemover("Força");
        teste.deveSerIgual(0, documento.objetoUnico("Habilidades").getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_6");
        teste.deveSerIgual(false, documento.objetoUnico("Habilidades").objetoExiste("Força"), "removeObjetoVerficaSeExiste -> Teste_7");

        documento.objetoUnico("Poderes");
        teste.deveSerIgual(2, documento.getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_8");
        teste.deveSerIgual(true, documento.objetoExiste("Poderes"), "removeObjetoVerficaSeExiste -> Teste_9");

        documento.objetoRemover("Poderes");
        teste.deveSerIgual(false, documento.objetoExiste("Poderes"), "removeObjetoVerficaSeExiste -> Teste_10");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "removeObjetoVerficaSeExiste -> Teste_11");
    }

    @TesteCalebe
    public static void criaAtributoVerficaSeExiste(TestandoCalebe teste) {

        CalebeDocumento documento = new CalebeDocumento();

        teste.deveSerIgual(0, documento.getObjetos().getQuantidade(), "criaAtributoVerficaSeExiste -> Teste_1");

        documento.objetoUnico("Poderes");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "criaAtributoVerficaSeExiste -> Teste_2");
        teste.deveSerIgual(true, documento.objetoExiste("Poderes"), "criaAtributoVerficaSeExiste -> Teste_3");

        documento.objetoUnico("Poderes").atributo("Força","50");

        teste.deveSerIgual(true,documento.objetoUnico("Poderes").atributoExiste("Força"), "criaAtributoVerficaSeExiste -> Teste_4");

        teste.deveSerIgual("50",documento.objetoUnico("Poderes").getAtributo("Força").getValor(), "criaAtributoVerficaSeExiste -> Teste_5");
        teste.deveSerDiferente("70",documento.objetoUnico("Poderes").getAtributo("Força").getValor(), "criaAtributoVerficaSeExiste -> Teste_6");

        teste.deveSerIgual(false,documento.objetoUnico("Poderes").atributoExiste("Velocidade"), "criaAtributoVerficaSeExiste -> Teste_7");

        teste.deveSerIgual(true, documento.objetoExiste("Poderes"), "criaAtributoVerficaSeExiste -> Teste_8");

        teste.deveSerIgual(1, documento.objetoUnico("Poderes").getAtributos().getQuantidade(), "criaAtributoVerficaSeExiste -> Teste_9");
    }

    @TesteCalebe
    public static void removeAtributoVerficaSeExiste(TestandoCalebe teste) {

        CalebeDocumento documento = new CalebeDocumento();

        teste.deveSerIgual(0, documento.getObjetos().getQuantidade(), "removeAtributoVerficaSeExiste -> Teste_1");

        documento.objetoUnico("Poderes");
        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "removeAtributoVerficaSeExiste -> Teste_2");
        teste.deveSerIgual(true, documento.objetoExiste("Poderes"), "removeAtributoVerficaSeExiste -> Teste_3");

        documento.objetoUnico("Poderes").atributo("Força","50");

        teste.deveSerIgual(true,documento.objetoUnico("Poderes").atributoExiste("Força"), "removeAtributoVerficaSeExiste -> Teste_4");

        documento.objetoUnico("Poderes").atributoRemover("Força");
        teste.deveSerIgual(false,documento.objetoUnico("Poderes").atributoExiste("Força"), "removeAtributoVerficaSeExiste -> Teste_4");
    }


    @TesteCalebe
    public static void parserCalebeDocumento(TestandoCalebe teste) {

        CalebeDocumento documento = new CalebeDocumento();

        teste.deveSerIgual(0, documento.getObjetos().getQuantidade(), "parserCalebeDocumento -> Teste_1");

        documento.parse("!Documento [@Autor=\"Calebe Alves Freitas\" @Versao=\"1.0\"] { !Valor [] {} !Valor [] {} }");

        teste.deveSerIgual(1, documento.getObjetos().getQuantidade(), "parserCalebeDocumento -> Teste_2");

        teste.deveSerIgual(true, documento.objetoExiste("Documento"), "parserCalebeDocumento -> Teste_3");

        teste.deveSerIgual(2, documento.objetoUnico("Documento").getObjetos().getQuantidade(), "parserCalebeDocumento -> Teste_4");

        Objeto o1 = documento.objetoUnico("Documento").getObjetos().get(0);
        Objeto o2 = documento.objetoUnico("Documento").getObjetos().get(1);

        teste.deveSerIgual("Valor", o1.getNome(), "parserCalebeDocumento -> Teste_5");
        teste.deveSerIgual("Valor", o2.getNome(), "parserCalebeDocumento -> Teste_6");

    }


}
