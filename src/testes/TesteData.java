package testes;

import libs.teste.TestandoCalebe;
import libs.teste.TesteCalebe;
import libs.teste.TesteClasseCalebe;
import tempo.Data;

@TesteClasseCalebe
public class TesteData {

    @TesteCalebe
    public static void Data_valida(TestandoCalebe teste){
        Data data1 = new Data(1,1,1);

        teste.deveSerVerdadeiro(data1.validar(),"Data_valida -> Teste_1");
    }

    @TesteCalebe
    public static void Data_invalida(TestandoCalebe teste){
        try{
            Data data1 = new Data(1,1,0);
            teste.falhar("Data_invalida -> Teste_1");
        }catch (Exception e){
            teste.deveSerIgual("Erro: Data invalida!",e.getMessage(),"Data_invalida -> Teste_2");
        }


        try{
            Data data2 = new Data(1,0,1);
            teste.falhar("Data_invalida -> Teste_3");
        }catch (Exception e){
            teste.deveSerIgual("Erro: Data invalida!",e.getMessage(),"Data_invalida -> Teste_4");
        }


        try{
            Data data3 = new Data(0,1,1);
            teste.falhar("Data_invalida -> Teste_5");
        }catch (Exception e){
            teste.deveSerIgual("Erro: Data invalida!",e.getMessage(),"Data_invalida -> Teste_6");
        }
    }

    @TesteCalebe
    public static void Data_igual(TestandoCalebe teste){
        Data data1 = new Data(1,1,1);
        Data data2 = new Data(1,1,1);

        teste.deveSerVerdadeiro(Data.igual(data1,data2),"Data_igual -> Teste_1");
    }

    @TesteCalebe
    public static void Data_diferente(TestandoCalebe teste){
        Data data1 = new Data(1,1,1);
        Data data2 = new Data(31,12,9999);

        teste.deveSerVerdadeiro(Data.diferente(data1,data2),"Data_diferente -> Teste_1");
    }



    @TesteCalebe
    public static void Data_maior(TestandoCalebe teste){
        Data data1 = new Data(31,12,9999);
        Data data2 = new Data(1,1,1);

        teste.deveSerVerdadeiro(Data.maior(data1,data2),"Data_maior -> Teste_1");
    }

    @TesteCalebe
    public static void Data_menor(TestandoCalebe teste){
        Data data1 = new Data(1,1,1);
        Data data2 = new Data(31,12,9999);

        teste.deveSerVerdadeiro(Data.menor(data1,data2),"Data_menor -> Teste_1");

    }

    @TesteCalebe
    public static void Data_maior_ou_igual(TestandoCalebe teste){
        Data data1 = new Data(31,12,9999);
        Data data2 = new Data(31,12,9999);
        Data data3 = new Data(1,1,1);

        teste.deveSerVerdadeiro(Data.igual(data1,data2),"Data_maior_ou_igual -> Teste_1");
        teste.deveSerVerdadeiro(Data.maior(data1,data3),"Data_maior_ou_igual -> Teste_2");

        teste.deveSerVerdadeiro(Data.maiorOuIgual(data1,data3),"Data_maior_ou_igual -> Teste_3");
    }

    @TesteCalebe
    public static void Data_menor_ou_igual(TestandoCalebe teste){
        Data data1 = new Data(1,1,1);
        Data data2 = new Data(1,1,1);
        Data data3 = new Data(31,12,9999);

        teste.deveSerVerdadeiro(Data.igual(data1,data2),"Data_menor_ou_igual -> Teste_1");
        teste.deveSerVerdadeiro(Data.menor(data1,data3),"Data_menor_ou_igual -> Teste_2");

        teste.deveSerVerdadeiro(Data.menorOuIgual(data1,data3),"Data_menor_ou_igual -> Teste_3");
    }

    @TesteCalebe
    public static void Data_dia_da_semana_simples(TestandoCalebe teste){
        Data data1 = new Data(1,3,2026);
        Data data2 = new Data(23,3,2002);
        Data data3 = new Data(27,7,1992);

        teste.deveSerIgual("Domingo",data1.getDiaDaSemana().diaSimples(),"Data_dia_da_semana -> Teste_1");
        teste.deveSerIgual("Sabado",data2.getDiaDaSemana().diaSimples(),"Data_dia_da_semana -> Teste_2");
        teste.deveSerIgual("Segunda",data3.getDiaDaSemana().diaSimples(),"Data_dia_da_semana -> Teste_3");

    }

    @TesteCalebe
    public static void Data_dia_da_semana_composto(TestandoCalebe teste){
        Data data1 = new Data(1,3,2026);
        Data data2 = new Data(23,3,2002);
        Data data3 = new Data(27,7,1992);

        teste.deveSerIgual("Domingo",data1.getDiaDaSemana().diaComposto(),"Data_dia_da_semana_composto -> Teste_1");
        teste.deveSerIgual("Sabado",data2.getDiaDaSemana().diaComposto(),"Data_dia_da_semana_composto -> Teste_2");
        teste.deveSerIgual("Segunda-Feira",data3.getDiaDaSemana().diaComposto(),"Data_dia_da_semana_composto -> Teste_3");

    }

    @TesteCalebe
    public static void Data_dia_da_semana_sigla(TestandoCalebe teste){
        Data data1 = new Data(1,3,2026);
        Data data2 = new Data(23,3,2002);
        Data data3 = new Data(27,7,1992);

        teste.deveSerIgual("Dom",data1.getDiaDaSemana().diaEmSigla(),"Data_dia_da_semana_sigla -> Teste_1");
        teste.deveSerIgual("Sab",data2.getDiaDaSemana().diaEmSigla(),"Data_dia_da_semana_sigla -> Teste_2");
        teste.deveSerIgual("Seg",data3.getDiaDaSemana().diaEmSigla(),"Data_dia_da_semana_sigla -> Teste_3");

    }
}