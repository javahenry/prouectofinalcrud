package ec.gob.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ec.gob.model.Oficios;
import ec.gob.model.Operativo;
import ec.gob.repository.OficiosRepository;
import ec.gob.repository.OperativoRepository;
@Service
public class OficiosServiceJpa implements IOficiosService{
  @Autowired
  
  private OficiosRepository oficiosRepo ;
	@Override
	public void insertar(Oficios oficios) {
		oficiosRepo.save(oficios);
		
	}

	@Override
	public List<Oficios> buscarTodas() {
		
		return oficiosRepo.findAll();
	}

	@Override
	public Oficios buscarPorId(int idOficios) {
		Optional<Oficios> optional  = oficiosRepo.findById(idOficios);
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
	public List<Oficios> buscarActivas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Oficios> buscarPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Oficios> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idOfcios) {
		// TODO Auto-generated method stub
		
	}

}
