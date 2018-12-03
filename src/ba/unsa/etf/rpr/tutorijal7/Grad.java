package ba.unsa.etf.rpr.tutorijal7;

public class Grad {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature;
    public Grad () {
        naziv = "";
        brojStanovnika = 0;
        temperature = new double[1000];
    }
    public String dajNaziv () {
        return naziv;
    }
    public int dajBrojStanovnika () {
        return brojStanovnika;
    }
    public double[] dajTemperature () {
        return temperature;
    }
}