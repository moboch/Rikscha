public class Spieler {
    private String geschlecht;
    private int alter;
    private String name;

    public Spieler(String geschlecht, int alter, String n) {
        this.geschlecht = geschlecht;
        this.alter = alter;
        name = n;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
    public void setName(String name){

        this.name = name;
    }
    public String getName(){

        return name;
    }

}


