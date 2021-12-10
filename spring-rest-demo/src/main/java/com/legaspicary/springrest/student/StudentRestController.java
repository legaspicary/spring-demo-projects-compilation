package com.legaspicary.springrest.student;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legaspicary.springrest.student.interfaces.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private IStudentService studentService;

	@PostConstruct
	private void loadData() {
		if (studentService.getStudents().size() <= 0) {
			studentService.saveStudent(new Student("Cary Legaspi1", "BSIT", "legaspicary@gmail.com"));
			studentService.saveStudent(new Student("Cary Legaspi2", "BSIT", "legaspicary@gmail.com"));
			studentService.saveStudent(new Student("Cary Legaspi3", "BSIT", "legaspicary@gmail.com"));
		}
	}

	@GetMapping("/hello")
	public String sayHello() {

		return "Hello Worlddd!";
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudent(id);
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.saveStudent(student);
		return student;
	}

	@PatchMapping("/students")
	public Student patchStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}

//	@GetMapping("/students/{name}")
//	public Student getStudentByName(@PathVariable String name) {
//		return studentService.getStudents().stream().filter((student) -> student.getName().equals(name)).findFirst()
//				.orElseThrow(() -> new NoSuchElementException("Cannot find student with name: " + name));
//	}

//	@ExceptionHandler
//	private ResponseEntity<StudentErrorResponse> handleNotFoundException(NoSuchElementException e) {
//		StudentErrorResponse msg = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), "Student not found",
//				System.currentTimeMillis());
//		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
//	}
//
//	@ExceptionHandler
//	private ResponseEntity<StudentErrorResponse> handleExceptions(Exception e) {
//		StudentErrorResponse msg = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
//				System.currentTimeMillis());
//		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
//	}
}
