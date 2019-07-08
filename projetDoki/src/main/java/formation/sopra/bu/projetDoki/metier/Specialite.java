package formation.sopra.bu.projetDoki.metier;

import javax.persistence.*;

@Entity
@Table(name = "Specialité")
public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpe")
	@SequenceGenerator(name = "seqSpe", sequenceName = "sequence_specialité",initialValue = 1, allocationSize = 1)
	private Integer id;
	@Column(name = "libele")
	private String libele;
	
	public Specialite() {
	}
	public Specialite(String libele) {
		this.libele = libele;
	}
	
	public Specialite(Integer id, String libele) {
		this.id = id;
		this.libele = libele;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libele == null) ? 0 : libele.hashCode());
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
		return true;
	}
	
	
}
