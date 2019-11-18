package ec.gob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.model.HorarioOperativo;
@Repository
public interface HorarioRepository extends JpaRepository<HorarioOperativo, Integer> {

}
