
package sudoku.ui;

import sudoku.logiikka.Kentta;
import sudoku.logiikka.Sudoku;

/**
 *
 * @author ari
 */
public interface Ui {
    
    /**
     *
     * @return
     */
    public boolean tarkista();
    
    /**
     *
     */
    public void paivita();

    public boolean ratkaise();

    public void asetaTyhjaKentta();

    public void generoi();
    
}
