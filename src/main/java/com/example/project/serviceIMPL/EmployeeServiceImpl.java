package com.example.project.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Employee;
import com.example.project.repoistory.EmployeeRepo;
import com.example.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public String removeEmployee(int id) {
		employeeRepo.deleteById(id);
		return "Delete data SucccessFully";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if (emp.isPresent()) {
			return emp;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = employeeRepo.findAll();
		return empList;
	}

	@Override
	public String updateEmployee(int id, Employee emp) {
		Optional<Employee> empOptional = employeeRepo.findById(id);

		if (empOptional.isPresent()) {
			Employee existingEmployee = empOptional.get();
			employeeRepo.save(existingEmployee);

			return "Employee updated successfully";
		} else {
			return "Employee not found";
		}

	}

}
