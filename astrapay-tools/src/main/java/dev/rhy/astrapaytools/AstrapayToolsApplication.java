package dev.rhy.astrapaytools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AstrapayToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstrapayToolsApplication.class, args);
	}

}
