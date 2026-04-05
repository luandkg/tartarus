package main;

import main.app.futebol.Futebol;
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
                    executarTestes();
                    break;
                case "-futebol":
                    System.out.println("Carregando dados de futebol...");
                    executarFutebol();
                    break;
                case "-documento":
                    System.out.println("Carregando dados de documento...");
                    executarDocumento();
                    break;
                default:
                    System.out.println("Comando desconhecido: " + comando);
            }
        } else {
            System.out.println("Nenhum comando enviado.");
        }
    }

    public static void executarTestes() {
        Lista<Class<?>> testarClasses = new Lista<Class<?>>();
        testarClasses.adicionar(TesteLista.class);
        testarClasses.adicionar(TesteCaixa.class);
        testarClasses.adicionar(TesteTexto.class);
        testarClasses.adicionar(TesteDados.class);
        testarClasses.adicionar(TesteHorario.class);
        testarClasses.adicionar(TesteData.class);
        testarClasses.adicionar(TesteInteiros.class);
        testarClasses.adicionar(TesteFMT.class);
        testarClasses.adicionar(TesteTempo.class);
        testarClasses.adicionar(TesteCronometro.class);
        testarClasses.adicionar(TesteTalvez.class);
        testarClasses.adicionar(TesteCalebeDocumento.class);

        TesteExecutor.TESTAR(testarClasses);

        //TesteExecutor.TESTAR_UNICO(TesteCronometro.class);
    }

    public static void executarFutebol() {
        Futebol jogo = new Futebol();
        jogo.executar();
    }

    public static void executarDocumento() {
        String dados = Texto.ler("arquivos/objetos.calebe");

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

        doc.salvar("arquivos/documento_teste.calebe");

        System.out.println(Texto.ler("arquivos/documento_teste.calebe"));
        fmt.println("------------------------------------------------------");

        CalebeDocumento doc2 = new CalebeDocumento();

        doc2.abrir("arquivos/documento_teste.calebe");
        doc2.salvar("arquivos/documento_teste_2.calebe");

        fmt.println("------------------------------------------------------");
        System.out.println(Texto.ler("arquivos/documento_teste_2.calebe"));

    }
}