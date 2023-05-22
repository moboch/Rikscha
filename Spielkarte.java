public class Spielkarte {
    private String wert;
    private int zahlenWert;
    private String farbe;
    private int id;
    private boolean offen;

    public Spielkarte(String wert, String farbe, int i, int id) {
        this.wert = wert;
        this.farbe = farbe;
        this.zahlenWert = i;
        this.offen = false;
        this.id = id;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

    public int getZahlenwert() {
        return zahlenWert;
    }

    public void setZahlenwert(int zahlenwert) {
        this.zahlenWert = zahlenwert;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getOffen() {
        return offen;

    }

    public void umdrehen() {
        offen = !offen;

    }
    public Spielkarte ausgeben(){
        if(offen != true){
        return this;
    }
    else{

        return null;
    }
    }
}
