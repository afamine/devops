package tn.esprit.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEntrepriseService;


@Controller
public class IControllerEntrepriseImpl{

	
	@Autowired
	IEntrepriseService ientrepriseservice;
	

	public int ajouterEntreprise(Entreprise ssiiConsulting) {
		ientrepriseservice.ajouterEntreprise(ssiiConsulting);
		return ssiiConsulting.getId();
	}
	public Entreprise getEntrepriseById(int entrepriseId) {

		return ientrepriseservice.getEntrepriseById(entrepriseId);
	}
	public void deleteEntrepriseById(int entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
	}
	
	
	
	
}

