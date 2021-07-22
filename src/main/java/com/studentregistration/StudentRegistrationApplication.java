package com.studentregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaRepositories(basePackages = "com.studentregistration")
@EntityScan(basePackages = "com.studentregistration")
@SpringBootApplication(scanBasePackages = {"com.studentregistration"})
public class StudentRegistrationApplication {

	public static void main(final String[] args) {
		SpringApplication.run(StudentRegistrationApplication.class, args);
	}

}
