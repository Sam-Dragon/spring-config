package learn.spring.caching.service;

import java.util.Optional;

import learn.spring.caching.model.Student;

public interface ApiService {

	Optional<Student> getStudent(String id, Boolean cacheble);
}
