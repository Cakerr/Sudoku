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

    /**
     * Kapseloi sudokulaudan ruudut
     * @param arvo Solulle asetettava alkuarvo
     */
    public Solu(int arvo) {
        this.arvo = arvo;
        lukittu = true;
    }

    /**
     * Palauttaa soluun asetetun arvo
     * @return solun arvo
     */
    public int getArvo() {
        return this.arvo;
    }

    /**
     * Asettaa solulle uuden arvon
     * @param arvo
     */
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
    
}
