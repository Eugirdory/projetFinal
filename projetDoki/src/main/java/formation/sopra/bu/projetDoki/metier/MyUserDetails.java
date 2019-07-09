package formation.sopra.bu.projetDoki.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	private Personne personne;
	
	
	public MyUserDetails() {
	}

	public MyUserDetails(Personne personne) {
		super();
		this.personne = personne;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (UserRole userRole : personne.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().toString()));
		}
	
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return personne.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return personne.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return personne.isEnable();
	}

}
