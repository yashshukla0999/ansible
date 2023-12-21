package com.example.project.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
