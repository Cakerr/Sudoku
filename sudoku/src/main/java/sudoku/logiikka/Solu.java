/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.logiikka;

/**
 *
 * @author ari
 */
public class Solu {

    private boolean lukittu;
    private int arvo;

    public Solu(int arvo) {
        this.arvo = arvo;
        lukittu = true;
    }

    public int getArvo() {
        return this.arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public boolean onkoLukittu(){
        return lukittu;
    }
    
}
