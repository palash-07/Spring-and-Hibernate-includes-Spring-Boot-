package com.palash.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palash.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the student data .. only once !

	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Carl", "Marx"));
		theStudents.add(new Student("Mary", "Jane"));
		theStudents.add(new Student("Snoop", "Dogg"));
	}

	// define an endpoint for /students

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

	// define an endpoint for /student/{studentId} - return student at index

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check the student id against the list size
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return theStudents.get(studentId);
	}

}
