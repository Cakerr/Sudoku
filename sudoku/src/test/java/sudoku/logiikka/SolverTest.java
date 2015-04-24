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
        
        int [][] toimivaKentta = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        
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
    public void sisaltyyRiviinPalaauttaaTrueKunArvoLöytyyJoRiviltä(){
        assertEquals(solver.sisaltyyRiviin(3, 1), true);
    }
    
    @Test
    public void sisaltyyRiviinPalaauttaaFalseKunArvoEiLöydyRiviltä(){
        kentta.setArvo(0, 0, 0);
        assertEquals(solver.sisaltyyRiviin(1, 0), false);
    }
    
    @Test
    public void sisaltyyRiviinPalaauttaaTrueKunArvoLöytyyRivinViimeisestäPaikasta(){
        assertEquals(solver.sisaltyyRiviin(9, 0), true);
    }
    
}
