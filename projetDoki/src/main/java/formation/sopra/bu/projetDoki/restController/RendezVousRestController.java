package formation.sopra.bu.projetDoki.restController;

import java.net.*;
import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;

import com.fasterxml.jackson.annotation.*;

import formation.sopra.bu.projetDoki.metier.*;
import formation.sopra.bu.projetDoki.repository.*;
import formation.sopra.bu.projetDoki.view.*;


@RestController
@RequestMapping("/rest/rdv")
//@CrossOrigin(origins="*")
public class RendezVousRestController {
	@Autowired
	private RendezVousRepository rendezVousRepository; 
	
	@JsonView(JsonViews.Common.class)
    @GetMapping(value= {"","/"})
    public ResponseEntity<List<RendezVous>> findAll(){
        return list();
    }
    
    @JsonView(JsonViews.RdvAvecPatient.class)
    @GetMapping(value= {"/patient"})
    public ResponseEntity<List<RendezVous>> findAllAvecPatient(){
        return list();
    }
    
    @JsonView(JsonViews.RdvAvecPraticien.class)
    @GetMapping(value= {"/praticien"})
    public ResponseEntity<List<RendezVous>> findAllAvecPraticien(){
        return list();
    }
    
    public ResponseEntity<List<RendezVous>> list(){
        return new ResponseEntity<List<RendezVous>>(rendezVousRepository.findAll(),HttpStatus.OK);
    }
    
    @PostMapping(value= {"","/"})
    public ResponseEntity<Void> create(@Valid @RequestBody RendezVous rdv,BindingResult br, UriComponentsBuilder ucb){
        if(br.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        rendezVousRepository.save(rdv);
        HttpHeaders headers=new HttpHeaders();
        URI uri=ucb.path("/rest/rdv/{id}").buildAndExpand(rdv.getId()).toUri();
        headers.setLocation(uri);
        
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @GetMapping(value= {"/{id}"})
    @JsonView(JsonViews.Common.class)
    public ResponseEntity<RendezVous> findById(@PathVariable(name="id")Integer id){
        return findRdvById(id);
    }

    
    private ResponseEntity<RendezVous> findRdvById( Integer id){
        Optional<RendezVous> opt=rendezVousRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<RendezVous>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<RendezVous>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> Update(@PathVariable(name="id") Integer id,@RequestBody RendezVous rendezVous){
    Optional<RendezVous> opt = rendezVousRepository.findById(id);
    	if (opt.isPresent()) {
    		RendezVous rdvEnBase=opt.get();
    		rdvEnBase.setDateRdv((rendezVous.getDateRdv()!=null)?rendezVous.getDateRdv():rdvEnBase.getDateRdv());
    		rdvEnBase.setHeureRdv((rendezVous.getHeureRdv()!=null)?rendezVous.getHeureRdv():rdvEnBase.getHeureRdv());
    		rdvEnBase.setMotif((rendezVous.getMotif()!=null)?rendezVous.getMotif():rdvEnBase.getMotif());
    		rdvEnBase.setPatient((rendezVous.getPatient()!=null)?rendezVous.getPatient():rdvEnBase.getPatient());
    		rdvEnBase.setPraticien((rendezVous.getPraticien()!=null)?rendezVous.getPraticien():rdvEnBase.getPraticien());
    		rendezVousRepository.save(rdvEnBase);
      	return new ResponseEntity<>(HttpStatus.OK);
      	
}
    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}

  @DeleteMapping("/{id}") 
  public ResponseEntity<Void> delete(@PathVariable(name="id")Integer id){
	  Optional<RendezVous> opt = rendezVousRepository.findById(id);
  	if (opt.isPresent()) {
  		rendezVousRepository.deleteById(id);
      	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  	}
    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

}
}
