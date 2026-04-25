package main.libs.arquivo.calebeDocumento;

import main.libs.estruturas.Lista;
import main.libs.estruturas.Texto;
import main.libs.estruturas.TextoDocumento;
import main.libs.estruturas.fmt;

public class Objeto {

    private String nome;
    private Lista<Atributo> atributos;
    private Lista<Objeto> objetos;

    public Objeto(String nome) {
        this.nome = nome;
        this.atributos = new Lista<>();
        this.objetos = new Lista<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista<Atributo> getAtributos() {
        return atributos;
    }

    public Lista<Objeto> getObjetos() {
        return objetos;
    }


    // ------------------------- ATRIBUTOS -----------------------------------

    public Atributo atributo(String nome) {
        for (Atributo atr : atributos) {
            if (Texto.igual(atr.getNome(), nome)) {
                return atr;
            }
        }
        Atributo novo_atributo = new Atributo(nome, "");
        atributos.adicionar(novo_atributo);
        return novo_atributo;
    }

    public Atributo atributo(String nome, String valor) {
        for (Atributo atr : atributos) {
            if (Texto.igual(atr.getNome(), nome)) {
                atr.setValor(valor);
                return atr;
            }
        }
        Atributo novo_atributo = new Atributo(nome, valor);
        atributos.adicionar(novo_atributo);
        return novo_atributo;
    }


    public Atributo getAtributo(String nome) {
        for (Atributo atr : atributos) {
            if (Texto.igual(atr.getNome(), nome)) {
                return atr;
            }
        }
        return null;
    }

    public boolean atributoExiste(String nome) {
        for (Atributo atr : atributos) {
            if (Texto.igual(atr.getNome(), nome)) {
                return true;
            }
        }
        return false;
    }

    public void atributoRemover(String nome) {
        for (Atributo atr : atributos) {
            if (Texto.igual(atr.getNome(), nome)) {
                atributos.removerReferencia(atr);
                break;
            }
        }
    }

    // ------------------------- OBJETOS -----------------------------------

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

    public boolean objetoExiste(String nome) {
        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                return true;
            }
        }
        return false;
    }

    public void objetoRemover(String nome) {
        int cont = 0;
        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                objetos.remover(cont);
                break;
            }
            cont++;
        }
    }

    public Objeto objetoUnico(String nome) {

        for (Objeto obj : objetos) {
            if (Texto.igual(obj.getNome(), nome)) {
                return obj;
            }
        }
        return objetoCriar(nome);
    }


    // ------------------------- SALVAR -----------------------------------

    public void salvando(TextoDocumento texto, int identacao) {
        for (Objeto obj : objetos) {
            String textoAtributos = "";
            for (Atributo atr : obj.atributos) {
                textoAtributos += "@" + atr.getNome() + "=\"" + atr.getValor() + "\" ";

            }
            String identacaoTexto = fmt.repete("\t", identacao);

            if(obj.getObjetos().getQuantidade()!=0){
                texto.adicionarLinha(identacaoTexto + "!" + obj.getNome() + " [" + textoAtributos + "] {\t\t");
                obj.salvando(texto, identacao + 1);
                texto.adicionarLinha(identacaoTexto + "}");
            }else{
                texto.adicionarLinha(identacaoTexto + "!" + obj.getNome() + " [" + textoAtributos + "] {}");
            }
        }
    }


}
