package ec.gob.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ec.gob.model.Operativo;
import ec.gob.model.Persona;
import ec.gob.repository.PersonaRepository;
@Service
public class PersonaServiceJpa implements IPersonaService{
@Autowired
private PersonaRepository personarepo;

	@Override
	public void insertar(Persona persona) {
		personarepo.save(persona);
		
	}

	@Override
	public List<Persona> buscarTodas() {
		
		return personarepo.findAll();
	}

	@Override
	public Persona buscarPorId(int idPersona) {
		Optional<Persona> optional  =personarepo.findById(idPersona);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona buscarPorNombre(String nombre) {
	Optional<Persona> lista =personarepo.findByNombres(nombre);
	
	if(lista.isPresent()) {
		return lista.get();
	}
		return null;
	}

	@Override
	public List<Persona> buscarPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Persona> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idPersona) {
		// TODO Auto-generated method stub
		
	}

}
