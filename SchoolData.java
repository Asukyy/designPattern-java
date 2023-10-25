package designPattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolData implements Serializable {
    private List<Élève> élèves;
    private List<Professeur> professeurs;
    private List<Cours> cours;
    private List<Classe> classes;
    private List<Matière> matières;
    private Map<Integer, List<Note>> notes;

    private static SchoolData instance;

    private SchoolData() {
        élèves = new ArrayList<>();
        professeurs = new ArrayList<>();
        cours = new ArrayList<>();
        classes = new ArrayList<>();
        matières = new ArrayList<>();
        notes = new HashMap<>();
    }

    public static SchoolData getInstance() {
        if (instance == null) {
            instance = new SchoolData();
        }
        return instance;
    }

    public List<Élève> getÉlèves() {
        return élèves;
    }

    public Élève getÉlèveById(int id) {
        for (Élève élève : élèves) {
            if (élève.getIdPersonne() == id) {
                return élève;
            }
        }
        return null;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public List<Matière> getMatières() {
        return matières;
    }
    public Float getNote() {
        return getNote();
    }
}
