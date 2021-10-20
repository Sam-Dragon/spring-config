package learn.spring.caching.service.impl;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import learn.spring.caching.model.Student;
import learn.spring.caching.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	@CacheEvict(value = "student-cache", key = "'StudentCache'+#id", condition = "!#cacheble")
	@Cacheable(value = "student-cache", key = "'StudentCache'+#id", condition = "#cacheble")
	@Override
	public Optional<Student> getStudent(String id, Boolean cacheble) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Student.students().stream().filter(s -> s.getId().equals(id)).findFirst();
	}
}
