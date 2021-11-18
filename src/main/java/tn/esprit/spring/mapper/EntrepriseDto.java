package tn.esprit.spring.mapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EntrepriseDto {
@JsonProperty("id")
private int id1;
@JsonProperty("name")
private String name1;
@JsonProperty("raisonSocial")
private String raisonSocial1;
public int getId1() {
	return id1;
}
public void setId1(int id1) {
	this.id1 = id1;
}
public String getName1() {
	return name1;
}
public void setName1(String name1) {
	this.name1 = name1;
}
public String getRaisonSocial1() {
	return raisonSocial1;
}
public void setRaisonSocial1(String raisonSocial1) {
	this.raisonSocial1 = raisonSocial1;
}





	



}
