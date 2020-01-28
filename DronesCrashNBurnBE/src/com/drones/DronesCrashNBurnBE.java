package com.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.drones.springboot.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication
@EnableJpaAuditing
public class DronesCrashNBurnBE {

	public static void main(String[] args) {
		SpringApplication.run(DronesCrashNBurnBE.class, args);
	}

}
