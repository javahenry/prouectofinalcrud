package ec.gob.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.gob.model.Oficios;
import ec.gob.model.Operativo;

public interface IOficiosService {
	void insertar(Oficios oficios);	
	List<Oficios> buscarTodas();
	Oficios buscarPorId(int idOficios);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
    List<Oficios> buscarActivas();	
	List<Oficios> buscarPorFecha(Date fecha);
	Page<Oficios> buscarTodas(Pageable page);	
	void eliminar(int idOfcios);

}
