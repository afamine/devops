package tn.esprit.spring.controller;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.mapper.EntrepriseDto;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc 
public class RestControlEntrepriseTest {

	@Mock
	IEntrepriseService serviceentreprise;
	@InjectMocks
	   private RestControlEntreprise entreController;

    Entreprise entre = new Entreprise();
    Departement dep = new Departement();

    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setup(){
    entre = new Entreprise("esprit");
    mockMvc = MockMvcBuilders.standaloneSetup(entreController).build();
    }
    @AfterEach
    void setDown() {
    entre = null;
 }
   
       
   
    
    
    @Test
    public void deleteEntrepriseById() throws Exception {
          doNothing().when(serviceentreprise).deleteEntrepriseById(17);
          mockMvc.perform(delete("/deleteEntrepriseById/17")
          .contentType(MediaType.APPLICATION_JSON)
          .content(asJsonString(entre)))
          .andExpect(MockMvcResultMatchers.status().isOk()).
          andDo(MockMvcResultHandlers.print());
    }
    
    @Test
	public void affecterDepartementAEntrepriseTest() throws Exception {
        doNothing().when(serviceentreprise).affecterDepartementAEntreprise(entre.getId(), dep.getId());
        mockMvc.perform(put("/affecterDepartementAEntreprise/2/1").
               contentType(MediaType.APPLICATION_JSON).
               content(asJsonString(dep))).
               andExpect(MockMvcResultMatchers.status().isOk()).
               andDo(MockMvcResultHandlers.print());
    }
    
   @Test
    public void getByIdTest() throws Exception {
        	   when(serviceentreprise.getEntrepriseById(entre.getId())).thenReturn(entre);
        	   mockMvc.perform(get("/getEntrepriseById/3").
               contentType(MediaType.APPLICATION_JSON).
               content(asJsonString(entre))).
               andExpect(MockMvcResultMatchers.status().isOk()).
               andDo(MockMvcResultHandlers.print());
    }

    public  String asJsonString(final Object obj) {
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
               throw new RuntimeException(e);
          }
    }
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
  
}
