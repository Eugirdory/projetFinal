package formation.sopra.bu.projetDoki.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.bu.projetDoki.metier.Adresse;
import formation.sopra.bu.projetDoki.metier.Praticien;
import formation.sopra.bu.projetDoki.metier.Specialite;

public interface PraticienRepository extends JpaRepository<Praticien, String> {

//OK
	@Query("select distinct p from Praticien p left join fetch p.specialites as ss left join fetch ss.key as k left join fetch k.specialite as s where s.libelle=:libelle")
	List<Praticien> findAllBySpecialite(@Param("libelle") String libelle);

//OK
	public List<Praticien> findByNomContaining(String prenom);

//OK
	public List<Praticien> findByPrenomContaining(String prenom);

//OK
	@Query("select distinct p from Praticien p left join fetch p.dispos as d left join fetch d.cabinet as c where c.ville=:ville")
	Optional<Praticien> findAllByVille(@Param("ville") String ville);
	
//OK
	@Query("select distinct p from Praticien p inner join p.dispos as d inner join d.cabinet as c "
			+ "inner join p.specialites as ss inner join ss.key as k inner join k.specialite as s "
			+ "where c.ville=:ville and s.libelle=:libelle")
	Optional<Praticien> FindAllWithVilleAndSpecialite(@Param("ville") String ville, @Param("libelle") String llibelle);

}
