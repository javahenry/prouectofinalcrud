package ec.gob.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "Operativo")
public class Operativo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int eventosControlados;
	private int disuacionAcogPerso;
	private int AprenDelin;
	private int infoturis;
	private int AprenGrafi;
	private int operAmc;
	private int retenciones;
	private int personasEncontadas;
	private int sitioClausurados;
	private int personaAgredido;
	private int licoresDecomisados;
	private Date fecha;
	
	
	
//@Transient //no sea persistencia no le va tomar encuenta atributo detalle
@OneToOne	
@JoinColumn(name = "idDetalle")
	private Detalle detalle;
//de uno a muchos inversa
@OneToMany(mappedBy = "operativo",fetch = FetchType.EAGER)
private List<HorarioOperativo> horarios;

	public Operativo() {
	
}

	public List<HorarioOperativo> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioOperativo> horarios) {
		this.horarios = horarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventosControlados() {
		return eventosControlados;
	}

	public void setEventosControlados(int eventosControlados) {
		this.eventosControlados = eventosControlados;
	}

	public int getDisuacionAcogPerso() {
		return disuacionAcogPerso;
	}

	public void setDisuacionAcogPerso(int disuacionAcogPerso) {
		this.disuacionAcogPerso = disuacionAcogPerso;
	}

	public int getAprenDelin() {
		return AprenDelin;
	}

	public void setAprenDelin(int aprenDelin) {
		AprenDelin = aprenDelin;
	}

	public int getInfoturis() {
		return infoturis;
	}

	public void setInfoturis(int infoturis) {
		this.infoturis = infoturis;
	}

	public int getAprenGrafi() {
		return AprenGrafi;
	}

	public void setAprenGrafi(int aprenGrafi) {
		AprenGrafi = aprenGrafi;
	}

	public int getOperAmc() {
		return operAmc;
	}

	public void setOperAmc(int operAmc) {
		this.operAmc = operAmc;
	}

	public int getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(int retenciones) {
		this.retenciones = retenciones;
	}

	public int getPersonasEncontadas() {
		return personasEncontadas;
	}

	public void setPersonasEncontadas(int personasEncontadas) {
		this.personasEncontadas = personasEncontadas;
	}

	public int getSitioClausurados() {
		return sitioClausurados;
	}

	public void setSitioClausurados(int sitioClausurados) {
		this.sitioClausurados = sitioClausurados;
	}

	public int getPersonaAgredido() {
		return personaAgredido;
	}

	public void setPersonaAgredido(int personaAgredido) {
		this.personaAgredido = personaAgredido;
	}

	public int getLicoresDecomisados() {
		return licoresDecomisados;
	}

	public void setLicoresDecomisados(int licoresDecomisados) {
		this.licoresDecomisados = licoresDecomisados;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Operativo [id=" + id + ", eventosControlados=" + eventosControlados + ", disuacionAcogPerso="
				+ disuacionAcogPerso + ", AprenDelin=" + AprenDelin + ", infoturis=" + infoturis + ", AprenGrafi="
				+ AprenGrafi + ", operAmc=" + operAmc + ", retenciones=" + retenciones + ", personasEncontadas="
				+ personasEncontadas + ", sitioClausurados=" + sitioClausurados + ", personaAgredido=" + personaAgredido
				+ ", licoresDecomisados=" + licoresDecomisados + ", fecha=" + fecha + ", detalle=" + detalle
				+ ", horarios=" + horarios + "]";
	}

	

	

	


}
