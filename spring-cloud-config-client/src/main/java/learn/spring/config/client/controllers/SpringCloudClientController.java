package learn.spring.config.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.config.client.model.DBSettings;

@RestController
@RequestMapping("/config/client")
public class SpringCloudClientController {

	@Autowired
	private DBSettings dbSettings;

	@GetMapping
	public String getDBProperties() {
		return dbSettings.getName() + " <> " + dbSettings.getPass() + " <> " + dbSettings.getPort();
	}
}
