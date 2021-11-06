package learn.spring.caching.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.caching.model.Student;
import learn.spring.caching.service.ApiService;

@RestController
@RequestMapping("/student")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@PostMapping
	public void addStudent(@RequestBody Student student) {
		apiService.addStudent(student);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(apiService.updateStudent(student));
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		apiService.deleteStudent(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
		return ResponseEntity.ok(apiService.getStudent(id).get());
	}
}
