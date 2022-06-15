package org.otrs.costos;

import org.otrs.costos.security.JWTAuthorizationFilter1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class CostosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostosApplication.class, args);
	}

	/* Al activar se activa la seguridad por token para acceder al mismo primero se debe invocar
	* POST
	* http://localhost:8080/api/User  	
	* param: user, passsword
	*/
	// @EnableWebSecurity
	// @Configuration
	// class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// 	@Override
	// 	protected void configure(HttpSecurity http) throws Exception {
	// 		http.csrf().disable()
	// 				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
	// 				.authorizeRequests()
	// 				.antMatchers(HttpMethod.POST, "/api/User").permitAll()
	// 				.anyRequest().authenticated();
	// 	}
	// }
	
}
