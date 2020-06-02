package br.com.microservice.project.loja;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import br.com.microservice.project.loja.lang.Constants;

@EnableDiscoveryClient
@ComponentScan(Constants.PACKAGE)
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class LojaApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(LojaApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
