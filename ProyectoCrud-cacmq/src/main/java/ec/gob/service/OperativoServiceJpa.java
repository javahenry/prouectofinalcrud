package ec.gob.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ec.gob.model.Operativo;
import ec.gob.repository.OperativoRepository;

@Service
public class OperativoServiceJpa implements IOperativoService {
	@Autowired
	private OperativoRepository operativorepo;

	@Override
	public void insertar(Operativo operativo) {
		operativorepo.save(operativo);

	}

	@Override
	public List<Operativo> buscarTodas() {
		
		return operativorepo.findAll();
	}

	@Override
	public Operativo buscarPorId(int idOperativo) {
		Optional<Operativo> optional  =operativorepo.findById(idOperativo);
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
	public List<Operativo> buscarActivas() {


		return null;
	}

	@Override
	public List<Operativo> buscarPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Operativo> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idOperativo) {
		operativorepo.deleteById(idOperativo);

	}

}
