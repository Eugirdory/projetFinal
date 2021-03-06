package formation.sopra.bu.projetDoki.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.bu.projetDoki.metier.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{


	@Query("select distinct p from Patient p left join fetch p.rdvs where p.id=:id")
    Optional<Patient> findByIdWithRendezVous(@Param("id") String id);

}
