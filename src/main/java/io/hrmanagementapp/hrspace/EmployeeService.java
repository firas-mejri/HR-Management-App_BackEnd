package io.hrmanagementapp.hrspace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(String id) {

		// Calculating salary and Leave days Credit each time an employee is fetshed
		Employee employee;
		if(employeeRepository.existsById(id)) {
			employee = employeeRepository.findById(id).get();
			employee.CalcRemainingLeaveCredit();
			employee.calcSalary();
			employeeRepository.save(employee);
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
	
	public void updateEmployee(Employee employee, String id) {
		employee.setId(id);
		employeeRepository.save(employee);
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
