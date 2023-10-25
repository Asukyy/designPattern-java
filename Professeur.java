package designPattern;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Professeur extends Personne implements Serializable {
    private List<String> matièresEnseignées;
    private Float note;

    public Professeur(int idPersonne, String nom, String prénom, String dateDeNaissance, String adresse) {
        super(idPersonne, nom, prénom, dateDeNaissance, adresse);
        matièresEnseignées = new ArrayList<>();
        note = 0.0f;
    }

    public void ajouterMatière(String matière) {
        matièresEnseignées.add(matière);
    }
    public void ajouterNote(Float note) {
        this.note = note;
    }

    public void ajouterNoteEleve(Élève eleve, double valeurNote) {
        int noteId = Note.getUniqueNoteId();
        Note note = new Note(noteId, valeurNote);
        eleve.ajouterNote(note);
    }
    

    
}
