package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Employee;
import com.example.project.serviceIMPL.EmployeeServiceImpl;

@RestController

public class EmployeeController {

	@Autowired
	public EmployeeServiceImpl empservice;

	@GetMapping("/home")
	public String homePage() {
		return "Yash Shukla";

	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = empservice.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id) {
	    empservice.removeEmployee(id);
	    return new ResponseEntity<String>("Remove successfully", HttpStatus.ACCEPTED);
	}


	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id) {
		Optional<Employee> emps = empservice.findEmpById(id);
		return new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> ListOfEmployee() {
		List<Employee> Emp = empservice.getAllEmployee();
		return new ResponseEntity<List<Employee>>(Emp, HttpStatus.ACCEPTED);
	}
	@PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        String result = empservice.updateEmployee(id, emp);
        if ("Employee updated successfully".equals(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

}
