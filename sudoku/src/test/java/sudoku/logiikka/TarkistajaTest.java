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

    private int[][] toimivaKentta, validointiOnnistuu, validointiEiOnnistu, validointiEiOnnistu2,
            validointiEiOnnistu3, validointiOnnistuu2, validointiOnnistuu3;
    private int[][] eiToimivaKentta;
    private int[][] eiToimivaKentta2;
    private int[][] eiToimivaKentta3;
    private int[][] eiToimivaKentta4;
    private int[][] eiToimivaKentta5;
    private int[][] eiToimivaKentta6;
    private Kentta kentta = new Kentta(9);
    Sudoku sudoku = new Sudoku(kentta);

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

        eiToimivaKentta5 = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 0, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        eiToimivaKentta6 = new int[][]{
            {0, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 0, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiEiOnnistu = new int[][]{
            {0, 1, 1, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 0, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiEiOnnistu2 = new int[][]{
            {0, 1, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 0, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiEiOnnistu3 = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {2, 8, 9, 1, 0, 3, 4, 5, 6},
            {0, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 0, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiOnnistuu = new int[][]{
            {0, 0, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiOnnistuu2 = new int[][]{
            {0, 0, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {0, 1, 2, 3, 4, 5, 6, 7, 8}};

        validointiOnnistuu3 = new int[][]{
            {0, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 0, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        Kentta kentta = new Kentta(9);

    }

    public void luoKenttTaulukosta(int[][] taulukko) {

        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[i].length; j++) {
                kentta.setArvo(i, j, taulukko[i][j]);
            }
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaTrue() {
        luoKenttTaulukosta(toimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), true);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaafalse() {
        luoKenttTaulukosta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaFalseJosDuplikaatteja() {
        luoKenttTaulukosta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaTrue() {
        luoKenttTaulukosta(toimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), true);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaFalse() {
        luoKenttTaulukosta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaTrue() {
        luoKenttTaulukosta(toimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), true);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaFalse() {
        luoKenttTaulukosta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunNegatiivisiaArvoja() {
        luoKenttTaulukosta(eiToimivaKentta3);
        assertEquals(Tarkistaja.validoi(kentta), false);
    }

    @Test
    public void oikeatNumerotPalauttaaTrue() {
        luoKenttTaulukosta(toimivaKentta);
        assertEquals(Tarkistaja.validoi(kentta), true);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunLiianSuuriaArvoja() {
        luoKenttTaulukosta(eiToimivaKentta4);
        assertEquals(Tarkistaja.validoi(kentta), false);
    }

    @Test
    public void validointiEiOnnistuKunRivillä2samaaNumeroa() {
        luoKenttTaulukosta(validointiEiOnnistu);
        assertEquals(Tarkistaja.validoi(kentta), false);
    }

    @Test
    public void validointiEiOnnistuKunSarakkeessa2samaaNumeroa() {
        luoKenttTaulukosta(validointiEiOnnistu2);
        assertEquals(Tarkistaja.validoi(kentta), false);
    }

    @Test
    public void validointiEiOnnistuKunRuudussa2samaaNumeroa() {
        luoKenttTaulukosta(validointiEiOnnistu3);
        assertEquals(Tarkistaja.validoi(kentta), false);
    }

    @Test
    public void validointiOnnistuKunRivillä2Nollaa() {
        luoKenttTaulukosta(validointiOnnistuu);
        assertEquals(Tarkistaja.validoi(kentta), true);
    }

    @Test
    public void validointiOnnistuKunSarakkeessa2Nollaa() {
        luoKenttTaulukosta(validointiOnnistuu2);
        assertEquals(Tarkistaja.validoi(kentta), true);
    }

    @Test
    public void validointiOnnistuKunRuudussa2Nollaa() {
        luoKenttTaulukosta(validointiOnnistuu3);
        assertEquals(Tarkistaja.validoi(kentta), true);
    }

    @Test
    public void eiNolliaPalauttaaFalseKunNollia() {
        luoKenttTaulukosta(validointiOnnistuu);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void tarkistaOikeellisuusPalauttaaTrueKunOikeinTäytettyKentta() {
        luoKenttTaulukosta(toimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), true);
    }

    @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunRivillaDuplikaatteja() {
        luoKenttTaulukosta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunSarakkeessaDuplikaatteja() {
        luoKenttTaulukosta(eiToimivaKentta2);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

    @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunRuudussaDuplikaatteja() {
        luoKenttTaulukosta(eiToimivaKentta2);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

}
