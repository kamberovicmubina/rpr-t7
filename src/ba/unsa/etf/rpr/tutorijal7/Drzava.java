package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;

public class Drzava implements Serializable {
    private String naziv;
    private int brojStanovnika;
    private double povrsina;
    private String jedinicaZaPovrsinu;
    private Grad glavniGrad;

    public Drzava () {
        naziv = "";
        brojStanovnika = 0;
        povrsina = 0;
        jedinicaZaPovrsinu = "";
    }
    public String dajNaziv ()  {
        return naziv;
    }
    public int dajBrojStanovnika ()  {
        return brojStanovnika;
    }
    public double dajPovrsinu ()  {
        return povrsina;
    }
    public String dajJedinicuZaPovrsinu ()  {
        return jedinicaZaPovrsinu;
    }
    public Grad dajGlavniGrad ()  {
        return glavniGrad;
    }
}
