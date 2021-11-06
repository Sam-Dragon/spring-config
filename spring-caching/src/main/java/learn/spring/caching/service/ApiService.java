package learn.spring.caching.service;

import java.util.Optional;

import learn.spring.caching.model.Student;

public interface ApiService {

	Optional<Student> getStudent(Long id);

	Student updateStudent(Student student);

	void deleteStudent(Long id);

	void addStudent(Student student);
}
