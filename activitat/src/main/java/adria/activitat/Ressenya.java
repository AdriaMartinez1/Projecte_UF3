package adria.activitat;

import java.sql.Date;

public class Ressenya {
	private String usuari_id;
	private String llibre_id;
	private float valoracio;
	private String comentari;
	private Date data;
	public Ressenya(String usuari_id, String llibre_id, float valoracio, String comentari, Date data) {
		super();
		this.usuari_id = usuari_id;
		this.llibre_id = llibre_id;
		this.valoracio = valoracio;
		this.comentari = comentari;
		this.data = data;
	}
	public String getUsuari_id() {
		return usuari_id;
	}
	public void setUsuari_id(String usuari_id) {
		this.usuari_id = usuari_id;
	}
	public String getLlibre_id() {
		return llibre_id;
	}
	public void setLlibre_id(String llibre_id) {
		this.llibre_id = llibre_id;
	}
	public float getValoracio() {
		return valoracio;
	}
	public void setValoracio(float valoracio) {
		this.valoracio = valoracio;
	}
	public String getComentari() {
		return comentari;
	}
	public void setComentari(String comentari) {
		this.comentari = comentari;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
