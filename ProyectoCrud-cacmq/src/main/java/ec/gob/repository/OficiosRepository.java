package ec.gob.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ec.gob.model.Oficios;

@Repository
//public interface OficiosRepository extends CrudRepository<Oficios, Integer> {
public interface OficiosRepository extends JpaRepository<Oficios, Integer> {



}


