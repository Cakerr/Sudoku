package sudoku.logiikka;

import sudoku.ui.Gui;
import sudoku.ui.Ui;


/**
 *
 * @author ari
 */
public class Sudoku {

    private Kentta kentta;
    private Ui ui;
    private Solver solver;
    private Kentta temp;

    /**
     * Konstruktori, jokaa saa parametrina Kentta-olion ja käynnistää graaffisen
     * käyttöliittymän.
     *
     * @param kentta
     */
    public Sudoku(Kentta kentta) {
        this.kentta = kentta;
        this.solver = new Solver();
        
        
    }

    /**
     * Tarkistaa onko valmis sudoku täytetty oikein.
     *
     * @return false jos sudoku on väärin täytetty
     */
    public boolean tarkista() {
        return Tarkistaja.tarkistaOikeellisuus(kentta);
    }

    /**
     * Asettaa kentän ruudun(y,x) arvoksi parametrina saadun arvon
     *
     * @param y y-koordinaatti
     * @param x x-koordinaatti
     * @param arvo
     */
    public void lisaaNumero(int y, int x, int arvo) {
        kentta.setArvo(y, x, arvo);
    }

    /**
     *
     */
    public void gui() {
        ui = new Gui(this);
    }

    /**
     * Palauttaa kentän koon
     *
     * @return
     */
    public int getKoko() {
        return kentta.getKoko();
    }

    /**
     *
     * @param uusi true, jos halutaan uuden kentän tiedot, muuten false.
     * @param y
     * @param x
     * @return
     */
    public int getArvo(int y, int x) {
        return kentta.getArvo(y, x);
    }

    /**
     *
     * @param y
     * @param x
     * @param arvo
     */
    public void setArvo(int y, int x, int arvo) {
        kentta.setArvo(y, x, arvo);
    }

    /**
     * Luo uuden kentän, joka koostuu pelkistä 0:sta ja päivittää näkymän.
     */
    public void uusiKentta() {
        Kentta uusi = new Kentta(9);
        temp = new Kentta(9);
        swapKentat();
        ui.paivita();
    }

    private void swapKentat() {
        Kentta swapTemp = kentta;
        kentta = temp;
        temp = swapTemp;
    }

    /**
     * Validoi gui:n kauttaa luodun uuden kentän.
     *
     * @return false jos jollain rivillä, sarakkeella tai ruudulla esiintyy sama
     * numero useaan kertaan.
     */
    public boolean tarkistaUusiKentta() {
        if (Tarkistaja.validoi(kentta)) {
            ui.paivita();
            return true;
        }
        return false;
    }

    public boolean ratkaise() {
        solver.setKentta(kentta);
        return solver.solve(0, 0);
    }
    
    public void generoiUusiKentta(){
        Generoija gen = new Generoija();
        kentta = gen.generoi();
        ui.paivita();
    }

}
