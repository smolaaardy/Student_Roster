package com.smolaardy.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smolaardy.studentroster.entities.Student;
import com.smolaardy.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepo;

	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<Student> findAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student findStudentById(Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return null;
		}
	}
	
	public List<Student> findStudentsWithoutContactInfo(){
		return studentRepo.findByContactInfoIsNull();
	}
	
	public void saveStudent (Student student) {
		studentRepo.save(student);
	}
	
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
	}
}