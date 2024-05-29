package com.vu.vu;

import com.vu.vu.role.Role;
import com.vu.vu.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
@SpringBootApplication
@ComponentScan(basePackages = {"com.vu.vu", "com.vu.vu.security"})
@EnableMongoRepositories(basePackages = "com.vu.vu.user")
@EnableAsync
public class VuApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}

}
