package br.com.microservice.project.transportador;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import br.com.microservice.project.transportador.lang.Constants;

@EnableDiscoveryClient
@ComponentScan(Constants.PACKAGE)
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class TransportadorApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(TransportadorApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
