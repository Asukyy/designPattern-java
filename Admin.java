package designPattern;

import java.util.List;
import java.io.Serializable;

public class Admin extends Personne implements Serializable {
    public Admin(int idPersonne, String nom, String prénom, String dateDeNaissance, String adresse) {
        super(idPersonne, nom, prénom, dateDeNaissance, adresse);
    }

    public void ajouterÉlève(List<Élève> élèves, Élève nouvelÉlève) {
        élèves.add(nouvelÉlève);
    }

    public void ajouterNoteEleve(Élève eleve, Note note) {
        eleve.ajouterNote(note);
    }
    

    public void ajouterProfesseur(List<Professeur> professeurs, Professeur nouveauProfesseur) {
        professeurs.add(nouveauProfesseur);
    }
}
