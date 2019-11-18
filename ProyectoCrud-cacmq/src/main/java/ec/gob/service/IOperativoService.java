package ec.gob.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.gob.model.Operativo;

public interface IOperativoService {
	void insertar(Operativo operativo);	
	List<Operativo> buscarTodas();
	Operativo buscarPorId(int idOperativo);
	List<String> buscarGeneros();
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
    List<Operativo> buscarActivas();	
	List<Operativo> buscarPorFecha(Date fecha);
	Page<Operativo> buscarTodas(Pageable page);	
	void eliminar(int idOperativo);
}
