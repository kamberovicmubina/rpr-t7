package ba.unsa.etf.rpr.tutorijal7;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
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

        UN un = ucitajXml(g);
        for (int i = 0; i < un.dajDrzave().size(); i++) {
            System.out.println("Ime drzave: "+ un.dajDrzave().get(i).dajNaziv() );
            System.out.println("Broj stanovnika drzave: "+ un.dajDrzave().get(i).dajBrojStanovnika() );
            System.out.println("Povrsina: "+ un.dajDrzave().get(i).dajPovrsinu() );
            System.out.println("Jedinica za povrsinu: "+ un.dajDrzave().get(i).dajJedinicuZaPovrsinu() );
            System.out.println("Glavni grad: "+ un.dajDrzave().get(i).dajGlavniGrad().dajNaziv());
            System.out.print("Temperature: ");
            for (int j = 0; j < un.dajDrzave().get(i).dajGlavniGrad().dajBrojTemperatura(); j++) {
                System.out.print(un.dajDrzave().get(i).dajGlavniGrad().dajTemperature()[j]+" ");
            }
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

    public static UN ucitajXml (ArrayList<Grad> gradovi) {
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("C:\\Users\\User\\IdeaProjects\\rpr-t7\\src\\ba\\unsa\\etf\\rpr\\tutorijal7\\drzave.xml"));
        }
        catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }

        ArrayList<Drzava> listaDrzava = new ArrayList<>();
        UN un = new UN();
        Element korijen = null;
        NodeList drzave = null;
        try {
            korijen = xmldoc.getDocumentElement();
            drzave = korijen.getChildNodes();
        } catch (NullPointerException e) {
            System.out.println("Izuzetak");
        }


        for (int i = 0; i < drzave.getLength(); i++) {
            Node drzava = drzave.item(i);
            if (drzava instanceof Element) {
                Element e = (Element) drzava;
                Drzava d = new Drzava();
                int brojSt = Integer.parseInt(e.getAttribute("stanovnika"));
                d.setBrojStanovnika(brojSt);
                NodeList karakteristikeDrzave = e.getChildNodes();
                for (int j = 0; j < karakteristikeDrzave.getLength(); j++) {
                    Node karakteristika = karakteristikeDrzave.item(j);
                    if (karakteristika instanceof Element) {
                        Element karakteristika1 = (Element) karakteristika;
                        if (karakteristika1.getTagName().equals("naziv")) {
                            d.setNaziv(karakteristika1.getTextContent());
                        } else if (karakteristika1.getTagName().equals("povrsina")) {
                            d.setPovrsina(Double.parseDouble(karakteristika1.getTextContent()));
                            d.setJedinicaZaPovrsinu(karakteristika1.getAttribute("jedinica"));
                        } else if (karakteristika1.getTagName().equals("glavnigrad")) {
                            Grad g = new Grad();
                            g.setBrojStanovnika(Integer.parseInt(karakteristika1.getAttribute("stanovnika")));
                            NodeList karakteristikeGrada = karakteristika1.getChildNodes();
                            for (int k = 0; k < karakteristikeGrada.getLength(); k++) {
                                Node kg = karakteristikeGrada.item(k);
                                if (kg instanceof Element) {
                                    Element kGrada = (Element) kg;
                                    if (kGrada.getTagName().equals("naziv")) {
                                        g.setNaziv(kGrada.getTextContent().trim());
                                    }
                                }
                            }
                            for (Grad grad : gradovi) {
                                if (grad.dajNaziv().equals(g.dajNaziv())) {
                                    g.setTemperature(grad.dajTemperature());
                                    g.setBrojTemperatura(grad.dajBrojTemperatura());
                                }
                            }

                            d.setGlavniGrad(g);
                        }
                    }
                }
                listaDrzava.add(d);
            }
        }

        un.setDrzave(listaDrzava);
        return un;
    }

}
