package testes;


import main.libs.auxiliar.Ponto;
import main.libs.estruturas.Pilha;
import main.libs.teste.TestandoCalebe;
import main.libs.teste.TesteCalebe;
import main.libs.teste.TesteClasseCalebe;

@TesteClasseCalebe
public class TesteFila {

    @TesteCalebe
    public static void Fila_criar(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_criar -> Teste_1");
    }

    @TesteCalebe
    public static void Fila_esta_vazia(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_esta_vazia -> Teste_1");
        teste.deveSerVerdadeiro(l.estaVazia(), "Fila_esta_vazia -> Teste_2");
    }

    @TesteCalebe
    public static void Fila_inserir(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_inserir -> Teste_1");

        l.empilhar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(), "Fila_inserir -> Teste_2");
        l.empilhar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_inserir -> Teste_3");
        l.empilhar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_inserir -> Teste_4");
    }

    @TesteCalebe
    public static void Fila_quantidade(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_quantidade -> Teste_1");

        l.empilhar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(), "Fila_quantidade -> Teste_2");

        l.empilhar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_quantidade -> Teste_3");

        l.empilhar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_quantidade -> Teste_4");
    }

    @TesteCalebe
    public static void Fila_remover_por_posicao(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_1");

        l.empilhar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_2");

        l.empilhar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_3");

        l.empilhar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_4");

        l.desempilhar();
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_5");

        l.empilhar("quarta");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_6");

        l.desempilhar();
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_7");

        l.empilhar("quinta");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_8");

        l.desempilhar();
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_posicao -> Teste_9");
    }

    @TesteCalebe
    public static void Fila_remover_por_referencia(TestandoCalebe teste) {
        Pilha<String> l = new Pilha<String>();
        teste.deveSerIgual(0, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_1");

        l.empilhar("primeira");
        teste.deveSerIgual(1, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_2");

        l.empilhar("segunda");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_3");

        l.empilhar("terceira");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_4");

        //l.removerReferencia("primeira");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_5");

        l.empilhar("quarta");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_6");

        //l.removerReferencia("quarta");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_7");

        l.empilhar("quinta");
        teste.deveSerIgual(3, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_8");

        //l.removerReferencia("terceira");
        teste.deveSerIgual(2, l.getQuantidade(), "Fila_remover_por_referencia -> Teste_9");
    }

    @TesteCalebe
    public static void Fila_remover_por_valor(TestandoCalebe teste) {
        Ponto ponto = new Ponto(1, 5);

        Pilha<Ponto> l = new Pilha<Ponto>();

        l.empilhar(new Ponto(0, 6));

        l.empilhar(ponto);
        l.empilhar(new Ponto(2, 4));
        l.empilhar(new Ponto(3, 3));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(5, 1));
        l.empilhar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade(), "Fila_remover_por_valor -> Teste_1");

        l.desempilhar();
        teste.deveSerIgual(6, l.getQuantidade(), "Fila_remover_por_valor -> Teste_2");

        //l.removerReferencia(ponto);
        teste.deveSerIgual(5, l.getQuantidade(), "Fila_remover_por_valor -> Teste_3");

        //l.removerValor(new Ponto(6, 0), new PontoIgualdade());
        teste.deveSerIgual(4, l.getQuantidade(), "Fila_remover_por_valor -> Teste_4");
    }

    @TesteCalebe
    public static void Fila_set(TestandoCalebe teste) {
        Pilha<Ponto> l = new Pilha<Ponto>();

        l.empilhar(new Ponto(0, 6));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(2, 4));
        l.empilhar(new Ponto(3, 3));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(5, 1));
        l.empilhar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade(), "Fila_set -> Teste_1");

        //teste.deveSerIgual(0, l.get(0).getX(),"Fila_set -> Teste_2");
        //teste.deveSerIgual(6, l.get(0).getY(),"Fila_set -> Teste_3");

        //l.set(0, new Ponto(9, 9));

        //teste.deveSerIgual(9, l.get(0).getX(),"Fila_set -> Teste_4");
        //teste.deveSerIgual(9, l.get(0).getY(),"Fila_set -> Teste_5");
    }

    @TesteCalebe
    public static void Fila_set_posicao_invalida(TestandoCalebe teste) {
        Pilha<Ponto> l = new Pilha<Ponto>();

        l.empilhar(new Ponto(0, 6));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(2, 4));
        l.empilhar(new Ponto(3, 3));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(5, 1));
        l.empilhar(new Ponto(6, 0));
        teste.deveSerIgual(7, l.getQuantidade(), "Fila_set_posicao_invalida -> Teste_1");

        try {
            //l.set(8, new Ponto(9, 9));
            teste.falhar("Fila_set_posicao_invalida -> Teste_2");
        } catch (Exception e) {
            teste.deveSerIgual("Erro: Posicao nao encontrada!", e.getMessage(), "Fila_set_posicao_invalida -> Teste_3");
        }
    }

    @TesteCalebe
    public static void Fila_existe_valor(TestandoCalebe teste) {
        Pilha<Ponto> l = new Pilha<Ponto>();

        l.empilhar(new Ponto(0, 6));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(2, 4));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(4, 5));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(3, 5));

        teste.deveSerIgual(12, l.getQuantidade(), "Fila_existe_valor -> Teste_1");

        //teste.deveSerVerdadeiro(l.existeValor(new Ponto(1, 5), new PontoIgualdade()),"Fila_existe_valor -> Teste_2");

        //teste.deveSerFalso(l.existeValor(new Ponto(8, 2), new PontoIgualdade()),"Fila_existe_valor -> Teste_3");
    }

    @TesteCalebe
    public static void Fila_contagem_valor(TestandoCalebe teste) {
        Pilha<Ponto> l = new Pilha<Ponto>();

        l.empilhar(new Ponto(0, 6));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(2, 4));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(4, 5));
        l.empilhar(new Ponto(4, 2));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(1, 5));
        l.empilhar(new Ponto(3, 5));

        teste.deveSerIgual(12, l.getQuantidade(), "Fila_contagem_valor -> Teste_1");

        //teste.deveSerIgual(6, l.contarValor(new Ponto(1, 5), new PontoIgualdade()),"Fila_contagem_valor -> Teste_2");

        //teste.deveSerIgual(2, l.contarValor(new Ponto(4, 2), new PontoIgualdade()),"Fila_contagem_valor -> Teste_3");
    }

    @TesteCalebe
    public static void Fila_percarrendo_itens(TestandoCalebe teste) {
        Pilha<Integer> pilhaInteger = new Pilha<>();

        pilhaInteger.empilhar(55);
        pilhaInteger.empilhar(33);
        pilhaInteger.empilhar(22);

        int cont = 0;
        //for (int i : pilhaInteger) {
        //cont++;
        //}
        teste.deveSerIgual(3, cont, "Fila_percarrendo_itens -> Teste_1");
    }

    @TesteCalebe
    public static void Fila_retorna_item_e_posicao(TestandoCalebe teste) {
        Pilha<Integer> pilhaInteger = new Pilha<>();

        pilhaInteger.empilhar(55);
        pilhaInteger.empilhar(33);
        pilhaInteger.empilhar(22);
        teste.deveSerIgual(3, pilhaInteger.getQuantidade(), "Fila_retorna_item_e_posicao -> Teste_1");

        //ItemComPosicao<Integer> t1 = pilhaInteger.getItensComPosicao().get(0);
        //teste.deveSerIgual(55, t1.getItem(), "Fila_retorna_item_e_posicao -> Teste_2");
        //teste.deveSerIgual(0, t1.getPosicao(), "Fila_retorna_item_e_posicao -> Teste_3");

        //ItemComPosicao<Integer> t2 = pilhaInteger.getItensComPosicao().get(1);
        //teste.deveSerIgual(33, t2.getItem(), "Fila_retorna_item_e_posicao -> Teste_4");
        //teste.deveSerIgual(1, t2.getPosicao(), "Fila_retorna_item_e_posicao -> Teste_5");

        //ItemComPosicao<Integer> t3 = pilhaInteger.getItensComPosicao().get(2);
        //teste.deveSerIgual(22, t3.getItem(), "Fila_retorna_item_e_posicao -> Teste_6");
        //teste.deveSerIgual(2, t3.getPosicao(), "Fila_retorna_item_e_posicao -> Teste_7");
    }

    @TesteCalebe
    public static void Fila_filtrar(TestandoCalebe teste) {
        Pilha<Integer> num = new Pilha<>();

        num.empilhar(0);
        num.empilhar(1);
        num.empilhar(2);
        num.empilhar(3);
        num.empilhar(4);
        num.empilhar(5);


        //Pilha<Integer> pilha = num.filtrar(new Condicional<Integer>() {
        //@Override
        //public boolean condicao(Integer a, Integer b) {
        //return a < b;
        //}
        //}, 3);

        //teste.deveSerIgual(3, pilha.getQuantidade(),"Fila_filtrar -> Teste_1");

        //teste.deveSerIgual(0, pilha.get(0),"Fila_filtrar -> Teste_2");
        //teste.deveSerIgual(1, pilha.get(1),"Fila_filtrar -> Teste_3");
        //teste.deveSerIgual(2, pilha.get(2),"Fila_filtrar -> Teste_4");

        //Ferramenta.printDuasListas(num,lista);
    }

    @TesteCalebe
    public static void Fila_filtrar_parametrizado(TestandoCalebe teste) {
        Pilha<Integer> num = new Pilha<>();

        num.empilhar(0);
        num.empilhar(1);
        num.empilhar(2);
        num.empilhar(3);
        num.empilhar(4);
        num.empilhar(5);

        /*
        Pilha<Integer> pilha = num.filtrar(new CondicionalParametrizado<Integer, String>() {
            @Override
            public String getValor() {
                return "2";
            }

            @Override
            public boolean condicao(Integer a) {
                if(Texto.terminaCom(a.toString(), getValor())){
                    return true;
                }
                return false;
            }

        });

        */

        //teste.deveSerIgual(1, pilha.getQuantidade(), "Fila_filtrar_parametrizado -> Teste_1");

        //teste.deveSerIgual(2, pilha.get(0), "Fila_filtrar_parametrizado -> Teste_2");

        //Ferramenta.printDuasListas(num,lista);
    }

    @TesteCalebe
    public static void Fila_clonar(TestandoCalebe teste) {
        Pilha<Integer> lInt = new Pilha<>();

        lInt.empilhar(0);
        lInt.empilhar(1);
        lInt.empilhar(2);
        lInt.empilhar(3);
        lInt.empilhar(4);
        lInt.empilhar(5);

        teste.deveSerIgual(6, lInt.getQuantidade(), "Fila_clonar -> Teste_1");

        Pilha<Integer> clone = new Pilha<>();

        teste.deveSerIgual(0, clone.getQuantidade(), "Fila_clonar -> Teste_2");

        //clone = lInt.clonar();

        teste.deveSerIgual(clone.getQuantidade(), lInt.getQuantidade(), "Fila_clonar -> Teste_3");

        /*
        if (clone.getQuantidade() == lInt.getQuantidade()) {
            for (int i = 0; i < lInt.getQuantidade(); i++) {
                teste.deveSerIgual(clone.get(i), lInt.get(i), "Fila_clonar -> Teste_4");
            }
        }*/

        //Ferramenta.printDuasListas(lInt,clone);
    }

    @TesteCalebe
    public static void Fila_limpar(TestandoCalebe teste) {
        Pilha<Integer> lInt = new Pilha<>();

        lInt.empilhar(0);
        lInt.empilhar(1);
        lInt.empilhar(2);
        lInt.empilhar(3);
        lInt.empilhar(4);
        lInt.empilhar(5);

        teste.deveSerIgual(6, lInt.getQuantidade(), "Fila_limpar -> Teste_1");

        //lInt.limpar();

        teste.deveSerIgual(0, lInt.getQuantidade(), "Fila_limpar -> Teste_2");

    }

    @TesteCalebe
    public static void Fila_Adicionar_Antes(TestandoCalebe teste) {
        Pilha<String> semana = new Pilha<>();

        semana.empilhar("Segunda");
        semana.empilhar("Terça");
        semana.empilhar("Quinta");
        semana.empilhar("Sexta");
        //teste.deveSerIgual(semana.get(2), "Quinta", "Fila_Adicionar_Antes -> Teste_1");
        teste.deveSerIgual(semana.getQuantidade(), 4, "Fila_Adicionar_Antes -> Teste_2");

        //semana.inserirAntes(2, "Quarta");

        //teste.deveSerIgual(semana.get(2), "Quarta", "Fila_Adicionar_Antes -> Teste_3");
        teste.deveSerIgual(semana.getQuantidade(), 5, "Fila_Adicionar_Antes -> Teste_4");

        //semana.exibirLista();
    }

    @TesteCalebe
    public static void Fila_Adicionar_Depois(TestandoCalebe teste) {
        Pilha<String> semana = new Pilha<>();

        semana.empilhar("Segunda");
        semana.empilhar("Terça");
        semana.empilhar("Quarta");
        semana.empilhar("Sexta");
        //teste.deveSerIgual(semana.get(3), "Sexta", "Fila_Adicionar_Depois -> Teste_1");
        teste.deveSerIgual(semana.getQuantidade(), 4, "Fila_Adicionar_Depois -> Teste_2");

        //semana.inserirDepois(2, "Quinta");

        //teste.deveSerIgual(semana.get(3), "Quinta", "Fila_Adicionar_Depois -> Teste_3");
        teste.deveSerIgual(semana.getQuantidade(), 5, "Fila_Adicionar_Depois -> Teste_4");

        //semana.exibirLista();
    }
}
