package org.otrs.costos.security;

import java.time.Duration;
import java.util.Arrays;

import org.otrs.costos.service.OtrsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private OtrsUserDetailsService otrsUserDetailsService;

	@Autowired
	private JwtFilterRequest jwtFilterRequest;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(otrsUserDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		cors().and()
		.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
		 .antMatchers("/**/swagger-ui.html").permitAll()
		 .antMatchers("/EstadoTicket/*").permitAll()
		 .anyRequest()
		 		.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				 ;
		//http.cors();
		http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
	}

	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource12(){
		CorsConfiguration cc = new CorsConfiguration();
		cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With",
								"Content-Type", "Access-Control-Request-Wethod",
								"Access-Control-Request-Headers",
								"Authorization"));
		cc.setAllowedHeaders(Arrays.asList(
								"Access-Control-Allow-Origin", 
								"Access-Control-Allow-Credentials"));
		cc.setAllowedOrigins(Arrays.asList("/*"));
		cc.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "OPTIONS", "DELETE"));
		cc.setMaxAge(Duration.ZERO);
		cc.setAllowCredentials(true);
        
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cc);
		return source;
	}

	@Bean   
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //or add * to allow all origins
		//configuration.setAllowedOrigins(Arrays.asList("/*")); //or add * to allow all origins
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); //to set allowed http methods
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("custom-header1", "custom-header2"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); 
        return source; 
    }
}