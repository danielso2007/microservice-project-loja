package br.com.microservice.project.config.server;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ConfigServerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}


}
