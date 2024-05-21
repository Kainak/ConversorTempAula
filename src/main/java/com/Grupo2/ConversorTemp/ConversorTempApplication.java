package com.Grupo2.ConversorTemp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConversorTempApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorTempApplication.class, args);
	}
}
