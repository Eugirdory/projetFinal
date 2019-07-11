package formation.sopra.bu.projetDoki.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.metier.Disponibilite;
import formation.sopra.bu.projetDoki.metier.Praticien;
import formation.sopra.bu.projetDoki.repository.DisponibiliteRepository;
import formation.sopra.bu.projetDoki.repository.PraticienRepository;
import formation.sopra.bu.projetDoki.view.JsonViews;

@RestController
@RequestMapping("/rest/disponibilites")
//@CrossOrigin(origins="*")
public class DisponibiliteRestController {

	@Autowired
	private DisponibiliteRepository disponibiliteRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Disponibilite>> findAll() {
		return list();
	}

	public ResponseEntity<List<Disponibilite>> list() {
		return new ResponseEntity<List<Disponibilite>>(disponibiliteRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> create(@Valid @RequestBody Disponibilite disponibilite, BindingResult br,
			UriComponentsBuilder ucb) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		disponibiliteRepository.save(disponibilite);
		HttpHeaders headers = new HttpHeaders();
		URI uri = ucb.path("/rest/disponibilites/{id}").buildAndExpand(disponibilite.getId()).toUri();
		headers.setLocation(uri);

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = { "/{id}" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Disponibilite> findById(@PathVariable(name = "id_dispo") Integer id) {
		return findDisponibiliteById(id);
	}


	private ResponseEntity<Disponibilite> findDisponibiliteById(Integer id) {
		Optional<Disponibilite> opt = disponibiliteRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Disponibilite>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Disponibilite>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> Update(@PathVariable(name = "id_dispo") Integer id,
			@RequestBody Disponibilite disponibilite) {
		Optional<Disponibilite> opt = disponibiliteRepository.findById(id);
		if (opt.isPresent()) {
			Disponibilite disponibiliteEnBase = opt.get();
			disponibiliteEnBase.setJour(
					(disponibilite.getJour() != null) ? disponibilite.getJour() : disponibiliteEnBase.getJour());
			disponibiliteEnBase.setHeureDebut((disponibilite.getHeureDebut() != null) ? disponibilite.getHeureDebut()
					: disponibiliteEnBase.getHeureDebut());
			disponibiliteEnBase.setHeureFin((disponibilite.getHeureFin() != null) ? disponibilite.getHeureFin()
					: disponibiliteEnBase.getHeureFin());
			disponibiliteEnBase.setCabinet((disponibilite.getCabinet() != null) ? disponibilite.getCabinet()
					: disponibiliteEnBase.getCabinet());
			disponibiliteRepository.save(disponibiliteEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id_dispo") Integer id) {
		Optional<Disponibilite> opt = disponibiliteRepository.findById(id);
		if (opt.isPresent()) {
			disponibiliteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
