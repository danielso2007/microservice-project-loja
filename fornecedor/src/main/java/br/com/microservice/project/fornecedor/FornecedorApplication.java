package br.com.microservice.project.fornecedor;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.microservice.project.fornecedor.lang.Constants;

@EnableDiscoveryClient
@EnableJpaRepositories(Constants.PACKAGE + ".repository") 
@EntityScan(basePackages = Constants.PACKAGE+ ".entity")
@ComponentScan(Constants.PACKAGE)
@SpringBootApplication
public class FornecedorApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(FornecedorApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
