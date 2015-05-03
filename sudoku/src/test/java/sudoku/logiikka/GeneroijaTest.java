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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ari
 */
public class GeneroijaTest {

    private int[][] alkuTilanne, alkutilanne2;
    private Generoija gen = new Generoija();

    public GeneroijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        gen.alustaKentta();

        alkuTilanne = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        alkutilanne2 = new int[][]{
            {2, 1, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 2, 1, 3},
            {7, 8, 9, 2, 1, 3, 4, 5, 6},
            {1, 3, 4, 5, 6, 7, 8, 9, 2},
            {5, 6, 7, 8, 9, 2, 1, 3, 4},
            {8, 9, 2, 1, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 2, 1},
            {6, 7, 8, 9, 2, 1, 3, 4, 5},
            {9, 2, 1, 3, 4, 5, 6, 7, 8}};

    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustaKenttaTuottaaOikeanKentan() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(gen.getKentta().getArvo(i, j), alkuTilanne[i][j]);
            }
        }
    }

    @Test
    public void vaihdaNumerotKeskenaanTuottaaOikeanTilanteen() {
        gen.vaihdaNumerotKeskenaan(1, 2);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(gen.getKentta().getArvo(i, j), alkutilanne2[i][j]);
            }
        }
    }

    @Test
    public void ruuturivienVaihtoTuottaaOikeanTilanteen() {

        int[][] haluttuTilanne = new int[][]{
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6}};

        gen.ruutuRiviSwap(0, 0, 6, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(gen.getKentta().getArvo(i, j), haluttuTilanne[i][j]);
            }
        }
    }

    @Test
    public void ruutusarakkeenVaihtoTuottaaOikeantilanteen() {
        int[][] haluttuTilanne = new int[][]{
            {7, 8, 9, 4, 5, 6, 1, 2, 3},
            {1, 2, 3, 7, 8, 9, 4, 5, 6},
            {4, 5, 6, 1, 2, 3, 7, 8, 9},
            {8, 9, 1, 5, 6, 7, 2, 3, 4},
            {2, 3, 4, 8, 9, 1, 5, 6, 7},
            {5, 6, 7, 2, 3, 4, 8, 9, 1},
            {9, 1, 2, 6, 7, 8, 3, 4, 5},
            {3, 4, 5, 9, 1, 2, 6, 7, 8},
            {6, 7, 8, 3, 4, 5, 9, 1, 2}};

        gen.ruutuSarakeSwap(0, 0, 0, 6);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(gen.getKentta().getArvo(i, j), haluttuTilanne[i][j]);
            }
        }

    }

    @Test
    public void gridrollingTuottaaHalutunTilanteen() {
        int [][]haluttuTilanne = new int[][]{
            {9, 6, 3, 8, 5, 2, 7, 4, 1},
            {1, 7, 4, 9, 6, 3, 8, 5, 2},
            {2, 8, 5, 1, 7, 4, 9, 6, 3},
            {3, 9, 6, 2, 8, 5, 1, 7, 4},
            {4, 1, 7, 3, 9, 6, 2, 8, 5},
            {5, 2, 8, 4, 1, 7, 3, 9, 6},
            {6, 3, 9, 5, 2, 8, 4, 1, 7},
            {7, 4, 1, 6, 3, 9, 5, 2, 8},
            {8, 5, 2, 7, 4, 1, 6, 3, 9}};
        
        gen.gridRolling();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(gen.getKentta().getArvo(i, j), haluttuTilanne[i][j]);
            }
        }
    }
}
