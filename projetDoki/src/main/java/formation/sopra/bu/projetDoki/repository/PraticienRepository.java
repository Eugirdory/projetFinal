package formation.sopra.bu.projetDoki.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.bu.projetDoki.metier.Adresse;
import formation.sopra.bu.projetDoki.metier.Praticien;
import formation.sopra.bu.projetDoki.metier.Specialite;

public interface PraticienRepository extends JpaRepository <Praticien, Integer>{
	
	@Query("select p from Praticien p where p.specialite=:specialite")
    public Optional<Praticien> findAllBySpecialite (@Param("specialite") Specialite specialite);
	
	@Query("select p from Praticien p where p.nom=:nom")
    public Optional<Praticien> findAllByNom (@Param("nom") String nom);
	
	@Query("select p from Praticien p where p.prenom=:prenom")
    public Optional<Praticien> findAllByPrenom (@Param("prenom") String prenom);
	
	@Query("select p from Praticien p where p.cabinet.ville=:lieu")
    public Optional<Praticien> findAllByVille (@Param("lieu") String ville);
}
