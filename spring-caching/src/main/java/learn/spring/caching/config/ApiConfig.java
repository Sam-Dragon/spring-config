package learn.spring.caching.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learn.spring.caching.filter.APIFilter;

@Configuration
@EnableCaching
public class ApiConfig {

	@Bean
	public APIFilter opiFilter() {
		return new APIFilter();
	}
}
