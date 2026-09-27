package main.libs.estruturas;

import java.io.File;
import java.util.List;

public class FS {


    public static Lista<String> listarArquivos(String caminho) {
        File pasta = new File(caminho);
        File[] itens = pasta.listFiles();

        Lista<String> arquivos = new Lista<>();

        if (itens != null) {
            for (File item : itens) {
                if (item.isFile()) {
                    arquivos.adicionar(item.getAbsolutePath());
                }
            }
        }
        return arquivos;
    }

    public static void deletar(String caminho){
        new File(caminho).delete();
    }
}
