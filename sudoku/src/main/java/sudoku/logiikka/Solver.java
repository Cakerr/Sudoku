package sudoku.logiikka;

public class Solver {

    private Kentta kentta;

    public boolean solve(int y, int x) {

        //jos mennään rivin yli, lisätään y:n arvoa yhdellä ja nollataan x.
        if (x == 9) {
            x = 0;
            y += 1;
        }
        //Jos ollaan päästy kaikki rivit läpi, palautetaan true.
        if (y == 9) {
            return true;
        }
        //Jos arvo pisteessä (y,x) on jotain muuta kuin 0 hypätään seuraavaan soluun
        if (kentta.getArvo(y, x) != 0) {
            return solve(y, x+1);
        } else {
            for (int kokeiltavaArvo = 1; kokeiltavaArvo <= kentta.getKoko(); kokeiltavaArvo++) {

                if (!sisaltyyRiviin(kokeiltavaArvo, y)
                        && !sisaltyyRuutuun(kokeiltavaArvo, (y / 3) * 3, (x / 3) * 3)
                        && !sisaltyySarakkeeseen(kokeiltavaArvo, x)) {

                    kentta.setArvo(y, x, kokeiltavaArvo);

                    if (solve(y, x)) {
                        return true;
                    } else {
                        kentta.setArvo(y, x, 0);
                    }
                }
            }
        }
        return false;
    }

    public boolean sisaltyyRiviin(int arvo, int rivi) {
        for (int x = 0; x < kentta.getKoko(); x++) {
            if (kentta.getArvo(rivi, x) == arvo) {
                return true;
            }
        }
        return false;
    }

    public boolean sisaltyySarakkeeseen(int arvo, int sarake) {
        for (int y = 0; y < kentta.getKoko(); y++) {
            if (kentta.getArvo(y, sarake) == arvo) {
                return true;
            }
        }
        return false;
    }

    public boolean sisaltyyRuutuun(int arvo, int alkuY, int alkuX) {

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (kentta.getArvo(alkuY + y, alkuX + x) == arvo) {
                    return true;
                }
            }
        }
        return false;
    }

    void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }

}
