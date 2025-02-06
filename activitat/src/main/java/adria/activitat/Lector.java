package adria.activitat;

import java.util.ArrayList;
import java.util.List;

class Lector {
    private String nom;
    private String ressenya;

    public Lector(String nom) {
        this.nom = nom;
        this.ressenya = "";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRessenyes() {
        return ressenya;
    }

    public void addRessenya(String ressenya) {
        this.ressenya = ressenya;
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom='" + nom + '\'' + ", ressenyas=" + ressenya + '}';
    }
}