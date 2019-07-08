package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Praticien")
@DiscriminatorValue("praticien")
public class Praticien extends Personne{
	
	@OneToMany
	@JoinColumn(name = "Spécialité")
	private List<Specialite> specialites;
	@OneToMany
	@JoinColumn(name = "id_dispo")
	private List<Disponibilite> dispos;
	@OneToMany(mappedBy = "praticien")
	@JoinColumn(name = "id_rdv")
	private List<RendezVous> rdvs;
	@OneToMany
	@JoinColumn(name = "id_motif")
	private List<Motif> motifs;
	
	public Praticien() {
	}

	public Praticien(List<Specilite> specialites, List<Disponibilite> dispos, List<RendezVous> rdvs,
			List<Motif> motifs) {
		this.specialites = specialites;
		this.dispos = dispos;
		this.rdvs = rdvs;
		this.motifs = motifs;
	}

	public List<Specilite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specilite> specialites) {
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
