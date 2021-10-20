package learn.spring.caching.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.caching.model.Student;
import learn.spring.caching.service.ApiService;

@RestController
@RequestMapping("/student")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@GetMapping
	public ResponseEntity<Student> getStudent(@RequestParam("id") String id, @RequestParam("cacheble") Boolean cacheble) {
		return ResponseEntity.ok(apiService.getStudent(id, cacheble).get());
	}
}
