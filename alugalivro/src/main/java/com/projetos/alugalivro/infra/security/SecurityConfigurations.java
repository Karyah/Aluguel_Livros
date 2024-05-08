package com.projetos.alugalivro.infra.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.projetos.alugalivro.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations   {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DataSource dataSource;
	
	
	
	  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize.
				
				requestMatchers("/cadastro", "/cadastro/novo", "/home", "/home/**", "/styles/**").permitAll().
				anyRequest().authenticated()
				
		).formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/home", true).permitAll());
		http.csrf((csrf) -> {
		
				try {
					csrf.disable().userDetailsService(userService);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("erro aqui");
				}
			
		});
		
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
