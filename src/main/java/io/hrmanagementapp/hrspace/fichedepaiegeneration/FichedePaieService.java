package io.hrmanagementapp.hrspace.fichedepaiegeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hrmanagementapp.hrspace.employeemanagement.EmployeeRepository;

@Service
public class FichedePaieService {
	
	@Autowired
	private FichedePaieRepository fichedePaieRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public FichedePaie getFichedePaieById(String id) {
		
		FichedePaie fichedePaie;
		if(fichedePaieRepository.existsById(id)) {
			fichedePaie = fichedePaieRepository.findById(id).get();
			fichedePaie.LeaveCreditCalc();
			fichedePaie.NetSalaryCalc();
			return fichedePaie;
		}else {
			return null;
		}
	}

	public String addFichedePaie(String id, FichedePaie fichedePaie) {

		if(fichedePaieRepository.existsById(id)) {
			return "Fiche de Paie Existe";
		}else if(!employeeRepository.existsById(id)) {
			return "l'Employé n'existe pas";
		}else {
			fichedePaie.setEmployeeId(id);
			fichedePaieRepository.save(fichedePaie);
			return "Fiche de Paie Enregistré";
		}
	}

	public String updateFichedePaie(String id, FichedePaie fichedePaie) {
		
		if(fichedePaieRepository.existsById(id)) {
			fichedePaie.setEmployeeId(id);
			fichedePaieRepository.save(fichedePaie);
			return "Modifications Enregistré";
		}else {
			return "Fiche de Paie inexistante";
		}
	}

	public String deleteFichedePaie(String id) {
		
		if(fichedePaieRepository.existsById(id)) {
			fichedePaieRepository.deleteById(id);
			return "Fiche de Paie Supprimé";
		}else {
			return "Fiche de Paie inexistante";
		}
	}
	
}
