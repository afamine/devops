package tn.esprit.spring.mapper;
import org.springframework.stereotype.Component;
import tn.esprit.spring.entities.Entreprise;

@Component
public class MapStructMapperImpl {

	public Entreprise entreprisePostDtoToEntreprise(EntrepriseDto entrDto) {
        if ( entrDto == null ) {
            return null;
        }

        Entreprise entrp = new Entreprise();
        entrp.setId(entrDto.getId1());
        entrp.setName(entrDto.getName1());
        entrp.setRaisonSocial(entrDto.getRaisonSocial1());
        return entrp;
        
        
    }
	

}
