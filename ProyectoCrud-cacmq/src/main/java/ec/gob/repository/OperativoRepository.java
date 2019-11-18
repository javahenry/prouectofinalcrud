package ec.gob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.gob.model.Operativo;
@Repository
public interface OperativoRepository extends JpaRepository<Operativo, Integer> {

}
