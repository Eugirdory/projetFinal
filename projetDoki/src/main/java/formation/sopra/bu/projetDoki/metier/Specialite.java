package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.*;

@Entity
@Table(name = "Specialite")
public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpe")
	@SequenceGenerator(name = "seqSpe", sequenceName = "sequence_specialite",initialValue = 1, allocationSize = 1)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(name = "libele")
	private String libele;
	
	@OneToOne
	@JoinColumn(name = "id_praticien")
	@JsonView(JsonViews.Common.class)
	private Praticien praticien;
	
	@OneToMany(mappedBy = "key.specialite")
	@Column(name="praticien")
	private List<PraticienSpe> praticienSpe;
	
	
	//Constructor
	
	public Specialite() {
	}
	
	public Specialite(String libele) {
		this.libele = libele;
	}
	
	public Specialite(Integer id, String libele) {
		this.id = id;
		this.libele = libele;
	}
	
	//Getter et Setter
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<PraticienSpe> getPraticienSpe() {
		return praticienSpe;
	}

	public void setPraticienSpe(List<PraticienSpe> praticienSpe) {
		this.praticienSpe = praticienSpe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libele == null) ? 0 : libele.hashCode());
		result = prime * result + ((praticien == null) ? 0 : praticien.hashCode());
		result = prime * result + ((praticienSpe == null) ? 0 : praticienSpe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialite other = (Specialite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libele == null) {
			if (other.libele != null)
				return false;
		} else if (!libele.equals(other.libele))
			return false;
		if (praticien == null) {
			if (other.praticien != null)
				return false;
		} else if (!praticien.equals(other.praticien))
			return false;
		if (praticienSpe == null) {
			if (other.praticienSpe != null)
				return false;
		} else if (!praticienSpe.equals(other.praticienSpe))
			return false;
		return true;
	}

	
	
	
}
