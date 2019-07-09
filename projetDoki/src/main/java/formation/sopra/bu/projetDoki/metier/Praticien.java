package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
@Table(name = "praticien")
@DiscriminatorValue("praticien")
public class Praticien extends Personne{
	
	@OneToMany
	@Column(name = "Specialite")
	@JsonView(JsonViews.PraticienAvecSpe.class)
	private List<Specialite> specialites;
	
	@OneToMany(mappedBy = "key.praticien")
	private List<PraticienSpe> praticienSpe;
	
	@Column(name = "disponibilites")
	@OneToMany
	private List<Disponibilite> dispos;
	@OneToMany(mappedBy = "praticien")
	@Column(name = "id_rdv")
	private List<RendezVous> rdvs;
	
	@ManyToMany
	private List<Motif> motifs;
	
	public Praticien() {
	}

	public Praticien(List<Specialite> specialites, List<Disponibilite> dispos, List<RendezVous> rdvs,
			List<Motif> motifs) {
		this.specialites = specialites;
		this.dispos = dispos;
		this.rdvs = rdvs;
		this.motifs = motifs;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
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

	public List<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}
	
	//TODO Hastag and equals
	
}
