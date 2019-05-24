package br.com.fox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.fox" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
