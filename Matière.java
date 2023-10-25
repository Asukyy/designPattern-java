package designPattern;

public class Matière {
    private int idMatière;
    private String nomMatière;

    public Matière(int idMatière, String nomMatière) {
        this.idMatière = idMatière;
        this.nomMatière = nomMatière;
    }

    public int getIdMatière() {
        return idMatière;
    }

    public String getNomMatière() {
        return nomMatière;
    }
}
