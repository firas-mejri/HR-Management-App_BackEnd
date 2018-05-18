package io.hrmanagementapp.hrspace.employeemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@CrossOrigin
	@RequestMapping("/employee")
	public List<String> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@CrossOrigin
	@RequestMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee")
	public String addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{id}")
	public String updateEmployee(@RequestBody Employee employee,@PathVariable String id) {
		
		return employeeService.updateEmployee(employee, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		
		return employeeService.deleteEmployee(id);
	}

}