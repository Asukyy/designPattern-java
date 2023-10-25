package designPattern;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    private int idCours;
    private String nomCours;
    private String horaire;
    private List<Élève> élèvesInscrits; 
    

    public Cours(int idCours, String nomCours, String horaire) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.horaire = horaire;
        this.élèvesInscrits = new ArrayList<>();
    }

    public int getIdCours() {
        return idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public String getHoraire() {
        return horaire;
    }

    public void inscrireÉlève(Élève élève) {
        élèvesInscrits.add(élève);
    }

    public List<Élève> getÉlèvesInscrits() {
        return élèvesInscrits;
    }
}
