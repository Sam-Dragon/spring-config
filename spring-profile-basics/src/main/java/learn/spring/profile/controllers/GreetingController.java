package learn.spring.profile.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class GreetingController {

	@Value("${app.name:Default Application Name Not Read from Property file If 'Profile' is missed in config }")
	private String application;
	
	@Value("${app.description:Default Application Description Not Read from Property file If 'Profile' is missed in config }")
	private String description;

	@GetMapping
	public String externalMethod() {
		return application + " >> "+ description;
	}
}
