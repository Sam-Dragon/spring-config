package learn.spring.configuration.environment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

	@Autowired
	private Environment environment;

	@GetMapping
	public String externalMethod() {
		System.out.println(environment.getProperty("path"));
		System.out.println(environment.getProperty("java.version"));
		System.out.println(environment.getProperty("server.port"));
		return environment.toString();
	}
}
