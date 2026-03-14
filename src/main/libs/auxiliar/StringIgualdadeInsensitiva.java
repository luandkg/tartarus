package main.libs.auxiliar;

import main.libs.estruturas.Texto;
import main.libs.utils.Igualdade;

public class StringIgualdadeInsensitiva implements Igualdade<String> {
    @Override
    public boolean igual(String t1, String t2) {
        return Texto.igual(t1.toLowerCase(), t2.toLowerCase());
    }
}
