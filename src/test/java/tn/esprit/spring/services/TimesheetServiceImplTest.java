package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	@Autowired 
	ITimesheetService tM; 
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
@Test
public void testAffecterMission() {
	
 tM.affecterMissionADepartement(4,1);
 Optional<Mission> value= missionRepository.findById(4);
 if(value.isPresent()) {
	 Mission mission=value.get();  
	 int iddept=mission.getDepartement().getId();
	 assertEquals(1,iddept);
 }
 
	
	
	
}
	
	
	@Test
	public void testAllEmployeByMission() {
		
		List<Employe> listEmploye = tM.getAllEmployeByMission(1);
	 assertEquals(1,listEmploye.size());
	}  
	
	
	
	
		
		
	
		
	}  
	
