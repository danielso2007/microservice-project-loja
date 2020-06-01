package br.com.microservice.project.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(EurekaServerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
