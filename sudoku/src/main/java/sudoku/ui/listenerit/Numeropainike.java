/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.listenerit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import sudoku.ui.Gui;

/**
 *
 * @author ari
 */
public class Numeropainike extends JButton {

    private boolean onkoValittu = false;
    private Gui ui;
    private int y;
    private int x;

    /**
     *
     * @param y
     * @param x
     * @param arvo
     * @param ui
     */
    public Numeropainike(int y, int x, int arvo, Gui ui) {
        super();
        this.y = y;
        this.x = x;
        this.ui = ui;

        setText("");
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                onkoValittu = !onkoValittu;
            }

        });

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (onkoValittu) {
                    int nappain = ke.getKeyCode();
                    if ((nappain >= 49 && nappain <= 57) || (nappain >= 97 && nappain <= 105)) {
                        Numeropainike.this.setText("" + ke.getKeyChar());
                        Numeropainike.this.ui.setArvo(Numeropainike.this.y, Numeropainike.this.x, Integer.parseInt("" + ke.getKeyChar()));
                    } else {

                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        });
        if (arvo != 0) {
            setText(Integer.toString(arvo));
            setEnabled(false);
        }
    }
}
