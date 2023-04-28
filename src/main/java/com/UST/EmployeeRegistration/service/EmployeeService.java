/**
 * 
 */
package com.UST.EmployeeRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.EmployeeRegistration.model.Employee;
import com.UST.EmployeeRegistration.repository.EmployeeRepo;

/**
 * @author Administrator
 *
 */
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	public Employee createEmployee(Employee employee) {

		return repo.save(employee);
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "the employee information is deleted";
	}

	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Employee oldemp=null;
		Optional<Employee>optionalemployee=repo.findById(id);
		if(optionalemployee.isPresent()) {
			oldemp=optionalemployee.get();
			oldemp.setEmpid(employee.getEmpid());
			oldemp.setEmpname(employee.getEmpname());
//			oldemp.setAddress(employee.getAddress());
//			oldemp.setLocation(employee.getLocation());

			repo.save(oldemp);
		}else {
			return new Employee();
		}
		return oldemp;
	}

//		employee.setId(id);
//		return repo.save(employee);
//	}
}
