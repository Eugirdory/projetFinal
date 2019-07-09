package formation.sopra.bu.projetDoki.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.bu.projetDoki.metier.Adresse;
import formation.sopra.bu.projetDoki.metier.Praticien;
import formation.sopra.bu.projetDoki.metier.Specialite;

public interface PraticienRepository extends JpaRepository <Praticien, Integer>{
	
	//@Query("select p from Praticien p left join fetch p.praticienSpe where p.specialite=:specialite")
//    public Optional<Praticien> findBySpecialite (@Param("specialite") Specialite specialite);
//	
//	public List<Praticien> findByNomContaining (String prenom);
//	
//    public List<Praticien> findByPrenomContaining (String prenom);
//	
	//@Query("select p from Praticien p left join fetch p.dispos where p.dispos.cabinet.ville=:lieu")
   // public Optional<Praticien> findByVille (@Param("lieu") String ville);
}
