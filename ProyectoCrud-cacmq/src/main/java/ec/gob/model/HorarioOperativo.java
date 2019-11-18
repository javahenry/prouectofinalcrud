package ec.gob.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "horarioOperativos")
public class HorarioOperativo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhora;
	private Date fecha;
	private String hora;
	private String lugar;
	private int efectivos;
	//@Transient
	@ManyToOne
	@JoinColumn(name = "idoperativo")
	private Operativo operativo;
	
	
	public HorarioOperativo() {
		
	}

	public int getIdhora() {
		return idhora;
	}
	
	public void setIdhora(int idhora) {
		this.idhora = idhora;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getEfectivos() {
		return efectivos;
	}
	public void setEfectivos(int efectivos) {
		this.efectivos = efectivos;
	}
	public Operativo getOperativo() {
		return operativo;
	}
	public void setOperativo(Operativo operativo) {
		this.operativo = operativo;
	}
	@Override
	public String toString() {
		return "HorarioOperativo [idhora=" + idhora + ", fecha=" + fecha + ", hora=" + hora + ", lugar=" + lugar
				+ ", efectivos=" + efectivos + ", operativo=" + operativo + "]";
	}
	
	
}
