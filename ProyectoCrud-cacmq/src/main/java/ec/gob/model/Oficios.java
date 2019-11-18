package ec.gob.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="oficios")
public class Oficios {
    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int numeroDoc;
	private String solicitante;
	private Date fecha;
	private String detalle;
	
	public Oficios() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(int numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Oficios [id=" + id + ", numeroDoc=" + numeroDoc + ", solicitante=" + solicitante + ", fecha=" + fecha
				+ ", detalle=" + detalle + "]";
	}

	

	
}
