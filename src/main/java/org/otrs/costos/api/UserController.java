package org.otrs.costos.api;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.otrs.costos.dto.User;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;


/**
 * @apiNote Expone el servicio para generar el token
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

	@PostMapping("User")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}


	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		// List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		// 		.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		// String token = Jwts
		// 		.builder()
		// 		.setId("softtekJWT")
		// 		.setSubject(username)
		// 		.claim("authorities",
		// 				grantedAuthorities.stream()
		// 						.map(GrantedAuthority::getAuthority)
		// 						.collect(Collectors.toList()))
		// 		.setIssuedAt(new Date(System.currentTimeMillis()))
		// 		// .setExpiration(new Date(System.currentTimeMillis() + 600000))
		// 		.signWith(SignatureAlgorithm.HS512,
		// 				secretKey.getBytes()).compact();

		// return "Bearer " + token;
		return "";
	}
}