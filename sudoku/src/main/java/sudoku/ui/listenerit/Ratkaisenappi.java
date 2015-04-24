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
public class Ratkaisenappi extends JMenuItem{
    
    private Ui ui;
    
    public Ratkaisenappi(Ui ui){
        
        super("Ratkaise");
        this.ui = ui;
        
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!Ratkaisenappi.this.ui.ratkaise()){
                    JOptionPane.showMessageDialog(null, "Valitettavasti sudokulle ei löytynyt yhtään ratkaisua.");
                }
            }
        });
    }
    
}
