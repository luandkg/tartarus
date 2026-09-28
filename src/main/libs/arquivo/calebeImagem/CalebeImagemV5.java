package main.libs.arquivo.calebeImagem;

import main.app.editor.Cor;
import main.app.editor.ImagemEditor;
import main.libs.arquivo.calebeImagem.utils.Componentizador;
import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;
import main.libs.estruturas.fmt;
import org.w3c.dom.Text;

import java.awt.image.BufferedImage;

public class CalebeImagemV5 {

    public static void ler(Lista<String> linhas, ImagemEditor editor) {
        Lista<String> historico = new Lista<String>();
        int y = 0;

        for (String linha : linhas) {
            //fmt.println("---------------------");

            //fmt.println("Lendo linha: " + y);
            if (Texto.comecaCom(linha, "[")) {
                historico.inserirAntes(0, linha);
                transformaLinhaV2(y, linha, editor);
                y++;
            } else if (Texto.comecaCom(linha, "#")) {

                String asdas = "--------------------";

                //fmt.println("Cheguei na edição do #: ");

                String nLinha = Texto.limpandoCaracteres(linha);
                //fmt.println("linha: " + nLinha);

                for (int x = 0; x< editor.getLargura(); x++){
                    Cor cor = new Cor(editor.getImagem().getRGB(x,(y)-(Integer.parseInt(nLinha))));
                    editor.getImagem().setRGB(x,y,cor.getValor());
                }

                y++;
            } else if (Texto.comecaCom(linha, "+")) {
                //fmt.println("Cheguei na edição do +: ");
                transformaLinhaV5(y, listaDeComponentesV5(linha), listaDeCoresV5(linha), editor);
                y++;
            }


        }
    }

    public static String toNumero(int componente){
        String c = String.valueOf(componente);

        if(c.length()==1){
            c ="00"+c;
        }else if(c.length()==2){
            c ="0"+c;
        }

        return c;
    }

    public static String confirmaComponente(boolean val, int componente){
        if(val){
            return toNumero(componente);
        }else{
            return "_";
        }
    }

    public static String alteraPixel(boolean componentes, String letra, int valor){
        if(componentes){
            return letra;
        }else{
            return toNumero(valor);
        }
    }

    public static void salvar(BufferedImage imagem, String arquivo) {
        Lista<String> historico = new Lista<String>();
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        String linhaAnterior = "";
        TextoDocumento dados = new TextoDocumento();

        dados.adicionarLinha("!Imagem " + CalebeImagem.V5 + " :: " + largura + "x" + altura + "\n");

        for (int y = 0; y < altura; y++) {

            Componentizador componentes = Componentizador.processar(imagem, y, largura);

            String linha = "";

            if(componentes.r() || componentes.g() || componentes.b() || componentes.a()){

                linha += "+ (";
                linha += confirmaComponente(componentes.r(),componentes.compR())+" ";
                linha += confirmaComponente(componentes.g(),componentes.compG())+" ";
                linha += confirmaComponente(componentes.b(),componentes.compB())+" ";
                linha += confirmaComponente(componentes.a(),componentes.compA());
                linha += ") [";

                for (int x = 0; x < largura; x++) {
                    Cor cor = new Cor(imagem.getRGB(x, y));
                    String rgba = "";

                    rgba += alteraPixel(componentes.r(), "R", cor.getRed())+" ";
                    rgba += alteraPixel(componentes.g(), "G", cor.getGreen())+" ";
                    rgba += alteraPixel(componentes.b(), "B", cor.getBlue())+" ";
                    rgba += alteraPixel(componentes.a(), "A", cor.getAlpha());

                    linha += " (" + rgba + ")";
                }


                linha += " ]";
            }else{
                linha = "[";
                for (int x = 0; x < largura; x++) {
                    Cor cor = new Cor(imagem.getRGB(x, y));
                    String rgba = toNumero(cor.getRed()) + " " + toNumero(cor.getGreen()) + " " + toNumero(cor.getBlue()) + " " + toNumero(cor.getAlpha());
                    linha += " (" + rgba + ")";
                }

                linha += " ]";
            }





            boolean existe = false;
            int contador = 1;
            for (String item : historico) {
                if (Texto.igual(linha, item)) {
                    linha = "# [" + contador + "]";
                    existe = true;
                    break;
                }
                contador++;
            }

            dados.adicionarLinha(linha);

            historico.inserirAntes(0, linha);
            if (!existe) {

            }

            if (historico.getQuantidade() > 255) {
                historico.remover(historico.getQuantidade() - 1);
            }
        }

        Texto.escrever(arquivo, dados.toString());
    }

    private static void transformaLinhaV2(int Y, String linha, ImagemEditor editor) {
        //fmt.println("ANTES = |" + linha + "|");
        linha = Texto.removeString(linha, "[ ");
        linha = Texto.removeString(linha, " ]");
        linha = Texto.removeString(linha, ") ");
        linha = Texto.removeLetra(linha, ')');

        //fmt.println("DEPOIS = |" + linha + "|>");

        Lista<String> sCores = Texto.dividirPorSimbolo(linha, '(');

        int X = 0;

        for (String sCor : sCores) {
            if (sCor.length() > 0) {
                Lista<String> rgba = Texto.dividirPorSimbolo(sCor, ' ');

                // rgba.removerValor(" ", new StringIgualdade());
                String ccc = "";
                for (int i = 0; i < rgba.getQuantidade(); i++) {
                    ccc += i + ":" + rgba.get(i) + " ";
                }
                //fmt.println("|" + ccc + "|" + sCor.length());

                boolean tudoOk = true;
                if (rgba.getQuantidade() == 4) {
                    for (int i = 0; i < 4; i++) {
                        if (rgba.get(i).length() == 0 || rgba.get(i) == null) {
                            tudoOk = false;
                        }
                    }
                    if (!tudoOk) {
                        break;
                    }

                    int r = Integer.parseInt(rgba.get(0));
                    int g = Integer.parseInt(rgba.get(1));
                    int b = Integer.parseInt(rgba.get(2));
                    int a = Integer.parseInt(rgba.get(3));

                    Cor cor = new Cor(a, r, g, b);
                    if (X >= editor.getLargura() || Y >= editor.getAltura()) {
                        break;
                    }
                    //fmt.println("x:{} y:{} | r:{} g:{} b:{} a:{}", X, Y, r, g, b, a);
                    editor.setPixelCor(X, Y, cor);
                }
                X++;
            }
        }
        //Y++;
        //fmt.println("Transformei a linha: " + Y);
    }

    private static Lista<String> listaDeComponentesV5(String linha){
        Lista<String>componentes = Texto.dividirPorSimbolo(Texto.obterEntre(linha, "(", ")"),' ');
        return componentes;
    }

    private static Lista<String> listaDeCoresV5(String linha){
        //fmt.println("ANTES = |" + linha + "|");

        linha = Texto.removeString(linha, Texto.obterEntre(linha, "+", "["));
        linha = Texto.removeString(linha, "+");
        linha = Texto.removeString(linha, "[ ");
        linha = Texto.removeString(linha, " ]");
        linha = Texto.removeString(linha, ") ");
        linha = Texto.removeLetra(linha, ')');


        Lista<String> sCores = Texto.dividirPorSimbolo(linha, '(');

        //fmt.println("DEPOIS = |" + Texto.alteraLetra(linha,'('," - ") + "|>");

        return sCores;
    }

    private static void transformaLinhaV5(int Y, Lista<String> componentes, Lista<String> cores, ImagemEditor editor) {

        int X = 0;
        //fmt.println("-------------------------COMPONENTESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS--------------------------");
        //componentes.exibirLista();
        for (String sCor : cores) {
            if (sCor.length() > 0) {
                Lista<String> rgba = Texto.dividirPorSimbolo(sCor, ' ');

                // rgba.removerValor(" ", new StringIgualdade());
                String ccc = "";
                for (int i = 0; i < rgba.getQuantidade(); i++) {
                    ccc += i + ":" + rgba.get(i) + " ";
                }
                //fmt.println("|" + ccc + "|" + sCor.length());

                boolean tudoOk = true;
                if (rgba.getQuantidade() == 4) {
                    for (int i = 0; i < 4; i++) {
                        if (rgba.get(i).length() == 0 || rgba.get(i) == null) {
                            tudoOk = false;
                        }
                    }
                    if (!tudoOk) {
                        break;
                    }
                    //fmt.println("-------------------------CORESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS---ANTES-----------------------");

                    //rgba.exibirLista();

                    if(Texto.igual(rgba.get(0),"R")){
                        rgba.set(0, componentes.get(0));
                    }
                    if(Texto.igual(rgba.get(1), "G")){
                        rgba.set(1, componentes.get(1));
                    }
                    if(Texto.igual(rgba.get(2), "B")){
                        rgba.set(2, componentes.get(2));
                    }
                    if(Texto.igual(rgba.get(3), "A")){
                        rgba.set(3, componentes.get(3));
                    }

                    for (int i = 0; i<4;i++){
                        if(Texto.igual(rgba.get(i), "_")){
                            //rgba.set(i, componentes.get(i));
                            fmt.println("Encontrei um _ ");
                        }
                    }

                    //fmt.println("-------------------------CORESSSSSSSSSSSSSSSSSSSSSSSSSSS---------DEPOIS--------------------------");

                    //rgba.exibirLista();

                    int r = Integer.parseInt(rgba.get(0));
                    int g = Integer.parseInt(rgba.get(1));
                    int b = Integer.parseInt(rgba.get(2));
                    int a = Integer.parseInt(rgba.get(3));

                    Cor cor = new Cor(a, r, g, b);
                    if (X >= editor.getLargura() || Y >= editor.getAltura()) {
                        break;
                    }
                    //fmt.println("x:{} y:{} | r:{} g:{} b:{} a:{}", X, Y, r, g, b, a);
                    editor.setPixelCor(X, Y, cor);
                }
                X++;
            }
        }
        //Y++;
        //fmt.println("Transformei a linha: " + Y);
    }
}
