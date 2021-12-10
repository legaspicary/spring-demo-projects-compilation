package com.legaspicary.springrest.student.interfaces;

import java.util.List;

import com.legaspicary.springrest.student.Student;

public interface IStudentService {
	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(int id);

	public void deleteStudent(int id);
}
