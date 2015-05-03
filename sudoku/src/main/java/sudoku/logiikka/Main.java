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
            {0, 0, 0, 0, 0, 5, 0, 0, 0},
            {1, 5, 0, 0, 8, 0, 7, 0, 4},
            {7, 0, 0, 0, 0, 0, 5, 9, 0},
            {0, 0, 1, 3, 0, 0, 0, 8, 0},
            {9, 6, 0, 1, 0, 2, 0, 4, 5},
            {0, 2, 0, 0, 0, 9, 6, 0, 0},
            {0, 1, 7, 0, 0, 0, 0, 0, 3},
            {5, 0, 4, 0, 3, 0, 0, 7, 2},
            {0, 0, 0, 5, 0, 0, 0, 0, 0}};
        
        Kentta kentta = new Kentta(9);
        for (int y = 0; y < 9; y++){
            for (int x = 0; x < 9; x++){
                kentta.setArvo(y, x, k[y][x]);
            }
        }

        //kentta.setKentta(kentta);
        
        Sudoku sudoku = new Sudoku(kentta);
    }
    
}
