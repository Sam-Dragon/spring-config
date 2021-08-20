package learn.spring.profile.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.profile.datasource.DevResource;
import learn.spring.profile.datasource.TestResource;

@RestController
@RequestMapping("/profiles")
public class DevDatasourceController {

	@Autowired(required = false)
	private DevResource devResource;

	@Autowired(required = false)
	private TestResource testResource;

	@GetMapping("/dev")
	public String dev() {
		System.out.println("Dev Resource :: " + devResource.url);
		return devResource.url;
	}

	@GetMapping("/test")
	public String test() {
		System.out.println("Test Resource :: " + testResource.url);
		return testResource.url;
	}
}
