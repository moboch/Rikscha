import java.util.Scanner;
import java.util.Random;

public class Spiel {
    private BinaryTree<Spieler> spielerBaum;
    private Spieler aktuellerSpieler;
    private Spielfeld Feld;
    public Spiel() {
        int anzahlSpieler = abfrageAnzahlSpieler();
        spielerBaum = erstelleSpielerBaum(anzahlSpieler);
        Feld = new Spielfeld();
    }

    private int abfrageAnzahlSpieler() { // Festlegen der Spieleranzahl
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Spieler nehmen am Spiel teil?");
        return scanner.nextInt();

    }

    private BinaryTree<Spieler> erstelleSpielerBaum(int anzahl) { // Speichern der Spieler im Binärbaum
        if (anzahl == 0) {
            return null;
        }
        BinaryTree<Spieler> links = erstelleSpielerBaum(anzahl / 2);
        BinaryTree<Spieler> rechts = erstelleSpielerBaum(anzahl - (anzahl / 2) - 1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib das Geschlecht des Spielers ein:");
        String geschlecht = scanner.next();
        System.out.println("Gib das Alter des Spielers ein:");
        int alter = scanner.nextInt();
        System.out.println("Gib den Namen des Spielers ein:");
        String name = scanner.next();
        return new BinaryTree<>(new Spieler(geschlecht, alter, name), links, rechts);
    }

    public void start() {
        Spieler beginnenderSpieler = waehleZufaelligenSpieler(spielerBaum);
        System.out.println("Das Spiel beginnt mit: " + beginnenderSpieler.getName());
        aktuellerSpieler = beginnenderSpieler;

    }

    private Spieler waehleZufaelligenSpieler(BinaryTree<Spieler> spielerBaum) {
        if (spielerBaum == null) {
            return null;
        }
        int anzahlSpielerLinks = getAnzahlSpieler(spielerBaum.getLeftChild());
        int anzahlSpielerRechts = getAnzahlSpieler(spielerBaum.getRightChild());
        int gesamtAnzahl = anzahlSpielerLinks + anzahlSpielerRechts + 1;
        Random random = new Random();
        int randomIndex = random.nextInt(gesamtAnzahl);
        if (randomIndex < anzahlSpielerLinks) {
            return waehleZufaelligenSpieler(spielerBaum.getLeftChild());
        } else if (randomIndex == anzahlSpielerLinks) {
            return spielerBaum.getData();
        } else {
            return waehleZufaelligenSpieler(spielerBaum.getRightChild());
        }
    }

    private int getAnzahlSpieler(BinaryTree<Spieler> spielerBaum) {
        if (spielerBaum == null) {
            return 0;
        }
        int anzahlSpielerLinks = getAnzahlSpieler(spielerBaum.getLeftChild());
        int anzahlSpielerRechts = getAnzahlSpieler(spielerBaum.getRightChild());
        return anzahlSpielerLinks + anzahlSpielerRechts + 1;
    }
    public void Spielzug(Spieler s){
        Feld.printSpielfeld();
       //Karte wählen:
       Scanner scanner = new Scanner(System.in);
        System.out.println("Wähle eine Karte");
        int gewaehlterSlot = scanner.nextInt();
        Spielkarte gewaehlteKarte = Feld.getKarte(gewaehlterSlot);

        if(gewaehlteKarte.getOffen() == true){
            System.out.println("Diese Karte Wurde bereits aufgedeckt");
            Spielzug(s);
        }
else{
        
    




    
    
    
    System.out.println("Höher oder Niedriger?");
        String Guess = scanner.next();
        
        



    }

    }



    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        spiel.start();
    }


    
        


    }








