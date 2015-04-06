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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] k =  new int[][]{
            {0, 0, 3, 4, 5, 0, 7, 0, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 0, 7, 8, 0, 1},
            {5, 0, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 0, 8, 9, 0, 2, 0, 4, 0},
            {9, 1, 0, 3, 4, 0, 6, 7, 0}};
        
        Kentta kentta = new Kentta();
        kentta.setKentta(k);
        
        Sudoku sudoku = new Sudoku(kentta);
    }
    
}
