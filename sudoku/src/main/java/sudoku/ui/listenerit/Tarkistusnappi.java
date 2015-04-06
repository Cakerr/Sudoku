/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.listenerit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sudoku.ui.Ui;

/**
 *
 * @author ari
 */
public class Tarkistusnappi extends JMenuItem {

    private Ui ui;

    public Tarkistusnappi(Ui ui) {
        super("Tarkista");
        this.ui = ui;
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Tarkistusnappi.this.ui.tarkista()) {
                    JOptionPane.showMessageDialog(null, "Onneksi olkoon, sudoku on ratkaistu oikein!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nyt on menty jossain metsään! Yritäppä uudelleen");
                }
            }
        });
    }
}
