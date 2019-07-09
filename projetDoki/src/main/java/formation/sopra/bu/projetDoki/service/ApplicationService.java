package formation.sopra.bu.projetDoki.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.bu.projetDoki.metier.Personne;
import formation.sopra.bu.projetDoki.repository.PersonneRepository;

@Service
public class ApplicationService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public void run(String... args) throws Exception {
//		for(Personne personne : personneRepository.findAll()) {
//			personne.setPassword(passwordEncoder.encode("toto"));//pour encoder les MDP
//			personneRepository.save(personne);
//		
//		 }
	}
}
