package com.smolaardy.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smolaardy.studentroster.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	public List<Student> findAll();
	public List<Student> findByContactInfoIsNull();
}