package adria.activitat;

import java.sql.Date;


public class Llibre {
	private String titol;
	private String autor;
	private String genere;
	private String descripcio;
	private Date any_publicacio;
	private String portada;
	public Llibre(String titol, String autor, String genere, String descripcio, Date any_publicacio, String portada) {
		super();
		this.titol = titol;
		this.autor = autor;
		this.genere = genere;
		this.descripcio = descripcio;
		this.any_publicacio = any_publicacio;
		this.portada = portada;
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
}
