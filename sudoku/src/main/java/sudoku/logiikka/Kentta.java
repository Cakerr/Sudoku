package sudoku.logiikka;

import java.util.ArrayList;

public class Kentta {

    private int[][] kentta;
    private int koko;

    public boolean setKentta(int[][] kentta) {
        if (Tarkistaja.validoi(kentta)) {
            this.kentta = kentta;
            this.koko = kentta.length;
            return true;
        }
        return false;
    }

    public int getArvo(int y, int x) {
        return kentta[y][x];
    }

    public int getKoko() {
        return koko;
    }

}
