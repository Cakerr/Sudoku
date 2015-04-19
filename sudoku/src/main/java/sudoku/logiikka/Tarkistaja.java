package sudoku.logiikka;

/**
 * Luokka tarjoaa sudokulaudan tarkistamiseen ja validoimiseen tarvittavat
 * julkiset metodit.
 * @author ari
 */
public class Tarkistaja {

    /**
     *Tarkistaa täytetyn sudokun.
     * @param kentta tarkistettava kentta
     * @return False, jos sudoku ei ole oikein täytetty.
     */
    public static boolean tarkistaOikeellisuus(Kentta kentta) {
        if (eiNollia(kentta)) {
            return sarakkeetOikein(kentta) && rivitOikein(kentta) && ruudutOikein(kentta);
        }
        return false;
    }

    private static boolean eiNollia(Kentta kentta) {
        for (int y = 0; y < kentta.getKoko(); y++) {
            for (int x = 0; x < kentta.getKoko(); x++) {
                if (kentta.getArvo(y, x) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean sarakkeetOikein(Kentta kentta) {
        for (int x = 0; x < kentta.getKoko(); x++) {
            if (!kaikkiNumerotSarakkeessa(kentta, x)) {
                return false;
            }
        }
        return true;
    }

    private static boolean rivitOikein(Kentta kentta) {
        for (int y = 0; y < kentta.getKoko(); y++) {
            if (!kaikkiNumerotVaakarivilla(kentta, y)) {
                return false;
            }
        }
        return true;
    }

    private static boolean ruudutOikein(Kentta kentta) {
        for (int y = 0; y < kentta.getKoko(); y += 3) {
            for (int x = 0; x < kentta.getKoko(); x += 3) {
                if (!kaikkiNumerotRuudukossa(kentta, y, x)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean kaikkiNumerotSarakkeessa(Kentta kentta, int x) {
        boolean[] tarkistus = new boolean[kentta.getKoko()];

        for (int y = 0; y < kentta.getKoko(); y++) {
            tarkistus[kentta.getArvo(y, x) - 1] = true;
        }

        return sisaltaaKaikkiNumerot(tarkistus);
    }

    
    private static boolean kaikkiNumerotVaakarivilla(Kentta kentta, int y) {
        boolean[] tarkistus = new boolean[kentta.getKoko()];
        for (int x = 0; x < kentta.getKoko(); x++) {
            tarkistus[kentta.getArvo(y, x) - 1] = true;
        }

        return sisaltaaKaikkiNumerot(tarkistus);
    }

    
    private static boolean kaikkiNumerotRuudukossa(Kentta kentta, int startY, int startX) {
        boolean[] tarkistus = new boolean[kentta.getKoko()];

        for (int y = startY; y < startY + 3; y++) {
            for (int x = startX; x < startX + 3; x++) {
                tarkistus[kentta.getArvo(y, x) - 1] = true;
            }
        }
        return sisaltaaKaikkiNumerot(tarkistus);
    }

    private static boolean sisaltaaKaikkiNumerot(boolean[] tarkistus) {
        for (int x = 0; x < tarkistus.length; x++) {
            if (!tarkistus[x]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validoi uuden kentän.
     * 
     * @param kentta
     * @return false jos riveillä, sarakkeilla tai ruuduissa on samoja numeroita.
     */
    public static boolean validoi(Kentta kentta) {
        if (!oikeatNumerot(kentta)) {
            return false;
        }
        return (riveillaEiDuplikaatteja(kentta) && sarakkeissaEiDuplikaatteja(kentta) && ruuduissaEiDuplikaatteja(kentta));
    }

    private static boolean oikeatNumerot(Kentta kentta) {
        for (int y = 0; y < kentta.getKoko(); y++) {
            for (int x = 0; x < kentta.getKoko(); x++) {
                int arvo = kentta.getArvo(y, x);
                if (arvo < 0 || arvo > 9) {
                    return false;
                }
            }
        }
        return true;
    }

   
    private static boolean riveillaEiDuplikaatteja(Kentta kentta) {
        for (int y = 0; y < kentta.getKoko(); y++) {
            int[] tarkistus = new int[kentta.getKoko()];
            for (int x = 0; x < kentta.getKoko(); x++) {
                if (kentta.getArvo(y, x) < 1) {
                    continue;
                }
                if (++tarkistus[kentta.getArvo(y, x) - 1] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean sarakkeissaEiDuplikaatteja(Kentta kentta) {
        for (int x = 0; x < kentta.getKoko(); x++) {
            int[] tarkistus = new int[kentta.getKoko()];
            for (int y = 0; y < kentta.getKoko(); y++) {
                if (kentta.getArvo(y, x) < 1) {
                    continue;
                }
                if (++tarkistus[kentta.getArvo(y, x) - 1] > 1) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean ruuduissaEiDuplikaatteja(Kentta kentta) {

        for (int y = 0; y < kentta.getKoko(); y += 3) {
            for (int x = 0; x < kentta.getKoko(); x += 3) {
                int[] tarkistus = new int[kentta.getKoko()];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (kentta.getArvo(i, j) < 1) {
                            continue;
                        }
                        if (++tarkistus[kentta.getArvo(i, j) - 1] > 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}
