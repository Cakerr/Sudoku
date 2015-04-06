package sudoku.logiikka;

import java.util.ArrayList;

public class Kentta {

    private int[][] kentta;
    private int koko;

    public boolean setKentta(int[][] kentta) {
        this.kentta = kentta;
        this.koko = kentta[0].length;
        if (Tarkistaja.validoi(this)) {
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

    void setArvo(int y, int x, int arvo) {
        kentta[y][x] = arvo;
    }

}
