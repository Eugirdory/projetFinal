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
import org.springframework.web.bind.annotation.CrossOrigin;
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

import formation.sopra.bu.projetDoki.metier.Patient;
import formation.sopra.bu.projetDoki.metier.Praticien;
import formation.sopra.bu.projetDoki.repository.PatientRepository;
import formation.sopra.bu.projetDoki.repository.PraticienRepository;
import formation.sopra.bu.projetDoki.view.JsonViews;


@RestController
@RequestMapping("/rest/praticien")
@CrossOrigin(origins="*")
public class PraticienRestController {

		
		@Autowired
		private PraticienRepository praticienRepository; 
		
		@JsonView(JsonViews.Common.class)
	    @GetMapping(value= {"","/"})
	    public ResponseEntity<List<Praticien>> findAll(){
	        return list();
	    }
	    
	    @JsonView(JsonViews.PraticienAvecRdv.class)
	    @GetMapping(value= {"/rdvs"})
	    public ResponseEntity<List<Praticien>> findAllAvecRdv(){
	        return list();
	    }
	    
	    public ResponseEntity<List<Praticien>> list(){
	        return new ResponseEntity<List<Praticien>>(praticienRepository.findAll(),HttpStatus.OK);
	    }
	    
	    @PostMapping(value= {"","/"})
	    public ResponseEntity<Void> create(@Valid @RequestBody Praticien praticien,BindingResult br, UriComponentsBuilder ucb){
	        if(br.hasErrors()) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        praticienRepository.save(praticien);
	        HttpHeaders headers=new HttpHeaders();
	        URI uri=ucb.path("/rest/praticien/{id}").buildAndExpand(praticien.getUsername()).toUri();
	        headers.setLocation(uri);
	        
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	    }
	    
	    @GetMapping(value= {"/{id}"})
	    @JsonView(JsonViews.Common.class)
	    public ResponseEntity<Praticien> findById(@PathVariable(name="id")Integer id){
	        return findPraticienById(id);
	    }
	    
	    @GetMapping(value= {"/{id}/rdvs"})
	    @JsonView(JsonViews.PraticienAvecRdv.class)
	    public ResponseEntity<Praticien> findByIdAvecRdv(@PathVariable(name="id")Integer id){
	        return findPraticienById(id);
	    }
	    
	    private ResponseEntity<Praticien> findPraticienById( Integer id){
	        Optional<Praticien> opt=praticienRepository.findById(id);
	        if (opt.isPresent()) {
	            return new ResponseEntity<Praticien>(opt.get(), HttpStatus.OK);
	        }
	        return new ResponseEntity<Praticien>(HttpStatus.NOT_FOUND);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Void> Update(@PathVariable(name="id") Integer id,@RequestBody Praticien praticien){
	    Optional<Praticien> opt = praticienRepository.findById(id);
	    	if (opt.isPresent()) {
	    	Praticien praticienEnBase=opt.get();
	    	praticienEnBase.setPrenom((praticien.getPrenom()!=null)?praticien.getPrenom():praticienEnBase.getPrenom());
	    	praticienEnBase.setNom((praticien.getNom()!=null)?praticien.getNom():praticienEnBase.getNom());
	    	praticienEnBase.setSpecialites((praticien.getSpecialites()!=null)?praticien.getSpecialites():praticienEnBase.getSpecialites());
	    	praticienEnBase.setDispos((praticien.getDispos()!=null)?praticien.getDispos():praticienEnBase.getDispos());
	    	praticienEnBase.setRdvs((praticien.getRdvs()!=null)?praticien.getRdvs():praticienEnBase.getRdvs());
	    	praticienEnBase.setMotifs((praticien.getMotifs()!=null)?praticien.getMotifs():praticienEnBase.getMotifs());
	    	praticienRepository.save(praticienEnBase);
	      	return new ResponseEntity<>(HttpStatus.OK);
	      	
	}
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	  @DeleteMapping("/{id}") 
	  public ResponseEntity<Void> delete(@PathVariable(name="id")Integer id){
		  Optional<Praticien> opt = praticienRepository.findById(id);
	  	if (opt.isPresent()) {
	  		praticienRepository.deleteById(id);
	      	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  	}
	    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	}


