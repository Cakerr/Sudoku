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
    private Kentta kentta = new Kentta();

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


        Kentta kentta = new Kentta();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaTrue() {
        kentta.setKentta(toimivaKentta);
        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(kentta, 0), true);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaafalse() {
        kentta.setKentta(eiToimivaKentta);
        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(kentta, 0), false);
    }

    @Test
    public void KaikkiNumerotVaakarivillaPalauttaaFalseJosDuplikaatteja() {
        kentta.setKentta(eiToimivaKentta);
        assertEquals(Tarkistaja.kaikkiNumerotVaakarivilla(kentta, 0), false);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaTrue() {
        kentta.setKentta(toimivaKentta);
        assertEquals(Tarkistaja.riveillaEiDuplikaatteja(kentta), true);
    }

    @Test
    public void riveillaEiDuplikaattejaPalauttaaFalse() {
        kentta.setKentta(eiToimivaKentta);
        assertEquals(Tarkistaja.riveillaEiDuplikaatteja(kentta), false);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaTrue() {
        kentta.setKentta(toimivaKentta);
        assertEquals(Tarkistaja.kaikkiNumerotRuudukossa(kentta, 0, 0), true);
    }

    @Test
    public void kaikkiNumerotRuudukossaPalauttaaFalse() {
        kentta.setKentta(eiToimivaKentta);
        assertEquals(Tarkistaja.kaikkiNumerotRuudukossa(kentta, 0, 0), false);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunNegatiivisiaArvoja() {
        kentta.setKentta(eiToimivaKentta3);
        assertEquals(Tarkistaja.oikeatNumerot(kentta), false);
    }

    @Test
    public void oikeatNumerotPalauttaaTrue() {
        kentta.setKentta(toimivaKentta);
        assertEquals(Tarkistaja.oikeatNumerot(kentta), true);
    }

    @Test
    public void oikeatNumerotPalauttaaFalseKunLiianSuuriaArvoja() {
        kentta.setKentta(eiToimivaKentta4);
        assertEquals(Tarkistaja.oikeatNumerot(kentta), false);
    }
    
    @Test
    public void validointiEiOnnistuKunRivillä2samaaNumeroa(){
        assertEquals(kentta.setKentta(validointiEiOnnistu), false);
    }
    
    @Test
    public void validointiEiOnnistuKunSarakkeessa2samaaNumeroa(){
        assertEquals(kentta.setKentta(validointiEiOnnistu2), false);
    }
    
    @Test
    public void validointiEiOnnistuKunRuudussa2samaaNumeroa(){
        assertEquals(kentta.setKentta(validointiEiOnnistu3), false);
    }
    
    @Test
    public void validointiOnnistuKunRivillä2Nollaa(){
        assertEquals(kentta.setKentta(validointiOnnistuu), true);
    }
    
     @Test
    public void validointiOnnistuKunSarakkeessa2Nollaa(){
        assertEquals(kentta.setKentta(validointiOnnistuu2), true);
    }
    
    @Test
    public void validointiOnnistuKunRuudussa2Nollaa(){
        assertEquals(kentta.setKentta(validointiOnnistuu3), true);
    }
    
    @Test
    public void eiNolliaPalauttaaFalseKunNollia(){
        kentta.setKentta(validointiOnnistuu);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }
    
    @Test
    public void tarkistaOikeellisuusPalauttaaTrueKunOikeinTäytettyKentta(){
        kentta.setKentta(toimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), true);
    }
    
    @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunRivillaDuplikaatteja(){
        kentta.setKentta(eiToimivaKentta);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }
    
     @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunSarakkeessaDuplikaatteja(){
        kentta.setKentta(eiToimivaKentta2);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }
    
     @Test
    public void tarkistaOikeellisuusPalauttaaFalseKunRuudussaDuplikaatteja(){
        kentta.setKentta(eiToimivaKentta2);
        assertEquals(Tarkistaja.tarkistaOikeellisuus(kentta), false);
    }

}
