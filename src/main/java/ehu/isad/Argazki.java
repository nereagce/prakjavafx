package ehu.isad;

public class Argazki {
    private String izena;
    private String dir;

    public Argazki(String izena, String dir) {
        this.izena = izena;
        this.dir = dir;
    }

    @Override
    public String toString() {
        return  izena ;
    }
}