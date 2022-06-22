package org.otrs.costos.security.model;

/**
 * Dto para la respuesta de la autenticación
 * 
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 * 
 */
public class AuthenticationResponse {
	private String jwt;

	/**
	 * Constructor para del Dto de la respuesta de la autenticación
	 * @param jwt token de las peticiones
	 */
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}