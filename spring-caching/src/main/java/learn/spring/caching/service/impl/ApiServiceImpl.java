package learn.spring.caching.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import learn.spring.caching.model.Student;
import learn.spring.caching.repository.ApiRepository;
import learn.spring.caching.service.ApiService;

@Service
@CacheConfig(cacheNames = "student-cache")
public class ApiServiceImpl implements ApiService {

	@Autowired
	private ApiRepository apiRepository;

	@Override
	public void addStudent(Student student) {
		System.out.println("Add Call");
		apiRepository.save(student);
	}

	@CachePut(key = "'StudentCache'+#student.id")
	@Override
	public Student updateStudent(Student student) {
		System.out.println("Update Call");
//		apiRepository.findById(student.getId()).ifPresent(s -> {
//			s.setName(s.getName());
//			apiRepository.save(student);
//		});

		apiRepository.updateWithId(student.getId(), student.getName());
		return student;
	}

	@CacheEvict(key = "'StudentCache'+#id")
	@Override
	public void deleteStudent(Long id) {
		System.out.println("Delete Call");
		apiRepository.deleteById(id);
	}

	@Cacheable(key = "'StudentCache'+#id")
	@Override
	public Optional<Student> getStudent(Long id) {
		System.out.println("Get Call");
		return apiRepository.findById(id).or(() -> Optional.empty());
	}
}
