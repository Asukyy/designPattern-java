package designPattern;

import java.io.Serializable;

public class Personne implements Serializable {
    private int idPersonne;
    private String nom;
    private String prénom;
    private String dateDeNaissance;
    private String adresse;

    public Personne(int idPersonne, String nom, String prénom, String dateDeNaissance, String adresse) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prénom = prénom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }


    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }
}
