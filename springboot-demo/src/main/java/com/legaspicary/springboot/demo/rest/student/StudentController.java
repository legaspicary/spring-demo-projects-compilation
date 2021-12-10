package com.legaspicary.springboot.demo.rest.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getStudents() {
	return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
	return studentService.getStudent(id);
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
	student.setId(0);
	studentService.saveStudent(student);
	return student;
    }

    @PatchMapping()
    public Student patchStudent(@RequestBody Student student) {
	studentService.saveStudent(student);
	return student;
    }
}
