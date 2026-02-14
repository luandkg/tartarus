package estruturas;
import utils.Serializavel;

public class IO {

    public static <T> void guardar(String arquivo, Lista<T> lista, Serializavel<T> serializavel){
        String texto = "";
        int cont = 1;

        for (T item : lista){
            if(cont==lista.getQuantidade()){
                texto += serializavel.transforma(item);
            }else{
                texto += serializavel.transforma(item)+"\n";
            }
            cont++;
        }

        Texto.escrever(arquivo,texto);
    }

    public static <T> Lista<T> abrir(String arquivo, Serializavel<T> serializavel){
        Lista<T> lista = new Lista<>();

        String texto = Texto.ler(arquivo);

        for (String linha : Texto.dividirLinhas(texto)){
            if(linha.length()>0){
                T valor = serializavel.destransforma(linha);
                lista.adicionar(valor);
            }
        }

        return lista;
    }
}
