package ro.unibuc.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.unibuc.hello.data.AccountRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = AccountRepository.class)
public class HelloApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
