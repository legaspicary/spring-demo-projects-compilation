package com.legaspicary.springboot.demo.rest.student;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

//	@Autowired
//	private StudentDAO studentDAO;'

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public List<Student> getStudents() {
	return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
	studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
	return studentRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Cannot find student"));
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
	studentRepository.deleteById(id);
    }

}
