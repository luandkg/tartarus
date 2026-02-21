package estruturas;

public class fmt {

    public static String direita(String texto, int tamanhoFixo) {
        while (texto.length() < tamanhoFixo) {
            texto = " " + texto;
        }
        return texto;
    }

    public static void printDireitaMultiplasLinhas(String texto, int tamanhoFixo) {
        Lista<String> textoEmLinhas = Texto.dividirLinhas(texto);

        for (String linha : textoEmLinhas) {
            System.out.println(direita(linha, tamanhoFixo));
        }
    }

    public static String esquerda(String texto, int tamanhoFixo) {
        while (texto.length() < tamanhoFixo) {
            texto += " ";
        }
        return texto;
    }

    public static void printEsquerdaMultiplasLinhas(String texto, int tamanhoFixo) {
        Lista<String> textoEmLinhas = Texto.dividirLinhas(texto);

        for (String linha : textoEmLinhas) {
            System.out.println(esquerda(linha, tamanhoFixo));
        }
    }

    public static <T> String repete(T c, int tamanho) {
        String sequencia = "";
        for (int i = 0; i < tamanho; i++) {
            sequencia += c;
        }
        return sequencia;
    }

    public static void print(String texto, Object... argumentos) {
        System.out.print(formatar(texto,argumentos));
    }

    public static void println(String texto, Object... argumentos) {
        System.out.println(formatar(texto,argumentos));
    }

    public static String formatar(String texto, Object... argumentos) {
        int i = 0;
        int o = texto.length();
        String novoTexto = "";
        String formato = "";
        boolean dentroDOFOrmato = false;
        int posicao = 0;

        while (i < o) {
            String letra = String.valueOf(texto.charAt(i));

            if (letra.contentEquals("{")) {
                dentroDOFOrmato = true;
                formato = "";

            } else if (letra.contentEquals("}")) {
                if(Texto.comecaCom(formato,"direita_")){
                    int quantidade = Integer.parseInt(formato.replace("direita_",""));
                    novoTexto += direita(String.valueOf(argumentos[posicao]),quantidade);
                }else if(Texto.comecaCom(formato,"esquerda_")){
                    int quantidade = Integer.parseInt(formato.replace("esquerda_",""));
                    novoTexto += esquerda(String.valueOf(argumentos[posicao]),quantidade);
                }else if(Texto.comecaCom(formato,"repete_")){
                    int quantidade = Integer.parseInt(formato.replace("repete_",""));
                    novoTexto += repete(String.valueOf(argumentos[posicao]),quantidade);
                }else if(Texto.comecaCom(formato,"centraliza_")){
                    int quantidade = Integer.parseInt(formato.replace("centraliza_",""));
                    int palavra = String.valueOf(argumentos[posicao]).length();
                    if(palavra%2 == 1){

                        throw new RuntimeException("Erro: A palavra deve ter um quantidade par! Caso necessario adicione um ' ' no final. : "+String.valueOf(argumentos[posicao]));
                    }
                    novoTexto += repete(" ",(quantidade/2)-(palavra/2))+ String.valueOf(argumentos[posicao])+repete(" ",(quantidade/2)-(palavra/2));
                }else{
                    novoTexto += String.valueOf(argumentos[posicao]);
                }
                dentroDOFOrmato = false;
                posicao++;

            } else {
                if(dentroDOFOrmato == false){
                    novoTexto+=letra;
                }else{
                    formato+=letra;
                }
            }
            i++;
        }

        return novoTexto;
    }
}
