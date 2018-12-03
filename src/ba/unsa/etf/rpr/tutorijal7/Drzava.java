package ba.unsa.etf.rpr.tutorijal7;

public class Drzava {
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
    public String dajNaziv () const {
        return naziv;
    }
    public int dajBrojStanovnika () const {
        return brojStanovnika;
    }
    public double dajPovrsinu () const {
        return povrsina;
    }
    public String dajJedinicuZaPovrsinu () const {
        return jedinicaZaPovrsinu;
    }
    public Grad dajGlavniGrad () const {
        return glavniGrad;
    }
}
