package com.football_field.football_field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
//need to register JPA 2.1 converters so that all the Java 8 Date/Time
//fields in the domain models automatically get converted to SQL types when we persist them in the database.
@EntityScan(basePackageClasses = {
		FootballFieldApplication.class,
		Jsr310JpaConverters.class
})
public class FootballFieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballFieldApplication.class, args);
	}

}
