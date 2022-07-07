package com.palash.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palash.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// thats it and we get all the crud methods for free
}
