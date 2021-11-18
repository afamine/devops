package tn.esprit.spring.services;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Test
	public void testAjouterEntreprise() {
		Entreprise entreprise = new Entreprise("Vermeg","technologie");
		int a = ientrepriseservice.ajouterEntreprise(entreprise);
		assertEquals(entreprise.getId(), a);
	}
	
	@Test
	public void testaffecterEntrepriseADepartement() {
			List<Departement>list = new ArrayList<>();
			Departement departement1 = new Departement(2,"Info");
			list.add(departement1);
			Entreprise entreprise = new Entreprise(3,"Esprit",list);
			ientrepriseservice.affecterDepartementAEntreprise(departement1.getId(), entreprise.getId());
	        
			assertEquals(list,entreprise.getDepartements());
		}
	
	
	
	@Test
	public void testgetEntrepriseById() {
		Entreprise entreprise1 = new Entreprise(1,"vermeg");
		Entreprise entreprise2 = entrepriseRepoistory.save(entreprise1);
		Optional<Entreprise> optional = entrepriseRepoistory.findById(entreprise2.getId());
		assertEquals(entreprise2.getId(), optional.get().getId());
		
	}
	
		
		@Test
		public void testdeleteEntrepriseById() {
			 Entreprise entreprise = new Entreprise(1,"vermeg");
			 Entreprise entrp = entrepriseRepoistory.save(entreprise);
			 ientrepriseservice.deleteEntrepriseById(entrp.getId());
		      assertNotEquals(entrp.getId(), entreprise.getId());
		}
	}

