package tn.esprit.spring.services;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	public void deleteEntrepriseById(int entrepriseId);
	public Entreprise getEntrepriseById(int entrepriseId);
	
}
