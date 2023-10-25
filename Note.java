package designPattern;
import java.io.Serializable;

public class Note implements Serializable {
    private int idÉlève;
    private static int uniqueNoteId = 1;
    private int idNote;
    private double valeur;

    public Note(int idNote, double valeur) {
        this.idNote = idNote;
        this.valeur = valeur;
    }

    public static int getUniqueNoteId() {
        return uniqueNoteId++;
    }

    public int getIdÉlève() {
        return idÉlève;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}

