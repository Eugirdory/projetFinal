package formation.sopra.bu.projetDoki.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.sopra.bu.projetDoki.metier.Personne;

public interface PersonneRepository extends JpaRepository<Personne, String>{

	@Query ("select distinct p from Personn p left join fetch p.roles where p.username=:username")
	Optional<Personne> findByIdWithRoles (String username);
}
