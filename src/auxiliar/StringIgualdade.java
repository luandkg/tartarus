package auxiliar;

import estruturas.Texto;
import utils.Igualdade;

public class StringIgualdade implements Igualdade<String> {

    @Override
    public boolean igual(String t1, String t2) {
        return Texto.igual(t1,t2);
    }
}
