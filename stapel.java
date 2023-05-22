import java.util.Random;

public class stapel {
    private Spielkarte[] karten;

    public stapel() {
        // Erstellt ein Kartendeck mit allen Karten eines Bayerischen Blatts, jedem Wert
        // wird ein "zahlenWert" zugeordnet, zum einfacheren Vergleichen der Karten.
        karten = new Spielkarte[32];

        String[] farben = { "Eichel", "Gras", "Herz", "Schelln" };
        String[] werte = { "7", "8", "9", "10", "Unter", "Ober", "König", "Ass" };

        int id = 0;
        int zahlenWert = 0;
        int index = 0;
        for (String wert : werte) {
            for (String farbe : farben) {
                karten[index] = new Spielkarte(farbe, wert, zahlenWert, id);
                id++;
                index++;
            }
            zahlenWert++;
        }
    }

    // gibt das Kartendeck auf der Konsole aus
    public void printStapel() {
        for (int i = 0; i < karten.length; i++) {
            Spielkarte karte = karten[i];
            System.out.println(karte.getFarbe() + " " + karte.getWert() + " (ID: " + karte.getId() + ")");
        }
    }

    public Spielkarte[] getKarten() {
        return karten;
    }

    // Funktion mischt die Karten
    public void shuffle() {
        Random r = new Random();
        for (int i = karten.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Spielkarte temp = karten[i];
            karten[i] = karten[j];
            karten[j] = temp;
        }
    }
public static void main(String[] args){
stapel s = new stapel();
s.printStapel();

}
}
