package main.app.documento;

import main.libs.calebeDocumento.CalebeDocumento;
import main.libs.calebeDocumento.Objeto;
import main.libs.estruturas.Texto;
import main.libs.estruturas.fmt;

public class AppDocumento {

    public static void executarDocumento() {
        String dados = Texto.ler("arquivos/documentos/objetos.calebe");

        fmt.println("------------------------------------------------------");
        fmt.println("{}", dados);
        fmt.println("------------------------------------------------------");


        CalebeDocumento doc = new CalebeDocumento();

        Objeto pessoa = new Objeto("Pessoa");
        pessoa.atributo("Nome","Calebe Alves Freitas");
        pessoa.atributo("Idade","24");
        pessoa.atributo("Altura","1.63");
        pessoa.atributo("Profissao","Militar");
        Objeto habilidade = new Objeto("Habilidade");
        habilidade.atributo("Nome","Jogar Futebol");
        habilidade.atributo("Valor","50");
        habilidade.atributo("Eficacia","78%");
        doc.objetoUnico("Pessoas").getObjetos().adicionar(pessoa);
        pessoa.objetoUnico("Habilidades").getObjetos().adicionar(habilidade);


        // Exemplo 1
        Objeto pessoa1 = new Objeto("Pessoa");
        pessoa1.atributo("Nome", "Ana Souza");
        pessoa1.atributo("Idade", "31");
        pessoa1.atributo("Altura", "1.70");
        pessoa1.atributo("Profissao", "Engenheira");
        doc.objetoUnico("Pessoas").getObjetos().adicionar(pessoa1);

        // Exemplo 2
        Objeto pessoa2 = new Objeto("Pessoa");
        pessoa2.atributo("Nome", "Bruno Oliveira");
        pessoa2.atributo("Idade", "28");
        pessoa2.atributo("Altura", "1.85");
        pessoa2.atributo("Profissao", "Desenvolvedor");
        doc.objetoUnico("Pessoas").getObjetos().adicionar(pessoa2);

        // Exemplo 3
        Objeto pessoa3 = new Objeto("Pessoa");
        pessoa3.atributo("Nome", "Carla Dias");
        pessoa3.atributo("Idade", "45");
        pessoa3.atributo("Altura", "1.58");
        pessoa3.atributo("Profissao", "Professora");
        doc.objetoUnico("Pessoas").getObjetos().adicionar(pessoa3);

        doc.objetoUnico("Pessoas").objetoCriar("Pessoa").atributo("Nome","Pessoa Sem Dados");

        fmt.println("Quantidade de Pessoas = {}",doc.objetoUnico("Pessoas").getObjetos().getQuantidade());

        doc.salvar("arquivos/documentos/documento_teste.calebe");

        System.out.println(Texto.ler("arquivos/documentos/documento_teste.calebe"));
        fmt.println("------------------------------------------------------");

        CalebeDocumento doc2 = new CalebeDocumento();

        doc2.abrir("arquivos/documentos/documento_teste.calebe");
        doc2.salvar("arquivos/documentos/documento_teste_2.calebe");

        fmt.println("------------------------------------------------------");
        System.out.println(Texto.ler("arquivos/documentos/documento_teste_2.calebe"));

    }
}
