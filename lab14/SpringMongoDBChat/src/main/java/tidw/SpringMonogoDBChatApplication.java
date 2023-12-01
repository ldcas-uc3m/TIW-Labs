package tidw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringMonogoDBChatApplication {

	public static void main(String[] args) {
		// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#preface
		SpringApplication.run(SpringMonogoDBChatApplication.class, args);
	}
}
