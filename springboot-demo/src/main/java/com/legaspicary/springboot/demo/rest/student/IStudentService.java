package com.legaspicary.springboot.demo.rest.student;

import java.util.List;

public interface IStudentService {
	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(int id);

	public void deleteStudent(int id);
}
