public class Spielfeld {
    private Spielkarte[] kartenFelder;

    public Spielfeld() {
        kartenFelder = new Spielkarte[16];
        stapel s = new stapel();
        s.shuffle();
        Spielkarte[] karten = s.getKarten();

        for (int i = 0; i < 16; i++) {
            kartenFelder[i] = karten[i];
        }
        kartenFelder[0].umdrehen();
        kartenFelder[4].umdrehen();
        kartenFelder[8].umdrehen();
        kartenFelder[12].umdrehen();

    }

    public void setKarte(int pos, Spielkarte karte) {
        kartenFelder[pos] = karte;
    }

    public Spielkarte getKarte(int index) {
        return kartenFelder[index];
    }

    // Funktion gibt das Spielfeld als Liste aus
    public void printSpielfeld() {
        for (int i = 0; i < kartenFelder.length; i++) {
            Spielkarte karte = kartenFelder[i];
            if(karte.getOffen() != true){
                System.out.println("Umgedreht");

            }
            else{
            System.out.println(karte.getFarbe() + " " + karte.getWert() + " (ID: " + karte.getId() + ")");
        
            }
        }

    }
    
    public boolean vergleichen(String guess, int karte) {
        Spielkarte aktuelleKarte = kartenFelder[karte];
        Spielkarte vorherigeKarte = null;
        Spielkarte naechsteKarte = null;

        if (karte > 0) {
            vorherigeKarte = kartenFelder[karte - 1];
        }
        if (karte < kartenFelder.length - 1) {
            naechsteKarte = kartenFelder[karte + 1];
        }

        if (vorherigeKarte != null && !vorherigeKarte.getOffen()) {
            // Vorherige Karte ist umgedreht
            return vergleicheMitOffenerKarte(aktuelleKarte, vorherigeKarte, guess);
        } else if (naechsteKarte != null && !naechsteKarte.getOffen()) {
            // Nächste Karte ist umgedreht
            return vergleicheMitOffenerKarte(aktuelleKarte, naechsteKarte, guess);
        } else {
            // Beide anliegenden Karten sind aufgedeckt
            return vergleicheMitUmgedrehtenKarten(aktuelleKarte, vorherigeKarte, naechsteKarte, guess);
        }
    }

    private boolean vergleicheMitOffenerKarte(Spielkarte aktuelleKarte, Spielkarte offeneKarte, String guess) {
        int aktuellerWert = aktuelleKarte.getZahlenwert();
        int offenerWert = offeneKarte.getZahlenwert();

        if (guess.equals("Höher")) {
            return aktuellerWert > offenerWert;
        } else if (guess.equals("Niedriger")) {
            return aktuellerWert < offenerWert;
        } else {
            return false;
        }
    }

    private boolean vergleicheMitUmgedrehtenKarten(Spielkarte aktuelleKarte, Spielkarte vorherigeKarte, Spielkarte naechsteKarte, String guess) {
        if (vorherigeKarte == null || naechsteKarte == null) {
            return false;
        }

        int aktuellerWert = aktuelleKarte.getZahlenwert();
        int vorherigerWert = vorherigeKarte.getZahlenwert();
        int naechsterWert = naechsteKarte.getZahlenwert();

        if (guess.equals("Innerhalb")) {
            return aktuellerWert > vorherigerWert && aktuellerWert < naechsterWert;
        } else if (guess.equals("Außerhalb")) {
            return aktuellerWert < vorherigerWert || aktuellerWert > naechsterWert;
        } else {
            return false;
        }
    }



    

    public static void main(String[] args) {
        Spielfeld spielfeld = new Spielfeld();
        spielfeld.printSpielfeld();
    }

}