package com.graphql;

import com.graphql.insfrastructure.user.UserEntity;
import com.graphql.insfrastructure.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserRepository userRepository) {
		return args -> {
			userRepository.save(UserEntity.builder().name("marlon").email("marlon@gmail.com").build());
			userRepository.save(UserEntity.builder().name("will").email("will@hotmail.com").build());
			userRepository.save(UserEntity.builder().name("matheus").email("matheus@outlook.com").build());
		};
	}
}
