package learn.spring.caching.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.spring.caching.model.Student;

@Repository
public interface ApiRepository extends CrudRepository<Student, Long> {

	@Transactional
	@Modifying
	@Query("update Student s set s.name=?2 where s.id=?1 ")
	void updateWithId(Long id, String name);
}
