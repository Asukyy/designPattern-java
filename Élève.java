package designPattern;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Élève extends Personne implements Serializable {
    private List<Cours> coursInscrits = new ArrayList<>();
    private List<Note> notes = new ArrayList<>();
    private float note;  // Add this attribute to store the student's note

    public void inscrireAuCours(Cours cours) {
        coursInscrits.add(cours);
    }

    public List<Cours> getCoursInscrits() {
        return coursInscrits;
    }

    public Élève(int idPersonne, String nom, String prénom, String dateDeNaissance, String adresse, float note) {
        super(idPersonne, nom, prénom, dateDeNaissance, adresse);
        this.note = note;
    }
    


    public void ajouterNote(Note note) {
        notes.add(note);
    }

    public float getNotes() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
