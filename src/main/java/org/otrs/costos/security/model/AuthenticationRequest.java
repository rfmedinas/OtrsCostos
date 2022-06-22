package org.otrs.costos.security.model;

/**
 * Dto para la petición de la autenticación
 * 
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 * 
 */
public class AuthenticationRequest {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}