package ex3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Personne personne = new Personne("","",System.getDate());
        System.out.println( personne.calcul_age());

    }
}
