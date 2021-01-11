package cryptoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebApiApp {

	public static void main(String[] args) {
		SpringApplication.run(WebApiApp.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
		//Use RestTemplateBuilder to create Rest template beans
	}
}
