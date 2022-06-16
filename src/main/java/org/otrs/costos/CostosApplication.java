package org.otrs.costos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.otrs.costos.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class CostosApplication {
	// Manejo de errores
	static Log LOGGER = LogFactory.getLog(CostosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CostosApplication.class, args);
		
		try {

		} catch (Exception e) {
			LOGGER.error("esto es un error");
		}

	}

	/*
	 * Al activar se activa la seguridad por token para acceder al mismo primero se
	 * debe invocar
	 * POST
	 * http://localhost:8080/api/User
	 * param: user, passsword
	 */
	 @EnableWebSecurity
	 @Configuration
	 class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable()
	 .addFilterAfter(new JWTAuthorizationFilter(),
	 UsernamePasswordAuthenticationFilter.class)
	 .authorizeRequests()
	 .antMatchers(HttpMethod.POST, "/api/login").permitAll()
	 .anyRequest().authenticated();
	 }
	 }

}
