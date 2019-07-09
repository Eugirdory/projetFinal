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
import formation.sopra.bu.projetDoki.repository.PatientRepository;
import formation.sopra.bu.projetDoki.view.JsonViews;

@RestController
@RequestMapping("/rest/patient")
//@CrossOrigin(origins="*")
public class PatientRestController {
	
	@Autowired
	private PatientRepository patientRepository; 
	
	@JsonView(JsonViews.Common.class)
    @GetMapping(value= {"","/"})
    public ResponseEntity<List<Patient>> findAll(){
        return list();
    }
    
    @JsonView(JsonViews.PatientAvecRdv.class)
    @GetMapping(value= {"/rdvs"})
    public ResponseEntity<List<Patient>> findAllAvecRdv(){
        return list();
    }
    
    public ResponseEntity<List<Patient>> list(){
        return new ResponseEntity<List<Patient>>(patientRepository.findAll(),HttpStatus.OK);
    }
    
    @PostMapping(value= {"","/"})
    public ResponseEntity<Void> create(@Valid @RequestBody Patient patient,BindingResult br, UriComponentsBuilder ucb){
        if(br.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.save(patient);
        HttpHeaders headers=new HttpHeaders();
        URI uri=ucb.path("/rest/patient/{id}").buildAndExpand(patient.getUsername()).toUri();
        headers.setLocation(uri);
        
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @GetMapping(value= {"/{id}"})
    @JsonView(JsonViews.Common.class)
    public ResponseEntity<Patient> findById(@PathVariable(name="id")String id){
        return findPatientById(id);
    }
    
    @GetMapping(value= {"/{id}/rdvs"})
    @JsonView(JsonViews.PatientAvecRdv.class)
    public ResponseEntity<Patient> findByIdAvecRdv(@PathVariable(name="id")String id){
        return findPatientById(id);
    }
    
    private ResponseEntity<Patient> findPatientById( String id){
        Optional<Patient> opt=patientRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<Patient>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> Update(@PathVariable(name="id") String id,@RequestBody Patient patient){
    Optional<Patient> opt = patientRepository.findById(id);
    	if (opt.isPresent()) {
    	Patient patientEnBase=opt.get();
    	patientEnBase.setPrenom((patient.getPrenom()!=null)?patient.getPrenom():patientEnBase.getPrenom());
    	patientEnBase.setNom((patient.getNom()!=null)?patient.getNom():patientEnBase.getNom());
    	patientEnBase.setMail((patient.getMail()!=null)?patient.getMail():patientEnBase.getMail());
    	patientEnBase.setTelephone((patient.getTelephone()!=null)?patient.getTelephone():patientEnBase.getTelephone());
    	patientEnBase.setDateNaissance((patient.getDateNaissance()!=null)?patient.getDateNaissance():patientEnBase.getDateNaissance());
    	patientEnBase.setDomicile((patient.getDomicile()!=null)?patient.getDomicile():patientEnBase.getDomicile());
    	patientRepository.save(patientEnBase);
      	return new ResponseEntity<>(HttpStatus.OK);
      	
}
    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
}

  @DeleteMapping("/{id}") 
  public ResponseEntity<Void> delete(@PathVariable(name="id")String id){
	  Optional<Patient> opt = patientRepository.findById(id);
  	if (opt.isPresent()) {
  		patientRepository.deleteById(id);
      	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  	}
    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

}
}
