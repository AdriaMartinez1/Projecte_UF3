package adria.activitat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Llibre {
    private String titol;
    private String autor;
    private String genere;
    private String descripcio;
    private Date any_publicacio;
    private String portada;
    private List<Usuari> usuaris;

    public Llibre(String titol, String autor, String genere, String descripcio, Date any_publicacio, String portada) {
        this.titol = titol;
        this.autor = autor;
        this.genere = genere;
        this.descripcio = descripcio;
        this.any_publicacio = any_publicacio;
        this.portada = portada;
        this.usuaris = new ArrayList<>();
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getAny_publicacio() {
        return any_publicacio;
    }

    public void setAny_publicacio(Date any_publicacio) {
        this.any_publicacio = any_publicacio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public List<Usuari> getUsuaris() {
        return usuaris;
    }

    public void addUsuari(Usuari usuari) {
        this.usuaris.add(usuari);
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", genere='" + genere + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", any_publicacio=" + any_publicacio +
                ", portada='" + portada + '\'' +
                ", usuaris=" + usuaris +
                '}';
    }
}

class Ressenya {
    private String text;

    public Ressenya(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Ressenya{" + "text='" + text + '\'' + '}';
    }
}

class Usuari {
    private String nom;
    private List<Ressenya> ressenyes;

    public Usuari(String nom) {
        this.nom = nom;
        this.ressenyes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ressenya> getRessenyes() {
        return ressenyes;
    }

    public void addRessenya(Ressenya ressenya) {
        this.ressenyes.add(ressenya);
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom='" + nom + '\'' + ", ressenyes=" + ressenyes + '}';
    }
}