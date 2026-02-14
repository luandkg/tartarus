package estruturas;

import java.io.*;

public class Texto {


    public static String ler(String arquivo) {
        String texto = "";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                texto += linha + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto;
    }

    public static void escrever(String arquivo, String novoTexto) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(novoTexto);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
