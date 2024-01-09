package com.lirannesta.demoforapplicationcontextinitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoForApplicationContextInitializerApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoForApplicationContextInitializerApplication.class);
		application.addInitializers(new com.lirannesta.demoforapplicationcontextinitializer.CustomApplicationContextInitializer());
		application.run(args);
	}

}
