/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ari
 */
public class TarkistajaTest {

    private int[][] toimivaKentta;
    private int[][] eiToimivaKentta;
    private int[][] eiToimivaKentta2;
    private int[][] eiToimivaKentta3;
    private int[][] eiToimivaKentta4;

    public TarkistajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        toimivaKentta = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        eiToimivaKentta = new int[][]{
            {1, 1, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        eiToimivaKentta2 = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        eiToimivaKentta3 = new int[][]{
            {11, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        eiToimivaKentta4 = new int[][]{
            {-3, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};
    }

    @After
    public void tearDown() {
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaTrue() {
        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(toimivaKentta[0]), true);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaafalse() {
        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(eiToimivaKentta[0]), false);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaFalseJosDuplikaatteja() {

        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(eiToimivaKentta[0]), false);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaTrue() {
        assertEquals(Tarkistaja.riveillaEiDuplikaatteja(toimivaKentta), true);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaFalse() {
        assertEquals(Tarkistaja.riveillaEiDuplikaatteja(eiToimivaKentta), false);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaTrue() {
        assertEquals(Tarkistaja.kaikkiNumerotRuudukossa(toimivaKentta, 0, 0), true);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaFalse() {
        assertEquals(Tarkistaja.kaikkiNumerotRuudukossa(eiToimivaKentta, 0, 0), false);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunNegatiivisiaArvoja() {
        assertEquals(Tarkistaja.oikeatNumerot(eiToimivaKentta3), false);
    }

    @Test
    public void oikeatNumerotPalauttaaTrue() {
        assertEquals(Tarkistaja.oikeatNumerot(toimivaKentta), true);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunLiianSuuriaArvoja() {
        assertEquals(Tarkistaja.oikeatNumerot(eiToimivaKentta4), false);
    }
    
   

}
