package ec.gob.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ec.gob.model.Persona;

public interface IPersonaService {
	void insertar(Persona persona);	
	List<Persona> buscarTodas();
	Persona buscarPorId(int idPersona);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
	Persona buscarPorNombre(String nombre);
	List<Persona> buscarPorFecha(Date fecha);
	Page<Persona> buscarTodas(Pageable page);	
	void eliminar(int idPersona);
}
