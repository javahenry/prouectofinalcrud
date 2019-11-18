package ec.gob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.model.Detalle;
import ec.gob.repository.DetalleRepository;
@Service
public class DetalleServiceJPA implements IDetallesService {
	@Autowired
	private DetalleRepository detallesRepo;
	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
		
	}
	@Override
	public void eliminar(int iddetalle) {
		detallesRepo.deleteById(iddetalle);
		
	}

}
