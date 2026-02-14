package auxiliar;

import utils.Igualdade;

public class StringIgualdade implements Igualdade<String> {

    @Override
    public boolean igual(String t1, String t2) {

        if (t1.length() == t2.length()) {
            boolean tudoOK = false;

            for (int i = 0; i < t1.length(); i++) {
                char letraT1  = t1.charAt(i);
                char letraT2  = t2.charAt(i);
                if (letraT1 == letraT2) {
                    tudoOK = true;
                }else{
                    tudoOK = false;
                    break;
                }
                return tudoOK;
            }
        }
        return false;
    }
}
