
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
public class UusiKenttapainike extends JMenuItem{
    private Gui ui;

    /**
     *
     * @param ui
     */
    public UusiKenttapainike(Gui ui) {
        super("Luo uusi sudoku");
        this.ui = ui;
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                UusiKenttapainike.this.ui.uusiKentta();
                UusiKenttapainike.this.ui.paivita();
            }
        });
    }
}
