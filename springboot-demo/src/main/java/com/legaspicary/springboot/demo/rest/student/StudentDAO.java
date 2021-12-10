package com.legaspicary.springboot.demo.rest.student;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO implements IStudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents() {
	TypedQuery<Student> query = entityManager
		.createQuery("from Student order by name", Student.class);
	return query.getResultList();
    }

    @Override
    public void saveStudent(Student student) {
	Student savedStudent = entityManager.merge(student);
	student.setId(savedStudent.getId());
    }

    @Override
    public Student getStudent(int id) {
	Student student = entityManager.find(Student.class, id);
	if (student == null)
	    throw new NoSuchElementException(
		    String.format("Student with id %d not found", id));
	return student;
    }

    @Override
    public void deleteStudent(int id) {
	Student student = getStudent(id);
	entityManager.remove(student);
    }

}
