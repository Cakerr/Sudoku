package sudoku.logiikka;

import java.util.Random;

public class Generoija {

    private Kentta uusi = new Kentta(9);

    private int[][] pohja = new int[][]{
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {4, 5, 6, 7, 8, 9, 1, 2, 3},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {2, 3, 4, 5, 6, 7, 8, 9, 1},
        {5, 6, 7, 8, 9, 1, 2, 3, 4},
        {8, 9, 1, 2, 3, 4, 5, 6, 7},
        {3, 4, 5, 6, 7, 8, 9, 1, 2},
        {6, 7, 8, 9, 1, 2, 3, 4, 5},
        {9, 1, 2, 3, 4, 5, 6, 7, 8}};

    public Kentta generoi() {
        alustaKentta();
        sekoita();
        return uusi;
    }

    public void alustaKentta() {
        for (int i = 0; i < pohja.length; i++) {
            for (int j = 0; j < pohja[i].length; j++) {
                uusi.setArvo(i, j, pohja[i][j]);
            }
        }
    }

    public Kentta getKentta() {
        return uusi;
    }

    private void sekoita() {
        
        for (int i = 0; i < 5000; i++) {
            int rand = new Random().nextInt(6);

            //pyöritetään koko kenttää 90 astetta myötäpäivään
            if (rand == 4) {
                gridRolling();
            } else if (rand == 5) {
                int luku1 = new Random().nextInt(9);
                int luku2 = new Random().nextInt(9);

                while (luku2 == luku1) {
                    luku2 = new Random().nextInt(9);
                }

                vaihdaNumerotKeskenaan(luku1 + 1, luku2 + 1);
            } else {
                //ruutusarake/rivi, jonka sisällä swappi tehdään / joka swapataan
                int swap1 = new Random().nextInt(3) * 3;

                //jos rand < 2, niin tehdään swapataan rivi/sarake ruudukkorivin/sarakkeen sisällä
                if (rand < 2) {
                    //etäisyys ruudun alusta 1. swapttavaan riviin/sarakkeesen
                    int offset1 = new Random().nextInt(3);
                    //ensimmäinen swapattava rivi/sarake
                    int vaihto1 = offset1 + swap1;

                    //etäisyys ensimmäisestä swapattavasta rivistä/ruudusta, 1 tai 2.
                    int swap2 = new Random().nextInt(2) + 1;

                    swap2 += vaihto1;

                    //jakojäännöös ensimmäisen ja toisen swapattavan solun indeksien summasta
                    swap2 %= 3;

                    //lisätään jakojäännös ruutusarakkeen/rivin aloitusindeksiin.
                    swap2 += swap1;

                    if (rand == 0) {
                        riviSwap(swap1, swap2);
                    } else {
                        sarakeSwap(swap1, swap2);
                    }
                } else {
                    int swap2 = new Random().nextInt(3) * 3;

                    if (rand == 2) {
                        ruutuRiviSwap(swap1, 0, swap2, 0);
                    } else {
                        ruutuSarakeSwap(0, swap1, 0, swap2);
                    }
                }
            }
        }
    }

    public void vaihdaNumerotKeskenaan(int arvo1, int arvo2) {

        for (int y = 0; y < 9; y++) {
            boolean vaihdettu = false;
            for (int x = 0; x < 9; x++) {
                if (vaihdettu) {
                    break;
                }

                if (uusi.getArvo(y, x) == arvo1) {
                    for (int x2 = 0; x2 < 9; x2++) {
                        if (uusi.getArvo(y, x2) == arvo2) {
                            swap(y, x, y, x2);
                            vaihdettu = true;
                            break;
                        }
                    }

                }
            }
        }
    }

    public void ruutuRiviSwap(int y1, int x1, int y2, int x2) {
        for (int i = 0; i < 3; i++) {
                riviSwap(y1+i, y2+i);
        
        }
    }

    public void ruutuSarakeSwap(int y1, int x1, int y2, int x2) {
        for (int j = 0; j < 3; j++) {
            sarakeSwap(x1+j, x2+j);
        }

    }

    public void riviSwap(int y1, int y2) {
        for (int x = 0; x < 9; x++) {
            swap(y1, x, y2, x);
        }
    }

    public void sarakeSwap(int x1, int x2) {
        for (int y = 0; y < 9; y++) {
            swap(y, x1, y, x2);
        }
    }

    private void swap(int y1, int x1, int y2, int x2) {
        int temp;
        temp = uusi.getArvo(y1, x1);
        uusi.setArvo(y1, x1, uusi.getArvo(y2, x2));
        uusi.setArvo(y2, x2, temp);
    }

    public void gridRolling() {
        int[][] temp = new int[9][9];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 8; j >= 0; j--) {
                if (x == 9) {
                    x = 0;
                    y++;
                }
                temp[y][x] = uusi.getArvo(j, i);
                x++;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                uusi.setArvo(i, j, temp[i][j]);
            }
        }
    }

}
