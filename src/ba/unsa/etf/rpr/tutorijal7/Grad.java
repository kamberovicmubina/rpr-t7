package ba.unsa.etf.rpr.tutorijal7;

public class Grad {
    private String naziv;
    private int brojStanovnika;
    private double[] temperature;
    private int brojTemperatura;
    public Grad () {
        naziv = "";
        brojStanovnika = 0;
        temperature = new double[1000];
        brojTemperatura = 0;
    }
    public Grad (String ime, int brSt, double[] temp, int brTemp) {
        naziv = ime;
        brojStanovnika = brSt;
        temperature = temp;
        brojTemperatura = brTemp;
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
    public void setNaziv (String ime) {
        naziv = ime;
    }
    public void setBrojStanovnika (int broj) {
        brojStanovnika = broj;
    }
    public void setTemperature (double[] temp) {
        temperature = temp;
    }
    public void ispisiTemperature () {
        for (int i = 0; i < brojTemperatura; i++) {
            System.out.print(temperature[i]);
            System.out.print(" ");
        }
    }
}
