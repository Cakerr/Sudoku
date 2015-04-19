package sudoku.logiikka;

import java.util.ArrayList;

/**
 *Luokka kapseloi sudokulaudan toteutuksen.
 * @author ari
 */
public class Kentta {

    private int[][] kentta;
    private int koko;

    /**
     *Metodi asettaa syotteenä saadun kentän.
     * @param kentta Syotteenä saatava sudokukentta 
     * @return palauttaa false jos syötteenä saatu kenttä ei ole validi
     */
    public boolean setKentta(int[][] kentta) {
        this.kentta = kentta;
        this.koko = kentta[0].length;
        if (Tarkistaja.validoi(this)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param y
     * @param x
     * @return
     */
    public int getArvo(int y, int x) {
        return kentta[y][x];
    }

    /**
     *
     * @return
     */
    public int getKoko() {
        return koko;
    }

    void setArvo(int y, int x, int arvo) {
        kentta[y][x] = arvo;
    }

}
