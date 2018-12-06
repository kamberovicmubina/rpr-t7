package ba.unsa.etf.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Tutorijal {
    public static void main(String[] args) {
        ArrayList<Grad> g = ucitajGradove();

        for (Grad gr : g) {
            out.println(gr.dajNaziv());
          //  out.println(gr.dajTemperature());
        }

    }

    public static ArrayList<Grad> ucitajGradove () {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileReader("/home/student/IntelliJIDEAProjects/rpr-t7/src/ba/unsa/etf/rpr/tutorijal7/mjerenja.txt"));
        } catch (FileNotFoundException e) {
            out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
        }

        ArrayList<Grad> izlaz = new ArrayList<>();

        while (ulaz.hasNext()) {
            int j = 0;
            String[] linija = ulaz.next().split(",");
            String ime = linija[0];

            Double[] temp =  Arrays.stream(linija[1]).mapToDouble(Double::parseDouble);

            ulaz.nextLine();
            Grad gr = new Grad (ime, 0, temp);
            izlaz.add(gr);
        }
        ulaz.close();
        return izlaz;
    }
}
