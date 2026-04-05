package main.libs.calebeDocumento;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;
import main.libs.estruturas.fmt;

public class CalebeDocumento {

    // AUTOR : CALEBE ALVES FREITAS
    // CRIADO : 2026 04 04

    private Lista<Objeto> objetos;

    public CalebeDocumento() {
        this.objetos = new Lista<>();
    }



    // ------------------------- OBJETOS -----------------------------------

    public Lista<Objeto> getObjetos() {
        return objetos;
    }


    public Objeto objetoCriar(String nome) {
        Objeto novoObjeto = new Objeto(nome);
        objetos.adicionar(novoObjeto);

        return novoObjeto;
    }

    public Objeto objeto(String nome) {
        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                return obj;
            }
        }
        return null;
    }

    public void objetoRemover(String nome) {
        int cont = 0;
        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                objetos.remover(cont);
                return;
            }
            cont++;
        }
    }

    public boolean objetoExiste(String nome) {
        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                return true;
            }
        }
        return false;
    }

    public Objeto objetoUnico(String nome) {

        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                return obj;
            }
        }
        return objetoCriar(nome);
    }


    // ------------------------- ABRIR -----------------------------------

    public void abrir(String arquivo) {
        String texto = Texto.ler(arquivo);

        Lista<Token> tokens = dividirTokens(texto);

        fmt.println("Lista de Tokens: Possui {} {}", tokens.getQuantidade(), "tokens.");
        for (Token tk : tokens) {
            fmt.println("Token: {}: {}", tk.getTipo().toString(), tk.getValor().toString());
        }
        montaObjetos(tokens);
    }

    public void parse(String texto) {

        Lista<Token> tokens = dividirTokens(texto);

        fmt.println("Lista de Tokens: Possui {} {}", tokens.getQuantidade(), "tokens.");
        for (Token tk : tokens) {
            fmt.println("Token: {}: {}", tk.getTipo().toString(), tk.getValor().toString());
        }
        montaObjetos(tokens);
    }



    public Lista<Token> dividirTokens(String texto) {
        Lista<Token> tokens = new Lista<>();

        int i = 0;
        int o = texto.length();
        while (i < o) {
            String letra = String.valueOf(texto.charAt(i));

            fmt.println("L{}= {}\t", i, letra);

            if (Texto.igual(letra, "!")) {
                tokens.adicionar(new Token(TokenTipo.EXCLAMACAO, "!"));
                String obj = "";
                i++;

                while (i < o) {
                    String l2 = String.valueOf(texto.charAt(i));

                    if (Texto.igual(l2, " ") || Texto.igual(l2, "[")) {
                        i--;
                        break;
                    } else {
                        obj += l2;
                    }
                    i++;
                }
                fmt.println("Palavra: {}", obj);
                tokens.adicionar(new Token(TokenTipo.NOME, obj));
            } else if (Texto.igual(letra, "@")) {
                tokens.adicionar(new Token(TokenTipo.ARROBA, "@"));

                String obj = "";
                i++;

                while (i < o) {
                    String l2 = String.valueOf(texto.charAt(i));

                    if (Texto.igual(l2, "=")) {
                        i--;
                        break;
                    } else {
                        obj += l2;
                    }
                    i++;
                }
                fmt.println("Palavra: {}", obj);
                tokens.adicionar(new Token(TokenTipo.NOME, obj));


            } else if (Texto.igual(letra, "=")) {
                tokens.adicionar(new Token(TokenTipo.IGUAL, "="));

            } else if (Texto.igual(letra, "\"")) {
                String obj = "";
                i++;

                while (i < o) {
                    String l2 = String.valueOf(texto.charAt(i));

                    if (Texto.igual(l2, "\"")) {
                        break;
                    } else {
                        obj += l2;
                    }
                    i++;
                }
                fmt.println("Palavra: {}", obj);
                tokens.adicionar(new Token(TokenTipo.VALOR, obj));

            } else if (Texto.igual(letra, "[")) {
                tokens.adicionar(new Token(TokenTipo.COLCHETE_ABRE, "["));

            } else if (Texto.igual(letra, "]")) {
                tokens.adicionar(new Token(TokenTipo.COLCHETE_FECHA, "]"));

            } else if (Texto.igual(letra, "{")) {
                tokens.adicionar(new Token(TokenTipo.CHAVES_ABRE, "{"));

            } else if (Texto.igual(letra, "}")) {
                tokens.adicionar(new Token(TokenTipo.CHAVES_FECHA, "}"));
            }
            i++;
        }
        return tokens;
    }

    public int montaObjetosInterno(Lista<Token> tokens, int n, Objeto objPai) {
        int o = tokens.getQuantidade();

        boolean chaveAberta = false;
        boolean colcheteAberto = false;

        while (n < o) {
            Token tk = tokens.get(n);
            if (tk.getTipo() == TokenTipo.COLCHETE_ABRE) {
                colcheteAberto = true;

            } else if (tk.getTipo() == TokenTipo.COLCHETE_FECHA && colcheteAberto) {
                colcheteAberto = false;
                break;
            } else if (tk.getTipo() == TokenTipo.ARROBA && colcheteAberto) {
                String nome = "";
                String valor = "";

                if (n + 1 < tokens.getQuantidade()) {
                    n++;
                    tk = tokens.get(n);
                    if (tk.getTipo() != TokenTipo.NOME) {
                        throw new RuntimeException("Erro: Token de tipo invalido! Esperado: @NOME");
                    }
                    nome = tk.getValor();
                }

                if (n + 1 < tokens.getQuantidade()) {
                    n++;
                    tk = tokens.get(n);
                    if (tk.getTipo() != TokenTipo.IGUAL) {
                        throw new RuntimeException("Erro: Token de tipo invalido! Esperado: =");
                    }
                }
                if (n + 1 < tokens.getQuantidade()) {
                    n++;
                    tk = tokens.get(n);
                    if (tk.getTipo() != TokenTipo.VALOR) {
                        throw new RuntimeException("Erro: Token de tipo invalido! Esperado: \"VALOR\"");
                    }
                    valor = tk.getValor();
                }

                objPai.atributo(nome,valor);
            }
            n++;
        }

        while (n < o) {
            Token tk = tokens.get(n);
            if (tk.getTipo() == TokenTipo.CHAVES_ABRE) {
                chaveAberta = true;
            } else if (tk.getTipo() == TokenTipo.CHAVES_FECHA && chaveAberta) {
                chaveAberta = false;
                break;
            } else if (tk.getTipo() == TokenTipo.EXCLAMACAO && chaveAberta) {
                String nome = "";

                if (n + 1 < tokens.getQuantidade()) {
                    n++;
                    tk = tokens.get(n);
                    if (tk.getTipo() != TokenTipo.NOME) {
                        throw new RuntimeException("Erro: Token de tipo invalido! Esperado: @NOME");
                    }
                    nome = tk.getValor();
                }
                Objeto obj2 = new Objeto(nome);
                n = montaObjetosInterno(tokens, n, obj2);
                objPai.getObjetos().adicionar(obj2);
            }
            n++;
        }

        if(chaveAberta){
            throw new RuntimeException("Erro: Era esperado fechar chaves !");
        }

        if(colcheteAberto){
            throw new RuntimeException("Erro: Era esperado fechar colechetes !");
        }

        return n;
    }

    public void montaObjetos(Lista<Token> tokens) {
        objetos.limpar();

        int i = 0;
        int o = tokens.getQuantidade();

        while (i < o) {
            Token tk = tokens.get(i);

            if (tk.getTipo() == TokenTipo.EXCLAMACAO) {
                String nome = "";

                if (i + 1 < tokens.getQuantidade()) {
                    i++;
                    tk = tokens.get(i);
                    if (tk.getTipo() != TokenTipo.NOME) {
                        throw new RuntimeException("Erro: Token de tipo invalido! Esperado: @NOME");
                    }
                    nome = tk.getValor();
                }

                Objeto obj = new Objeto(nome);
                i = montaObjetosInterno(tokens, i, obj);
                objetos.adicionar(obj);
            }
            i++;
        }
    }



    // ------------------------- SALVAR -----------------------------------

    public void salvar(String arquivo) {
        TextoDocumento novoRelatorio = new TextoDocumento();
        int identacao = 0;

        for (Objeto obj : objetos) {
            String textoAtributos = "";
            for (Atributo atr : obj.getAtributos()) {
                textoAtributos += "@" + atr.getNome() + "=\"" + atr.getValor() + "\" ";
            }

            if(obj.getObjetos().getQuantidade()!=0){
                novoRelatorio.adicionarLinha("!" + obj.getNome() + " [" + textoAtributos + "] {\t\t");
                obj.salvando(novoRelatorio, identacao + 1);
                novoRelatorio.adicionar("}");
            }else{
                novoRelatorio.adicionarLinha("!" + obj.getNome() + " [" + textoAtributos + "] {}");
            }

        }
        Texto.escrever(arquivo, novoRelatorio.toString());
    }
}
