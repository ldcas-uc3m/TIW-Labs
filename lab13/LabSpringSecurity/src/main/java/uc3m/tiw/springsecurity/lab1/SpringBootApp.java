package uc3m.tiw.springsecurity.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableAutoConfiguration(exclude = { SecurityFilterAutoConfiguration.class })
@ImportResource("security.xml")
public class SpringBootApp {

	// https://danielme.com/2019/03/20/spring-rest-basic-spring-security/
	// https://www.yawintutor.com/using-generated-security-password-spring-boot/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
