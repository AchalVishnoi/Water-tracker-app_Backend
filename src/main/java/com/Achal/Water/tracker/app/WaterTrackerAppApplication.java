package com.Achal.Water.tracker.app;

import com.Achal.Water.tracker.app.response.AuthResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterTrackerAppApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(WaterTrackerAppApplication.class, args);

	}

}
