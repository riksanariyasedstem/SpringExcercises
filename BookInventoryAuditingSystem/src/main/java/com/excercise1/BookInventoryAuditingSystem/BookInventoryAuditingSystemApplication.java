package com.excercise1.BookInventoryAuditingSystem;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class  BookInventoryAuditingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookInventoryAuditingSystemApplication.class, args);
	}

}
