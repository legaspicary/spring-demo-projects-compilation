package com.legaspicary.springrest.student;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.legaspicary.springrest.student.interfaces.IStudentDAO;

@Repository
public class StudentDAO implements IStudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query = session.createQuery("from Student order by name", Student.class);
		return query.getResultList();
	}

	@Override
	public void saveStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		if (student == null)
			throw new NoSuchElementException(String.format("Student with id %d not found", id));
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = getStudent(id);
		session.delete(student);
	}

}
