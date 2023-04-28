/**
 * 
 */
package com.UST.EmployeeRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UST.EmployeeRegistration.model.Employee;
import com.UST.EmployeeRegistration.service.EmployeeService;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/emp/registration")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addemps")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
		//request of employee details 
		//employeeService is autowired,coz logic is written in employeeServices
	}
	@GetMapping ("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getEmployees();
	}
	@GetMapping ("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
}


	@PutMapping("/updateemployee/{id}")

	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
//		employee.setId(id);
		return employeeService.updateEmployee(id,employee);
	}


	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}
}
