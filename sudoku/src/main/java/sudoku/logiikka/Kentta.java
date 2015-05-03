package sudoku.logiikka;

/**
 * Luokka kapseloi sudokulaudan toteutuksen.
 *
 * @author ari
 */
public class Kentta {

    private Solu[][] kentta;
    private int koko;

    public Kentta(int koko) {
        this.koko = koko;
        kentta = new Solu[koko][koko];
        for (int y = 0; y < koko; y++) {
            for (int x = 0; x < koko; x++) {
                kentta[y][x] = new Solu(0);
            }
        }
    }

    /**
     * Metodi asettaa syotteenä saadun kentän.
     *
     * @param kentta Syotteenä saatava sudokukentta
     * @return palauttaa false jos syötteenä saatu kenttä ei ole validi
     */
//    public boolean setKentta(int[][] kentta) {
//        this.kentta = kentta;
//        this.koko = kentta[0].length;
//        if (Tarkistaja.validoi(this)) {
//            return true;
//        }
//        return false;
//    }
    /**
     *
     * @param y
     * @param x
     * @return
     */
    public int getArvo(int y, int x) {
        return kentta[y][x].getArvo();
    }

    /**
     *
     * @return
     */
    public int getKoko() {
        return koko;
    }

    void setArvo(int y, int x, int arvo) {
        kentta[y][x].setArvo(arvo);
    }

}
