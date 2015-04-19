/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui;

import sudoku.ui.listenerit.NumeroPainike;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sudoku.logiikka.Sudoku;
import sudoku.ui.listenerit.Tarkistusnappi;
import sudoku.ui.listenerit.UusiKenttaPainike;
import sudoku.ui.listenerit.Valmisnappi;

/**
 *
 * @author ari
 */
public class Gui extends JFrame implements Ui {

    private Sudoku sudoku;
    private JPanel tausta;
    private JLabel aika;
    private JMenuItem ratkaise;
   
    private JButton kentta[][];
    private JPanel ruudukko[][];
    private JMenuBar menubar;
    private JMenu menu, uusi;
    private JMenuItem tarkista, generoi, syota, valmisPainike;

    /**
     *
     * @param sudoku
     */
    public Gui(Sudoku sudoku) {
        this.sudoku = sudoku;

        luoKayttoliittyma();
    }

    private void luoKayttoliittyma() {
        setTitle("Supersudoku");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        luoKomponentit();

        setSize(600, 600);
        setContentPane(tausta);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private void luoKomponentit() {
        tausta = new JPanel();
        menubar = new JMenuBar();
        menu = new JMenu("Valikko");
        tarkista = new Tarkistusnappi(this);
        ratkaise = new JMenuItem("Ratkaise");
        generoi = new JMenuItem("Generoi");
        syota = new UusiKenttaPainike(this);
        uusi = new JMenu("Uusi");

        asetaKomponentit();
        luoRuudukko();
    }

    private void asetaKomponentit() {
        tausta.setLayout(new GridLayout(3, 3));
        tausta.setSize(600, 600);
        menubar.add(menu);
        setJMenuBar(menubar);
        menu.add(tarkista);
        menu.add(ratkaise);
        menu.add(uusi);
        uusi.add(syota);
        uusi.add(generoi);

    }

    private void luoRuudukko() {
        kentta = new JButton[9][9];
        ruudukko = new JPanel[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ruudukko[i][j] = new JPanel(new GridLayout(3, 3));
                ruudukko[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                kentta[i][j] = new NumeroPainike(i, j, sudoku.getArvo(i, j), this);
                kentta[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                kentta[i][j].setHorizontalAlignment(JTextField.CENTER);
                ruudukko[i / 3][j / 3].add(kentta[i][j]);
            }
        }

        for (int u = 0; u <= 2; u++) {
            for (int i = 0; i <= 2; i++) {
                tausta.add(ruudukko[u][i], BorderLayout.CENTER);
            }
        }

    }

    /**
     *
     * @param y
     * @param x
     * @param arvo
     */
    public void setArvo(int y, int x, int arvo) {
        sudoku.setArvo(y, x, arvo);
    }
    
    /**
     *
     */
    public void uusiKentta(){
        sudoku.uusiKentta();
        valmisPainike();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean tarkista() {
        return sudoku.tarkista();
    }

    /**
     *
     */
    @Override
    public void paivita() {
        for (int i = 0; i < kentta.length; i++) {
            for (int j = 0; j < kentta.length; j++) {
                kentta[i][j].setText("" + sudoku.getArvo(i, j));
                kentta[i][j].setEnabled(true);
            }
        }
    }

    private void valmisPainike() {
        valmisPainike = new Valmisnappi(this);
        menubar.add(valmisPainike);
    }

    /**
     *
     * @return
     */
    public boolean paivitaKentta() {
        return sudoku.tarkistaUusiKentta();
        
    }

  
}
