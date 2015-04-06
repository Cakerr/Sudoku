
package sudoku.ui.listenerit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sudoku.ui.Gui;
import sudoku.ui.Ui;

public class UusiKenttaPainike extends JMenuItem{
    private Gui ui;

    public UusiKenttaPainike(Gui ui) {
        super("Luo uusi sudoku");
        this.ui = ui;
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                UusiKenttaPainike.this.ui.uusiKentta();
                UusiKenttaPainike.this.ui.paivita();
            }
        });
    }
}
