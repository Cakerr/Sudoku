package sudoku.logiikka;

import sudoku.ui.Gui;
import sudoku.ui.Ui;

public class Sudoku {

    private Kentta kentta;
    private Ui ui;

    public Sudoku(Kentta kentta) {
        this.kentta = kentta;
        gui();
    }

    public boolean tarkista() {
        return Tarkistaja.tarkistaOikeellisuus(kentta);
    }

    public void lisaaNumero(int y, int x, int arvo) {
        kentta.setArvo(y, x, arvo);
    }

    public void gui() {
        ui = new Gui(this);
    }

    public int getKoko() {
        return kentta.getKoko();
    }

    public int getArvo(int y, int x) {
        return kentta.getArvo(y, x);
    }

    public void setArvo(int y, int x, int arvo) {
        kentta.setArvo(y, x, arvo);
    }

    public void uusiKentta() {
        int[][] uusi = new int[9][9];
        kentta.setKentta(uusi);
        
        ui.paivita();
    }

}
