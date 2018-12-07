package ba.unsa.etf.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {
    public static void main(String[] args) {
        ArrayList<Grad> g = ucitajGradove();

        for (Grad gr : g) {
            System.out.println(gr.dajNaziv());
            gr.ispisiTemperature();
            System.out.println();
        }
    }

    public static ArrayList<Grad> ucitajGradove () {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileReader("C:\\Users\\User\\IdeaProjects\\rpr-t7\\src\\ba\\unsa\\etf\\rpr\\tutorijal7\\mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
        }

        ArrayList<Grad> izlaz = new ArrayList<>();
        try {
            while (ulaz.hasNext()) {
                String[] linija = ulaz.nextLine().split(",");
                String ime = linija[0];
                double[] temp = new double[1000];
                int i;
                for (i = 0; i < linija.length - 1; i++) {
                    temp[i] = (double) Double.valueOf(linija[i + 1]);
                }
                izlaz.add(new Grad(ime, 0, temp, i));
            }
        } catch(NullPointerException e) {
            System.out.println("Izuzetak");
            return izlaz;
        }
        ulaz.close();
        return izlaz;
    }
}
