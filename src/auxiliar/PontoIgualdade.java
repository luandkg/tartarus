package auxiliar;

import utils.Igualdade;

public class PontoIgualdade implements Igualdade<Ponto>{

    @Override
    public boolean igual(Ponto t1, Ponto t2) {
        if(t1.getX() == t2.getX() && t1.getY() == t2.getY()){
            return true;
        }
        return false;
    }

}
