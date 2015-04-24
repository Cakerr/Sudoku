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
public class SolverTest {

    private Kentta kentta = new Kentta();
    private Solver solver;
    private int[][] solverTest1, solverTest1Answ;

    public SolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        int[][] toimivaKentta = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        solverTest1 = new int[][]{
            {0, 0, 0, 0, 0, 5, 0, 0, 0},
            {1, 5, 0, 0, 8, 0, 7, 0, 4},
            {7, 0, 0, 0, 0, 0, 5, 9, 0},
            {0, 0, 1, 3, 0, 0, 0, 8, 0},
            {9, 6, 0, 1, 0, 2, 0, 4, 5},
            {0, 2, 0, 0, 0, 9, 6, 0, 0},
            {0, 1, 7, 0, 0, 0, 0, 0, 3},
            {5, 0, 4, 0, 3, 0, 0, 7, 2},
            {0, 0, 0, 5, 0, 0, 0, 0, 0}};

        solverTest1Answ = new int[][]{
            {2, 4, 9, 7, 6, 5, 1, 3, 8},
            {1, 5, 6, 9, 8, 3, 7, 2, 4},
            {7, 8, 3, 2, 1, 4, 5, 9, 6},
            {4, 7, 1, 3, 5, 6, 2, 8, 9},
            {9, 6, 8, 1, 7, 2, 3, 4, 5},
            {3, 2, 5, 8, 4, 9, 6, 1, 7},
            {6, 1, 7, 4, 2, 8, 9, 5, 3},
            {5, 9, 4, 6, 3, 1, 8, 7, 2},
            {8, 3, 2, 5, 9, 7, 4, 6, 1}};

        kentta.setKentta(toimivaKentta);
        solver = new Solver();
        solver.setKentta(kentta);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void sisaltyyRiviinPalaauttaaTrueKunArvoLöytyyJoRiviltä() {
        assertEquals(solver.sisaltyyRiviin(3, 1), true);
    }

    @Test
    public void sisaltyyRiviinPalaauttaaFalseKunArvoEiLöydyRiviltä() {
        kentta.setArvo(0, 0, 0);
        assertEquals(solver.sisaltyyRiviin(1, 0), false);
    }

    @Test
    public void sisaltyyRiviinPalaauttaaTrueKunArvoLöytyyRivinViimeisestäPaikasta() {
        assertEquals(solver.sisaltyyRiviin(9, 0), true);
    }

    @Test
    public void sisaltaaSarakkeeseenPalauttaaTrueKunArvoLoytyyJoRivilta() {
        kentta.setArvo(3, 0, 0);
        assertEquals(solver.sisaltyySarakkeeseen(1, 0), true);
    }

    @Test
    public void sisaltyySarakkeeseenPalaauttaaFalseKunArvoaEiLöydySarakkeesta() {
        kentta.setArvo(0, 0, 0);
        assertEquals(solver.sisaltyySarakkeeseen(1, 0), false);
    }

    @Test
    public void sisaltyySarakkeeseenPalaauttaaTrueKunArvoLöytyySarakkeenViimeisestäSolusta() {
        assertEquals(solver.sisaltyyRiviin(9, 0), true);
    }

    @Test
    public void sisaltyyRuutuunPalaauttaaFalseKunArvoEiRuudussa() {
        kentta.setArvo(2, 2, 0);
        assertEquals(solver.sisaltyyRuutuun(9, 0, 0), false);
    }

    @Test
    public void sisaltyyRuutuunPalaauttaaTrueKunArvoOnJoRuudussa() {
        assertEquals(solver.sisaltyyRuutuun(9, 0, 0), true);
    }

    @Test
    public void solverPalauttaaTrueKunSudokunVoiRatkaista() {
        kentta.setKentta(solverTest1);
        assertEquals(solver.solve(0, 0), true);
    }

    @Test
    public void solverLuoOikeanRatkaisun() {
        kentta.setKentta(solverTest1);
        solver.solve(0, 0);
        for (int y = 0; y < kentta.getKoko(); y++) {
            for (int x = 0; x < kentta.getKoko(); x++) {
                assertEquals(kentta.getArvo(y, x), solverTest1Answ[y][x]);
            }
        }
    }

}
