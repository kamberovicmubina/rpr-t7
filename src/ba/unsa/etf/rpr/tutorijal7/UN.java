package ba.unsa.etf.rpr.tutorijal7;

import java.io.Serializable;
import java.util.ArrayList;

public class UN implements Serializable {
    private ArrayList<Drzava> drzave;
    public UN () {
        drzave = new ArrayList<>();
    }
    public ArrayList<Drzava> dajDrzave () {
        return drzave;
    }
}
