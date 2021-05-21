package learn.spring.value.controllers;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/value")
public class ValueAnnotationController {

	@Value("${app.name:Default Application Name Not Read from Property file If 'Profile' is missed in config }")
	private String application;

	@Value("Some static message")
	private String staticMessage;

	@Value("${blacklist.mobile.number}")
//	private List<String> blackListedNumbers;
	private Set<String> blackListedNumbers;

	@Value("#{${connection.detail}}")
	private Map<String, String> connectionMap;

	@GetMapping
	public String externalMethod() {
		return application + " >> " + staticMessage + " << " + blackListedNumbers + " || " + connectionMap;
	}
}
