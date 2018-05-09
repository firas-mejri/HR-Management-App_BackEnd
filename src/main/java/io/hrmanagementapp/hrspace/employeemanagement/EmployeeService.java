package io.hrmanagementapp.hrspace.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hrmanagementapp.hrspace.fichedepaiegeneration.FichedePaieRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private FichedePaieRepository fichedePaieRepository;
	
	public List<String> getAllEmployees(){
		
		String employeeFullName;
		List<String> employeeNamesList = new ArrayList<String>();
		List<Employee> employeeList = employeeRepository.findAll();
		
		for(int i=0;i<employeeList.size();i++) {
			employeeFullName = employeeList.get(i).getName() +" "+employeeList.get(i).getLastName();
			if(employeeFullName != "null null") {
				employeeNamesList.add(employeeFullName);
			}
		}
		
		return employeeNamesList;
			
	}
	
	public Employee getEmployeeById(String id) {

		// Calculating salary and Leave days Credit each time an employee is fetched
		Employee employee;
		if(employeeRepository.existsById(id)) {
			employee = employeeRepository.findById(id).get();
			if(fichedePaieRepository.existsById(id)) {
				employee.setSalary(fichedePaieRepository.findById(id).get().getNetSalary());
				employee.setRemainingLeaveCredit(fichedePaieRepository.findById(id).get().getLeaveDaysCredit());
				employeeRepository.save(employee);
			}
			return employee;
		}else {
			return null;
		}
	}
	
	public String addEmployee(Employee employee) {
		
		if(employeeRepository.existsById(employee.getId())) {
			return "L'employé Existe deja";
		}else {
			employeeRepository.save(employee);
			return "L'employé a été ajouté";
		}
	}
	
	public String updateEmployee(Employee employee, String id) {
		
		if(employeeRepository.existsById(id)) {
			employee.setId(id);
			employeeRepository.save(employee);
			return "Informations Employé Enregistré";
		}else {
			return "Employé inexistant";
		}
	}
	
	public String deleteEmployee(String id) {
		
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return "Employé supprimé";
		}else {
			return "L'employé que vous voulez supprimé n'existe pas";
		}
	}
	

}
