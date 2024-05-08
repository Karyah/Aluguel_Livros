package com.projetos.alugalivro.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class WebConfig {

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
			return new HiddenHttpMethodFilter();
	}
}
