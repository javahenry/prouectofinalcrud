package ec.gob.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	Optional<Persona> findByNombres(String nombres);
}
