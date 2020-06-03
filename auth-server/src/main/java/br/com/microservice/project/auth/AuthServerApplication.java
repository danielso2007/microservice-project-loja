package br.com.microservice.project.auth;

import java.security.Principal;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class AuthServerApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(AuthServerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

}
