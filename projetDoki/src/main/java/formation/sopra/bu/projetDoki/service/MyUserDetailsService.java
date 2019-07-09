package formation.sopra.bu.projetDoki.service;

import java.util.Optional;

import formation.sopra.bu.projetDoki.metier.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.bu.projetDoki.metier.Personne;
import formation.sopra.bu.projetDoki.repository.PersonneRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Personne> opt= personneRepository.findByIdWithRoles(username);
		if(opt.isPresent()) { 
			return new MyUserDetails(opt.get());
		}
		
		throw new UsernameNotFoundException("utilisateur inconnu");
	}
	
	
}
