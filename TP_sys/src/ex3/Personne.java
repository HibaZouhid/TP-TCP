package ex3;

import java.io.Serializable;
import java.util.Date;

public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
private String nom ;
private String prénom ;
private Date date_naissance ;
        Personne(String nom, String prénom, Date date_naissance ){
        this.nom=nom ;
        this.prénom=prénom ;
        this.date_naissance = date_naissance ;}
     public int  calcul_age() {
            Date d = new Date();
         long  ageInSec = Math.abs(d.getTime()-this.date_naissance.getTime());

    return 0;
            }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }
}

