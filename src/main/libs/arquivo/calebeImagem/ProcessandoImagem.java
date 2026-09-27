package main.libs.arquivo.calebeImagem;

import main.app.editor.ImagemEditor;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;

public record ProcessandoImagem(Lista<String> linhas, String versao, ImagemEditor editor){

    public static ProcessandoImagem obterCabecalho(String caminho){
        String dados = Texto.ler(caminho);
        String versao = "";

        Lista<String> linhas = Texto.dividirLinhas(dados);

        ImagemEditor editor = new ImagemEditor(1, 1);

        for (String linha : linhas) {
            if (Texto.comecaCom(linha, "!")) {
                Lista<String> imagem = Texto.dividirPorSimbolo(linha, ' ');
                //imagem.exibirLista();
                versao = imagem.get(1);
                Lista<String> tamanhos = Texto.dividirPorSimbolo(imagem.get(imagem.getQuantidade() - 1), 'x');
                //tamanhos.exibirLista();
                editor = new ImagemEditor(Integer.parseInt(tamanhos.get(0)), Integer.parseInt(tamanhos.get(1)));
                break;
            }
        }
        return new ProcessandoImagem(linhas, versao, editor);
    }

}
