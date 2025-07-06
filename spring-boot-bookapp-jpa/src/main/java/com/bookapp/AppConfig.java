package com.bookapp;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean // bean definition
	ModelMapper mapper(){
		return new ModelMapper();
	}
}
