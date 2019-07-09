package formation.sopra.bu.projetDoki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.bu.projetDoki.metier.PraticienMotif;
import formation.sopra.bu.projetDoki.metier.PraticienMotifKey;

public interface PraticienMotifRepository extends JpaRepository<PraticienMotif, PraticienMotifKey>{

}
