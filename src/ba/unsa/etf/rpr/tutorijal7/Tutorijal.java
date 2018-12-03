package ba.unsa.etf.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tutorijal {
    public static void main(String[] args) {

    }

    public static void ucitajGradove () {
        Scanner ulaz, izlaz;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
            return;
        }

        /*try {
            izlaz = new PrintWriter(new FileWriter())
        }*/
    }
}
