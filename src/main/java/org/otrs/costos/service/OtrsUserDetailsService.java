package org.otrs.costos.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
 * Gestiona los datos para la autenticación
 */
@Service
public class OtrsUserDetailsService implements UserDetailsService {
	@Autowired
	UsuarioService usuarioService;

	//@Autowired    
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new User("Josepascual",
						"{noop}josepascual", 
						new ArrayList<>());
	}

	/*
	public UserBD save(UserBD user) {
		UserBD newUser = new UserBD();
		newUser.setUsername(user.getUsername());		
		newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userService.save(user);
	}
 	*/
	// @Bean
	// public BCryptPasswordEncoder passwordEncoder() {
	// 	return new BCryptPasswordEncoder();
	// }
}
