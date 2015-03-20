package sudoku.logiikka;

public class Tarkistaja {

    public static boolean tarkistaOikeellisuus(int[][] kentta) {

        return sarakkeetOikein(kentta) && rivitOikein(kentta) && ruudutOikein(kentta);
    }

    private static boolean sarakkeetOikein(int[][] kentta) {
        for (int x = 0; x < kentta[0].length; x++) {
            if (kaikkiNumerotSarakkeessa(kentta, x)) {
                return false;
            }
        }
        return true;
    }

    private static boolean rivitOikein(int[][] kentta) {
        for (int y = 0; y < kentta.length; y++) {
            if (!kaikkiNumerotVaakarivilla(kentta[y])) {
                return false;
            }
        }
        return true;
    }

    private static boolean ruudutOikein(int[][] kentta) {
        for (int y = 0; y < kentta.length; y++) {
            if (y % 3 == 0) {
                for (int x = 0; x < kentta[0].length; x++) {
                    if (x % 3 == 0) {
                        if (!kaikkiNumerotRuudukossa(kentta, y, x)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean kaikkiNumerotSarakkeessa(int[][] kentta, int x) {
        boolean[] tarkistus = new boolean[kentta.length];

        for (int y = 0; y < kentta.length; y++) {
            tarkistus[y] = true;
        }

        return sisaltaaKaikkiNumerot(tarkistus);
    }

    public static boolean kaikkiNumerotVaakarivilla(int[] kentta) {

        boolean[] tarkistus = new boolean[kentta.length];

        for (int x = 0; x < kentta.length; x++) {
            tarkistus[kentta[x] - 1] = true;
        }

        return sisaltaaKaikkiNumerot(tarkistus);
    }

    public static boolean kaikkiNumerotRuudukossa(int[][] kentta, int startY, int startX) {
        boolean[] tarkistus = new boolean[kentta.length];

        for (int y = startY; y < startY + 3; y++) {
            for (int x = startX; x < startX + 3; x++) {
                tarkistus[kentta[y][x] - 1] = true;
            }
        }
        return sisaltaaKaikkiNumerot(tarkistus);
    }

    private static boolean sisaltaaKaikkiNumerot(boolean[] tarkistus) {
        for (int x = 0; x < tarkistus.length; x++) {
            if (tarkistus[x] == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean validoi(int[][] kentta) {
        if (!oikeatNumerot(kentta)){
            return false;
        }
        return (riveillaEiDuplikaatteja(kentta));
    }

    public static boolean oikeatNumerot(int[][] kentta) {
        for (int[] rivi : kentta) {
            for (int arvo : rivi) {
                if (arvo < 0 || arvo > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean riveillaEiDuplikaatteja(int[][] kentta) {
        for (int y = 0; y < kentta[0].length; y++) {
            int[] tarkistus = new int[kentta.length];
            for (int x = 0; x < kentta.length; x++) {
                if (++tarkistus[kentta[y][x] - 1] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean sarakkeissaEiDuplikaatteja(Kentta kentta) {
        return true;
    }

    private static boolean ruuduissaEiDuplikaatteja(Kentta kentta) {
        return true;
    }

}
