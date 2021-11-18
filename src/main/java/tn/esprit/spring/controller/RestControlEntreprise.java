package tn.esprit.spring.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.mapper.EntrepriseDto;
import tn.esprit.spring.mapper.MapStructMapperImpl;
import tn.esprit.spring.services.IEntrepriseService;


@RestController
public class RestControlEntreprise {

	
	@Autowired
	IEntrepriseService ientrepriseservice;
	private MapStructMapperImpl mapperImpl;
	@Autowired
	    public RestControlEntreprise(
	    		MapStructMapperImpl mapperImpl
	    ) {
	        this.mapperImpl = mapperImpl;
	    }
	 
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RestControlEntreprise.class);
	@PostMapping("/ajouterEntreprise")
    public ResponseEntity<Void> ajouterEntreprise(@Valid @RequestBody EntrepriseDto entrDto) {
		
        logger.trace("Begin Function ajouterEntreprise");
    	try {
    		logger.trace("MESSAGE TRACE : BEGIN METHOD ajouterEntreprise ");
    		logger.info("MESSAGE INFO :ajouterEntreprise");
    		ientrepriseservice.ajouterEntreprise(mapperImpl.entreprisePostDtoToEntreprise(entrDto));
    		logger.info(" MESSAGE INFO : OUT ajouterEntreprise");
    		
    	
    		
		} catch (Exception e) {
			logger.error("MESSAGE ERROR TO ajouterEntreprise : ", e);
		}
    	 logger.trace(" MESSAGE TRACE : END FUNCTION ajouterEntreprise");
    	 return new ResponseEntity<>(HttpStatus.CREATED);
    }

	
    @PutMapping(value = "/affecterDepartementAEntreprise/{iddept}/{identreprise}") 
	public void affecterDepartementAEntreprise(@PathVariable("iddept")int depId, @PathVariable("identreprise")int entrepriseId) 
    { logger.trace("Begin Function affecterDepartementAEntreprise");
    	try {
    		logger.trace("MESSAGE TRACE : BEGIN METHOD affecterDepartementAEntreprise ");
    		logger.info("MESSAGE INFO :IN AFFECT DEPARTMENT TO ENTREPRISE");
    		logger.debug("MESSAGE DEBUG : affecterDepartementAEntreprise : START ");
    		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
    		logger.debug("MESSAGE DEBUG To affecterDepartementAEntreprise : END ");
    		logger.info(" MESSAGE INFO : OUT AFFECT DEPARTMENT TO ENTREPRISE");
    		
		} catch (Exception e) {
			logger.error("MESSAGE ERROR TO affecterDepartementAEntreprise : ", e);
		}
    	 logger.trace(" MESSAGE TRACE : END FUNCTION affecterDepartementAEntreprise");
	}

    @DeleteMapping("/deleteEntrepriseById/{identreprise}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("identreprise")int entrepriseId)
	{
		
		logger.trace("Begin Function deleteEntrepriseById");
    	try {
    		logger.trace("MESSAGE TRACE : BEGIN METHOD deleteEntrepriseById ");
    		logger.info("MESSAGE INFO : IN DELETE ENTREPRISE BY ID");
    		ientrepriseservice.deleteEntrepriseById(entrepriseId);
    		logger.info("MESSAGE INFO : ENTREPRISE DELETE");
    		
		} catch (Exception e) {
			logger.error("MESSAGE ERROR TO deleteEntrepriseById : ", e);
		}
    	 logger.trace("MESSAGE TRACE :END FUNCTION deleteEntrepriseById");
	}
    

    @GetMapping(value= "/getEntrepriseById/{identreprise}")
    @ResponseBody
	public Entreprise getEntrepriseById(@PathVariable("identreprise") int entrepriseId) {
    	
    		 logger.trace("Begin Function getEntrepriseById");
    		 logger.trace("MESSAGE TRACE : BEGIN METHOD getEntrepriseById ");
    	     logger.info("MESSAGE INFO :getEntrepriseById");
    	     Entreprise get = ientrepriseservice.getEntrepriseById(entrepriseId);
    	     logger.info(" MESSAGE INFO : OUT getEntrepriseById");
       	   	 logger.trace(" MESSAGE TRACE : END FUNCTION getEntrepriseById");
			 return get;
    	
	
	}
    
   
   
    
	
    
}
