package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
@Table(name = "praticien")
@DiscriminatorValue("praticien")
public class Praticien extends Personne {

//Attributs
	@OneToMany(mappedBy = "key.praticien")
	@Column(name = "specialite")
	@JsonView(JsonViews.PraticienAvecSpe.class)
	private List<PraticienSpecialite> specialites;

	@OneToMany(mappedBy = "key.praticien")
	private List<PraticienMotif> motifs;

	@Column(name = "disponibilites")
	@OneToMany
	private List<Disponibilite> dispos;

	@OneToMany(mappedBy = "praticien") // , fetch = FetchType.LAZY) ???
	@Column(name = "rdvs_avec-patient")
	@JsonView(JsonViews.PraticienAvecRdv.class)
	private List<RendezVous> rdvs;

//Constructeurs
	public Praticien() {
	}

	public Praticien(String mail, String username, String password, String civilite, String nom, String prenom,
			String telephone, List<PraticienSpecialite> specialites, List<PraticienMotif> motifs,
			List<Disponibilite> dispos, List<RendezVous> rdvs, boolean enable, List<UserRole> roles, int version) {
		super(mail, username, password, civilite, nom, prenom, telephone, enable, roles, version);
		this.specialites = specialites;
		this.motifs = motifs;
		this.dispos = dispos;
		this.rdvs = rdvs;
	}

//Getters & Setters

	public List<PraticienMotif> getMotifs() {
		return motifs;
	}

	public List<PraticienSpecialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<PraticienSpecialite> specialites) {
		this.specialites = specialites;
	}

	public void setMotifs(List<PraticienMotif> motifs) {
		this.motifs = motifs;
	}

	public List<Disponibilite> getDispos() {
		return dispos;
	}

	public void setDispos(List<Disponibilite> dispos) {
		this.dispos = dispos;
	}

	public List<RendezVous> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}

//HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dispos == null) ? 0 : dispos.hashCode());
		result = prime * result + ((motifs == null) ? 0 : motifs.hashCode());
		result = prime * result + ((rdvs == null) ? 0 : rdvs.hashCode());
		result = prime * result + ((specialites == null) ? 0 : specialites.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Praticien other = (Praticien) obj;
		if (dispos == null) {
			if (other.dispos != null)
				return false;
		} else if (!dispos.equals(other.dispos))
			return false;
		if (motifs == null) {
			if (other.motifs != null)
				return false;
		} else if (!motifs.equals(other.motifs))
			return false;
		if (rdvs == null) {
			if (other.rdvs != null)
				return false;
		} else if (!rdvs.equals(other.rdvs))
			return false;
		if (specialites == null) {
			if (other.specialites != null)
				return false;
		} else if (!specialites.equals(other.specialites))
			return false;
		return true;
	}

}