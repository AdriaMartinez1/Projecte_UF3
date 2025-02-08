package adria.activitat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

public class Llibre {
    private String titol;
    private String autor;
    private String genere;
    private String descripcio;
    private int any_publicacio;
    private String portada;
    private List<Lector> lector;

    public Llibre(String titol, String autor, String genere, String descripcio, int any_publicacio, String portada) {
        this.titol = titol;
        this.autor = autor;
        this.genere = genere;
        this.descripcio = descripcio;
        this.any_publicacio = any_publicacio;
        this.portada = portada;
        this.lector = new ArrayList<>();
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

    public int getAny_publicacio() {
        return any_publicacio;
    }

    public void setAny_publicacio(int any_publicacio) {
        this.any_publicacio = any_publicacio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public List<Lector> getUsuaris() {
        return lector;
    }

    public void addUsuari(Lector usuari) {
        this.lector.add(usuari);
    }

    @Override
    public String toString() {
    	String sortida = 
                 " -------------------------------" + '\n' +
        		"Iitol= " + titol + '\n' +
                "Autor= " + autor + '\n' +
                "Genere= " + genere + '\n' +
                "Descripcio= " + descripcio + '\n' +
                "Any de publicacio= " + any_publicacio + '\n' +
                "Portada= " + portada + '\n' +
                "Lectors: " + '\n' ;
    	
    	for (int i = 0 ; i < lector.size(); i++)
    		{
    		sortida = sortida + lector.get(i).toString();
    		}
    	return sortida;
    }



	public Document toDocument() {
		Document doc = new Document("titol", this.titol)
                .append("autor", this.autor)
                .append("genere", this.genere)
                .append("descripcio", this.descripcio)
                .append("any_publicacio", this.any_publicacio)
                .append("portada", this.portada);
       // System.out.println("Document creat: " + doc.toJson());
		
		return doc;
	}
}

