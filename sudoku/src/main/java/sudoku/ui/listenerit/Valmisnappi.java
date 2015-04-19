

package sudoku.ui.listenerit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sudoku.ui.Gui;
import sudoku.ui.Ui;

/**
 *
 * @author ari
 */
public class Valmisnappi extends JMenuItem{
    private Gui ui;

    /**
     *
     * @param ui
     */
    public Valmisnappi(Gui ui) {
        super("Valmis"); 
        this.ui = ui;
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               
                if(!Valmisnappi.this.ui.paivitaKentta()){
                    JOptionPane.showMessageDialog(null, "Numerot 1-9 voivat ilmetä vain kerran per sarake, rivi ja 3x3 ruutu.");
                }
            }
        });
    }
}
