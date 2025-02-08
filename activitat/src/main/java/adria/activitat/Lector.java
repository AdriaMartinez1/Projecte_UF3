package adria.activitat;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

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
        return "Nom= " + nom + ' ' + " Opinió= " + ressenya + '\n';
    }
    
    public Document toDocument()
    {
    	Document lectorJSON = new Document("nom", this.nom).append("ressenya", this.ressenya);
    	return lectorJSON;
    }
}